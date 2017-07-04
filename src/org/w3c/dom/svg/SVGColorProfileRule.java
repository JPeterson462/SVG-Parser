package org.w3c.dom.svg;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSStyleSheet;

public interface SVGColorProfileRule extends SVGCSSRule, SVGRenderingIntent {

	public String getSrc();
	
	public void setSrc(String src) throws DOMException;
	
	public String getName();
	
	public void setName(String name) throws DOMException;
	
	public short getRenderingIntent();
	
	public void setRenderingIntent(short renderingIntent) throws DOMException;
	
	public static class Implementation implements SVGColorProfileRule {

		private String cssText;
		
		private CSSRule parentRule;
		
		private CSSStyleSheet parentStyleSheet;
		
		private String src, name;
		
		private short renderingIntent;

		public Implementation(String cssText, CSSRule parentRule, CSSStyleSheet parentStyleSheet,
				String src, String name, short renderingIntent) {
			this.cssText = cssText;
			this.parentRule = parentRule;
			this.parentStyleSheet = parentStyleSheet;
			this.src = src;
			this.name = name;
			this.renderingIntent = renderingIntent;
		}
		
		@Override
		public String getCssText() {
			return cssText;
		}

		@Override
		public CSSRule getParentRule() {
			return parentRule;
		}

		@Override
		public CSSStyleSheet getParentStyleSheet() {
			return parentStyleSheet;
		}

		@Override
		public short getType() {
			return COLOR_PROFILE_RULE;
		}

		@Override
		public void setCssText(String text) throws DOMException {
			cssText = text;
		}

		@Override
		public String getSrc() {
			return src;
		}

		@Override
		public void setSrc(String src) throws DOMException {
			this.src = src;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void setName(String name) throws DOMException {
			this.name = name;
		}

		@Override
		public short getRenderingIntent() {
			return renderingIntent;
		}

		@Override
		public void setRenderingIntent(short renderingIntent) throws DOMException {
			this.renderingIntent = renderingIntent;
		}
		
	}
	
}
