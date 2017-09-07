package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGClock;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGSetElement extends SVGAnimationElement, SVGExternalResourcesRequired, AnimationEventHandler, AnimationTarget, AnimationTiming {

	public String getTo();
	
	public static class Implementation extends SVGAnimationElement.Implementation implements SVGSetElement {

		private String onBegin, onEnd, onRepeat, onLoad;
		
		private short attributeType;
		
		private String attributeName;
		
		private SMILClockValue duration, min, max;
		
		private SMILTimingValueList begin, end;
		
		private short restart;
		
		private SVGNumber repeatCount;
		
		private boolean repeatIndefinite;
		
		private SMILClockValue repeatDuration;
		
		private short fill;
		
		private String to;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired, SVGElement targetElement,
				String onBegin, String onEnd, String onRepeat, String onLoad, short attributeType, String attributeName,
				SMILTimingValueList begin, SMILClockValue duration, SMILTimingValueList end,
				SMILClockValue min, SMILClockValue max, short restart, SVGNumber repeatCount,
				boolean repeatIndefinite, SMILClockValue repeatDuration, short fill, String to, SVGClock clock) {
			super(id, xmlBase, ownerSVGElement, viewportElement, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, targetElement, clock);
			this.onBegin = onBegin;
			this.onEnd = onEnd;
			this.onRepeat = onRepeat;
			this.onLoad = onLoad;
			this.attributeType = attributeType;
			this.attributeName = attributeName;
			this.begin = begin;
			this.duration = duration;
			this.end = end;
			this.min = min;
			this.max = max;
			this.restart = restart;
			this.repeatCount = repeatCount;
			this.repeatIndefinite = repeatIndefinite;
			this.repeatDuration = repeatDuration;
			this.fill = fill;
			this.to = to;
		}

		@Override
		public String getOnBegin() {
			return onBegin;
		}

		@Override
		public String getOnEnd() {
			return onEnd;
		}

		@Override
		public String getOnRepeat() {
			return onRepeat;
		}

		@Override
		public String getOnLoad() {
			return onLoad;
		}

		@Override
		public short getAttributeType() {
			return attributeType;
		}

		@Override
		public String getAttributeName() {
			return attributeName;
		}

		@Override
		public SMILTimingValueList getBegin() {
			return begin;
		}
		
		@Override
		public SMILClockValue getDuration() {
			return duration;
		}

		@Override
		public SMILTimingValueList getEnd() {
			return end;
		}
		
		@Override
		public SMILClockValue getMin() {
			return min;
		}

		@Override
		public SMILClockValue getMax() {
			return max;
		}

		@Override
		public short getRestart() {
			return restart;
		}

		@Override
		public SVGNumber getRepeatCount() {
			return repeatCount;
		}

		@Override
		public boolean isRepeatIndefinite() {
			return repeatIndefinite;
		}

		@Override
		public SMILClockValue getRepeatDuration() {
			return repeatDuration;
		}

		@Override
		public short getFill() {
			return fill;
		}

		@Override
		public String getTo() {
			return to;
		}
		
	}

}
