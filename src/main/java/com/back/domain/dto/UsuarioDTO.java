package com.back.domain.dto;

import lombok.Data;

@Data
public class UsuarioDTO {

    private Long id;

    private String name;

    private String email;

    private String password;

    private Long permissao;

    private String descPermissao;

    private Integer validado;

    public String setDescPermissao() {
        return permissao == 1 ? "ADMIN" : "PADRÃO";
    }
}
