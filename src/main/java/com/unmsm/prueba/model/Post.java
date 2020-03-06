package com.unmsm.prueba.model;

public class Post {
	private String titulo;
	private String descripcion;
	private String urlIMG;
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String getUrlIMG() {
		return urlIMG;
	}
	
	public void setUrlIMG(String urlIMG) {
		this.urlIMG = urlIMG;
	}
	
	public Post(String titulo, String descripcion, String urlIMG) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.urlIMG = urlIMG;
	}
	
	public Post() {
	}
	
	
}
