package com.dar.model;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;

public class EscapeUtils {
	public static HashMap<Integer, String> m;
	public static void init() {
		m = new HashMap<Integer, String>();
		m.put(160, "&nbsp;");	// Non-breaking space
		m.put(60, "&lt;");   // < - less-than
		m.put(62, "&gt;");   // > - greater-than
		m.put(34, "&quot;"); // " - quote
		m.put(38, "&amp;");	//Ampersand
		m.put(162, "&cent;");	//Cent
		m.put(163, "&pound;");	//Pound
		m.put(165, "&yen;");	//Yen
		m.put(8364, "&euro;");	//Euro
		m.put(167, "&sect;");	//Section
		m.put(169, "&copy;");	//Copyright
		m.put(174, "&reg;");	//Registered trademark
		m.put(8482, "&trade;");	//Trademark
		
		
	//User needs to map all html entities with their corresponding decimal values. 
    //Please refer to below table for mapping of entities and integer value of a char
    }

	public static String escapeHtml(String str) {
		if(m == null)
			init();
		try {
			StringWriter writer = new StringWriter((int) 
                           (str.length() * 1.5));
			
			escape(writer, str);
			System.out.println("Encoded string is " + writer.toString() );
			return writer.toString();
		   } catch (IOException ioe) {
			ioe.printStackTrace();
			return null;
        }
	}

	private static void escape(Writer writer, String str) throws IOException {
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			int ascii = (int) c;
			String entityName = (String) m.get(ascii);
			if (entityName == null) {
				if (c > 0x7F) {
					writer.write("&#");
					writer.write(Integer.toString(c, 10));
					writer.write(';');
				} else {
					writer.write(c);
				}
			} else {
                     writer.write(entityName);
			}
		}
	}
}
