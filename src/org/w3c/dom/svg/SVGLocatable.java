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
		
		private SVGRect bBox = new SVGRect.Implementation(0, 0, 0, 0);
		
		private SVGMatrix screenCtm = new SVGMatrix.Implementation(), ctm = new SVGMatrix.Implementation();
		
		public Implementation(SVGElement element) {
			this.element = element;
			screenCtm.identity();
			ctm.identity();
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
			return bBox;
		}

		@Override
		public SVGMatrix getCTM() {
			ctm.identity();
			getMatrixUntilViewport(ctm, element, getNearestViewportElement());
			return ctm;
		}
		
		private void getMatrixUntilViewport(SVGMatrix matrix, SVGElement element, SVGElement nearestViewport) {
			if (!element.equals(nearestViewport)) {
				getMatrixUntilViewport(matrix, (SVGElement) element.getParentNode(), nearestViewport);
				((SVGTransformable) element).getTransform().getBaseValue().applyTo(matrix);
			}
		}

		@Override
		public SVGMatrix getScreenCTM() {
			return screenCtm;
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			if (!(element instanceof SVGTransformable)) {
				return SVGErrors.error("Element " + element.getTag() + " cannot be located");
			}
			if (bBox.getWidth() == 0 || bBox.getHeight() == 0) {
				return SVGErrors.error("This element cannot be used to transform to " + element);
			}
			SVGMatrix source = getCTM();
			SVGMatrix destination = ((SVGTransformable) element).getCTM();
			SVGMatrix matrix = new SVGMatrix.Implementation();
			matrix.set(destination.getA(), destination.getB(), destination.getC(), destination.getD(), destination.getE(), destination.getF());
			matrix.multiply(source.inverse());
			return matrix;
		}
		
	}

}
