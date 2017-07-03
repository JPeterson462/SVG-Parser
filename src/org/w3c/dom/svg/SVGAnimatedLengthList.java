package org.w3c.dom.svg;

public interface SVGAnimatedLengthList extends Animated<SVGLengthList> {

	public static class Implementation implements SVGAnimatedLengthList {

		private SVGLengthList baseValue, animatedValue;
		
		public Implementation(SVGLengthList baseValue, SVGLengthList animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public SVGLengthList getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGLengthList value) {
			this.baseValue = value;
		}

		@Override
		public SVGLengthList getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
