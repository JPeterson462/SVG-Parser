package com.digiturtle.svg.datatypes;

public class ViewSpec {

	private ZoomAndPan zoomAndPan;
	
	private FitToViewBox fitToViewBox;
	
//	TODO TransformList
	
	private Element viewTarget;
	
	private String viewBoxString, preserveAspectRatioString, transformString, viewTargetString;

	public ViewSpec(ZoomAndPan zoomAndPan, FitToViewBox fitToViewBox, Element viewTarget, String viewBoxString,
			String preserveAspectRatioString, String transformString, String viewTargetString) {
		this.zoomAndPan = zoomAndPan;
		this.fitToViewBox = fitToViewBox;
		this.viewTarget = viewTarget;
		this.viewBoxString = viewBoxString;
		this.preserveAspectRatioString = preserveAspectRatioString;
		this.transformString = transformString;
		this.viewTargetString = viewTargetString;
	}

	public ZoomAndPan getZoomAndPan() {
		return zoomAndPan;
	}

	public FitToViewBox getFitToViewBox() {
		return fitToViewBox;
	}

	public Element getViewTarget() {
		return viewTarget;
	}

	public String getViewBoxString() {
		return viewBoxString;
	}

	public String getPreserveAspectRatioString() {
		return preserveAspectRatioString;
	}

	public String getTransformString() {
		return transformString;
	}

	public String getViewTargetString() {
		return viewTargetString;
	}
	
	
	
}
