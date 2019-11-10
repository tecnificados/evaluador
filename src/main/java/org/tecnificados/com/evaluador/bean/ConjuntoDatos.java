package org.tecnificados.com.evaluador.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class ConjuntoDatos {
	
	private String title;
	private List<String> format;
	
	
	public ConjuntoDatos() {
		super();
		this.title = "";
		this.format = new ArrayList<String>();
	}
	
	public ConjuntoDatos(String title, List<String> format) {
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


	public List<String> getFormat() {
		return format;
	}


	public void setFormat(List<String> format) {
		this.format = format;
	}
	
	

}
