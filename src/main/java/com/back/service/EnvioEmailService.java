package com.back.service;

import com.back.domain.entity.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EnvioEmailService {

    private final JavaMailSender mailSender;

    public static String novoTitulo(Usuario usuario){
        return usuario.getName() + " seu cadastro foi recebido!";

    }

    public void enviar(String para, String titulo, String conteudo) {
        log.info("Enviando email para confirmação de cadastro...");

        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setFrom("sonyciro@gmail.com");
        mensagem.setTo(para);
        mensagem.setSubject(titulo);
        mensagem.setText(conteudo);
        mailSender.send(mensagem);
        log.info("Email enviado com sucesso!");

    }
}
