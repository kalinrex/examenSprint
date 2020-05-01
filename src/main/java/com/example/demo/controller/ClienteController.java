package com.example.demo.controller;

import java.util.Date;  
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Enums.ResponseCode;
import com.example.demo.interfaceService.IClienteService;
import com.example.demo.models.Cliente;


@RestController
@RequestMapping("/NutriNET")
public class ClienteController {
	
	@Autowired
	private IClienteService service;

	@GetMapping("/getClientes")
	public HashMap<String, Object> getClientes(){
		HashMap<String, Object> res = new HashMap<>();
		List<Cliente> clientes = (List<Cliente>)service.findAll();
		res = Response(ResponseCode.EXITOSO, clientes);
		return res;
	}
	@GetMapping("/getClienteById/{id}")
	public  HashMap<String, Object> getClienteById(@PathVariable int id){
		HashMap<String, Object> res = new HashMap<>();
		
		Cliente cliente = service.findById(id);
		
		if(cliente == null) {
			res = Response(ResponseCode.ERROR, "El cliente no existe en la base de datos");
			
		}
		res = Response(ResponseCode.EXITOSO, cliente);
		return res;
	}
	
	@PostMapping("/addCliente")
	public  HashMap<String, Object> addCliente(@RequestBody Cliente cliente){
		HashMap<String, Object> res = new HashMap<>();
		cliente.setId(0);
		int result = service.save(cliente);
		System.out.print(result);
		if(result == -1) {
			return res = Response(ResponseCode.ERROR, "El cliente ya existe favor de verificarlo");
		}
		
		res = Response(ResponseCode.EXITOSO, "Registro guardado correctamente");
		return res;
	}
	@PutMapping("/updateCliente/{id}")
	public HashMap<String, Object> updateCliente(@PathVariable int id, @RequestBody Cliente cliente){
		HashMap<String, Object> res = new HashMap<>();
		cliente.setId(id);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		 Date date = new Date(); 
		 String str = formatter.format(date);
		 Date hoy = null;
		try {
			hoy = formatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		cliente.setFecha_Actualizacion(hoy);
		int result = service.save(cliente);
		
		if(result == -1) {
			return res = Response(ResponseCode.ERROR, "A ocurrido un error...");
		}
		res = Response(ResponseCode.EXITOSO, result);
		
		return res;
	}
	
	@DeleteMapping("deleteCliente/{id}")
	public  HashMap<String, Object> deleteCliente(@PathVariable int id) {
		HashMap<String, Object> res = new HashMap<>();
		Cliente cliente = service.findById(id);
		
		if(cliente == null) {
			return res = Response(ResponseCode.ERROR, "El cliente no exiwste");
		}
		
		service.deleteById(id);
		
		res = Response(ResponseCode.EXITOSO, "Cliente eliminado");
		return res;
	}
	
	public HashMap<String, Object> Response(Object code, Object message){
		HashMap<String, Object> res = new HashMap<>();
		 res.put("Cve_Error", code);
		 res.put("Cve_Mensaje", message);
		return res;
	}
}
