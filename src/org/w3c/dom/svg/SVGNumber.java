package org.w3c.dom.svg;

public interface SVGNumber {
	
	public float getValue();
	
	public void setValue(float value);
	
	public static class Implementation implements SVGNumber {
		
		private float value;

		public Implementation(float value) {
			this.value = value;
		}
		
		@Override
		public float getValue() {
			return value;
		}

		@Override
		public void setValue(float value) {
			this.value = value;
		}
		
	}

}
