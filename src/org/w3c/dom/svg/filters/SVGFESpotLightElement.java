package org.w3c.dom.svg.filters;

import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFESpotLightElement extends SVGElement {

	public SVGAnimatedNumber getX();
	
	public SVGAnimatedNumber getY();

	public SVGAnimatedNumber getZ();
	
	public SVGAnimatedNumber getPointsAtX();

	public SVGAnimatedNumber getPointsAtY();

	public SVGAnimatedNumber getPointsAtZ();

	public SVGAnimatedNumber getSpecularExponent();

	public SVGAnimatedNumber getLimitingConeAngle();
	
	public static class Implementation extends SVGElement.Implementation implements SVGFESpotLightElement {

		private SVGAnimatedNumber x, y, z, pointsAtX, pointsAtY, pointsAtZ, specularExponent, limitingConeAngle;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedNumber x, SVGAnimatedNumber y, SVGAnimatedNumber z,
				SVGAnimatedNumber pointsAtX, SVGAnimatedNumber pointsAtY, SVGAnimatedNumber pointsAtZ,
				SVGAnimatedNumber specularExponent, SVGAnimatedNumber limitingConeAngle) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.x = x;
			this.y = y;
			this.z = z;
			this.pointsAtX = pointsAtX;
			this.pointsAtY = pointsAtY;
			this.pointsAtZ = pointsAtZ;
			this.specularExponent = specularExponent;
			this.limitingConeAngle = limitingConeAngle;
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

		@Override
		public SVGAnimatedNumber getPointsAtX() {
			return pointsAtX;
		}

		@Override
		public SVGAnimatedNumber getPointsAtY() {
			return pointsAtY;
		}

		@Override
		public SVGAnimatedNumber getPointsAtZ() {
			return pointsAtZ;
		}

		@Override
		public SVGAnimatedNumber getSpecularExponent() {
			return specularExponent;
		}

		@Override
		public SVGAnimatedNumber getLimitingConeAngle() {
			return limitingConeAngle;
		}
		
	}
	
}
