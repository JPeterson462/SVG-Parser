package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGSetElement extends SVGAnimationElement, AnimationEventHandler, AnimationTarget, AnimationTiming {
	
	// TODO to
	
	public static class Implementation extends SVGAnimationElement.Implementation implements SVGSetElement {

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
		public short getAttributeType() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public String getAttributeName() {
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
		
	}

}
