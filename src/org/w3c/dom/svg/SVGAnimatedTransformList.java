package org.w3c.dom.svg;

import java.util.ArrayList;

import org.w3c.dom.DOMErrors;

public interface SVGAnimatedTransformList extends Animated<SVGTransformList> {

	public static class Implementation implements SVGAnimatedTransformList {

		private SVGTransformList baseValue, animatedValue;
		
		public Implementation(SVGTransformList baseValue, SVGTransformList animatedValue) {
			this.baseValue = baseValue;
			if (baseValue == animatedValue) {
				ArrayList<SVGTransform> transforms = new ArrayList<>();
				for (int i = 0; i < baseValue.getNumberOfItems(); i++) {
					SVGTransform transform = new SVGTransform.Implementation();
					SVGTransform oldTransform = baseValue.getItem(i);
					SVGMatrix matrix = new SVGMatrix.Implementation();
					matrix.setA(oldTransform.getMatrix().getA());
					matrix.setB(oldTransform.getMatrix().getB());
					matrix.setC(oldTransform.getMatrix().getC());
					matrix.setD(oldTransform.getMatrix().getD());
					matrix.setE(oldTransform.getMatrix().getE());
					matrix.setF(oldTransform.getMatrix().getF());
					transform.setMatrix(matrix);
					transforms.add(transform);
				}
				this.animatedValue = new SVGTransformList.Implementation(transforms);
			} else {
				this.animatedValue = animatedValue;
			}
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
