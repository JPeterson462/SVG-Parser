package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public class DOMErrors {

	public static <T> T deprecatedMethod() throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "This method is deprecated");
	}
	
	public static void notSupported() {
		//TODO
	}
	
}
