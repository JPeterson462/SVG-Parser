package org.w3c.dom.svg.shapes;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.Animated;
import org.w3c.dom.svg.SVGPointList;

public interface SVGAnimatedPoints extends Animated<SVGPointList> {

	public static class Implementation implements SVGAnimatedPoints {

		private SVGPointList baseValue, animatedValue;
		
		public Implementation(SVGPointList baseValue, SVGPointList animatedValue) {
			this.baseValue = baseValue;
			this.animatedValue = animatedValue;
		}
		
		@Override
		public SVGPointList getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGPointList value) {
			throw new DOMException(DOMException.INVALID_MODIFICATION_ERR, "SVGAnimatedPoints instances are readonly");
		}

		@Override
		public SVGPointList getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
