package org.w3c.dom.svg.animation;

import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGNumberList;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.paths.SVGPathSegList;

public interface SVGAnimateMotionElement extends SVGAnimationElement, AnimationEventHandler, AnimationTiming, AnimationValue, AnimationAddition {
	
	public SVGPathSegList getPath();
	
	public SVGNumberList getKeyPoints();
	
	public SVGNumber getRotate();

	public boolean isRotateAuto();
	
	public boolean isRotateReverse();
	
	public String getOrigin();
	
	public static class Implementation extends SVGAnimationElement.Implementation implements SVGAnimateMotionElement {

		private String onBegin, onEnd, onRepeat, onLoad;
		
		private SMILClockValue duration, min, max;
		
		private SMILTimingValueList begin, end;
		
		private short restart;
		
		private SVGNumber repeatCount;
		
		private boolean repeatIndefinite;
		
		private SMILClockValue repeatDuration;
		
		private short fill, calcMode, additive, accumulate;
		
		private SVGPathSegList path;
		
		private SVGNumberList keyPoints;
		
		private SVGNumber rotate;
		
		private boolean rotateAuto, rotateReverse;
		
		private String origin;
		
		private SVGStringList values, keyTimes, keySplines;
		
		private String from, to, by;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired, SVGElement targetElement,
				String onBegin, String onEnd, String onRepeat, String onLoad, SMILTimingValueList begin,
				SMILClockValue duration, SMILTimingValueList end, SMILClockValue min,
				SMILClockValue max, short restart, SVGNumber repeatCount, boolean repeatIndefinite, SMILClockValue repeatDuration,
				short fill, short calcMode, short additive, short accumulate, SVGPathSegList path, SVGNumberList keyPoints,
				SVGNumber rotate, boolean rotateAuto, boolean rotateReverse, String origin,
				SVGStringList values, SVGStringList keyTimes, SVGStringList keySplines, String from, String to, String by) {
			super(id, xmlBase, ownerSVGElement, viewportElement, requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, targetElement);
			this.onBegin = onBegin;
			this.onEnd = onEnd;
			this.onRepeat = onRepeat;
			this.onLoad = onLoad;
			this.duration = duration;
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
			this.path = path;
			this.keyPoints = keyPoints;
			this.rotate = rotate;
			this.rotateAuto = rotateAuto;
			this.rotateReverse = rotateReverse;
			this.origin = origin;
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
		public SVGPathSegList getPath() {
			return path;
		}

		@Override
		public SVGNumberList getKeyPoints() {
			return keyPoints;
		}

		@Override
		public SVGNumber getRotate() {
			return rotate;
		}

		@Override
		public boolean isRotateAuto() {
			return rotateAuto;
		}

		@Override
		public boolean isRotateReverse() {
			return rotateReverse;
		}

		@Override
		public String getOrigin() {
			return origin;
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
