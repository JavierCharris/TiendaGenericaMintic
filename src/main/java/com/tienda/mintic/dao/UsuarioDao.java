package com.tienda.mintic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.mintic.model.model.Usuario;

@Repository
public interface UsuarioDao extends JpaRepository<Usuario,Long> {
	
	
	
}
