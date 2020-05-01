package com.example.demo.models;

import java.util.Date;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cliente")
public class Cliente {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private int Id;
	
	@Column(name="Nombre_Usuario")
	private String Nombre_Usuario;
	
	@Column(name="Contrasena")
	private String Contrasena;
	
	@Column(name="Nombre")
	private String Nombre;
	
	@Column(name="Apellidos")
	private String Apellidos;
	
	@Column(name="Correo_Electronico")
	private String Correo_Electronico;
	
	@Column(name="Edad")
	private int Edad;
	
	@Column(name="Estatura")
	private double Estatura;
	
	@Column(name="Peso")
	private double Peso;
	
	@Column(name="IMC")
	private double IMC;
	
	@Column(name="GEB")
	private double GEB;
	
	@Column(name="ETA")
	private double ETA;
	
	@Column(name="Fecha_Creacion")
	private Date Fecha_Creacion;
	
	@Column(name="Fecha_Actualizacion")
	private Date Fecha_Actualizacion;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(int Idc, String nombre_Usuario, String contrasena, String nombre, String apellidos,
			String correo_Electronico, int edad, double estatura, double peso, double iMC, double gEB, double eTA,
			Date fecha_Creacion, Date fecha_Actualizacion) {
		super();
		Id = Idc;
		Nombre_Usuario = nombre_Usuario;
		Contrasena = contrasena;
		Nombre = nombre;
		Apellidos = apellidos;
		Correo_Electronico = correo_Electronico;
		Edad = edad;
		Estatura = estatura;
		Peso = peso;
		IMC = iMC;
		GEB = gEB;
		ETA = eTA;
		Fecha_Creacion = fecha_Creacion;
		Fecha_Actualizacion = fecha_Actualizacion;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNombre_Usuario() {
		return Nombre_Usuario;
	}

	public void setNombre_Usuario(String nombre_Usuario) {
		Nombre_Usuario = nombre_Usuario;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public String getCorreo_Electronico() {
		return Correo_Electronico;
	}

	public void setCorreo_Electronico(String correo_Electronico) {
		Correo_Electronico = correo_Electronico;
	}

	public int getEdad() {
		return Edad;
	}

	public void setEdad(int edad) {
		Edad = edad;
	}

	public double getEstatura() {
		return Estatura;
	}

	public void setEstatura(double estatura) {
		Estatura = estatura;
	}

	public double getPeso() {
		return Peso;
	}

	public void setPeso(double peso) {
		Peso = peso;
	}

	public double getIMC() {
		return IMC;
	}

	public void setIMC(double iMC) {
		IMC = iMC;
	}

	public double getGEB() {
		return GEB;
	}

	public void setGEB(double gEB) {
		GEB = gEB;
	}

	public double getETA() {
		return ETA;
	}

	public void setETA(double eTA) {
		ETA = eTA;
	}

	public Date getFecha_Creacion() {
		return Fecha_Creacion;
	}

	public void setFecha_Creacion(Date fecha_Creacion) {
		Fecha_Creacion = fecha_Creacion;
	}

	public Date getFecha_Actualizacion() {
		return Fecha_Actualizacion;
	}

	public void setFecha_Actualizacion(Date fecha_Actualizacion) {
		Fecha_Actualizacion = fecha_Actualizacion;
	}
}
