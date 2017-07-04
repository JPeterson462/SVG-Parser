package org.w3c.dom.svg.filters;

import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFESpecularLightingElement extends SVGElement {

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedNumber getSurfaceScale();
	
	public SVGAnimatedNumber getSpecularConstant();

	public SVGAnimatedNumber getSpecularExponent();
	
	public SVGAnimatedNumber getKernelUnitLengthX();

	public SVGAnimatedNumber getKernelUnitLengthY();
	
	public static class Implementation extends SVGElement.Implementation implements SVGFESpecularLightingElement {

		private SVGAnimatedString in1;
		
		private SVGAnimatedNumber surfaceScale, specularConstant, specularExponent, kernelUnitLengthX, kernelUnitLengthY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString in1, SVGAnimatedNumber surfaceScale, SVGAnimatedNumber specularConstant,
				SVGAnimatedNumber specularExponent, SVGAnimatedNumber kernelUnitLengthX, SVGAnimatedNumber kernelUnitLengthY) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.in1 = in1;
			this.surfaceScale = surfaceScale;
			this.specularConstant = specularConstant;
			this.specularExponent = specularExponent;
			this.kernelUnitLengthX = kernelUnitLengthX;
			this.kernelUnitLengthY = kernelUnitLengthY;
		}

		public SVGAnimatedString getIn1() {
			return in1;
		}

		public SVGAnimatedNumber getSurfaceScale() {
			return surfaceScale;
		}

		public SVGAnimatedNumber getSpecularConstant() {
			return specularConstant;
		}

		public SVGAnimatedNumber getSpecularExponent() {
			return specularExponent;
		}

		public SVGAnimatedNumber getKernelUnitLengthX() {
			return kernelUnitLengthX;
		}

		public SVGAnimatedNumber getKernelUnitLengthY() {
			return kernelUnitLengthY;
		}
		
	}
	
}
