package org.w3c.dom.svg.fonts;

import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGUnicodeRangeList;
import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGVKernElement extends SVGElement {

	public SVGUnicodeRangeList getU1();
	
	public SVGStringList getG1();
	
	public SVGUnicodeRangeList getU2();
	
	public SVGStringList getG2();
	
	public SVGNumber getK();
	
	public static class Implementation extends SVGElement.Implementation implements SVGVKernElement {

		private SVGUnicodeRangeList u1, u2;
		
		private SVGStringList g1, g2;
		
		private SVGNumber k;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGUnicodeRangeList u1, SVGStringList g1, SVGUnicodeRangeList u2, SVGStringList g2, SVGNumber k) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.u1 = u1;
			this.u2 = u2;
			this.g1 = g1;
			this.g2 = g2;
			this.k = k;
		}

		@Override
		public SVGUnicodeRangeList getU1() {
			return u1;
		}

		@Override
		public SVGStringList getG1() {
			return g1;
		}

		@Override
		public SVGUnicodeRangeList getU2() {
			return u2;
		}

		@Override
		public SVGStringList getG2() {
			return g2;
		}

		@Override
		public SVGNumber getK() {
			return k;
		}
		
	}
	
}
