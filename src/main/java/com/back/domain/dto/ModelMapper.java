//package com.back.domain.dto;
//
//import com.back.domain.entity.Usuario;
//import ma.glasnost.orika.MapperFactory;
//import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
//import org.springframework.stereotype.Component;
//
//@Component
//public class ModelMapper implements OrikaMapperFactoryConfigurer {
//
//    //    private final org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();
////
////
////    public UsuarioDTO resultDto (Usuario entidade){
////        return mapper.map(entidade, UsuarioDTO.class);
////    }
//    @Override
//    public void configure(MapperFactory orikaMapperFactory) {
//        orikaMapperFactory.classMap(Usuario.class, UsuarioDTO.class);
//    }
//}
