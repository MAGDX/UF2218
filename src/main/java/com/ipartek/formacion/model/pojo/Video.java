package com.ipartek.formacion.model.pojo;

public class Video {

	// Constantes
	private static final int LONGITUD_CODIGO = 11;
	private static final int LONGITUD_MIN_NOMBRE = 2;
	private static final int LONGITUD_MAX_NOMBRE = 150;
	private static final String URL = "https://www.youtube.com/watch?v=";

	// Atributos
	private int id; //id de la BBDD
	private String codigo; // exactamente 11
	private String nombre; // min 2 letras max 150
	private int reproducciones;

	// Constructores
	public Video() {
		this.id = -1;
		this.nombre = "";
		this.codigo = "";
		this.reproducciones = 0;
	}
	
	public Video(int id, String codigo, String nombre) throws Exception {
		super();
		this.setId(id);
		this.setCodigo(codigo);
		this.setNombre(nombre);
	}

	public Video(String codigo, String nombre) throws Exception {
		this.setCodigo(codigo);
		this.setNombre(nombre);
	}
	
	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) throws Exception {

		if (codigo != null && codigo.length() == LONGITUD_CODIGO) {
			this.codigo = codigo;
		} else {
			throw new Exception("Longitud debe de ser " + LONGITUD_CODIGO);
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if (nombre != null && nombre.length() >= LONGITUD_MIN_NOMBRE && nombre.length() <= LONGITUD_MAX_NOMBRE) {
			this.nombre = nombre;
		} else {
			throw new Exception("Longitud debe de ser entre " + LONGITUD_MIN_NOMBRE + " y " + LONGITUD_MAX_NOMBRE);
		}
	}

	public int getReproducciones() {
		return reproducciones;
	}

	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
	}

	// Funciones
	public String toString() {
		return "Video [codigo=" + codigo + ", nombre=" + nombre + ", reproducciones=" + reproducciones + "]";
	}

	public String getURL() {
		return URL + codigo;
	}
}