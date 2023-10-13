package com.projetoBar.controller;

import com.projetoBar.dto.ExibirUsuarioDTO;
import com.projetoBar.service.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class AutenticacaoController {

    @Autowired
    private final UsuarioService usuarioService;

    @GetMapping("/login/{usuario}/senha/{senha}")
    public ResponseEntity<ExibirUsuarioDTO> exibirSeExisteUsuario(@PathVariable String usuario, @PathVariable String senha){

        ExibirUsuarioDTO usuarioDTO = usuarioService.verificarUsuarioNoBanco(usuario, senha);

        return ResponseEntity.ok(usuarioDTO);

    }

}
