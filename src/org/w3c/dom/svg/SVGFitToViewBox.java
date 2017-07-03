package org.w3c.dom.svg;

public interface SVGFitToViewBox {
	
	public SVGAnimatedRect getViewBox();
	
	public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio();
	
	public static class Implementation implements SVGFitToViewBox {

		private SVGAnimatedRect viewBox;
		
		private SVGAnimatedPreserveAspectRatio preserveAspectRatio;
		
		public Implementation(SVGAnimatedRect viewBox, SVGAnimatedPreserveAspectRatio preserveAspectRatio) {
			this.viewBox = viewBox;
			this.preserveAspectRatio = preserveAspectRatio;
		}
		
		@Override
		public SVGAnimatedRect getViewBox() {
			return viewBox;
		}

		@Override
		public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
			return preserveAspectRatio;
		}
		
	}

}
