package com.back.service;

import com.back.domain.entity.Usuario;
import com.back.messages.EmailMessages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final EnvioEmailService emailService;

    public Usuario user(Usuario usuario) {
        this.validarUsuario(usuario);
        Usuario novo = new Usuario(usuario.getNome(), usuario.getEmail());
        novo.setSenha(UUID.randomUUID().toString());

        this.emailService.enviar(usuario.getEmail(),
                EmailMessages.novoTitulo(usuario), EmailMessages.mensagem(usuario, novo.getSenha()));

        novo.setSenha("123456");

        return novo;
    }

public void validarUsuario(Usuario usuario) {
    if (usuario.getNome() == null || usuario.getEmail() == null) {
        throw new RuntimeException("É necessário todas as informações");
    }
}
}
