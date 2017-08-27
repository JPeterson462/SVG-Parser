package org.w3c.dom.svg.animation;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGAnimationElement extends SVGElement, SVGTests, SVGExternalResourcesRequired, ElementTimeControl {

	public SVGElement getTargetElement();
	
	public float getStartTime() throws DOMException;

	public float getCurrentTime();
	
	public float getSimpleDuration() throws DOMException;
	
	public static class Implementation extends SVGElement.Implementation implements SVGAnimationElement {

		private SVGStringList requiredFeatures, requiredExtensions, systemLanguage;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGElement targetElement;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired, SVGElement targetElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
			this.externalResourcesRequired = externalResourcesRequired;
			this.targetElement = targetElement;
		}

		@Override
		public SVGStringList getRequiredFeatures() {
			return requiredFeatures;
		}

		@Override
		public SVGStringList getRequiredExtensions() {
			return requiredExtensions;
		}

		@Override
		public SVGStringList getSystemLanguage() {
			return systemLanguage;
		}

		@Override
		public boolean hasExtension(String extension) throws DOMException {
			return DOMErrors.notSupported();
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public void beginElement() {
			beginElementAt(0);
		}

		@Override
		public void beginElementAt(float offset) {
			//TODO
		}

		@Override
		public void endElement() {
			endElementAt(0);
		}

		@Override
		public void endElementAt(float offset) {
			//TODO
		}

		@Override
		public SVGElement getTargetElement() {
			return targetElement;
		}

		@Override
		public float getStartTime() throws DOMException {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getCurrentTime() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getSimpleDuration() throws DOMException {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
	
}
