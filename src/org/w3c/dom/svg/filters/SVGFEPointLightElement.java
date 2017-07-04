package org.w3c.dom.svg.filters;

import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEPointLightElement extends SVGElement {

	public SVGAnimatedNumber getX();
	
	public SVGAnimatedNumber getY();

	public SVGAnimatedNumber getZ();
	
	public static class Implementation extends SVGElement.Implementation implements SVGFEPointLightElement {

		private SVGAnimatedNumber x, y, z;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedNumber x, SVGAnimatedNumber y, SVGAnimatedNumber z) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public SVGAnimatedNumber getX() {
			return x;
		}

		@Override
		public SVGAnimatedNumber getY() {
			return y;
		}

		@Override
		public SVGAnimatedNumber getZ() {
			return z;
		}
		
	}
	
}
