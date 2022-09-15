package com.back.service;

import com.back.convert.ConverterEntity;
import com.back.domain.dto.UsuarioDTO;
import com.back.domain.entity.Usuario;
import com.back.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
//@RequiredArgsConstructor
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    private final EnvioEmailService emailService;

    private final ConverterEntity converterEntity = new ConverterEntity();


    public Usuario criar(Usuario usuario) {
        Usuario usuario1 = this.usuarioRepository.save(usuario);
        return usuario1;
    }

    public List<UsuarioDTO> buscarTodos() {
        List<UsuarioDTO> visualiza = new ArrayList<>();
        List<Usuario> usuarios =this.usuarioRepository.findAll();
        usuarios.forEach(t -> {
            UsuarioDTO usuarioDTO = converterEntity.usuarioDTO(t);
            usuarioDTO.setDescPermissao();
            visualiza.add(usuarioDTO);
        });
        return visualiza;

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

    public UsuarioDTO registrar(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        UsuarioDTO email = converterEntity.usuarioDTO(usuarioRepository.save(usuario));
        String url = "http://localhost:4200/?DjncdNSnfdsA=" + passwordEncoder.encode(email.getEmail());
        emailService.enviar(email.getEmail(), "Registrado com sucesso!", url);
        return email;
    }

    public boolean validar(String texto) {
        Usuario usuario = usuarioRepository.findByEmail(passwordEncoder.encode(texto)).orElse(null);
        if (usuario != null) {
            usuario.setValidado("1");
            usuarioRepository.save(usuario);
            return true;
        } else
            return false;
    }

    public UsuarioDTO reset(Long Id) {

        Usuario usuario = buscarPorId(Id);
        usuario.setPassword(passwordEncoder.encode("123456"));
        return converterEntity.usuarioDTO(usuarioRepository.save(usuario));
    }

    public UsuarioDTO logar (String email, String password) {

        UsuarioDTO result;

        try {
            password = passwordEncoder.encode(password);
            result = converterEntity.usuarioDTO(usuarioRepository.findByEmailAndPassword(email, password));
            return result;
        } catch (Exception e) {
            return new UsuarioDTO();
        }
    }

}
