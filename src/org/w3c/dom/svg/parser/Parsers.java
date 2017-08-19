package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.svg.parser.shapes.SVGCircleElementParser;
import org.w3c.dom.svg.parser.shapes.SVGEllipseElementParser;
import org.w3c.dom.svg.parser.shapes.SVGLineElementParser;
import org.w3c.dom.svg.parser.shapes.SVGPolygonElementParser;
import org.w3c.dom.svg.parser.shapes.SVGPolylineElementParser;
import org.w3c.dom.svg.parser.shapes.SVGRectElementParser;

@SuppressWarnings("rawtypes")
public class Parsers {
	
	private static final HashMap<String, ElementParser> parsers = new HashMap<>();
	
	private static boolean registered = false;

	private Parsers() {
		// Hidden Constructor
	}
	
	public static void registerParsers() {
		parsers.put(Tags.METADATA, new SVGMetadataElementParser());
		parsers.put(Tags.CIRCLE, new SVGCircleElementParser());
		parsers.put(Tags.ELLIPSE, new SVGEllipseElementParser());
		parsers.put(Tags.LINE, new SVGLineElementParser());
		parsers.put(Tags.POLYGON, new SVGPolygonElementParser());
		parsers.put(Tags.POLYLINE, new SVGPolylineElementParser());
		parsers.put(Tags.RECT, new SVGRectElementParser());
		registered = true;
	}
	
	public static boolean hasRegistered() {
		return registered;
	}
	
	public static ElementParser getParser(String tag) {
		return parsers.get(tag);
	}
	
}
