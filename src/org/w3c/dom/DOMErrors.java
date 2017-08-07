package org.w3c.dom;

import org.w3c.dom.DOMException;

public class DOMErrors {

	public static <T> T deprecatedMethod() throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "This method is deprecated");
	}
	
	public static <T> T notSupported() throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}
	
	public static <T> T indexTooHigh() throws DOMException {
		throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
	}
	
	public static <T> T readonly(Class<T> type) throws DOMException {
		throw new DOMException(DOMException.INVALID_MODIFICATION_ERR, "Instances of " + type.getSimpleName() + " are readonly");
	}
	
	public static <T> T invalidAccess() throws DOMException {
		throw new DOMException(DOMException.INVALID_ACCESS_ERR, "Invalid Value");
	}
	
	public static <T> T invalidValue() throws DOMException {
		throw new DOMException(DOMException.VALIDATION_ERR, "Invalid Value");
	}
	
}
