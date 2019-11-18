package org.tecnificados.com.evaluador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tecnificados.com.evaluador.bean.ConjuntoDatos;
import org.tecnificados.com.evaluador.bean.OrganoPublicador;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class Evaluador {
	
	private static final Logger log = LoggerFactory.getLogger(Evaluador.class);
	
	private static final int COLUMNA_TITULO = 3;
	private static final int COLUMNA_ORGANO = 10;	
	private static final int COLUMNA_DISTRIBUCIONES = 17;
	

	public static Map<String, OrganoPublicador> evaluaLineas(List<String> readedLines) {
		
		log.info("evaluaLineas");
		
		Map<String, OrganoPublicador> organos= new TreeMap<String, OrganoPublicador>();
		
		
		for (int i=0;i<readedLines.size();i++)
        {
			if (i>0)
			{
					
				String actual=readedLines.get(i);
				
				OrganoPublicador organo = evaluaLinea(actual);
				
				if (organos.containsKey(organo.getName()))
				{
					OrganoPublicador organoYaExistente = organos.get(organo.getName());
					List<ConjuntoDatos> dataset = organoYaExistente.getDataset();
					dataset.addAll(organo.getDataset());
					organoYaExistente.setDataset(dataset);
				}
				else
				{
					organos.put(organo.getName(), organo);
				}
				
				//log.info(actual);
			}
        }
		
		return organos;
	}

	private static OrganoPublicador evaluaLinea(String actual) {
				
		if (actual.contains("\"\""))
		{			
			actual=actual.replace("\"\"","'");		
		}
		
		String[] splitted = actual.split(",");
		List<String> cells=new ArrayList<String>();
					
		boolean fraction=false;
		String valorAnterior="";
		for (int i=0;i<splitted.length;i++)
		{
			String valorActual=splitted[i];
			if (valorActual.startsWith("\""))
			{
				fraction=true;
			}
			if (valorActual.endsWith("\""))
			{
				valorActual=valorAnterior+","+valorActual;
				fraction=false;
			}
			
			if (fraction==false)
			{
				if (valorActual.startsWith("\"") && (valorActual.endsWith("\"")))
				{
					valorActual=valorActual.substring(1);
					valorActual=StringUtils.chop(valorActual);
				}
				cells.add(valorActual);
				valorAnterior="";
			}else {
				valorAnterior=valorAnterior+valorActual+",";
			}
	
		}
		
		//En cell ya tenemos todas las celdas que se ajustan al CSV
		
		//Creamos un organo publicador y le asignamos su nombre
		OrganoPublicador org=new OrganoPublicador();
		org.setName(cells.get(COLUMNA_ORGANO));
		
		ConjuntoDatos dataset=new ConjuntoDatos();
		dataset.setTitle(cells.get(COLUMNA_TITULO));
		
		String distribuciones=cells.get(COLUMNA_DISTRIBUCIONES);
		Set<String> formatos=new TreeSet<String>();
		
		int recursos=0;
		String[] split = distribuciones.split("]");
		for (int j=0;j<split.length;j++)
		{
			String s=split[j];
			if (s.endsWith("MEDIA_TYPE"))				
			{
				String f=split[j+1];
				if (f.contains("["))
				{
					f=f.substring(0,f.indexOf("["));
				}
				if (f.contains("//"))
				{
					f=f.substring(0,f.indexOf("//"));
				}		
				f=f.replace("\"","");
				formatos.add(f);
				recursos++;
			}
		}
		
		dataset.setFormat(formatos);
		dataset.setRecursos(recursos);
		org.getDataset().add(dataset);
		
		
		
		return org;
		
	}

}
