package com.tienda.mintic.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.tienda.mintic.model.model.Usuario;

public interface UsuarioService {
	
	
	public Iterable<Usuario> findAll();
	
	
	public Page<Usuario> findAll(Pageable pageable);
	
	
	public Optional<Usuario> findById(Long id);
	
	
	public Usuario save(Usuario usuarios);
	
	
	public void deleteById(Long id);
	
	

}
