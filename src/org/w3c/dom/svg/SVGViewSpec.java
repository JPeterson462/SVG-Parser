package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGViewSpec extends SVGZoomAndPan, SVGFitToViewBox {

	public SVGTransformList getTransform();
	
	public SVGElement getViewTarget();
	
	public String getViewBoxString();
	
	public String getPreserveAspectRatioString();
	
	public String getTransformString();
	
	public String getViewTargetString();
	
	public static class Implementation implements SVGViewSpec {

		private short zoomAndPan;
		
		private SVGAnimatedRect viewBox;
		
		private SVGAnimatedPreserveAspectRatio preserveAspectRatio;
		
		private SVGTransformList transform;
		
		private SVGElement viewTarget;
		
		private String viewBoxString, preserveAspectRatioString, transformString, viewTargetString;
		
		public Implementation(short zoomAndPan, SVGAnimatedRect viewBox, SVGAnimatedPreserveAspectRatio preserveAspectRatio, SVGTransformList transform, SVGElement viewTarget, String viewBoxString,
				String preserveAspectRatioString, String transformString, String viewTargetString) {
			this.zoomAndPan = zoomAndPan;
			this.viewBox = viewBox;
			this.preserveAspectRatio = preserveAspectRatio;
			this.transform = transform;
			this.viewTarget = viewTarget;
			this.viewBoxString = viewBoxString;
			this.preserveAspectRatioString = preserveAspectRatioString;
			this.transformString = transformString;
			this.viewTargetString = viewTargetString;
		}

		@Override
		public short getZoomAndPan() {
			return zoomAndPan;
		}

		@Override
		public void setZoomAndPan(short zoomAndPan) throws DOMException {
			this.zoomAndPan = zoomAndPan;
		}

		@Override
		public SVGAnimatedRect getViewBox() {
			return viewBox;
		}

		@Override
		public SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
			return preserveAspectRatio;
		}

		@Override
		public SVGTransformList getTransform() {
			return transform;
		}

		@Override
		public SVGElement getViewTarget() {
			return viewTarget;
		}

		@Override
		public String getViewBoxString() {
			return viewBoxString;
		}

		@Override
		public String getPreserveAspectRatioString() {
			return preserveAspectRatioString;
		}

		@Override
		public String getTransformString() {
			return transformString;
		}

		@Override
		public String getViewTargetString() {
			return viewTargetString;
		}
		
	}
	
}
