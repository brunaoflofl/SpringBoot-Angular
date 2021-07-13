package io.github.brunaoflofl.clientes.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.brunaoflofl.clientes.model.entity.ServicosPrestados;

public interface ServicosPrestadosRepository extends JpaRepository<ServicosPrestados, Integer> {

	@Query(" select s fron ServicoPrestado s join s.cliente c " + 
	" where upper( c.nome ) like upper( :nome ) and MONTH(s.data) =:mes  ")
	List<ServicosPrestados> findByNameAndMes(
			@Param("nome") String nome, @Param("mes") Integer mes);

}
