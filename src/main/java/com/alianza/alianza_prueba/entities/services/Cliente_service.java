package com.alianza.alianza_prueba.entities.services;

import java.util.List;

import com.alianza.alianza_prueba.entities.Cliente;


public interface Cliente_service {
	
    public List<Cliente> findAll();
	
	public Cliente findById(int cliente_id);
	
	public void save(Cliente cliente);
	
	public void deleteById(int cliente_id);
	
	public Cliente findByShared_key(String shared_key);
	
}
