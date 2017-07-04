package org.w3c.dom.svg.filters;

import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEDistantLightElement extends SVGElement {
	
	public SVGAnimatedNumber getAzimuth();
	
	public SVGAnimatedNumber getElevation();
	
	public static class Implementation extends SVGElement.Implementation implements SVGFEDistantLightElement {

		private SVGAnimatedNumber azimuth, elevation;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedNumber azimuth, SVGAnimatedNumber elevation) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.azimuth = azimuth;
			this.elevation = elevation;
		}

		@Override
		public SVGAnimatedNumber getAzimuth() {
			return azimuth;
		}

		@Override
		public SVGAnimatedNumber getElevation() {
			return elevation;
		}
		
	}

}
