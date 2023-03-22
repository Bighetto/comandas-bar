package com.projetoBar.configuration.security;

import com.projetoBar.configuration.security.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UserModel, Integer> {

    UserModel findByNome(String nome);

    @Query(value = "select * from usuario where nome = :nome ;",nativeQuery = true)
    List<UserModel> listaDeUsuario(String nome);


    @Query(value = "select * from usuario where nome = :nome and senha = :senha ;",nativeQuery = true)
    UserModel findByNomeESenha(@Param("nome") String nome, @Param("senha") String senha);
}
