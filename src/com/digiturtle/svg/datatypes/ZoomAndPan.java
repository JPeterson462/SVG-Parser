package com.digiturtle.svg.datatypes;

public class ZoomAndPan {
	
	public static final short ZOOMANDPAN_UNKNOWN = 0;
	
	public static final short ZOOMANDPAN_DISABLE = 1;
	
	public static final short ZOOMANDPAN_MAGNIFY = 2;
	
	private short zoomAndPan;
	
	public ZoomAndPan(short zoomAndPan) {
		this.zoomAndPan = zoomAndPan;
	}
	
	public short getZoomAndPan() {
		return zoomAndPan;
	}

}
