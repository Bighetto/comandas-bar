package com.projetoBar.controller;

import com.projetoBar.enums.TipoProdutoEnum;
import com.projetoBar.enums.TiposGenericosEnum;
import com.projetoBar.model.ProdutoModel;
import com.projetoBar.dto.ExibirProdutoDTO;
import com.projetoBar.dto.ProdutoDTO;
import com.projetoBar.dto.ProdutoInsertDTO;
import com.projetoBar.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping(path = "/getNome/{nome}/tipoGenerico/{tipoGenerico}")
    public ResponseEntity<List<ExibirProdutoDTO>>selecionarPorNome(@PathVariable String nome, @PathVariable TiposGenericosEnum tipoGenerico){

        List<ExibirProdutoDTO> user = produtoService.getByNome(nome, tipoGenerico.toString());

        return ResponseEntity.ok(user);

    }

    @GetMapping(path = "/tipo/{tipo}/nome/{nome}")
    public ResponseEntity<List<ExibirProdutoDTO>>selecionarNomePeloTipo(@PathVariable TipoProdutoEnum tipo,@PathVariable String nome){

        List<ExibirProdutoDTO> user = produtoService.listarNomesPeloTipo(nome, tipo);

        return ResponseEntity.ok(user);

    }


    @GetMapping(path = "tipo/{tipo}")
    public ResponseEntity<List<ExibirProdutoDTO>>selecionarPorTipo(@PathVariable TipoProdutoEnum tipo){

        List<ExibirProdutoDTO> listaDeProdutos = produtoService.selecionarPeloTipo(tipo);

        return ResponseEntity.ok(listaDeProdutos);

    }

    @GetMapping(path = "/tipoGenerico/{tipo}")
    public ResponseEntity<List<ExibirProdutoDTO>>tiposGenericos(@PathVariable TiposGenericosEnum tipo){

        List<ExibirProdutoDTO> listaDeGenericos = produtoService.exibirComTipoGenerico(tipo);

        return ResponseEntity.ok(listaDeGenericos);

    }

    @GetMapping(path = "/tipos")
    public ResponseEntity<List<TipoProdutoEnum>>todosOsTipos(){

        List<TipoProdutoEnum>list = new ArrayList<>();

        for (TipoProdutoEnum produtoEnum: TipoProdutoEnum.values()){
            list.add(produtoEnum);
        }

        return ResponseEntity.ok(list);

    }



    @Cacheable(value = "listaDeProdutos")//cache para nao sobrecarregar as consultas repetidas, ou seja, se vc executar duas vezes a mesma requisicao http no metodo, so vai ser executado uma, e a segunda vai retornar o resultado que ficou em cache
    @GetMapping(path = "/listProduct")
    public ResponseEntity<Page<ProdutoModel>> getList(@PageableDefault(direction = Sort.Direction.ASC, page = 0, size = 10)Pageable paginacao
                                                      //defini os parametros padroes caso o usuario nao mande as variaveis na requisicao
                                                        /* MODO DE FAZER A PAGINACAO MANUALMENTE:
                                                        @RequestParam(required = true) int pagina, //Requisitar no corpo da url a pagina e a quantidade da lista retornada na mesma
                                                        @RequestParam(required = true) int quantidade, //anotacao required = true e padrao(nao precisa colocar), se colocar "= false" o parametro nao e obrigatorio no corpo da requisicao
                                                        @RequestParam(required = true) String ordenacao
                                                        por fim: PASSAR OS PARAMETROS NO METODO getList!!! */
        ){

        Page<ProdutoModel> lista = produtoService.getList(paginacao);//definindo pagina no metodo getList

        return ResponseEntity.ok(lista);
    }

    @GetMapping(path = "/listarTudo")
    public ResponseEntity<List<ProdutoModel>> selecionarTudo(){

        List<ProdutoModel> lista = produtoService.listarTudo();

        return ResponseEntity.ok(lista);
    }

    @PostMapping(path = "/insertProduto")
    @CacheEvict(value = "listaDeProdutos", allEntries = true)//anotacao para resetar o cache do Get para retornar os novos registros depois de uma insercao no banco
    public ResponseEntity<ProdutoInsertDTO>inserirProduto(@RequestBody ProdutoInsertDTO produtoDto, UriComponentsBuilder uri){

        ProdutoModel produtoModel = new ProdutoModel(produtoDto);

        produtoService.inserirProduto(produtoModel);

        URI uriRequisicao = uri.path("/getNome/{nome}").buildAndExpand(produtoDto.getNome()).toUri();

        return ResponseEntity.created(uriRequisicao).body(produtoDto);

    }

    @PutMapping(path = "/alterarValorProduto/{idProduto}/valor/{valor}")
    public ResponseEntity<String>alterarValorProduto(@PathVariable Integer idProduto, @PathVariable Double valor){

        ProdutoDTO produto = produtoService.atualizarValorProduto(idProduto, valor);

        return ResponseEntity.ok("Preco do produto: " + produto.getNome() + " atualizado para : " + produto.getValorDeVenda());

    }

    @DeleteMapping(path = "/deletarId/{id}")
    public ResponseEntity<String>deletarProduto(@PathVariable Integer id){

        String resposta = produtoService.deletarProduto(id);

        return ResponseEntity.ok().body(resposta);

    }

}
