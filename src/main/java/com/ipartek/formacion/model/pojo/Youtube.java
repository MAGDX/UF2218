package com.ipartek.formacion.model.pojo;

public class Youtube {

	// Constantes
	private static final int LONGITUD_CODIGO = 11;
	private static final int LONGITUD_MIN_TITULO = 2;
	private static final int LONGITUD_MAX_TITULO = 150;
	private static final String URL = "https://www.youtube.com/watch?v=";

	// Atributos
	private int id; //id de la BBDD
	private String codigo; // exactamente 11
	private String titulo; // min 2 letras max 150
	private int reproducciones;

	// Constructores
	public Youtube(String codigo, String titulo) throws Exception {
		this.setCodigo(codigo);
		this.setTitulo(titulo);
		this.reproducciones = 0;
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws Exception {
		if (titulo != null && titulo.length() >= LONGITUD_MIN_TITULO && titulo.length() <= LONGITUD_MAX_TITULO) {
			this.titulo = titulo;
		} else {
			throw new Exception("Longitud debe de ser entre " + LONGITUD_MIN_TITULO + " y " + LONGITUD_MAX_TITULO);
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
		return "Youtube [codigo=" + codigo + ", titulo=" + titulo + ", reproducciones=" + reproducciones + "]";
	}

	public String getURL() {
		return URL + codigo;
	}
}