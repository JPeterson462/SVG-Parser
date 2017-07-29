package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGExternalResourcesRequired;
import org.w3c.dom.svg.SVGLangSpace;
import org.w3c.dom.svg.SVGPoint;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.SVGTests;
import org.w3c.dom.svg.SVGTransformable;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.SVGMatrix;

public interface SVGPathElement extends SVGElement, SVGLangSpace, SVGStylable, SVGTests, SVGExternalResourcesRequired, SVGTransformable, SVGAnimatedPathData {

	public SVGAnimatedNumber getPathLength();

	public float getTotalLength();

	public SVGPoint getPointAtLength(float distance);

	public long getPathSegAtLength(float distance);

	public SVGPathSegClosePath createSVGPathSegClosePath();

	public SVGPathSegMoveToAbs createSVGPathSegMoveToAbs(float x, float y);

	public SVGPathSegMoveToRel createSVGPathSegMoveToRel(float x, float y);
	
	public SVGPathSegLineToAbs createSVGPathSegLineToAbs(float x, float y);
	
	public SVGPathSegLineToRel createSVGPathSegLineToRel(float x, float y);
	
	public SVGPathSegCurveToCubicAbs createSVGPathSegCurveToCubicAbs(float x, float y, float x1, float y1, float x2, float y2);
	
	public SVGPathSegCurveToCubicRel createSVGPathSegCurveToCubicRel(float x, float y, float x1, float y1, float x2, float y2);
	
	public SVGPathSegCurveToQuadraticAbs createSVGPathSegCurveToQuadraticAbs(float x, float y, float x1, float y1);
	
	public SVGPathSegCurveToQuadraticRel createSVGPathSegCurveToQuadraticRel(float x, float y, float x1, float y1);
	
	public SVGPathSegArcAbs createSVGPathSegArcAbs(float x, float y, float r1, float r2, float angle, boolean largeArcFlag, boolean sweepFlag);
	
	public SVGPathSegArcRel createSVGPathSegArcRel(float x, float y, float r1, float r2, float angle, boolean largeArcFlag, boolean sweepFlag);
	
	public SVGPathSegLineToHorizontalAbs createSVGPathSegLineToHorizontalAbs(float x);
	
	public SVGPathSegLineToHorizontalRel createSVGPathSegLineToHorizontalRel(float x);
	
	public SVGPathSegLineToVerticalAbs createSVGPathSegLineToVerticalAbs(float y);
	
	public SVGPathSegLineToVerticalRel createSVGPathSegLineToVerticalRel(float y);
	
	public SVGPathSegCurveToCubicSmoothAbs createSVGPathSegCurveToCubicSmoothAbs(float x, float y, float x2, float y2);
	
	public SVGPathSegCurveToCubicSmoothRel createSVGPathSegCurveToCubicSmoothRel(float x, float y, float x2, float y2);
	
	public SVGPathSegCurveToQuadraticSmoothAbs createSVGPathSegCurveToQuadraticSmoothAbs(float x, float y);
	
	public SVGPathSegCurveToQuadraticSmoothRel createSVGPathSegCurveToQuadraticSmoothRel(float x, float y);
	
	public static class Implementation extends SVGElement.Implementation implements SVGPathElement {
		
		private String xmlLang, xmlSpace;
		
		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private SVGStringList requiredFeatures, requiredExtensions, systemLanguage;
		
		private SVGAnimatedBoolean externalResourcesRequired;

		private SVGPathSegList pathSegList, normalizedPathSegList, animatedPathSegList, animatedNormalizedPathSegList;
		
		private SVGAnimatedNumber pathLength;
		
