package net.atos.crojo.controller;

import java.util.concurrent.CompletableFuture;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.atos.crojo.dto.RegistroReqDTO;
import net.atos.crojo.model.Registro;
import net.atos.crojo.service.RegistroServiceImpl;

@RestController
@RequestMapping("/api/registros")
public class RegistroController {
	
	@Autowired
	RegistroServiceImpl srv;
	@Autowired
	ModelMapper mmap;
	
	@GetMapping("")
	public CompletableFuture<ResponseEntity> getAll()  {
		return srv.findAll().thenApply(ResponseEntity::ok);
	}
	
	@GetMapping("{id}")
	public CompletableFuture<ResponseEntity> getOne(@PathVariable("id") Long id){
		return srv.findById(id).thenApply( ResponseEntity::ok );
	}
	
	@PostMapping
	public CompletableFuture<ResponseEntity> save(@RequestBody RegistroReqDTO usr ){
		return srv.save(mmap.map( usr, Registro.class )).thenApply(ResponseEntity::ok);
	}
	
	@DeleteMapping("{id}")
	public CompletableFuture<ResponseEntity> delete(@PathVariable("id") Long id){
		return srv.delete(id).thenApply( ResponseEntity::ok );
	}
	
	@PutMapping("{id}")
	public CompletableFuture<ResponseEntity> update(
			@PathVariable("id") Long id,
			@RequestBody RegistroReqDTO usr 
			){
		return srv.update(id, mmap.map( usr, Registro.class ) ).thenApply( ResponseEntity::ok );
		
	}
	

}
