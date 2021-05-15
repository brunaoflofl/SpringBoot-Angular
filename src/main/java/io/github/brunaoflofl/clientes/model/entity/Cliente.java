package io.github.brunaoflofl.clientes.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.Setter;

@Entity
@Data
@Setter
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 150)
	private String nome;
	
	@Column(length = 11)
	private String cpf;
	
	@Column(name="data_cadastro")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro;
	
	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}

}
