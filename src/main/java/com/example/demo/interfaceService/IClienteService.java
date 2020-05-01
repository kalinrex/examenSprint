package com.example.demo.interfaceService;

import java.util.List;

import com.example.demo.models.Cliente;



public interface IClienteService {
	
	public List<Cliente> findAll();
	
	public Cliente findById(int id);
	
	public int save(Cliente cliente);
	
	public int deleteById(int id);
}
