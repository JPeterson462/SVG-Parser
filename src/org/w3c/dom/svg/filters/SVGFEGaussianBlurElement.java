package org.w3c.dom.svg.filters;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEGaussianBlurElement extends SVGFEElement {

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedNumber getStdDeviationX();

	public SVGAnimatedNumber getStdDeviationY();
	
	public void setStdDeviation(float stdDeviationX, float stdDeviationY) throws DOMException;
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFEGaussianBlurElement {

		private SVGAnimatedString in1;
		
		private SVGAnimatedNumber stdDeviationX, stdDeviationY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1, SVGAnimatedNumber stdDeviationX, SVGAnimatedNumber stdDeviationY) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.stdDeviationX = stdDeviationX;
			this.stdDeviationY = stdDeviationY;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}

		@Override
		public SVGAnimatedNumber getStdDeviationX() {
			return stdDeviationX;
		}

		@Override
		public SVGAnimatedNumber getStdDeviationY() {
			return stdDeviationY;
		}

		@Override
		public void setStdDeviation(float stdDeviationX, float stdDeviationY) throws DOMException {
			this.stdDeviationX.setBaseValue(stdDeviationX);
			this.stdDeviationY.setBaseValue(stdDeviationY);
		}
		
	}
	
}
