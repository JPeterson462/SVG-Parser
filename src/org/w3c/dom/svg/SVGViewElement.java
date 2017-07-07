package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGViewElement extends SVGElement, SVGExternalResourcesRequired, SVGFitToViewBox, SVGZoomAndPan {

	public SVGStringList getViewTarget();
	
	public static class Implementation extends SVGElement.Implementation implements SVGViewElement {

		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedRect viewBox;
		
		private SVGAnimatedPreserveAspectRatio preserveAspectRatio;
		
		private short zoomAndPan;
		
		private SVGStringList viewTarget;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedBoolean externalResourcesRequired, SVGAnimatedRect viewBox,
				SVGAnimatedPreserveAspectRatio preserveAspectRatio, short zoomAndPan,
				SVGStringList viewTarget) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.externalResourcesRequired = externalResourcesRequired;
			this.viewBox = viewBox;
			this.preserveAspectRatio = preserveAspectRatio;
			this.zoomAndPan = zoomAndPan;
			this.viewTarget = viewTarget;
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public SVGAnimatedRect getViewBox() {
			return viewBox;
		}

		@Override
		public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
			return preserveAspectRatio;
		}

		@Override
		public short getZoomAndPan() {
			return zoomAndPan;
		}

		@Override
		public void setZoomAndPan(short zoomAndPan) throws DOMException {
			this.zoomAndPan = zoomAndPan;
		}

		@Override
		public SVGStringList getViewTarget() {
			return viewTarget;
		}
		
	}
	
}
