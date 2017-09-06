package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGErrors;

public interface SMILClockValue {

	public static final short INDEFINITE = 1 << 0;
	public static final short MEDIA = 1 << 1;
	public static final short INDEFINITE_MEDIA = INDEFINITE | MEDIA;
	
	public float getHours();
	
	public float getMinutes();
	
	public float getSeconds();
	
	public boolean isMedia();
	
	public boolean isIndefinite();
	
	public void setValue(String clockValue);
	
	public String getValue();
	
	public static class Implementation implements SMILClockValue {
		
		private boolean indefinite, media;
		
		private float hours, minutes, seconds;
		
		private String clockValue;
		
		private short type;
		
		public Implementation(short type) {
			this.type = type;
		}

		@Override
		public float getHours() {
			return hours;
		}

		@Override
		public float getMinutes() {
			return minutes;
		}

		@Override
		public float getSeconds() {
			return seconds;
		}

		@Override
		public boolean isIndefinite() {
			return indefinite;
		}

		@Override
		public boolean isMedia() {
			return media;
		}

		@Override
		public void setValue(String clockValue) {
			System.out.println("'" + clockValue + "'");
			this.clockValue = clockValue;
			indefinite = clockValue.equals("indefinite");
			media = clockValue.equals("media");
			if ((type & INDEFINITE) == 0) {
				if (indefinite) {
					SVGErrors.error("Invalid clock value: cannot be set to indefinite");
				}
			}
			if ((type & MEDIA) == 0) {
				if (media) {
					SVGErrors.error("Invalid clock value: cannot be set to media");
				}
			}
			if (hours < 0 || minutes < 0 || seconds < 0) {
				SVGErrors.error("Invalid clock value: value must be >= 0");
			}
			if (!indefinite) {
				if (clockValue.contains(":")) {
					String[] clockValueParts = clockValue.split(":");
					if (clockValueParts.length == 2) {
						hours = 0;
						minutes = Float.parseFloat(clockValueParts[0]);
						seconds = Float.parseFloat(clockValueParts[1]);
					}
					else if (clockValueParts.length == 3) {
						hours = Float.parseFloat(clockValueParts[0]);
						minutes = Float.parseFloat(clockValueParts[1]);
						seconds = Float.parseFloat(clockValueParts[2]);
					}
					else {
						SVGErrors.error("Invalid clock value: " + clockValue);
					}
				} else {
					if (clockValue.endsWith("h")) {
						hours = Float.parseFloat(clockValue.substring(0, clockValue.length() - 1));
						minutes = 0;
						seconds = 0;
					}
					else if (clockValue.endsWith("min")) {
						hours = 0;
						minutes = Float.parseFloat(clockValue.substring(0, clockValue.length() - 3));
						seconds = 0;
					}
					else if (clockValue.endsWith("ms")) {
						hours = 0;
						minutes = 0;
						seconds =  Float.parseFloat(clockValue.substring(0, clockValue.length() - 2)) / 1000f;
					}
					else if (clockValue.endsWith("s")) {
						hours = 0;
						minutes = 0;
						seconds = Float.parseFloat(clockValue.substring(0, clockValue.length() - 1));
					}
					else {
						hours = 0;
						minutes = 0;
						seconds = Float.parseFloat(clockValue);
					}
				}
			}
		}

		@Override
		public String getValue() {
			return clockValue;
		}
		
	}
	
}
