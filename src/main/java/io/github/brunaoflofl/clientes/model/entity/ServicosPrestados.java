package io.github.brunaoflofl.clientes.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
public class ServicosPrestados {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable = false, length = 150)
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;
	
	@Column
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Column
	private BigDecimal valor;
	

}
