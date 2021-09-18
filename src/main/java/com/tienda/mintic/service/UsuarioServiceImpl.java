package com.tienda.mintic.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tienda.mintic.dao.UsuarioDao;
import com.tienda.mintic.model.model.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Usuario> findAll() {
		
		
		
		return usuarioDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Usuario> findAll(Pageable pageable) {
		
		return usuarioDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) {
		
		return usuarioDao.findById(id);
	}

	@Override
	@Transactional
	public Usuario save(Usuario usuarios) {
		
		return usuarioDao.save(usuarios);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		usuarioDao.deleteById(id);
		
	}
	
	
	

}
