package com.back.convert;


import com.back.domain.dto.UsuarioDTO;
import com.back.domain.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

@RequiredArgsConstructor
public class ConverterEntity {

    private final ModelMapper mapper = new ModelMapper();


    public UsuarioDTO usuarioDTO(Usuario usuario){
        return mapper.map(usuario, UsuarioDTO.class);
    }
}
