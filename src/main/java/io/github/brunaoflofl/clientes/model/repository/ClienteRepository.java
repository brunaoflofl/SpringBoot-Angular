package io.github.brunaoflofl.clientes.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.brunaoflofl.clientes.model.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
