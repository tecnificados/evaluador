/**
 * 
 */
package org.tecnificados.com.evaluador.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 *
 */
public class FormatMap {
	
	public static Map<String, Integer> formats=new HashMap<String,Integer>();
	
	static
	{
		
		Map<String, Integer> tempMap=new HashMap<String,Integer>();
		
		tempMap.put("API", 0); 
		tempMap.put("GZIP", 0); 
		tempMap.put("Solr", 0); 
		tempMap.put("SPARQL", 0); 
		tempMap.put("SPARQL-JSON", 0); 
		tempMap.put("SPARQL-XML", 0); 
		tempMap.put("XML-APP", 0); 
		tempMap.put("ZIP", 0); 
		tempMap.put("PDF", 1); 
		tempMap.put("PNG", 1); 
		tempMap.put("JPG", 1); 
		tempMap.put("Atom", 2); 
		tempMap.put("DBF", 2); 
		tempMap.put("DGN", 2); 
		tempMap.put("DjVu", 2); 
		tempMap.put("DOC", 2); 
		tempMap.put("DOCX", 2); 
		tempMap.put("DWG", 2); 
		tempMap.put("DXF", 2); 
		tempMap.put("ECW", 2); 
		tempMap.put("ELP", 2); 
		tempMap.put("ePub", 2); 
		tempMap.put("HTML", 2); 
		tempMap.put("MDB", 2); 
		tempMap.put("OCTET-STREAM", 2); 
		tempMap.put("SHP", 2); 
		tempMap.put("SOAP", 2); 
		tempMap.put("TIFF", 2); 
		tempMap.put("WFS", 2); 
		tempMap.put("WMS", 2); 
		tempMap.put("WMS-XML", 2); 
		tempMap.put("XHTML", 2); 
		tempMap.put("XLS", 2); 
		tempMap.put("XLSX", 2); 
		tempMap.put("ASCII", 3); 
		tempMap.put("Calendar", 3); 
		tempMap.put("CSV", 3); 
		tempMap.put("CSW", 3); 
		tempMap.put("GDB", 3); 
		tempMap.put("GeoJSON", 3); 
		tempMap.put("GeoRSS", 3); 
		tempMap.put("GML", 3); 
		tempMap.put("GPX", 3); 
		tempMap.put("JSON", 3); 
		tempMap.put("KML", 3); 
		tempMap.put("KMZ", 3); 
		tempMap.put("LAS", 3); 
		tempMap.put("MARC", 3); 
		tempMap.put("ODS", 3); 
		tempMap.put("ODT", 3); 
		tempMap.put("PC-Axis", 3); 
		tempMap.put("plain", 3); 
		tempMap.put("RSS", 3); 
		tempMap.put("RTF", 3); 
		tempMap.put("SCORM", 3); 
		tempMap.put("TBX", 3); 
		tempMap.put("TMX", 3); 
		tempMap.put("TSV", 3); 
		tempMap.put("vCard-XML", 3); 
		tempMap.put("WCS", 3); 
		tempMap.put("XBRL", 3); 
		tempMap.put("XML", 3); 
		tempMap.put("JSON-LD", 4); 
		tempMap.put("N3", 4); 
		tempMap.put("TURTLE", 4); 
		tempMap.put("RDF-N3", 4); 
		tempMap.put("RDF-Turtle", 4); 
		tempMap.put("RDF-XML", 4); 
		
		//pasamos todo a minusculas
		for (Map.Entry<String, Integer> entry : tempMap.entrySet()) {
			formats.put(entry.getKey().toLowerCase(), entry.getValue());
		}
		
	}

}
