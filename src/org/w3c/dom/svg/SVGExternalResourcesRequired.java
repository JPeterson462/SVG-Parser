package org.w3c.dom.svg;

public interface SVGExternalResourcesRequired {
	
	public SVGAnimatedBoolean getExternalResourcesRequired();
	
	public static class Implementation implements SVGExternalResourcesRequired {

		private SVGAnimatedBoolean externalResourcesRequired;
		
		public Implementation(SVGAnimatedBoolean externalResourcesRequired) {
			this.externalResourcesRequired = externalResourcesRequired;
		}
		
		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}
		
	}

}
