package com.tienda.mintic.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.mintic.model.model.Usuario;
import com.tienda.mintic.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	//*Crear un nuevo usuario
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Usuario usuario) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
		
	}
	
	// Leer un Usuario
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long usuarioid){
		
		Optional<Usuario> oUsuario = usuarioService.findById(usuarioid);
		
		if(!oUsuario.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oUsuario);
		
	}
	
	
	//Actualizar un Usuario
	@PutMapping("/{id}")
	public ResponseEntity<?> update (@RequestBody Usuario usuarioDetails, @PathVariable(value = "id") Long usuarioid){
		
		Optional<Usuario> uUsuario = usuarioService.findById(usuarioid);
		

		if(!uUsuario.isPresent()){
			return ResponseEntity.notFound().build();
		}
		
		//BeanUtils.copyProperties(usuarioDetails, uUsuario.get());
		uUsuario.get().setNombre(usuarioDetails.getNombre());
		uUsuario.get().setApellido(usuarioDetails.getApellido());
		uUsuario.get().setEmail(usuarioDetails.getEmail());
		uUsuario.get().setEnabled(usuarioDetails.getEnabled());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(uUsuario.get()));
		
	}
	
	
	
	@DeleteMapping("/´{id}")
	public ResponseEntity<?> delete (@PathVariable(value = "id") Long usuarioId){
		
		if(!usuarioService.findById(usuarioId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		usuarioService.deleteById(usuarioId);
		return ResponseEntity.ok().build();
	
	}
	
	
	
	@GetMapping
	public List<Usuario> readAll () {
		
		List<Usuario> usuarios = StreamSupport
				.stream(usuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return usuarios;
	}
	
	

}
