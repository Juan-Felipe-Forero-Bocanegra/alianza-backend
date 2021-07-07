package com.alianza.alianza_prueba.entities.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alianza.alianza_prueba.entities.Cliente;
import com.alianza.alianza_prueba.repository.Cliente_repository;

@Service
public class Cliente_service_impl implements Cliente_service {
	
	private Cliente_repository cliente_repository; 
	
	@Autowired 
	public Cliente_service_impl(Cliente_repository el_cliente_repository) {
		cliente_repository = el_cliente_repository; 
	}

	@Override
	public List<Cliente> findAll() {
		
		return cliente_repository.findAll(); 
	}

	
	@Override
	public Cliente findById(int cliente_id) {
		Optional<Cliente> result = cliente_repository.findById(cliente_id);
		
		 Cliente el_cliente = null;
			
			if (result.isPresent()) {
				el_cliente = result.get();
			}else {
				// we didn't find the employee
				throw new RuntimeException("No se encontró el cliente");
			}
			return el_cliente; 
	}

	@Override
	public void save(Cliente cliente) {
		cliente_repository.save(cliente);
	}

	@Override
	public void deleteById(int cliente_id) {
		cliente_repository.deleteById(cliente_id);

	}

	@Override
	public Cliente findByShared_key(String shared_key) {
	
		Cliente el_cliente = cliente_repository.findByShared_key(shared_key);      
			
			if (el_cliente == null) {		
				throw new RuntimeException("No se encontró el cliente " + shared_key);
			}
			return el_cliente; 
	}

}
