package com.back.service;

import com.back.domain.entity.Usuario;
import com.back.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
//@RequiredArgsConstructor
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public Usuario criar(Usuario usuario) {
        Usuario usuario1 = this.usuarioRepository.save(usuario);
        return usuario1;
    }

    public List<Usuario> buscarTodos() {
        List<Usuario> usuarios =this.usuarioRepository.findAll();
        return usuarios;
    }

    public Usuario buscarPorId(Long id) {
        Optional<Usuario>  result = usuarioRepository.findById(id);
        return result.orElse(null);
    }

    public Usuario alterar(Long id, Usuario usuario) {
        Usuario user = usuarioRepository.getOne(id);
        atualizar(user, usuario);
        return usuarioRepository.save(user);
    }

    private void atualizar(Usuario user, Usuario usuario) {
        user.setName(usuario.getName());
        user.setEmail(usuario.getEmail());
    }

//    public Usuario salvar(Usuario usuario) {
//        usuario.setPassword(criptografia.encriptar(usuario.getPassword()));
//        Usuario email = converterEntidade.toDto(getInicialRepository().save(usuario));
//        String url = "http://localhost:4200/?DjncdNSnfdsA=" + criptografia.encriptar(email.getEmail());
//        emailSenderService.sendSimpleEmail(email.getEmail(), "Registro efetuado com sucesso!", url);
//        return email;
//    }

}
