package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGLocatable {
	
	public SVGElement getNearestViewportElement();
	
	public SVGElement getFarthestViewportElement();
	
	public SVGRect getBBox();
	
	public SVGMatrix getCTM();
	
	public SVGMatrix getScreenCTM();
	
	public SVGMatrix getTransformToElement(SVGElement element) throws DOMException;
	
	// https://github.com/apache/batik/blob/c1d67eac2699e33807ee63a115dff5c46bcea2b7/batik-anim/src/main/java/org/apache/batik/anim/dom/SVGLocatableSupport.java
	
	public static class Implementation implements SVGLocatable {
		
		private SVGElement element;
		
		public Implementation(SVGElement element) {
			this.element = element;
		}
		
		@Override
		public SVGElement getNearestViewportElement() {
			SVGElement elt = element;
			while (elt != null) {
				elt = (SVGElement) element.getParentNode();
				if (elt instanceof SVGFitToViewBox) {
					break;
				}

			}
			return elt;
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			SVGElement rootSVG = (SVGElement) element.getOwnerDocument().getDocumentElement();
			if (element == rootSVG) {
				return null;
			}
			return rootSVG;
		}

		@Override
		public SVGRect getBBox() {
			return null;
		}

		@Override
		public SVGMatrix getCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getScreenCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
