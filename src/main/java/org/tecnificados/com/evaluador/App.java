package org.tecnificados.com.evaluador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tecnificados.com.evaluador.bean.ConjuntoDatos;
import org.tecnificados.com.evaluador.bean.OrganoPublicador;
import org.tecnificados.com.evaluador.util.Messages;

/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class App 
{

	

	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	
	
	private static void configuration() {
		Properties prop = new Properties();
    	try 
    	{
    		InputStream input = new FileInputStream(Constant.CONF_PROPERTIES);
    		prop.load(input);    	         	    
    	} 
    	catch (IOException ex) {
    	    log.error(Messages.getString("App.3"),ex); 
    	}
    	
    	if (prop.getProperty(Constant.PATH_TO_FILE)!=null) {
    		Constant.filePath=prop.getProperty(Constant.PATH_TO_FILE);
    	}else {
    		log.info(Constant.PATH_TO_FILE+Messages.getString("App.4")+Constant.CONF_PROPERTIES); 
    	}
		
	}
	
    public static void main( String[] args )
    {    	
    	Locale.setDefault(new Locale("es_ES"));
    
    	
    	log.info(Messages.getString("App.5")); 
    	    	  	
    	configuration();    	
    	
    	List<String> readedLines = new ArrayList<String>();
        try {
        	readedLines = FileUtils.readLines(new File(Constant.filePath),Constant.UTF_8);
        	log.info(Messages.getString("App.7")+readedLines.size()); 
			
		} catch (IOException e) {
			log.error(Messages.getString("App.8"),e); 
		}
        
        Map<String, OrganoPublicador> organos=Evaluador.evaluaLineas(readedLines);
        
        Set<String> diferentesFormatos = availableFormats(organos);
        
        //TODO generar una tabla de puntuacion para cada formato
        log.info("Los diferentes formatos son: "+diferentesFormatos);
        //TODO verificar si los formatos no varian de una ejecucion a otra, si varían enumera y lanzar excepcion
        
        //Comenzamos a generar Informes
        InformeOrganismoFormatos.genFiles(organos);
        
        
        log.info(Messages.getString("App.9")); 
    }

	private static Set<String> availableFormats(Map<String, OrganoPublicador> organos) {
		Set<String> diferentesFormatos=new HashSet<String>();
       
        for (Map.Entry<String, OrganoPublicador> entry : organos.entrySet())  
        {
            log.info( entry.getKey() + "," + entry.getValue().getDataset().size()); 
            
            List<ConjuntoDatos> dataset = entry.getValue().getDataset();
            
            for (ConjuntoDatos d:dataset)
            {
            	diferentesFormatos.addAll(d.getFormat());
            }
            
        }
		return diferentesFormatos;
	}

	
}
