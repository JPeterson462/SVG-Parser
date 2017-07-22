package org.w3c.dom.svg.parser;

import java.util.HashMap;

@SuppressWarnings("rawtypes")
public class Parsers {
	
	private static final HashMap<String, ElementParser> parsers = new HashMap<>();
	
	private static boolean registered = false;

	private Parsers() {
		// Hidden Constructor
	}
	
	public static void registerParsers() {
		parsers.put(Tags.METADATA, new SVGMetadataElementParser());
		registered = true;
	}
	
	public static boolean hasRegistered() {
		return registered;
	}
	
	public static ElementParser getParser(String tag) {
		return parsers.get(tag);
	}
	
}
