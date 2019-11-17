package org.tecnificados.com.evaluador;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tecnificados.com.evaluador.bean.ConjuntoDatos;
import org.tecnificados.com.evaluador.bean.OrganoPublicador;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class InformeOrganismoFormatos {
	
	private static final Logger log = LoggerFactory.getLogger(InformeOrganismoFormatos.class);
	
	private static StringBuffer informeMD=new StringBuffer();
	private static StringBuffer informeCSV=new StringBuffer();
	
	private static String breakLine=System.getProperty("line.separator");
	private static String csvSeparator=";";
	private static String csvQuote="\"";

	public static void genFiles(Map<String, OrganoPublicador> organos) {
		
		mdLine("# Informe de Organismos y formatos utilizados");	
		
		mdLine("En la siguiente tabla listamos cada organismo, el número de conjuntos de datos publicados, y los formatos que utiliza.");	
		
		mdLine("Organismo | Cojuntos de datos | Formatos");
		
		mdLine("-- | -- | --");
		
		csvLine("Organismo"+csvSeparator+"Cojuntos de datos"+csvSeparator+"Formatos");
		
		 
		  for (Map.Entry<String, OrganoPublicador> entry : organos.entrySet())  
	        {
			  	Set<String> diferentesFormatos=new TreeSet<String>();
	            
	            List<ConjuntoDatos> dataset = entry.getValue().getDataset();
	            
	            for (ConjuntoDatos d:dataset)
	            {
	            	diferentesFormatos.addAll(d.getFormat());
	            }
	            
	            String listaFormatos=diferentesFormatos.toString().substring(1);
	            listaFormatos=StringUtils.chop(listaFormatos);
	            
	            
	            mdLine(entry.getKey()+" | "+entry.getValue().getDataset().size()+" | "+listaFormatos);
	            csvLine(csvQuote+entry.getKey()+csvQuote+csvSeparator+entry.getValue().getDataset().size()+csvSeparator+csvQuote+listaFormatos+csvQuote);
	        }
		  
		  
		  
		  try {
			FileUtils.writeStringToFile(new File("informes"+File.separator+"organismoFormatos.md"), informeMD.toString(),"utf-8");
			FileUtils.writeStringToFile(new File("informes"+File.separator+"organismoFormatos.csv"), informeCSV.toString(),"utf-8");
		} catch (IOException e) {
			log.error("Error writing docs in disk",e);
		}
		
	}
	
	private static void mdLine(String line)
	{
		informeMD.append(line+breakLine);
	}
	
	private static void csvLine(String line)
	{
		informeCSV.append(line+breakLine);
	}

}
