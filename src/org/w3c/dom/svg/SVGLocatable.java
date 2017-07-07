package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGLocatable {
	
	public SVGElement getNearestViewportElement();
	
	public SVGElement getFarthestViewportElement();
	
	public SVGRect getBBox();
	
	public SVGMatrix getCTM();
	
	public SVGMatrix getScreenCTM();
	
	public SVGMatrix getTransformToElement(SVGElement element) throws DOMException;
	
	public static class Implementation implements SVGLocatable {
		
		private SVGElement nearestViewportElement, farthestViewportElement;

		public Implementation(SVGElement nearestViewportElement, SVGElement farthestViewportElement) {
			this.nearestViewportElement = nearestViewportElement;
			this.farthestViewportElement = farthestViewportElement;
		}
		
		@Override
		public SVGElement getNearestViewportElement() {
			return nearestViewportElement;
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			return farthestViewportElement;
		}

		@Override
		public SVGRect getBBox() {
			// TODO Auto-generated method stub
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
