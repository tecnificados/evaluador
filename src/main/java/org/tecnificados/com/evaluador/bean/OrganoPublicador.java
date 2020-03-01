package org.tecnificados.com.evaluador.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tecnificados.com.evaluador.Constant;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class OrganoPublicador {


	
	
	private String name;
	private List<ConjuntoDatos> dataset;
	private Map<Integer, Integer> status;

	
	public OrganoPublicador() {
	
		this.name = "";
		this.dataset = new ArrayList<ConjuntoDatos>();
		this.status = new HashMap<Integer, Integer>();
	}	
	

	
	
	public OrganoPublicador(OrganoPublicador copia) {

		this.name = copia.name;
		this.dataset = copia.dataset;
		this.status = copia.status;
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

	
	
	
	public Map<Integer, Integer> getStatus() {
		return status;
	}




	public void setStatus(Map<Integer, Integer> status) {
		this.status = status;
	}




	@Override
	public String toString() {
		
		String salto=System.getProperty("line.separator");
		
		String theString= "OrganoPublicador [name=" + name + ", dataset=" + dataset + "]";
		theString+=salto;
		for (int i=0;i<5;i++)
		{
			if (status.get(i).intValue()>0)
			{
				theString+="Conjuntos de datos con "+i+" estrellas: "+status.get(i).intValue()+salto;
			}
		}
		return theString;
	}


	public void statusGenerator() {
	
		
		status = new HashMap<Integer, Integer>();
		status.put(0, 0);
		status.put(1, 0);
		status.put(2, 0);
		status.put(3, 0);
		status.put(4, 0);
		
		for (ConjuntoDatos c:dataset)
		{
			int key=c.getStars();			
			int actual = status.get(key);
			actual++;
			status.put(key,actual);			
		}
		
		
		
		
		
		
		
	}

	
	
}
