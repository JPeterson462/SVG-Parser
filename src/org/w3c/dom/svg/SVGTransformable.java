package org.w3c.dom.svg;

public interface SVGTransformable extends SVGLocatable {
	
	public SVGAnimatedTransformList getTransform();

	public static class Implementation extends SVGLocatable.Implementation implements SVGTransformable {

		private SVGAnimatedTransformList transform;
		
		public Implementation(SVGElement nearestViewportElement, SVGElement farthestViewportElement, SVGAnimatedTransformList transform) {
			super(nearestViewportElement, farthestViewportElement);
			this.transform = transform;
		}

		@Override
		public SVGAnimatedTransformList getTransform() {
			return transform;
		}
		
	}
	
}
