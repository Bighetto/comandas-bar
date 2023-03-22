package com.projetoBar.service;

import com.projetoBar.configuration.security.UserModel;
import com.projetoBar.configuration.security.UsuarioRepository;
import com.projetoBar.model.dto.ExibirUsuarioDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public ExibirUsuarioDTO verificarUsuarioNoBanco(String nome, String senha){



        List<UserModel> usuario = usuarioRepository.listaDeUsuario(nome);

        if (usuario.isEmpty()){
            throw new UsernameNotFoundException("Usuario Nao Encontrado");
        }

        UserModel user = new UserModel();
        usuario.forEach( userModel -> {
            if (BCrypt.checkpw(senha, userModel.getSenha())) {

                user.setNome(userModel.getNome());
                user.setSenha(userModel.getSenha());
                user.setRoles(userModel.getRoles());


            }
        });



        ExibirUsuarioDTO usuarioDTO = new ExibirUsuarioDTO(user);

        return usuarioDTO;


    }

}
