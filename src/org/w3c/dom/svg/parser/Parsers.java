package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.svg.parser.fonts.SVGFontFaceFormatElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontFaceNameElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontFaceSrcElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontFaceUriElementParser;
import org.w3c.dom.svg.parser.shapes.SVGCircleElementParser;
import org.w3c.dom.svg.parser.shapes.SVGEllipseElementParser;
import org.w3c.dom.svg.parser.shapes.SVGLineElementParser;
import org.w3c.dom.svg.parser.shapes.SVGPolygonElementParser;
import org.w3c.dom.svg.parser.shapes.SVGPolylineElementParser;
import org.w3c.dom.svg.parser.shapes.SVGRectElementParser;
import org.w3c.dom.svg.parser.text.SVGTRefElementParser;
import org.w3c.dom.svg.parser.text.SVGTSpanElementParser;
import org.w3c.dom.svg.parser.text.SVGTextElementParser;

@SuppressWarnings("rawtypes")
public class Parsers {
	
	private static final HashMap<String, ElementParser> parsers = new HashMap<>();
	
	private static boolean registered = false;

	private Parsers() {
		// Hidden Constructor
	}
	
	public static void registerParsers() { // 17 out of 51 parsers completed
		parsers.put(Tags.STYLE, new SVGStyleElementParser());
		parsers.put(Tags.CURSOR, new SVGCursorElementParser());
		parsers.put(Tags.METADATA, new SVGMetadataElementParser());
		parsers.put(Tags.CIRCLE, new SVGCircleElementParser());
		parsers.put(Tags.ELLIPSE, new SVGEllipseElementParser());
		parsers.put(Tags.LINE, new SVGLineElementParser());
		parsers.put(Tags.POLYGON, new SVGPolygonElementParser());
		parsers.put(Tags.POLYLINE, new SVGPolylineElementParser());
		parsers.put(Tags.RECT, new SVGRectElementParser());
		parsers.put(Tags.FONT_FACE_SRC, new SVGFontFaceSrcElementParser());
		parsers.put(Tags.FONT_FACE_URI, new SVGFontFaceUriElementParser());
		parsers.put(Tags.FONT_FACE_FORMAT, new SVGFontFaceFormatElementParser());
		parsers.put(Tags.FONT_FACE_NAME, new SVGFontFaceNameElementParser());
		parsers.put(Tags.SCRIPT, new SVGScriptElementParser());
		parsers.put(Tags.TEXT, new SVGTextElementParser());
		parsers.put(Tags.TSPAN, new SVGTSpanElementParser());
		parsers.put(Tags.TREF, new SVGTRefElementParser());
		registered = true;
	}
	
	public static boolean hasRegistered() {
		return registered;
	}
	
	public static ElementParser getParser(String tag) {
		return parsers.get(tag);
	}
	
}
