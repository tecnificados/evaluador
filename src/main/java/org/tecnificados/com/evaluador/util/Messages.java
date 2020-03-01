package org.tecnificados.com.evaluador.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * @author Juan Carlos Ballesteros (tecnificados.com)
 */
public class Messages {
	private static final String BUNDLE_NAME = "org.tecnificados.com.evaluador.util.messages"; 

	private static ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle("messages");

	private Messages() {
	}
	
	static void setLocale(String lang) {
		Locale.setDefault(new Locale(lang));

	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
