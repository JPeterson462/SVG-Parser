package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGAnimateTransformElement extends SVGAnimationElement, AnimationEventHandler, AnimationTarget, AnimationTiming, AnimationValue, AnimationAddition {
	
	public static final short TRANSFORMTYPE_TRANSLATE = 0;
	public static final short TRANSFORMTYPE_SCALE = 1;
	public static final short TRANSFORMTYPE_ROTATE = 2;
	public static final short TRANSFORMTYPE_SKEWX = 3;
	public static final short TRANSFORMTYPE_SKEWY = 4;
	
	public short getTransformType();
	
	public static class Implementation extends SVGAnimationElement.Implementation implements SVGAnimateTransformElement {

		private String onBegin, onEnd, onRepeat, onLoad;
		
		private short attributeType;
		
		private String attributeName;
		
		private SMILTimingValueList begin, end;
		
		private SMILClockValue duration, min, max;
		
		private short restart;
		
		private SVGNumber repeatCount;
		
		private boolean repeatIndefinite;
		
		private SMILClockValue repeatDuration;
		
		private short fill, calcMode, additive, accumulate;

		private short transformType;
		
		private SVGStringList values, keyTimes, keySplines;
		
		private String from, to, by;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired, SVGElement targetElement,
				String onBegin, String onEnd, String onRepeat, String onLoad, short attributeType, String attributeName,
				SMILTimingValueList begin, SMILClockValue duration, SMILTimingValueList end, SMILClockValue min, SMILClockValue max,
				short restart, SVGNumber repeatCount, boolean repeatIndefinite, SMILClockValue repeatDuration, short fill, short calcMode,
				short additive, short accumulate, short transformType, SVGStringList values, SVGStringList keyTimes, SVGStringList keySplines,
				String from, String to, String by) {
			super(id, xmlBase, ownerSVGElement, viewportElement, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, targetElement);
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
			this.calcMode = calcMode;
			this.additive = additive;
			this.accumulate = accumulate;
			this.transformType = transformType;
			this.values = values;
			this.keyTimes = keyTimes;
			this.keySplines = keySplines;
			this.from = from;
			this.to = to;
			this.by = by;
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
		public short getCalcMode() {
			return calcMode;
		}

		@Override
		public short getAdditive() {
			return additive;
		}

		@Override
		public short getAccumulate() {
			return accumulate;
		}

		@Override
		public short getTransformType() {
			return transformType;
		}

		@Override
		public SVGStringList getValues() {
			return values;
		}

		@Override
		public SVGStringList getKeyTimes() {
			return keyTimes;
		}

		@Override
		public SVGStringList getKeySplines() {
			return keySplines;
		}

		@Override
		public String getFrom() {
			return from;
		}

		@Override
		public String getTo() {
			return to;
		}

		@Override
		public String getBy() {
			return by;
		}

	}

}
