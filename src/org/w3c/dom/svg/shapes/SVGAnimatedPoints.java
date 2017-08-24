package org.w3c.dom.svg.shapes;

import org.w3c.dom.svg.Animated;
import org.w3c.dom.svg.SVGPoint;

import java.util.ArrayList;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGPointList;

public interface SVGAnimatedPoints extends Animated<SVGPointList> {

	public static class Implementation implements SVGAnimatedPoints {

		private SVGPointList baseValue, animatedValue;
		
		public Implementation(SVGPointList baseValue, SVGPointList animatedValue) {
			this.baseValue = baseValue;
			if (baseValue == animatedValue) {
				ArrayList<SVGPoint> points = new ArrayList<>();
				for (int i = 0; i < baseValue.getNumberOfItems(); i++) {
					points.add(new SVGPoint.Implementation(baseValue.getItem(i).getX(), baseValue.getItem(i).getY()));
				}
				this.animatedValue = new SVGPointList.Implementation(points);
			} else {
				this.animatedValue = animatedValue;
			}
		}
		
		@Override
		public SVGPointList getBaseValue() {
			return baseValue;
		}

		@Override
		public void setBaseValue(SVGPointList value) {
			DOMErrors.readonly(getClass());
		}

		@Override
		public SVGPointList getAnimatedValue() {
			return animatedValue;
		}
		
	}
	
}
