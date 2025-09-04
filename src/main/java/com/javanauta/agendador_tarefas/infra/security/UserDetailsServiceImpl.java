package com.javanauta.agendador_tarefas.infra.security;



import com.javanauta.agendador_tarefas.business.dtos.UsuarioDTO;
import com.javanauta.agendador_tarefas.infra.security.client.UsuarioClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl  {

    private UsuarioClient client;


    public UserDetails carregaDdaosUsuario(String email, String token) {


        UsuarioDTO usuarioDTO = client.buscaUsuarioPorEmail(email, token);

        return User
                .withUsername(usuarioDTO.getEmail())
                .password(usuarioDTO.getSenha())
                .build();
    }


}
