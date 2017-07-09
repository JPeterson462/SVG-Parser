package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

public interface SVGICCColor {
	
	public String getColorProfile();
	
	public void setColorProfile(String colorProfile) throws DOMException;
	
	public SVGNumberList getColors();
	
	public static class Implementation implements SVGICCColor {

		private String colorProfile;
		
		private SVGNumberList colors;
		
		public Implementation(String colorProfile, SVGNumberList colors) {
			this.colorProfile = colorProfile;
			this.colors = colors;
		}
		
		@Override
		public String getColorProfile() {
			return colorProfile;
		}

		@Override
		public void setColorProfile(String colorProfile) throws DOMException {
			this.colorProfile = colorProfile;
		}

		@Override
		public SVGNumberList getColors() {
			return colors;
		}
		
		public String toString() {
			String str = "icc-color(";
			str += colorProfile;
			for (int i = 0; i < colors.getNumberOfItems(); i++) {
				str += ", " + colors.getItem(i).getValue();
			}
			str += ")";
			return str;
		}
		
	}

}
