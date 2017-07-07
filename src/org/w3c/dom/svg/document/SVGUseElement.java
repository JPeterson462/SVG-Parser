package org.w3c.dom.svg.document;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedLength;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.SVGTransformable;
import org.w3c.dom.svg.SVGURIReference;

public interface SVGUseElement extends SVGElement, SVGLangSpace, SVGStylable, SVGTests, SVGExternalResourcesRequired, SVGTransformable, SVGURIReference {

	public SVGAnimatedLength getX();
	
	public SVGAnimatedLength getY();
	
	public SVGAnimatedLength getWidth();
	
	public SVGAnimatedLength getHeight();
	
	public SVGElementInstance getInstanceRoot();
	
	public SVGElementInstance getAnimatedInstanceRoot();
	
	public static class Implementation extends SVGBaseElement.Implementation implements SVGUseElement {

		private SVGAnimatedString href;
		
		private SVGAnimatedLength x, y, width, height;
		
		private SVGElementInstance instanceRoot, animatedInstanceRoot;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired, SVGElement nearestViewportElement,
				SVGElement farthestViewportElement, SVGAnimatedTransformList transform,
				SVGAnimatedString href,
				SVGAnimatedLength x, SVGAnimatedLength y, SVGAnimatedLength width, SVGAnimatedLength height,
				SVGElementInstance instanceRoot, SVGElementInstance animatedInstanceRoot) {
			super(id, xmlBase, ownerSVGElement, viewportElement, xmlLang, xmlSpace, className, style, requiredFeatures,
					requiredExtensions, systemLanguage, externalResourcesRequired, nearestViewportElement, farthestViewportElement,
					transform);
			this.href = href;
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.instanceRoot = instanceRoot;
			this.animatedInstanceRoot = animatedInstanceRoot;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public SVGAnimatedLength getX() {
			return x;
		}

		@Override
		public SVGAnimatedLength getY() {
			return y;
		}

		@Override
		public SVGAnimatedLength getWidth() {
			return width;
		}

		@Override
		public SVGAnimatedLength getHeight() {
			return height;
		}

		@Override
		public SVGElementInstance getInstanceRoot() {
			return instanceRoot;
		}

		@Override
		public SVGElementInstance getAnimatedInstanceRoot() {
			return animatedInstanceRoot;
		}
		
	}
	
}
