package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGZoomAndPan {
	
	/** The enumeration was set to a value that is not one of
	 * 	predefined types. It is invalid to attempt to define
	 * 	a new value of this type or to attempt to switch an
	 * 	existing value to this type. */
	public static final short SVG_ZOOMANDPAN_UNKNOWN = 0;
	/** Corresponds to value 'disable'. */
	public static final short SVG_ZOOMANDPAN_DISABLE = 1;
	/** Corresponds to value 'magnify'. */
	public static final short SVG_ZOOMANDPAN_MAGNIFY = 2;
	
	public short getZoomAndPan();
	
	public void setZoomAndPan(short zoomAndPan) throws DOMException;

	public static class Implementation implements SVGZoomAndPan {

		private short zoomAndPan;
		
		public Implementation(short zoomAndPan) {
			this.zoomAndPan = zoomAndPan;
		}
		
		@Override
		public short getZoomAndPan() {
			return zoomAndPan;
		}

		@Override
		public void setZoomAndPan(short zoomAndPan) throws DOMException {
			this.zoomAndPan = zoomAndPan;
		}
		
	}
	
}
