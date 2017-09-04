package org.w3c.dom.css.impl.values;

import org.w3c.dom.DOMException;
import org.w3c.dom.css.CSSPaintValue;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGPaint;

public class CSSPaintValueImplementation implements CSSPaintValue {
	
	private String cssText;
	
	private SVGPaint paint;
	
	private boolean inherit;
	
	private String paintUri;

	@Override
	public String getCssText() {
		return cssText;
	}

	@Override
	public short getCssValueType() {
		return inherit ? CSS_INHERIT : CSS_PRIMITIVE_VALUE;
	}

	@Override
	public void setCssText(String text) throws DOMException {
		text = text.trim();
		cssText = text;
		if (paint == null) {
			paint = new SVGPaint.Implementation();
		}
//		if (text.startsWith("url(")) {
//			paintUri = StringUtils.parseUri(text);
//		} else {
			inherit = false;
			short paintType;
			String uri = null, rgbColor = null, iccColor = null;
			if (text.equals("none")) {
				paintType = SVGPaint.SVG_PAINTTYPE_NONE;
			}
			else if (text.equals("currentColor")) {
				paintType = SVGPaint.SVG_PAINTTYPE_CURRENTCOLOR;
			}
			else if (text.equals("inherit")) {
				paintType = SVGPaint.SVG_PAINTTYPE_NONE;
				inherit = true;
			}
			else if (text.startsWith(StringUtils.URI_PREFIX)) {
				uri = text.substring(0, text.indexOf(StringUtils.URI_SUFFIX));
				String colorText = text.substring(uri.length() + 1).trim();
				uri = uri.trim();
				if (colorText.equals("none")) {
					paintType = SVGPaint.SVG_PAINTTYPE_URI_NONE;
				}
				else if (colorText.trim().length() == 0) {
					paintType = SVGPaint.SVG_PAINTTYPE_URI_NONE;
				}
				else if (colorText.equals("currentColor")) {
					paintType = SVGPaint.SVG_PAINTTYPE_URI_CURRENTCOLOR;
				}
				else {
					if (colorText.contains("icc-color")) {
						rgbColor = colorText.substring(0, colorText.indexOf("icc-color"));
						iccColor = colorText.substring(rgbColor.length());
						rgbColor = rgbColor.trim();
						paintType = SVGPaint.SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR;
					} else {
						rgbColor = colorText.trim();
						paintType = SVGPaint.SVG_PAINTTYPE_URI_RGBCOLOR;
					}
				}
			}
			else {
				if (text.contains("icc-color")) {
					rgbColor = text.substring(0, text.indexOf("icc-color"));
					iccColor = text.substring(rgbColor.length());
					rgbColor = rgbColor.trim();
					paintType = SVGPaint.SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR;				
				} else {
					rgbColor = text.trim();
					paintType = SVGPaint.SVG_PAINTTYPE_RGBCOLOR;
				}
			}
			paint.setPaint(paintType, uri, rgbColor, iccColor);
//		}
	}

	@Override
	public SVGPaint getPaint() {
		return paint;
	}

	@Override
	public String getPaintUri() {
		return paintUri;
	}

}
