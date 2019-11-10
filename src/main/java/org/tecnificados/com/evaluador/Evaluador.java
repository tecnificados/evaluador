package org.tecnificados.com.evaluador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tecnificados.com.evaluador.bean.ConjuntoDatos;
import org.tecnificados.com.evaluador.bean.OrganoPublicador;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class Evaluador {
	
	private static final Logger log = LoggerFactory.getLogger(Evaluador.class);

	public static Map<String, OrganoPublicador> evaluaLineas(List<String> readedLines) {
		
		
		Map<String, OrganoPublicador> organos= new HashMap<String, OrganoPublicador>();
		
		
		for (int i=0;i<readedLines.size();i++)
        {
			if (i>0)
			{
				String actual=readedLines.get(0);
				
				OrganoPublicador organo = evaluaLinea(actual);
				
				if (organos.containsKey(organo.getName()))
				{
					OrganoPublicador organoYaExistente = organos.get(organo.getName());
					List<ConjuntoDatos> dataset = organoYaExistente.getDataset();
					//dataset.add(organo.getDataset());
				}
				else
				{
					organos.put(organo.getName(), organo);
				}
				
				log.info(actual);
			}
        }
		
		return organos;
	}

	private static OrganoPublicador evaluaLinea(String actual) {
		
		String[] splited = actual.split(",");
		
		OrganoPublicador org=new OrganoPublicador();
		org.setName(splited[11]);
		
		return org;
		
	}

}
