package org.w3c.dom.svg;

public interface SVGAnimatedLength extends Animated<SVGLength> {

	public static class Implementation implements SVGAnimatedLength {

		private SVGLength baseValue, animatedValue;
		
		public Implementation(SVGLength baseValue, SVGLength animatedValue) {
			this.baseValue = baseValue;
			if (baseValue != null) {
				if (baseValue == animatedValue) {
					this.animatedValue = new SVGLength.Implementation(baseValue.getUnitType(), baseValue.getValueInSpecifiedUnits(), baseValue.getBaselineElement());
				} else {
					this.animatedValue = animatedValue;
				}
			} else {
				this.animatedValue = animatedValue;
			}
		}
		
		@Override
		public SVGLength getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGLength value) {
			this.baseValue = value;
		}

		@Override
		public SVGLength getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
