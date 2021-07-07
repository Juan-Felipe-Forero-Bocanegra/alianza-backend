package com.alianza.alianza_prueba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alianza.alianza_prueba.entities.Cliente;

public interface Cliente_repository extends JpaRepository<Cliente, Integer> {
	@Query(value = "SELECT * from alianza.cliente where shared_key = :shared_key", nativeQuery = true)
	Cliente findByShared_key(@Param("shared_key") String shared_key);
}
