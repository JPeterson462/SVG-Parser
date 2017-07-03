package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGLangSpace {
	
	public String getXMLLang();
	
	public void setXMLLang(String xmlLang) throws DOMException;

	public String getXMLSpace();
	
	public void setXMLSpace(String xmlSpace) throws DOMException;
	
	public static class Implementation implements SVGLangSpace {

		private String xmlLang, xmlSpace;
		
		public Implementation(String xmlLang, String xmlSpace) {
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
		}
		
		@Override
		public String getXMLLang() {
			return xmlLang;
		}

		@Override
		public void setXMLLang(String xmlLang) throws DOMException {
			this.xmlLang = xmlLang;
		}

		@Override
		public String getXMLSpace() {
			return xmlSpace;
		}

		@Override
		public void setXMLSpace(String xmlSpace) throws DOMException {
			this.xmlSpace = xmlSpace;
		}
		
	}

}
