package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGTests {
	
	public SVGStringList getRequiredFeatures();
	
	public SVGStringList getRequiredExtensions();
	
	public SVGStringList getSystemLanguage();
	
	public boolean hasExtension(String extension) throws DOMException;
	
	public static class Implementation implements SVGTests {
		
		private SVGStringList requiredFeatures, requiredExtensions, systemLanguage;

		public Implementation(SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage) {
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
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
		
	}

}
