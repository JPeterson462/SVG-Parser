package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedInteger;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedNumberList;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFEConvolveMatrixElement extends SVGFEElement {

	/** The type is not one of predefined types.
	 * 	It is invalid to attempt to define a new value of
	 * 	this type or to attempt to switch an existing value
	 * 	to this type. */
	public static final short SVG_EDGEMODE_UNKNOWN = 0;
	/** Corresponds to value 'duplicate'. */
	public static final short SVG_EDGEMODE_DUPLICATE = 1;
	/** Corresponds to value 'wrap'. */
	public static final short SVG_EDGEMODE_WRAP = 2;
	/** Corresponds to value 'none'. */
	public static final short SVG_EDGEMODE_NONE = 3;

	public SVGAnimatedString getIn1();
	
	public SVGAnimatedInteger getOrderX();
	
	public SVGAnimatedInteger getOrderY();
	
	public SVGAnimatedNumberList getKernelMatrix();
	
	public SVGAnimatedNumber getDivisor();
	
	public SVGAnimatedNumber getBias();
	
	public SVGAnimatedInteger getTargetX();
	
	public SVGAnimatedInteger getTargetY();
	
	public SVGAnimatedEnumeration getEdgeMode();
	
	public SVGAnimatedNumber getKernelUnitLengthX();
	
	public SVGAnimatedNumber getKernelUnitLengthY();
	
	public SVGAnimatedBoolean getPreserveAlpha();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFEConvolveMatrixElement {

		private SVGAnimatedString in1;
		
		private SVGAnimatedInteger orderX, orderY;
		
		private SVGAnimatedNumberList kernelMatrix;
		
		private SVGAnimatedNumber divisor, bias;
		
		private SVGAnimatedInteger targetX, targetY;
		
		private SVGAnimatedEnumeration edgeMode;
		
		private SVGAnimatedNumber kernelUnitLengthX, kernelUnitLengthY;
		
		private SVGAnimatedBoolean preserveAlpha;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedString in1, SVGAnimatedInteger orderX, SVGAnimatedInteger orderY,
				SVGAnimatedNumberList kernelMatrix, SVGAnimatedNumber divisor, SVGAnimatedNumber bias,
				SVGAnimatedInteger targetX, SVGAnimatedInteger targetY, SVGAnimatedEnumeration edgeMode,
				SVGAnimatedNumber kernelUnitLengthX, SVGAnimatedNumber kernelUnitLengthY,
				SVGAnimatedBoolean preserveAlpha) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.in1 = in1;
			this.orderX = orderX;
			this.orderY = orderY;
			this.kernelMatrix = kernelMatrix;
			this.divisor = divisor;
			this.bias = bias;
			this.targetX = targetX;
			this.targetY = targetY;
			this.edgeMode = edgeMode;
			this.kernelUnitLengthX = kernelUnitLengthX;
			this.kernelUnitLengthY = kernelUnitLengthY;
			this.preserveAlpha = preserveAlpha;
		}

		@Override
		public SVGAnimatedString getIn1() {
			return in1;
		}

		@Override
		public SVGAnimatedInteger getOrderX() {
			return orderX;
		}

		@Override
		public SVGAnimatedInteger getOrderY() {
			return orderY;
		}

		@Override
		public SVGAnimatedNumberList getKernelMatrix() {
			return kernelMatrix;
		}

		@Override
		public SVGAnimatedNumber getDivisor() {
			return divisor;
		}

		@Override
		public SVGAnimatedNumber getBias() {
			return bias;
		}

		@Override
		public SVGAnimatedInteger getTargetX() {
			return targetX;
		}

		@Override
		public SVGAnimatedInteger getTargetY() {
			return targetY;
		}

		@Override
		public SVGAnimatedEnumeration getEdgeMode() {
			return edgeMode;
		}

		@Override
		public SVGAnimatedNumber getKernelUnitLengthX() {
			return kernelUnitLengthX;
		}

		@Override
		public SVGAnimatedNumber getKernelUnitLengthY() {
			return kernelUnitLengthY;
		}

		@Override
		public SVGAnimatedBoolean getPreserveAlpha() {
			return preserveAlpha;
		}
		
	}
	
}
