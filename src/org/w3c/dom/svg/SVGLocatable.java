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
			SVGElement parent = (SVGElement) element.getParentNode();
			SVGRect parentBoundingBox = null;
			while (parent != null && parentBoundingBox == null) {
				if (parent instanceof SVGLocatable) {
					parentBoundingBox = ((SVGLocatable) parent).getBBox();
				}
				parent = (SVGElement) parent.getParentNode();
			}
			if (parentBoundingBox == null) {
				parentBoundingBox = new SVGRect.Implementation(0, 0, 0, 0); // TODO
			}
			// TODO apply transforms, compute for shapes and paths
			return new SVGRect.Implementation(parentBoundingBox.getX(), parentBoundingBox.getY(), parentBoundingBox.getWidth(), parentBoundingBox.getHeight());
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
