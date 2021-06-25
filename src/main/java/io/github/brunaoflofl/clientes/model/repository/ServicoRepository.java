package io.github.brunaoflofl.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunaoflofl.clientes.model.entity.Servico;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
