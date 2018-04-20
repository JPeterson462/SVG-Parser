package org.w3c.dom.svg.animation;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.ElementFinder;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGClock;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExtensionManager;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGAnimationElement extends SVGElement, SVGTests, SVGExternalResourcesRequired, ElementTimeControl {

	public SVGElement getTargetElement();
	
	public void searchForTargetElement(ElementFinder elementFinder);
	
	public float getStartTime() throws DOMException;

	public float getCurrentTime();
	
	public float getSimpleDuration() throws DOMException;
	
	public static class Implementation extends SVGElement.Implementation implements SVGAnimationElement {

		private SVGStringList requiredFeatures, requiredExtensions, systemLanguage;
		
		private SVGAnimatedBoolean externalResourcesRequired;
		
		private SVGElement targetElement;
		
		private SVGClock clock;
		
		private float startTime, endTime;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired, SVGElement targetElement, SVGClock clock) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
			this.externalResourcesRequired = externalResourcesRequired;
			this.targetElement = targetElement;
			this.clock = clock;
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
			return SVGExtensionManager.getInstance(SVGExtensionManager.DEFAULT_MANAGER).hasExtension(extension);
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
			startTime = clock.getCurrentTime() + offset;
			endTime = Float.MAX_VALUE;
		}

		@Override
		public void endElement() {
			endElementAt(0);
		}

		@Override
		public void endElementAt(float offset) {
			endTime = getCurrentTime() + offset;
		}

		@Override
		public SVGElement getTargetElement() {
			return targetElement;
		}

		@Override
		public float getStartTime() throws DOMException {
			return startTime;
		}

		@Override
		public float getCurrentTime() {
			return clock.getCurrentTime();
		}

		@Override
		public float getSimpleDuration() throws DOMException {
			float currentTime = getCurrentTime();
			if (currentTime > endTime) {
				return endTime - getStartTime();
			}
			return currentTime - getStartTime();
		}

		@Override
		public void searchForTargetElement(ElementFinder elementFinder) {
			if (this instanceof AnimationTarget) {
				AnimationTarget target = (AnimationTarget) this;
				if (target.getAttributeType() == AnimationTarget.ANIMATIONTARGET_AUTO) {
					targetElement = elementFinder.findElement(target.getAttributeName());
				}
			}
		}
		
	}
	
}
