package org.w3c.dom.svg;

import java.util.ArrayList;

public interface SVGAnimatedNumberList extends Animated<SVGNumberList> {

	public static class Implementation implements SVGAnimatedNumberList {

		private SVGNumberList baseValue, animatedValue;
		
		public Implementation(SVGNumberList baseValue, SVGNumberList animatedValue) {
			this.baseValue = baseValue;
			if (baseValue == animatedValue) {
				ArrayList<SVGNumber> numbers = new ArrayList<>();
				for (int i = 0; i < baseValue.getNumberOfItems(); i++) {
					numbers.add(new SVGNumber.Implementation(baseValue.getItem(i).getValue()));
				}
				this.animatedValue = new SVGNumberList.Implementation(numbers);
			} else {
				this.animatedValue = animatedValue;
			}
		}
		
		@Override
		public SVGNumberList getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGNumberList value) {
			this.baseValue = value;
		}

		@Override
		public SVGNumberList getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
