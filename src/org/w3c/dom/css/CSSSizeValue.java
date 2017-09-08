package org.w3c.dom.css;

import org.w3c.dom.svg.SVGLength;

public interface CSSSizeValue extends CSSValue {
	
	public interface CSSSize {
		
		// Base tag
		
	}
	
	public enum CSSRelativeSize implements CSSSize {
		
		LARGER(1.2f),
		
		SMALLER(1 / 1.2f);
		
		private final float scalingFactor;
		
		CSSRelativeSize(float scalingFactor) {
			this.scalingFactor = scalingFactor;
		}

		public float apply(float scalingFactor) {
			return scalingFactor * this.scalingFactor;
		}
		
	}
	
	public enum CSSAbsoluteSize implements CSSSize {
	
		XX_SMALL (1f / (1.2f * 1.2f * 1.2f)),
		
		X_SMALL (1f / (1.2f * 1.2f)),
		
		SMALL (1f / 1.2f),
		
		MEDIUM (1),
		
		LARGE (1.2f),
		
		X_LARGE (1.2f * 1.2f),
		
		XX_LARGE(1.2f * 1.2f * 1.2f);
		
		public final float scalingFactor;
		
		CSSAbsoluteSize(float scalingFactor) {
			this.scalingFactor = scalingFactor;
		}
		
	}
	
	public CSSSize getSize();
	
	public SVGLength getFixedSize();
	
	public boolean isInherit();

}
