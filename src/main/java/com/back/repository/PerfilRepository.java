package com.back.repository;

import com.back.domain.entity.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Integer>  {
	Perfil findByPerfil(Long id);
}
