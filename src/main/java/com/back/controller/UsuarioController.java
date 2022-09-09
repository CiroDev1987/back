package com.back.controller;

import com.back.domain.entity.Perfil;
import com.back.domain.entity.Usuario;
import com.back.repository.PerfilRepository;
import com.back.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    private final PerfilRepository perfilRepository;

    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("/buscar")
    public List<Usuario> buscar() {
        return usuarioRepository.getUsuarios();
    }

    @PutMapping("/alterar")
    public ResponseEntity<Usuario> alterar( @RequestBody Usuario usuario) {
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return  ResponseEntity.ok(usuarioAtualizado);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Map<String, Boolean>> excluir(@PathVariable Long id){
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceAccessException("Não existe usuário com esse ID : " + id));
        usuarioRepository.delete(usuario);
        Map<String,Boolean> result = new HashMap<>();
        result.put("eliminar", Boolean.TRUE);
        return  ResponseEntity.ok(result);
    }

}
