package test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGRect;
import org.w3c.dom.svg.document.SVGRenderingState;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Parsers;
import org.w3c.dom.svg.parser.SVGParser;

public class TestSVG1 {
	
	// https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/
	public static void main(String[] args) throws Exception {
		SVGParser parser = new SVGParser();
		final String SVG_FILE = "svg-files/svg2009";
		// juanmontoya_lingerie, 
		// gump-bench,
		// compuserver_msn_Ford_Focus, svg2009
		if (!Parsers.hasRegistered()) Parsers.registerParsers();
		FileInputStream stream = new FileInputStream(SVG_FILE + ".svg");
		SVGRenderingState renderingState = new SVGRenderingState() {

			@Override
			public NodeList getIntersectionList(SVGRect rect, SVGElement referenceElement) {
				return null;
			}

			@Override
			public NodeList getEnclosureList(SVGRect rect, SVGElement referenceElement) {
				return null;
			}

			@Override
			public boolean checkIntersection(SVGElement element, SVGRect rect) {
				return false;
			}

			@Override
			public boolean checkEnclosure(SVGElement element, SVGRect rect) {
				return false;
			}

			@Override
			public void deselectAll() {
				
			}

			@Override
			public float getPixelsPerInch() {
				return 100;
			}
			
		};
		long s = System.nanoTime();
		SVGSVGElement element = parser.readDocument(stream, renderingState, () -> System.currentTimeMillis() / 1000f);
		System.out.println((System.nanoTime() - s)/1_000_000 + "ms");
		parser.writeDocument(element, new FileOutputStream(SVG_FILE + "-output1.svg"), false);
//		System.out.println(element);
	}

}
