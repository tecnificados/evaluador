package org.tecnificados.com.evaluador.bean;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class OrganoPublicador {

	private String name;
	private List<ConjuntoDatos> dataset;
	
	public OrganoPublicador() {
	
		this.name = "";
		this.dataset = new ArrayList<ConjuntoDatos>();
	}	
	
	public OrganoPublicador(String name, List<ConjuntoDatos> dataset) {

		this.name = name;
		this.dataset = dataset;
	}
	
	
	public OrganoPublicador(OrganoPublicador copia) {

		this.name = copia.name;
		this.dataset = copia.dataset;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<ConjuntoDatos> getDataset() {
		return dataset;
	}
	public void setDataset(List<ConjuntoDatos> dataset) {
		this.dataset = dataset;
	}

	@Override
	public String toString() {
		return "OrganoPublicador [name=" + name + ", dataset=" + dataset + "]";
	}

		
	
	
}
