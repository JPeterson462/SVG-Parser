package org.w3c.dom.svg;

public interface SVGAnimatedTransformList extends Animated<SVGTransformList> {

	public static class Implementation implements SVGAnimatedTransformList {

		private SVGTransformList baseValue, animatedValue;
		
		public Implementation(SVGTransformList baseValue, SVGTransformList animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public SVGTransformList getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGTransformList value) {
			DOMErrors.readonly(getClass());
		}

		@Override
		public SVGTransformList getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
