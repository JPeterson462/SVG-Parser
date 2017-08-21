package org.w3c.dom.svg;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGGradientElement extends SVGElement, SVGURIReference, SVGExternalResourcesRequired, SVGStylable, SVGUnitTypes {

	// Spread Method Types
	/** The type is not one of predefined types. It is invalid
	 * 	to attempt to define a new value of this type or to
	 * 	attempt to switch an existing value to this type. */
	public static final short SVG_SPREADMETHOD_UNKNOWN = 0;
	/** Corresponds to value 'pad'.*/
	public static final short SVG_SPREADMETHOD_PAD = 1;
	/** Corresponds to value 'reflect'. */
	public static final short SVG_SPREADMETHOD_REFLECT = 2;
	/** Corresponds to value 'repeat'. */
	public static final short SVG_SPREADMETHOD_REPEAT = 3;

	public SVGAnimatedEnumeration getGradientUnits();
	
	public SVGAnimatedTransformList getGradientTransform();
	
	public SVGAnimatedEnumeration getSpreadMethod();
	
	public static class Implementation extends SVGElement.Implementation implements SVGGradientElement {

		private SVGAnimatedString href;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGAnimatedEnumeration gradientUnits;
		
		private SVGAnimatedTransformList gradientTransform;
		
		private SVGAnimatedEnumeration spreadMethod;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGAnimatedString className, CSSStyleDeclaration style,
				SVGAnimatedEnumeration gradientUnits, SVGAnimatedTransformList gradientTransform, SVGAnimatedEnumeration spreadMethod) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
			this.externalResourcesRequired = externalResourcesRequired;
			this.className = className;
			this.style = style;
			this.gradientUnits = gradientUnits;
			this.gradientTransform = gradientTransform;
			this.spreadMethod = spreadMethod;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public SVGAnimatedString getClassName() {
			return className;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			return style;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			return DOMErrors.deprecatedMethod();
		}

		@Override
		public SVGAnimatedEnumeration getGradientUnits() {
			return gradientUnits;
		}

		@Override
		public SVGAnimatedTransformList getGradientTransform() {
			return gradientTransform;
		}

		@Override
		public SVGAnimatedEnumeration getSpreadMethod() {
			return spreadMethod;
		}
		
	}
	
}
