package org.tecnificados.com.evaluador.bean;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class ConjuntoDatos {
	
	private String title;
	private Set<String> format;
	
	
	public ConjuntoDatos() {
		super();
		this.title = "";
		this.format = new HashSet<String>();
	}
	
	public ConjuntoDatos(String title, HashSet<String> format) {
		super();
		this.title = title;
		this.format = format;
	}
	
	
	public ConjuntoDatos(ConjuntoDatos copia) {
		super();
		this.title = copia.title;
		this.format = copia.format;
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
	
	

}
