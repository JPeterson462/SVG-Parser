package org.w3c.dom.svg;

public interface SVGUnicodeRange {
	
	public int getMin();
	
	public int getMax();
	
	public String getValue();
	
	public void setValue(String value);
	
	public static class Implementation implements SVGUnicodeRange {

		private int min, max;
		
		private String value;
		
		public Implementation() {
			min = 0;
			max = 0x7FFFFFFF;
		}
		
		@Override
		public int getMin() {
			return min;
		}

		@Override
		public int getMax() {
			return max;
		}

		@Override
		public String getValue() {
			return value;
		}

		@Override
		public void setValue(String value) {
			this.value = value;
			if (value.startsWith("U+")) {
				String range = value.substring(2);
				if (range.contains("?")) {
					// wildcard range
					String prefix = range.substring(0, range.indexOf('?'));
					if (prefix.length() == 1) {
						int prefixInt = Integer.parseInt(prefix, 16);
						min = prefixInt << 12;
						max = min | 0xFFF;
					}
					else if (prefix.length() == 2) {
						int prefixInt = Integer.parseInt(prefix, 16);
						min = prefixInt << 8;
						max = min | 0xFF;
					}
					else if (prefix.length() == 3) {
						int prefixInt = Integer.parseInt(prefix, 16);
						min = prefixInt << 4;
						max = min | 0xF;
					}
					else {
						SVGErrors.error("Invalid unicode range: " + value);
					}
				}
				else if (range.contains("-")) {
					// codepoint range
					String[] rangeValues = range.split("-");
					min = Integer.parseInt(rangeValues[0], 16);
					max = Integer.parseInt(rangeValues[1], 16);
				}
				else {
					// single codepoint
					min = max = Integer.parseInt(range, 16);
				}
			} else {
				SVGErrors.error("Invalid unicode range: " + value);
			}
		}
		
	}

}
