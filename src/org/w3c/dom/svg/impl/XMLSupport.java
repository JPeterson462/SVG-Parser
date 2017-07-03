package org.w3c.dom.svg.impl;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

// https://github.com/apache/batik/blob/c1d67eac2699e33807ee63a115dff5c46bcea2b7/batik-dom/src/main/java/org/apache/batik/dom/util/XMLSupport.java
public class XMLSupport {

	public static final String XML_PRESERVE_VALUE = "preserve";
	
	public static final String XML_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
	
	public static String getXMLSpace(Element elt) {
		Attr attr = elt.getAttributeNodeNS(XML_NAMESPACE_URI, "space");
		if (attr != null) {
			return attr.getNodeValue();
		}
		for (Node n = elt.getParentNode(); n != null; n = n.getParentNode()) {
			if (n.getNodeType() == Node.ELEMENT_NODE) {
				attr = ((Element)n).getAttributeNodeNS(XML_NAMESPACE_URI,
						"space");
				if (attr != null) {
					return attr.getNodeValue();
				}
			}
		}
		return "default";
	}
	
	public static boolean isXMLSpace(char c) {
	      return (c <= 0x0020) &&
	             (((((1L << 0x0009) |
	                 (1L << 0x000A) |
	                 (1L << 0x000D) |
	                 (1L << 0x0020)) >> c) & 1L) != 0);
	}

}
