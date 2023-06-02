package com.projetoBar.dto;

import com.projetoBar.configuration.security.UserModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExibirUsuarioDTO {

    private String nome;
    private String nivelDeAcesso;

    public ExibirUsuarioDTO(UserModel usuario) {

        this.nome = usuario.getNome();
        this.nivelDeAcesso = usuario.getRoles();
    }
}
