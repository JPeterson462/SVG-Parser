package org.w3c.dom.svg;

import org.w3c.dom.DOMException;

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
			throw new DOMException(DOMException.INVALID_MODIFICATION_ERR, "SVGAnimatedTransformList instances are readonly");
		}

		@Override
		public SVGTransformList getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
