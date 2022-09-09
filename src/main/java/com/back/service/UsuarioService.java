package com.back.service;

import com.back.domain.entity.Perfil;
import com.back.domain.entity.Usuario;
import com.back.messages.EmailMessages;
import com.back.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final EnvioEmailService emailService;

    private final PerfilRepository perfilRepository;

    public Usuario user(Usuario usuario) {
        Usuario result = new Usuario();
        result.setSenha(UUID.randomUUID().toString());
        this.emailService.enviar(usuario.getEmail(),
                EmailMessages.novoTitulo(usuario), EmailMessages.mensagem(usuario, result.getSenha()));
        result.setSenha("123456");
        return result;
    }
}
