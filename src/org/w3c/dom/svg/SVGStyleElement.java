package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.documents.SVGSVGElement;

public interface SVGStyleElement extends SVGElement, SVGLangSpace {
	
	public String getType();
	
	public void setType(String type) throws DOMException;

	public String getMedia();
	
	public void setMedia(String media) throws DOMException;

	public String getTitle();
	
	public void setTitle(String title) throws DOMException;
	
	public static class Implementation extends SVGElement.Implementation implements SVGStyleElement {

		private String xmlLang, xmlSpace, type, media, title;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement, 
				String xmlLang, String xmlSpace, String type, String media, String title) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.type = type;
			this.media = media;
			this.title = title;
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

		@Override
		public String getType() {
			return type;
		}

		@Override
		public void setType(String type) throws DOMException {
			this.type = type;
		}

		@Override
		public String getMedia() {
			return media;
		}

		@Override
		public void setMedia(String media) throws DOMException {
			this.media = media;
		}

		@Override
		public String getTitle() {
			return title;
		}

		@Override
		public void setTitle(String title) throws DOMException {
			this.title = title;
		}
		
	}

}
