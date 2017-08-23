package org.w3c.dom.svg.animation;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGAnimateColorElement extends SVGAnimationElement, SVGStylable, AnimationEventHandler, AnimationTarget, AnimationTiming, AnimationValue, AnimationAddition {

	public static class Implementation extends SVGAnimationElement.Implementation implements SVGAnimateColorElement {

		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString className, CSSStyleDeclaration style) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.className = className;
			this.style = style;
		}

		@Override
		public SVGAnimatedString getClassName() {
			return className;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			return style;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			return DOMErrors.deprecatedMethod();
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
