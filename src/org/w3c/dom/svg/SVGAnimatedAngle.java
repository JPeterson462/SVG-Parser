package org.w3c.dom.svg;

public interface SVGAnimatedAngle extends Animated<SVGAngle> {

	public static class Implementation implements SVGAnimatedAngle {

		private SVGAngle baseValue, animatedValue;
		
		public Implementation(SVGAngle baseValue, SVGAngle animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public SVGAngle getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGAngle value) {
			this.baseValue = value;
		}

		@Override
		public SVGAngle getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
