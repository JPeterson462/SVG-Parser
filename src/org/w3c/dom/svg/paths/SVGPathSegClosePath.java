package org.w3c.dom.svg.paths;

public interface SVGPathSegClosePath extends SVGPathSeg {
	
	public static class Implementation extends SVGPathSeg.Implementation implements SVGPathSegClosePath {

		public Implementation(short pathSegType) {
			super(pathSegType);
		}
		
	}

}
