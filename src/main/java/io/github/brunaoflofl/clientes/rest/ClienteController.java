package io.github.brunaoflofl.clientes.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.brunaoflofl.clientes.model.entity.Cliente;
import io.github.brunaoflofl.clientes.model.repository.ClienteRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	private final ClienteRepository repository;
	
	@Autowired
	public ClienteController(ClienteRepository repository) {
		this.repository = repository;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar( @RequestBody Cliente cliente) {
		return repository.save(cliente);
	}

}
