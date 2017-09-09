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
	// pattern.patternUnits default should probably be userSpaceOnUse
	
	// https://dev.w3.org/SVG/tools/svgweb/samples/svg-files/
	public static void main(String[] args) throws Exception {
		SVGParser parser = new SVGParser();
		// 10 left; 371 files; 7 others; 364 ~ 2x - 10, x ~ 200
		// gradients are messed up
		final String SVG_FILE = "svg-files/svg2009";
		// juanmontoya_lingerie, gallardo,
		// rg1024_green_grapes, rg1024_metal_effect, scimitar-anim,
		// gump-bench, compuserver_msn_Ford_Focus, scimitar, svg2009, gaussian1
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
		SVGSVGElement element = parser.readDocument(stream, renderingState, () -> System.currentTimeMillis() / 1000f);
		parser.writeDocument(element, new FileOutputStream(SVG_FILE + "-output.svg"));
//		System.out.println(element);
	}

}
