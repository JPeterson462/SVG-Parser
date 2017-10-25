package org.w3c.dom.svg;

import java.io.PrintWriter;
import java.io.StringWriter;

public class SVGErrors {
	
	public static <T> T error(String message) throws SVGException {
		throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, message);
	}

	public static void error(Exception e) {
		StringWriter writer = new StringWriter();
		e.printStackTrace(new PrintWriter(writer));
		error(writer.toString());
	}

}
