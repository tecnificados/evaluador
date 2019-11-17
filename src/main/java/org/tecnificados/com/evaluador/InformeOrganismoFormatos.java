package org.tecnificados.com.evaluador;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tecnificados.com.evaluador.bean.ConjuntoDatos;
import org.tecnificados.com.evaluador.bean.OrganoPublicador;

public class InformeOrganismoFormatos {
	
	private static final Logger log = LoggerFactory.getLogger(InformeOrganismoFormatos.class);
	
	private static StringBuffer informe=new StringBuffer();
	
	private static String breakLine=System.getProperty("line.separator");

	public static void generaMD(Map<String, OrganoPublicador> organos) {
		
		addLine("# Informe de Organismos y formatos utilizados");	
		
		addLine("En la siguiente tabla listamos cada organismo, el número de conjuntos de datos publicados, y los formatos que utiliza.");	
		
		addLine("Organismo|Cojuntos de datos|Formatos");
		
		addLine("--|--|--");
		 
		  for (Map.Entry<String, OrganoPublicador> entry : organos.entrySet())  
	        {
			  
			  	
			  
			  	Set<String> diferentesFormatos=new HashSet<String>();
	            
	            List<ConjuntoDatos> dataset = entry.getValue().getDataset();
	            
	            for (ConjuntoDatos d:dataset)
	            {
	            	diferentesFormatos.addAll(d.getFormat());
	            }
	            
	            addLine(entry.getKey()+"|"+entry.getValue().getDataset().size()+"|"+diferentesFormatos);
	        }
		  
		  
		  
		  try {
			FileUtils.writeStringToFile(new File("informes"+File.separator+"organismoFormatos.md"), informe.toString(),"utf-8");
		} catch (IOException e) {
			log.error("Error writing doc in disk",e);
		}
		
	}
	
	private static void addLine(String line)
	{
		informe.append(line+breakLine);
	}

}
