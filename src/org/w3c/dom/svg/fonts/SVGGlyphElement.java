package org.w3c.dom.svg.fonts;

import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.css.CSSValue;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.SVGAnimatedString;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGStylable;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.paths.SVGPathSegList;

public interface SVGGlyphElement extends SVGElement, SVGStylable {
	
	public static final short SVG_GLYPHORIENTATION_H = 0;
	public static final short SVG_GLYPHORIENTATION_V = 1;
	
	public static final short SVG_ARABICFORM_INITIAL = 0;
	public static final short SVG_ARABICFORM_MEDIAL = 1;
	public static final short SVG_ARABICFORM_TERMINAL = 2;
	public static final short SVG_ARABICFORM_ISOLATED = 3;
	
	public String getUnicode();
	
	public SVGStringList getGlyphName();
	
	public SVGPathSegList getPathData();
	
	public short getOrientation();
	
	public short getArabicForm();
	
	public SVGStringList getLang();
	
	public SVGNumber getHorizontalAdvanceX();

	public SVGNumber getVerticalOriginX();

	public SVGNumber getVerticalOriginY();

	public SVGNumber getVerticalAdvanceY();

	public static class Implementation extends SVGElement.Implementation implements SVGGlyphElement {

		private SVGAnimatedString className;
		
		private CSSStyleDeclaration style;
		
		private String unicode;
		
		private SVGStringList glyphName;
		
		private SVGPathSegList pathData;
		
		private short orientation, arabicForm;
		
		private SVGStringList lang;
		
		private SVGNumber horizontalAdvanceX, verticalOriginX, verticalOriginY, verticalAdvanceY;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString className, CSSStyleDeclaration style, String unicode, SVGStringList glyphName,
				SVGPathSegList pathData, short orientation, short arabicForm, SVGStringList lang, SVGNumber horizontalAdvanceX,
				SVGNumber verticalOriginX, SVGNumber verticalOriginY, SVGNumber verticalAdvanceY) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.className = className;
			this.style = style;
			this.unicode = unicode;
			this.glyphName = glyphName;
			this.pathData = pathData;
			this.orientation = orientation;
			this.arabicForm = arabicForm;
			this.lang = lang;
			this.horizontalAdvanceX = horizontalAdvanceX;
			this.verticalOriginX = verticalOriginX;
			this.verticalOriginY = verticalOriginY;
			this.verticalAdvanceY = verticalAdvanceY;
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
		public String getUnicode() {
			return unicode;
		}

		@Override
		public SVGStringList getGlyphName() {
			return glyphName;
		}

		@Override
		public SVGPathSegList getPathData() {
			return pathData;
		}

		@Override
		public short getOrientation() {
			return orientation;
		}

		@Override
		public short getArabicForm() {
			return arabicForm;
		}

		@Override
		public SVGStringList getLang() {
			return lang;
		}

		@Override
		public SVGNumber getHorizontalAdvanceX() {
			return horizontalAdvanceX;
		}

		@Override
		public SVGNumber getVerticalOriginX() {
			return verticalOriginX;
		}

		@Override
		public SVGNumber getVerticalOriginY() {
			return verticalOriginY;
		}

		@Override
		public SVGNumber getVerticalAdvanceY() {
			return verticalAdvanceY;
		}
		
	}
	
}
