package org.w3c.dom.svg.filters;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedEnumeration;
import org.w3c.dom.svg.SVGAnimatedInteger;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGFETurbulenceElement extends SVGFEElement {

	// Turbulence Types
	/** The type is not one of predefined types. It is invalid
	 * 	to attempt to define a new value of this type or to
	 * 	attempt to switch an existing value to this type. */
	public static final short SVG_TURBULENCE_TYPE_UNKNOWN = 0;
	/** Corresponds to value 'fractalNoise'. */
	public static final short SVG_TURBULENCE_TYPE_FRACTALNOISE = 1;
	/** Corresponds to value 'turbulence'. */
	public static final short SVG_TURBULENCE_TYPE_TURBULENCE = 2;

	// Stitch Options
	/** The type is not one of predefined types. It is invalid
	 * 	to attempt to define a new value of this type or to
	 * 	attempt to switch an existing value to this type. */
	public static final short SVG_STITCHTYPE_UNKNOWN = 0;
	/** Corresponds to value 'stitch'. */
	public static final short SVG_STITCHTYPE_STITCH = 1;
	/** Corresponds to value 'noStitch'. */
	public static final short SVG_STITCHTYPE_NOSTITCH = 2;
	
	public SVGAnimatedNumber getBaseFrequencyX();

	public SVGAnimatedNumber getBaseFrequencyY();
	
	public SVGAnimatedInteger getNumOctaves();
	
	public SVGAnimatedNumber getSeed();
	
	public SVGAnimatedEnumeration getStitchTiles();
	
	public SVGAnimatedEnumeration getType();
	
	public static class Implementation extends SVGFEElement.Implementation implements SVGFETurbulenceElement {

		private SVGAnimatedNumber baseFrequencyX, baseFrequencyY;
		
		private SVGAnimatedInteger numOctaves;
		
		private SVGAnimatedNumber seed;
		
		private SVGAnimatedEnumeration stitchTiles, type;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGAnimatedString result, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedNumber baseFrequencyX, SVGAnimatedNumber baseFrequencyY,
				SVGAnimatedInteger numOctaves, SVGAnimatedNumber seed,
				SVGAnimatedEnumeration stitchTiles, SVGAnimatedEnumeration type) {
			super(id, xmlBase, ownerSVGElement, viewportElement, x, y, width, height, result, className, style);
			this.baseFrequencyX = baseFrequencyX;
			this.baseFrequencyY = baseFrequencyY;
			this.numOctaves = numOctaves;
			this.seed = seed;
			this.stitchTiles = stitchTiles;
			this.type = type;
		}

		@Override
		public SVGAnimatedNumber getBaseFrequencyX() {
			return baseFrequencyX;
		}

		@Override
		public SVGAnimatedNumber getBaseFrequencyY() {
			return baseFrequencyY;
		}

		@Override
		public SVGAnimatedInteger getNumOctaves() {
			return numOctaves;
		}

		@Override
		public SVGAnimatedNumber getSeed() {
			return seed;
		}

		@Override
		public SVGAnimatedEnumeration getStitchTiles() {
			return stitchTiles;
		}

		@Override
		public SVGAnimatedEnumeration getType() {
			return type;
		}
		
	}

}
