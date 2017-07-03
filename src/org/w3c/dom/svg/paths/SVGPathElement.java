package org.w3c.dom.svg.paths;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.svg.FileElement;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGAnimatedNumber;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGPoint;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGElement.Implementation;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.documents.SVGSVGElement;

public interface SVGPathElement extends FileElement, SVGAnimatedPathData {

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

		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
		}

		@Override
		public String getXMLLang() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setXMLLang(String xmlLang) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public String getXMLSpace() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setXMLSpace(String xmlSpace) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public SVGAnimatedString getClassName() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CSSStyleDeclaration getStyle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CSSValue getPresentationAttribute(String name) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGStringList getRequiredFeatures() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGStringList getRequiredExtensions() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGStringList getSystemLanguage() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean hasExtension(String extension) throws DOMException {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public SVGAnimatedBoolean getExternalResourcesRequired() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegList getPathSegList() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegList getNormalizedPathSegList() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegList getAnimatedPathSegList() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegList getAnimatedNormalizedPathSegList() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedNumber getPathLength() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public float getTotalLength() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public SVGPoint getPointAtLength(float distance) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getPathSegAtLength(float distance) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public SVGPathSegClosePath createSVGPathSegClosePath() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegMoveToAbs createSVGPathSegMoveToAbs(float x, float y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegMoveToRel createSVGPathSegMoveToRel(float x, float y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegLineToAbs createSVGPathSegLineToAbs(float x, float y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegLineToRel createSVGPathSegLineToRel(float x, float y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegCurveToCubicAbs createSVGPathSegCurveToCubicAbs(float x, float y, float x1, float y1, float x2,
				float y2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegCurveToCubicRel createSVGPathSegCurveToCubicRel(float x, float y, float x1, float y1, float x2,
				float y2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegCurveToQuadraticAbs createSVGPathSegCurveToQuadraticAbs(float x, float y, float x1, float y1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegCurveToQuadraticRel createSVGPathSegCurveToQuadraticRel(float x, float y, float x1, float y1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegArcAbs createSVGPathSegArcAbs(float x, float y, float r1, float r2, float angle,
				boolean largeArcFlag, boolean sweepFlag) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegArcRel createSVGPathSegArcRel(float x, float y, float r1, float r2, float angle,
				boolean largeArcFlag, boolean sweepFlag) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegLineToHorizontalAbs createSVGPathSegLineToHorizontalAbs(float x) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegLineToHorizontalRel createSVGPathSegLineToHorizontalRel(float x) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegLineToVerticalAbs createSVGPathSegLineToVerticalAbs(float y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegLineToVerticalRel createSVGPathSegLineToVerticalRel(float y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegCurveToCubicSmoothAbs createSVGPathSegCurveToCubicSmoothAbs(float x, float y, float x2,
				float y2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegCurveToCubicSmoothRel createSVGPathSegCurveToCubicSmoothRel(float x, float y, float x2,
				float y2) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegCurveToQuadraticSmoothAbs createSVGPathSegCurveToQuadraticSmoothAbs(float x, float y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGPathSegCurveToQuadraticSmoothRel createSVGPathSegCurveToQuadraticSmoothRel(float x, float y) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGAnimatedTransformList getTransform() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGElement getNearestViewportElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGElement getFarthestViewportElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGRect getBBox() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getScreenCTM() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public SVGMatrix getTransformToElement(SVGElement element) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
