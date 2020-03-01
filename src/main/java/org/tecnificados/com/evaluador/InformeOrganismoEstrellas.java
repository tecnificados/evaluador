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
public class InformeOrganismoEstrellas {
	
	
	private static final String ESTRELLAS_0 = "No evaluables";
	private static final String ESTRELLAS_1 = "1 Estrella";
	private static final String ESTRELLAS_2 = "2 Estrellas";
	private static final String ESTRELLAS_3 = "3 Estrellas";
	private static final String ESTRELLAS_4 = "4 Estrellas";
	private static final String ORGANISMO = "Organismo";
	private static final String CONJUNTOS_DE_DATOS = "Conjuntos de datos";
	private static final String SEPARADORES = "-- | -- | -- | --| --| --| --";
	private static final String CABECERAS_TABLA = ORGANISMO+" | "+CONJUNTOS_DE_DATOS+" | "+ESTRELLAS_0+" | "+ESTRELLAS_1+" | "+ESTRELLAS_2+" | "+ESTRELLAS_3+" | "+ESTRELLAS_4;
	private static final String DESCRIPCION = "En la siguiente tabla listamos por cada organismo, los diversos conjuntos de datos puntuados hasta cuatro estrellas";
	private static final String TITULO = "# Informe de Organismos y conjuntos de datos agrupados por su puntuación";

	private static final Logger log = LoggerFactory.getLogger(InformeOrganismoEstrellas.class);
	
	private static StringBuffer informeMD=new StringBuffer();
	private static StringBuffer informeCSV=new StringBuffer();
	
	private static String breakLine=System.getProperty("line.separator");
	private static String csvSeparator=";";
	private static String csvQuote="\"";

	public static void genFiles(Map<String, OrganoPublicador> organos, String fileName) {
		
		if ((fileName==null)||(fileName.equals("")))
		{
			fileName="organismoPuntuacion";
		}
		
		informeMD=new StringBuffer();
		informeCSV=new StringBuffer();
		
		mdLine(TITULO);		
		mdLine(DESCRIPCION);		
		mdLine("");		
		mdLine(CABECERAS_TABLA);		
		mdLine(SEPARADORES);
		
		informeCSV.append(new String(Constant.bom));
		
		csvLine(ORGANISMO+csvSeparator+CONJUNTOS_DE_DATOS+csvSeparator+ESTRELLAS_0+csvSeparator+ESTRELLAS_1+csvSeparator+ESTRELLAS_2+csvSeparator+ESTRELLAS_3+csvSeparator+ESTRELLAS_4);
		
		 
		  for (Map.Entry<String, OrganoPublicador> entry : organos.entrySet())  
	        {
			  	Set<String> diferentesFormatos=new TreeSet<String>();
			  	
			              
	            List<ConjuntoDatos> dataset = entry.getValue().getDataset();
	            	            
	            mdLine(entry.getKey()+" | "+entry.getValue().getDataset().size()+" | "+entry.getValue().getStatus().get(0)+" | "+entry.getValue().getStatus().get(1)+" | "+entry.getValue().getStatus().get(2)+" | "+entry.getValue().getStatus().get(3)+" | "+entry.getValue().getStatus().get(4));
	            csvLine(csvQuote+entry.getKey()+csvQuote+csvSeparator+entry.getValue().getDataset().size()+csvSeparator+entry.getValue().getStatus().get(0)+csvSeparator+entry.getValue().getStatus().get(1)+csvSeparator+entry.getValue().getStatus().get(2)+csvSeparator+entry.getValue().getStatus().get(3)+csvSeparator+entry.getValue().getStatus().get(4));
	        }
		  
		  
		  
		  try {
			FileUtils.writeStringToFile(new File("informes"+File.separator+fileName+".md"), informeMD.toString(),"utf-8");
			FileUtils.writeStringToFile(new File("informes"+File.separator+fileName+".csv"), informeCSV.toString(),"utf-8");
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
