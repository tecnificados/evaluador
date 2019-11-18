package org.tecnificados.com.evaluador.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class ConjuntoDatos {
	
	private String title;
	private Set<String> format;
	private int recursos;
	
	
	public ConjuntoDatos() {
		super();
		this.title = "";
		this.format = new TreeSet<String>();
		this.recursos=0;
	}
	
	public ConjuntoDatos(String title, TreeSet<String> format, int recursos) {
		super();
		this.title = title;
		this.format = format;
		this.recursos=recursos;
	}
	
	
	public ConjuntoDatos(ConjuntoDatos copia) {
		super();
		this.title = copia.title;
		this.format = copia.format;
		this.recursos=copia.recursos;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Set<String> getFormat() {
		return format;
	}


	public void setFormat(Set<String> format) {
		this.format = format;
	}

	public int getRecursos() {
		return recursos;
	}

	public void setRecursos(int recursos) {
		this.recursos = recursos;
	}
	
	

}
