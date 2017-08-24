package org.w3c.dom.svg;

public interface SVGAnimatedAngle extends Animated<SVGAngle> {

	public static class Implementation implements SVGAnimatedAngle {

		private SVGAngle baseValue, animatedValue;
		
		public Implementation(SVGAngle baseValue, SVGAngle animatedValue) {
			this.baseValue = baseValue;
			if (baseValue == animatedValue) {
				this.animatedValue = new SVGAngle.Implementation(baseValue.getUnitType(), baseValue.getValueInSpecifiedUnits());
			} else {
				this.animatedValue = animatedValue;
			}
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
