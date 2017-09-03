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
	
	public static void main(String[] args) throws Exception {
		SVGParser parser = new SVGParser();//radial gradients not loading,
		// inherit font face attributes (default other than "0")
		// path length NaN
		final String SVG_FILE = "svg-files/debian";
		// scimitar-anim, rdf, preserveAspectRatio, oscon, jsonatom, photos,
		// mysvg, mememe, image, gump-bench, displayWebStats, compuserver_msn_Ford_Focus,
		// car, anim2, bzr/bzrfeed (not correct), aa, The United States of America,
		// Steps, AJ_Digital_Camera, DroidSans-Bold, scimitar, shapes-polyline-01-t, snake, 
		// svg, twitter, video1 (<video> tag), x11 (<audio> tag),  decimal,
		// ubuntu(!), tommek_Car, svg2009, json, helloworld, gaussian1
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
