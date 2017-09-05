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
		// path length NaN for curves
		// animation and document events
		// 23 left; 371 files; 7 others; 364 ~ 2x - 23, x ~ 200
		// fill for animation elements
		final String SVG_FILE = "svg-files/DroidSans";
		// juanmontoya_lingerie, gallardo, pservers-grad-03-b-anim, anim3,
		// mouseEvents, ny1, patch, pservers-grad-03-b, rg1024_green_grapes,
		// rg1024_metal_effect, scimitar-anim, preserveAspectRatio,
		// gump-bench, displayWebStats, compuserver_msn_Ford_Focus,
		// anim2, The United States of America (mostly right), Steps, scimitar, snake, 
		// video1 (<video> tag), svg2009, gaussian1
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
		SVGSVGElement element = parser.readDocument(stream, renderingState);
		parser.writeDocument(element, new FileOutputStream(SVG_FILE + "-output.svg"));
		System.out.println(element);
	}

}
