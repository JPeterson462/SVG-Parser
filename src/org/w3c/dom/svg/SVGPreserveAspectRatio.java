package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGPreserveAspectRatio {

	// Alignment Types
	/** The enumeration was set to a value that is not one of predefined types.
	 * 	It is invalid to attempt to define a new value of this type or to attempt
	 * 	to switch an existing value to this type. */
	public static final short SVG_PRESERVEASPECTRATIO_UNKNOWN = 0;
	/** Corresponds to value 'none' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_NONE = 1;
	/** Corresponds to value 'xMinYMin' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_XMINYMIN = 2;
	/** Corresponds to value 'xMidYMin' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_XMIDYMIN = 3;
	/** Corresponds to value 'xMaxYMin' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_XMAXYMIN = 4;
	/** Corresponds to value 'XMinYMid' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_XMINYMID = 5;
	/** Corresponds to value 'xMidYMid' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_XMIDYMID = 6;
	/** Corresponds to value 'xMaxYMid' for attribute ‘preserveAspectRatio’.*/
	public static final short SVG_PRESERVEASPECTRATIO_XMAXYMID = 7;
	/** Corresponds to value 'xMinYMax' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_XMINYMAX = 8;
	/** Corresponds to value 'xMidYMax' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_XMIDYMAX = 9;
	/** Corresponds to value 'xMaxYMax' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_PRESERVEASPECTRATIO_XMAXYMAX = 10;

	// Meet-or-slice Types
	/** The enumeration was set to a value that is not one of predefined
	 * 	types. It is invalid to attempt to define a new value of this type
	 * 	or to attempt to switch an existing value to this type. */
	public static final short SVG_MEETORSLICE_UNKNOWN = 0;
	/** Corresponds to value 'meet' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_MEETORSLICE_MEET = 1;
	/** Corresponds to value 'slice' for attribute ‘preserveAspectRatio’. */
	public static final short SVG_MEETORSLICE_SLICE = 2;
	
	public short getAlign();
	
	public void setAlign(short align) throws DOMException;
	
	public short getMeetOrSlice();
	
	public void setMeetOrSlice(short meetOrSlice) throws DOMException;

	public static class Implementation implements SVGPreserveAspectRatio {

		private short align = SVG_PRESERVEASPECTRATIO_UNKNOWN;
		
		private short meetOrSlice = SVG_MEETORSLICE_UNKNOWN;
		
		@Override
		public short getAlign() {
			return align;
		}

		@Override
		public void setAlign(short align) throws DOMException {
			this.align = align;
		}

		@Override
		public short getMeetOrSlice() {
			return meetOrSlice;
		}

		@Override
		public void setMeetOrSlice(short meetOrSlice) throws DOMException {
			this.meetOrSlice = meetOrSlice;
		}
		
	}
	
}
