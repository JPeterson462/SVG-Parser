package com.digiturtle.svg.datatypes;

public interface SVGAnimatedNumberList extends Animated<SVGNumberList> {

	public static class Implementation implements SVGAnimatedNumberList {

		private SVGNumberList baseValue, animatedValue;
		
		public Implementation(SVGNumberList baseValue, SVGNumberList animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public SVGNumberList getBaseValue() {
			return baseValue;
		}

		@Override
		public void setAnimatedValue(SVGNumberList value) {
			this.animatedValue = value;
		}

		@Override
		public SVGNumberList getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
