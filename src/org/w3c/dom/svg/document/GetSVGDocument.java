package org.w3c.dom.svg.document;

public interface GetSVGDocument {

	public SVGDocument getSVGDocument();
	
	public static class Implementation implements GetSVGDocument {

		private SVGDocument svgDocument;
		
		public Implementation(SVGDocument svgDocument) {
			this.svgDocument = svgDocument;
		}
		
		@Override
		public SVGDocument getSVGDocument() {
			return svgDocument;
		}
		
	}
	
}
