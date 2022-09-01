package com.back.messages;

import com.back.domain.entity.Usuario;

public class EmailMessages {

    public static String novoTitulo(Usuario usuario){
        return usuario.getNome() + " seu cadastro foi recebido!";

    }
    public static String mensagem(Usuario usuario, String senha){
        return "Olá " + usuario.getNome()
                + "! Seja bem vindo. "
                + " Os seus dados e sua senha de acesso estão logo abaixo. \n\n"
                + "================================== \n"
                + "Nome: " + usuario.getNome() + "\n"
                + "E-mail: " + usuario.getEmail() + "\n"
                + "Password: " + senha + "\n"
                + "========================= \n\n"
                + "É importante acessar sua conta e trocar sua senha. \n"
                + "https://google.com.br";
    }
}
