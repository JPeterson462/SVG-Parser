package org.w3c.dom.svg;

public class SVGErrors {
	
	public static void error(String message) throws SVGException {
		throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, message);
	}

}
