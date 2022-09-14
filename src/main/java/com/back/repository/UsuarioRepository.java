package com.back.repository;

import com.back.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findAll();

    Usuario getById(Long Id);

    Usuario findByEmailAndPassword(String email, String password);

    Optional<Usuario> findByEmail(String email);

}
