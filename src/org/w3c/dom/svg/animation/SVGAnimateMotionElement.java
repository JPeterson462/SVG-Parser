package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.paths.SVGPathSegList;

public interface SVGAnimateMotionElement extends SVGAnimationElement, AnimationEventHandler, AnimationTiming, AnimationValue, AnimationAddition {
	
	public SVGPathSegList getPath();
	
	// TODO keyPoints
	// TODO rotate
	
	public String getOrigin();
	
	public static class Implementation extends SVGAnimationElement.Implementation implements SVGAnimateMotionElement {

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
		}

		@Override
		public String getOnBegin() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getOnEnd() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getOnRepeat() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getOnLoad() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SMILClockValue getDuration() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SMILClockValue getMin() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SMILClockValue getMax() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public short getRestart() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public float getRepeatCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public boolean isRepeatIndefinite() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public SMILClockValue getRepeatDuration() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public short getFill() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public short getCalcMode() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public short getAdditive() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public short getAccumulate() {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}

}
