package io.github.brunaoflofl.clientes.rest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.brunaoflofl.clientes.model.entity.Cliente;
import io.github.brunaoflofl.clientes.model.entity.ServicosPrestados;
import io.github.brunaoflofl.clientes.model.repository.ClienteRepository;
import io.github.brunaoflofl.clientes.model.repository.ServicosPrestadosRepository;
import io.github.brunaoflofl.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.brunaoflofl.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {
	
	private final ClienteRepository clienteRepository;
	private final ServicosPrestadosRepository  repository;
	private final BigDecimalConverter bigDecimalConverter; 
	
	public ServicoPrestadoController(
			ClienteRepository clienteRepository,
			ServicosPrestadosRepository repository) {
		this.clienteRepository = clienteRepository;
		this.repository = repository;
		this.bigDecimalConverter = new BigDecimalConverter();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
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
		servicosPrestados.setValor(bigDecimalConverter.converter(dto.getPreco()));
		
		return repository.save(servicosPrestados);
	}
	public List<ServicosPrestados> pesquisar(
			@RequestParam(value = "nome", required = false, defaultValue = "") String nome,
			@RequestParam(value = "mes", required = false) Integer mes
			){
		return repository.findByNameAndMes("%" + nome + "%", mes);
	}

}
