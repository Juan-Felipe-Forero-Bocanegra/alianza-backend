package com.alianza.alianza_prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alianza.alianza_prueba.entities.Cliente;
import com.alianza.alianza_prueba.entities.services.Cliente_service;



@RestController
@RequestMapping("/api")
public class Cliente_rest_controller {
	@Autowired
	private Cliente_service cliente_service; 
	
	@Autowired
	public Cliente_rest_controller(Cliente_service el_cliente_service) {
		cliente_service = el_cliente_service;
	}
	
	// GET ALL CLIENTES
		@GetMapping("/clientes")
		public List<Cliente> findAll() {
			return cliente_service.findAll();
		}
		
		// GET MAPPING CLIENTE ID 
		@GetMapping("/clientes/{cliente_id}")
		public Cliente getClientes(@PathVariable int cliente_id) {
			Cliente el_cliente = cliente_service.findById(cliente_id);
			if (el_cliente == null) {
				throw new RuntimeException("No se encontró el cliente");
			}
			return el_cliente; 
		}	
		
		// GET MAPPING shared_key 
		@GetMapping("/clientes/2/{shared_key}")
		public Cliente getSharedKey(@PathVariable String shared_key) {
			Cliente el_cliente = cliente_service.findByShared_key(shared_key);
			if (el_cliente == null) {
				throw new RuntimeException("Persona con no encontrada con shared_key: " + shared_key);
			}
			return el_cliente; 
		}
		
		// POST, AGREGAR UN CLIENTE
		@PostMapping("/clientes")
		public Cliente addCliente(@RequestBody Cliente el_cliente) {
			cliente_service.save(el_cliente); 
		    return el_cliente; 
		}

		//UPDATE CLIENTE
		@RequestMapping(
				  value = "/clientes/update/{cliente_id}", 
				  produces = "application/json", 
				  method = { RequestMethod.PUT}  )
		public Cliente updateCliente(@RequestBody Cliente el_cliente, @PathVariable int cliente_id) {
			Cliente Cliente_BD = cliente_service.findById(cliente_id); 
			Cliente_BD.setShared_key(el_cliente.getShared_key());
			Cliente_BD.setBussines_id(el_cliente.getBussines_id());
			Cliente_BD.setEmail(el_cliente.getEmail());
			Cliente_BD.setPhone(el_cliente.getPhone());
			Cliente_BD.setDate_added(el_cliente.getDate_added());		
			cliente_service.save(Cliente_BD);
			return Cliente_BD; 
		}
		
		
		// DELETE CLIENTE
		@DeleteMapping("/clientes/delete/{cliente_id}")
		public void deleteCliente(@PathVariable int cliente_id) {
			Cliente el_cliente = cliente_service.findById(cliente_id);
			// excepción si el cliente no existe
			if(el_cliente == null) {
				throw new RuntimeException("Cliente no encontrado");
			}
			cliente_service.deleteById(cliente_id);
			 
		} 
	
}
