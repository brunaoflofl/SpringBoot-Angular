package io.github.brunaoflofl.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.brunaoflofl.clientes.model.entity.Cliente;
import io.github.brunaoflofl.clientes.model.entity.ServicosPrestados;
import io.github.brunaoflofl.clientes.model.repository.ClienteRepository;
import io.github.brunaoflofl.clientes.model.repository.ServicosPrestadosRepository;
import io.github.brunaoflofl.clientes.rest.dto.ServicoPrestadoDTO;

@RestController
@RequestMapping("/api/servicos-prestados")
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicosPrestadosRepository  repository;
	
	public ServicoPrestadoController(
			ClienteRepository clienteRepository,
			ServicosPrestadosRepository repository) {
		this.clienteRepository = clienteRepository;
		this.repository = repository;
	}
	
	public ServicosPrestados salvar(@RequestBody ServicoPrestadoDTO dto) {
		LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Long idCliente = dto.getIdCliente();
		
		Cliente cliente = clienteRepository
				.findById(idCliente)
				.orElseThrow(() -> 
						new ResponseStatusException(
								HttpStatus.BAD_REQUEST, "Cliente inexistente!"));
		ServicosPrestados servicosPrestados = new ServicosPrestados();
		
		servicosPrestados.setDescricao(dto.getDescricao());
		servicosPrestados.setData(data);
		servicosPrestados.setCliente(cliente);
	}

}
