package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IClienteService;
import com.example.demo.interfaces.ICliente;
import com.example.demo.models.Cliente;


@Service
public class ClienteService implements IClienteService{
	
	@Autowired
	private ICliente service;

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		List<Cliente> clientes = service.findAll();
		return clientes;
	}

	@Override
	public Cliente findById(int id) {
		// TODO Auto-generated method stub
		Cliente cliente = service.findById(id);
		return cliente;
	}

	@Override
	public int save(Cliente cliente) {
		// TODO Auto-generated method stub
		int result = service.save(cliente);
		return result;
	}

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		service.deleteById(id);
		return 0;
	}
}
