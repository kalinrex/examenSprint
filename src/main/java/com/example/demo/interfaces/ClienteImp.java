package com.example.demo.interfaces;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.models.Cliente;

import javax.persistence.EntityManager;
@Transactional
@Repository
public class ClienteImp implements ICliente{
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Cliente> query = currentSession.createQuery("FROM Cliente", Cliente.class);
		List<Cliente> clientes = query.getResultList();
		return clientes;
	}

	@Override
	public Cliente findById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);

		Cliente cliente = currentSession.get(Cliente.class, id);
			
		return cliente;
	}
	
	@Override
	public int save(Cliente cliente) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		int Id = cliente.getId();
		String NombreUsuario = cliente.getNombre_Usuario().toString();
		String CorreoElectronico = cliente.getCorreo_Electronico().toString();
		System.out.print(Id);
		if(Id == 0) {
			
			@SuppressWarnings("unchecked")
			Query<Cliente> nombreUsuario = currentSession.createQuery("SELECT Id FROM Cliente WHERE Nombre_Usuario = :nombreUser");
			nombreUsuario.setParameter("nombreUser", NombreUsuario);
			@SuppressWarnings("unchecked")
			Query<Cliente> correo = currentSession.createQuery("SELECT Id FROM Cliente WHERE Correo_Electronico = :correoE");
			correo.setParameter("correoE", CorreoElectronico);
			if(nombreUsuario.getResultList().size() > 0 || correo.getResultList().size() > 0 ) {
				return -1;
			}
			currentSession.save(cliente);
		}else {
			
			//System.out.print("actualizar");
			String upd = "UPDATE Cliente SET Nombre_Usuario = :nombreUser, "
					+ "Contrasena = :contra, "
					+ "Nombre = :nombre, "
					+ "Apellidos = :ape,"
					+ "Correo_Electronico = :correo, "
					+ "Edad = :edad, "
					+ "Estatura = :estatura, "
					+ "Peso = :peso, "
					+ "IMC = :imc, "
					+ "GEB = :geb, "
					+ "ETA = :eta, "
					+ "Fecha_Actualizacion = :fechaActualizacion WHERE Id = :id";
					
			
				//currentSession.saveOrUpdate(cliente);
				@SuppressWarnings("unchecked")
				Query<Cliente> query = currentSession.createQuery(upd);
				query.setParameter("nombreUser", cliente.getNombre_Usuario().toString());
				query.setParameter("contra", cliente.getContrasena().toString());
				query.setParameter("nombre", cliente.getNombre().toString());
				query.setParameter("ape", cliente.getApellidos().toString());
				query.setParameter("correo", cliente.getCorreo_Electronico().toString());
				query.setParameter("estatura", cliente.getEstatura());
				query.setParameter("edad", cliente.getEdad());
				query.setParameter("peso", cliente.getPeso());
				query.setParameter("imc", cliente.getIMC());
				query.setParameter("geb", cliente.getGEB());
				query.setParameter("eta", cliente.getETA());
				query.setParameter("fechaActualizacion", cliente.getFecha_Actualizacion());
				query.setParameter("id", cliente.getId());
				int rowsUpdated = query.executeUpdate();
				System.out.println("rows "+rowsUpdated);
//				System.out.println("nombreUser "+ cliente.getNombre_Usuario().toString());
//				System.out.println("contra "+ cliente.getContrasena().toString());
//				System.out.println("nombre "+ cliente.getNombre().toString());
//				System.out.println("ape "+ cliente.getApellidos().toString());
//				System.out.println("correo "+ cliente.getCorreo_Electronico().toString());
//				System.out.println("estatura "+ cliente.getEstatura());
//				System.out.println("peso "+ cliente.getPeso());
//				System.out.println("imc "+ cliente.getIMC());
//				System.out.println("geb "+ cliente.getGEB());
//				System.out.println("eta "+ cliente.getETA());
//				System.out.println("fechaActualizacion "+ cliente.getFecha_Actualizacion());
//				System.out.println("id "+ cliente.getId());
				//query.executeUpdate();
			
			
			
			return 0;
		}

		return 0;
		
	}
	

	@Override
	public int deleteById(int id) {
		// TODO Auto-generated method stub
		Session currentSession = entityManager.unwrap(Session.class);
		System.out.print(id);
		@SuppressWarnings("unchecked")
		Query<Cliente> query = currentSession.createQuery("DELETE FROM Cliente WHERE Id=:id");
		
		query.setParameter("id", id);
		query.executeUpdate();
		//currentSession.getTransaction().commit();
		return 0;
	}
}
