package com.back.controller;

import com.back.domain.entity.Usuario;
import com.back.repository.UsuarioRepository;
import com.back.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.codehaus.plexus.resource.loader.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/usuario")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService usuarioService;

    private final UsuarioRepository usuarioRepository;

    @GetMapping("/buscar")
    public List<Usuario> listarTodos() {
        return usuarioService.buscarTodos();
    }

    @PostMapping("/adicionar")
    public Usuario adicionar(@RequestBody Usuario usuario) {
        return usuarioService.criar(usuario);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody Usuario user){
        user = usuarioService.alterar(id, user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Map<String,Boolean>> deletar(@PathVariable Long id) throws ResourceNotFoundException {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Não existe usuário com esse ID : " + id));

        usuarioRepository.delete(usuario);
        Map<String, Boolean> result = new HashMap<>();
        result.put("eliminar",Boolean.TRUE);
        return ResponseEntity.ok().body(result);
    }
}