		private SVGTransformable transformableBase;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				String xmlLang, String xmlSpace, SVGAnimatedString className, CSSStyleDeclaration style,
				SVGStringList requiredFeatures, SVGStringList requiredExtensions, SVGStringList systemLanguage,
				SVGAnimatedBoolean externalResourcesRequired,
				SVGPathSegList pathSegList, SVGPathSegList normalizedPathSegList, SVGPathSegList animatedPathSegList, SVGPathSegList animatedNormalizedPathSegList,
				SVGAnimatedNumber pathLength,
				SVGElement nearestViewportElement, SVGElement farthestViewportElement, SVGAnimatedTransformList transform) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.xmlLang = xmlLang;
			this.xmlSpace = xmlSpace;
			this.className = className;
			this.style = style;
			this.requiredFeatures = requiredFeatures;
			this.requiredExtensions = requiredExtensions;
			this.systemLanguage = systemLanguage;
			this.externalResourcesRequired = externalResourcesRequired;
			this.pathSegList = pathSegList;
			this.normalizedPathSegList = normalizedPathSegList;
			this.animatedPathSegList = animatedPathSegList;
			this.animatedNormalizedPathSegList = animatedNormalizedPathSegList;
			this.pathLength = pathLength;
			transformableBase = new SVGTransformable.Implementation(nearestViewportElement, farthestViewportElement, transform);
		}

		@Override
		public String getXMLLang() {
			return xmlLang;
		}

		@Override
		public void setXMLLang(String xmlLang) throws DOMException {
			this.xmlLang = xmlLang;
		}

		@Override
		public String getXMLSpace() {
			return xmlSpace;
		}

		@Override
		public void setXMLSpace(String xmlSpace) throws DOMException {
			this.xmlSpace = xmlSpace;
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
		public SVGStringList getRequiredFeatures() {
			return requiredFeatures;
		}

		@Override
		public SVGStringList getRequiredExtensions() {
			return requiredExtensions;
		}

		@Override
		public SVGStringList getSystemLanguage() {
			return systemLanguage;
		}

		@Override
		public boolean hasExtension(String extension) throws DOMException {
			return DOMErrors.notSupported();
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			return externalResourcesRequired;
		}

		@Override
		public SVGPathSegList getPathSegList() {
			return pathSegList;
		}

		@Override
		public SVGPathSegList getNormalizedPathSegList() {
			return normalizedPathSegList;
		}

		@Override
		public SVGPathSegList getAnimatedPathSegList() {
			return animatedPathSegList;
		}

		@Override
		public SVGPathSegList getAnimatedNormalizedPathSegList() {
			return animatedNormalizedPathSegList;
		}

		@Override
		public SVGAnimatedNumber getPathLength() {
			return pathLength;
		}

		@Override
		public float getTotalLength() {
			float totalLength = 0;
			SVGPathMath.State state = new SVGPathMath.State();
			state.point = new SVGPoint.Implementation(0, 0);
			state.start = new SVGPoint.Implementation(0, 0);
			boolean setStart = false;
			for (long segment = 0; segment < pathSegList.getNumberOfItems(); segment++) {
				SVGPathSeg seg = pathSegList.getItem(segment);
				if (!setStart && seg.getPathSegType() != SVGPathSeg.PATHSEG_MOVETO_ABS && seg.getPathSegType() != SVGPathSeg.PATHSEG_MOVETO_REL) {
					state.start.setX(state.point.getX());
					state.start.setY(state.point.getY());
					setStart = true;
				}
				float segDistance = SVGPathMath.getSegmentLength(seg, state);
				SVGPathMath.transformPoint(seg, segDistance, segDistance, state);
				totalLength += segDistance;
			}
			return totalLength;
		}

		@Override
		public SVGPoint getPointAtLength(float distance) {
			SVGPathMath.State state = new SVGPathMath.State();
			state.point = new SVGPoint.Implementation(0, 0);
			state.start = new SVGPoint.Implementation(0, 0);
			boolean setStart = false;
			for (long segment = 0; segment < pathSegList.getNumberOfItems(); segment++) {
				SVGPathSeg seg = pathSegList.getItem(segment);
				if (!setStart && seg.getPathSegType() != SVGPathSeg.PATHSEG_MOVETO_ABS && seg.getPathSegType() != SVGPathSeg.PATHSEG_MOVETO_REL) {
					state.start.setX(state.point.getX());
					state.start.setY(state.point.getY());
					setStart = true;
				}
				float segDistance = SVGPathMath.getSegmentLength(seg, state);
				if (distance < segDistance) {
					SVGPathMath.transformPoint(seg, distance, segDistance, state);
					return state.point;
				} else {
					SVGPathMath.transformPoint(seg, state);
					distance -= segDistance;
				}
			}
			return state.point;
		}

		@Override
		public long getPathSegAtLength(float distance) {
			SVGPathMath.State state = new SVGPathMath.State();
			state.point = new SVGPoint.Implementation(0, 0);
			state.start = new SVGPoint.Implementation(0, 0);
			boolean setStart = false;
			for (long segment = 0; segment < pathSegList.getNumberOfItems(); segment++) {
				SVGPathSeg seg = pathSegList.getItem(segment);
				if (!setStart && seg.getPathSegType() != SVGPathSeg.PATHSEG_MOVETO_ABS && seg.getPathSegType() != SVGPathSeg.PATHSEG_MOVETO_REL) {
					state.start.setX(state.point.getX());
					state.start.setY(state.point.getY());
					setStart = true;
				}
				float segDistance = SVGPathMath.getSegmentLength(seg, state);
				if (distance < segDistance) {
					return segment;
				}
				SVGPathMath.transformPoint(seg, state);
				distance -= segDistance;
			}
			return pathSegList.getNumberOfItems();
		}

		@Override
		public SVGPathSegClosePath createSVGPathSegClosePath() {
			SVGPathSegClosePath path = new SVGPathSegClosePath.Implementation();
			return path;
		}

		@Override
		public SVGPathSegMoveToAbs createSVGPathSegMoveToAbs(float x, float y) {
			SVGPathSegMoveToAbs path = new SVGPathSegMoveToAbs.Implementation();
			path.setX(x);
			path.setY(y);
			return path;
		}

		@Override
		public SVGPathSegMoveToRel createSVGPathSegMoveToRel(float x, float y) {
			SVGPathSegMoveToRel path = new SVGPathSegMoveToRel.Implementation();
			path.setX(x);
			path.setY(y);
			return path;
		}

		@Override
		public SVGPathSegLineToAbs createSVGPathSegLineToAbs(float x, float y) {
			SVGPathSegLineToAbs path = new SVGPathSegLineToAbs.Implementation();
			path.setX(x);
			path.setY(y);
			return path;
		}

		@Override
		public SVGPathSegLineToRel createSVGPathSegLineToRel(float x, float y) {
			SVGPathSegLineToRel path = new SVGPathSegLineToRel.Implementation();
			path.setX(x);
			path.setY(y);
			return path;
		}

		@Override
		public SVGPathSegCurveToCubicAbs createSVGPathSegCurveToCubicAbs(float x, float y, float x1, float y1, float x2,
				float y2) {
			SVGPathSegCurveToCubicAbs path = new SVGPathSegCurveToCubicAbs.Implementation();
			path.setX(x);
			path.setY(y);
			path.setX1(x1);
			path.setY1(y1);
			path.setX2(x2);
			path.setY2(y2);
			return path;
		}

		@Override
		public SVGPathSegCurveToCubicRel createSVGPathSegCurveToCubicRel(float x, float y, float x1, float y1, float x2,
				float y2) {
			SVGPathSegCurveToCubicRel path = new SVGPathSegCurveToCubicRel.Implementation();
			path.setX(x);
			path.setY(y);
			path.setX1(x1);
			path.setY1(y1);
			path.setX2(x2);
			path.setY2(y2);
			return path;
		}

		@Override
		public SVGPathSegCurveToQuadraticAbs createSVGPathSegCurveToQuadraticAbs(float x, float y, float x1, float y1) {
			SVGPathSegCurveToQuadraticAbs path = new SVGPathSegCurveToQuadraticAbs.Implementation();
			path.setX(x);
			path.setY(y);
			path.setX1(x1);
			path.setY1(y1);
			return path;
		}

		@Override
		public SVGPathSegCurveToQuadraticRel createSVGPathSegCurveToQuadraticRel(float x, float y, float x1, float y1) {
			SVGPathSegCurveToQuadraticRel path = new SVGPathSegCurveToQuadraticRel.Implementation();
			path.setX(x);
			path.setY(y);
			path.setX1(x1);
			path.setY1(y1);
			return path;
		}

		@Override
		public SVGPathSegArcAbs createSVGPathSegArcAbs(float x, float y, float r1, float r2, float angle,
				boolean largeArcFlag, boolean sweepFlag) {
			SVGPathSegArcAbs path = new SVGPathSegArcAbs.Implementation();
			path.setX(x);
			path.setY(y);
			path.setR1(r1);
			path.setR2(r2);
			path.setAngle(angle);
			path.setLargeArcFlag(largeArcFlag);
			path.setSweepFlag(sweepFlag);
			return path;
		}

		@Override
		public SVGPathSegArcRel createSVGPathSegArcRel(float x, float y, float r1, float r2, float angle,
				boolean largeArcFlag, boolean sweepFlag) {
			SVGPathSegArcRel path = new SVGPathSegArcRel.Implementation();
			path.setX(x);
			path.setY(y);
			path.setR1(r1);
			path.setR2(r2);
			path.setAngle(angle);
			path.setLargeArcFlag(largeArcFlag);
			path.setSweepFlag(sweepFlag);
			return path;
		}

		@Override
		public SVGPathSegLineToHorizontalAbs createSVGPathSegLineToHorizontalAbs(float x) {
			SVGPathSegLineToHorizontalAbs path = new SVGPathSegLineToHorizontalAbs.Implementation();
			path.setX(x);
			return path;
		}

		@Override
		public SVGPathSegLineToHorizontalRel createSVGPathSegLineToHorizontalRel(float x) {
			SVGPathSegLineToHorizontalRel path = new SVGPathSegLineToHorizontalRel.Implementation();
			path.setX(x);
			return path;
		}

		@Override
		public SVGPathSegLineToVerticalAbs createSVGPathSegLineToVerticalAbs(float y) {
			SVGPathSegLineToVerticalAbs path = new SVGPathSegLineToVerticalAbs.Implementation();
			path.setY(y);
			return path;
		}

		@Override
		public SVGPathSegLineToVerticalRel createSVGPathSegLineToVerticalRel(float y) {
			SVGPathSegLineToVerticalRel path = new SVGPathSegLineToVerticalRel.Implementation();
			path.setY(y);
			return path;
		}

		@Override
		public SVGPathSegCurveToCubicSmoothAbs createSVGPathSegCurveToCubicSmoothAbs(float x, float y, float x2,
				float y2) {
			SVGPathSegCurveToCubicSmoothAbs path = new SVGPathSegCurveToCubicSmoothAbs.Implementation();
			path.setX(x);
			path.setY(y);
			path.setX2(x2);
			path.setY2(y2);
			return path;
		}

		@Override
		public SVGPathSegCurveToCubicSmoothRel createSVGPathSegCurveToCubicSmoothRel(float x, float y, float x2,
				float y2) {
			SVGPathSegCurveToCubicSmoothRel path = new SVGPathSegCurveToCubicSmoothRel.Implementation();
			path.setX(x);
			path.setY(y);
			path.setX2(x2);
			path.setY2(y2);
			return path;
		}

		@Override
		public SVGPathSegCurveToQuadraticSmoothAbs createSVGPathSegCurveToQuadraticSmoothAbs(float x, float y) {
			SVGPathSegCurveToQuadraticSmoothAbs path = new SVGPathSegCurveToQuadraticSmoothAbs.Implementation();
			path.setX(x);
			path.setY(y);
			return path;
		}

		@Override
		public SVGPathSegCurveToQuadraticSmoothRel createSVGPathSegCurveToQuadraticSmoothRel(float x, float y) {
			SVGPathSegCurveToQuadraticSmoothRel path = new SVGPathSegCurveToQuadraticSmoothRel.Implementation();
			path.setX(x);
			path.setY(y);
			return path;
		}

		@Override
		public SVGAnimatedTransformList getTransform() {
			return transformableBase.getTransform();
		}

		@Override
		public SVGElement getNearestViewportElement() {
			return transformableBase.getNearestViewportElement();
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			return transformableBase.getFarthestViewportElement();
		}

		@Override
		public SVGRect getBBox() {
			return transformableBase.getBBox();
		}

		@Override
		public SVGMatrix getCTM() {
			return transformableBase.getCTM();
		}

		@Override
		public SVGMatrix getScreenCTM() {
			return transformableBase.getScreenCTM();
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			return transformableBase.getTransformToElement(element);
		}
		
	}
	
}
