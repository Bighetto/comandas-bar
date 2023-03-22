package com.projetoBar.configuration.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserModel user = usuarioRepository.findByNome(username);

        if (user== null){
            throw  new UsernameNotFoundException("Dados Invalidos");
        }

        return new Usuario(user.getNome(), user.getSenha(), user.getRoles());



    }
}
