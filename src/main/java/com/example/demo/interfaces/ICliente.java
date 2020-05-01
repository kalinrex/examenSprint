package com.example.demo.interfaces;

import java.util.List;

import com.example.demo.models.Cliente;



public interface ICliente {
	public List<Cliente> findAll();
	
	public Cliente findById(int id);
	
	public int save(Cliente user);
	
	public int deleteById(int id);
}
