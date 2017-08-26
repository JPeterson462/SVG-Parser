package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFESpecularLightingElement extends SVGFEElement {

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedNumber getSurfaceScale();
	
	public SVGAnimatedNumber getSpecularConstant();

	public SVGAnimatedNumber getSpecularExponent();
	
	public SVGAnimatedNumber getKernelUnitLengthX();

	public SVGAnimatedNumber getKernelUnitLengthY();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFESpecularLightingElement {

		private SVGAnimatedString in1;
		
		private SVGAnimatedNumber surfaceScale, specularConstant, specularExponent, kernelUnitLengthX, kernelUnitLengthY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1,
				SVGAnimatedNumber surfaceScale, SVGAnimatedNumber specularConstant, SVGAnimatedNumber specularExponent,
				SVGAnimatedNumber kernelUnitLengthX, SVGAnimatedNumber kernelUnitLengthY) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.surfaceScale = surfaceScale;
			this.specularConstant = specularConstant;
			this.specularExponent = specularExponent;
			this.kernelUnitLengthX = kernelUnitLengthX;
			this.kernelUnitLengthY = kernelUnitLengthY;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}

		@Override
		public SVGAnimatedNumber getSurfaceScale() {
			return surfaceScale;
		}

		@Override
		public SVGAnimatedNumber getSpecularConstant() {
			return specularConstant;
		}

		@Override
		public SVGAnimatedNumber getSpecularExponent() {
			return specularExponent;
		}

		@Override
		public SVGAnimatedNumber getKernelUnitLengthX() {
			return kernelUnitLengthX;
		}

		@Override
		public SVGAnimatedNumber getKernelUnitLengthY() {
			return kernelUnitLengthY;
		}

	}
	
}
