package org.w3c.dom.svg;

public interface SVGURIReference {
	
	public SVGAnimatedString getHref();
	
	public static class Implementation implements SVGURIReference {

		private SVGAnimatedString href;
		
		public Implementation(SVGAnimatedString href) {
			this.href = href;
		}
		
		@Override
		public SVGAnimatedString getHref() {
			return href;
		}
		
	}

}
