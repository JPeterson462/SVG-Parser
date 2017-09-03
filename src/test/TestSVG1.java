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
//		String s1 = "M 1190.0 2982.0 c -38.0 -31.0 -31.0 -179.0 17.0 -347.0 c 14.0 -49.0 -50.0 34.0 -89.0 115.0 c -59.0 126.0 -75.0 138.0 -139.0 104.0 c -89.0 -45.0 -31.0 -286.0 106.0 -438.0 c 37.0 -41.0 37.0 -56.0 2.0 -56.0 c -64.0 -1.0 -147.0 -63.0 -147.0 -111.0 c 0.0 -68.0 36.0 -95.0 107.0 -78.0 c 72.0 17.0 110.0 12.0 162.0 -18.0 c 59.0 -36.0 99.0 -53.0 121.0 -53.0 c 70.0 0.0 98.0 -274.0 36.0 -339.0 c -77.0 -80.0 -124.0 -64.0 -211.0 69.0 c -235.0 363.0 -871.0 1021.0 -794.0 823.0 c 6.0 -16.0 15.0 -109.0 21.0 -208.0 c 8.0 -154.0 7.0 -237.0 -7.0 -510.0 c -1.0 -22.0 -5.0 -71.0 -9.0 -110.0 c -3.0 -38.0 -8.0 -99.0 -11.0 -135.0 c -16.0 -193.0 -59.0 -311.0 -172.0 -463.0 c -89.0 -120.0 -103.0 -199.0 -62.0 -333.0 c 46.0 -147.0 32.0 -217.0 -65.0 -342.0 c -86.0 -110.0 -34.0 -240.0 74.0 -182.0 c 15.0 8.0 16.0 -2.0 16.0 -118.0 c -1.0 -208.0 99.0 -262.0 252.0 -137.0 c 459.0 378.0 583.0 383.0 820.0 37.0 c 106.0 -155.0 165.0 -182.0 267.0 -123.0 c 179.0 103.0 150.0 755.0 -55.0 1272.0 c -72.0 180.0 -71.0 272.0 6.0 419.0 l 38.0 l -1.0 c 0.0 177.0 4.0 192.0 76.0 262.0 c 82.0 80.0 99.0 158.0 65.0 300.0 c -25.0 105.0 -22.0 166.0 16.0 269.0 c 47.0 130.0 23.0 186.0 -68.0 161.0 c -65.0 -17.0 -142.0 -154.0 -142.0 -253.0 c 0.0 -42.0 -37.0 30.0 -49.0 96.0 c -23.0 120.0 -43.0 186.0 -61.0 202.0 c -30.0 27.0 -91.0 31.0 -120.0 7.0 z m -342.0 -1094.0 c 74.0 -22.0 122.0 -90.0 122.0 -170.0 c 0.0 -77.0 -7.0 -87.0 -54.0 -86.0 c -83.0 2.0 -183.0 -78.0 -173.0 -139.0 c 14.0 -82.0 -172.0 -40.0 -237.0 54.0 c -127.0 183.0 105.0 413.0 342.0 341.0 z m 315.0 -214.0 c 237.0 -426.0 341.0 -786.0 342.0 -1179.0 c 0.0 -460.0 -61.0 -531.0 -239.0 -277.0 c -251.0 358.0 -453.0 367.0 -824.0 35.0 c -124.0 -110.0 -190.0 -136.0 -208.0 -80.0 c -7.0 22.0 -7.0 235.0 0.0 272.0 c 2.0 11.0 7.0 45.0 10.0 75.0 c 4.0 30.0 8.0 66.0 11.0 80.0 c 2.0 14.0 9.0 52.0 14.0 85.0 c 109.0 661.0 160.0 849.0 214.0 789.0 c 199.0 -228.0 612.0 2.0 545.0 303.0 c -6.0 28.0 -4.0 32.0 15.0 36.0 c 38.0 7.0 40.0 4.0 120.0 -139.0 z m -900.0 -522.0 c 3.0 -4.0 -5.0 -61.0 -18.0 -127.0 c -13.0 -66.0 -25.0 -131.0 -27.0 -145.0 c -6.0 -36.0 -39.0 38.0 -46.0 101.0 c -7.0 76.0 66.0 213.0 91.0 171.0 z";
//		String s2 = "M1190 2982 c-38-31-31-179 17-347 14-49-50 34-89 115-59 126-75 138-139 104-89-45-31-286 106-438 37-41 37-56 2-56-64-1-147-63-147-111 0-68 36-95 107-78 72 17 110 12 162-18 59-36 99-53 121-53 70 0 98-274 36-339-77-80-124-64-211 69-235 363-871 1021-794823 6-16 15-109 21-208 8-154 7-237-7-510-1-22-5-71-9-110-3-38-8-99-11-135-16-193-59-311-172-463-89-120-103-199-62-33346-147 32-217-65-342-86-110-34-240 74-182 15 8 16-2 16-118-1-208 99-262 252-137 459 378 583 383 820 37 106-155 165-182 267-123 179 103 150 755-55 1272-72 180-71 272 6 419 l38 71-1 147 c0 177 4 192 76 262 82 80 99 158 65 300-25 105-22 166 16 269 47 130 23 186-68 161-65-17-142-154-142-253 0-42-37 30-49 96-23 120-43 186-61 202-30 27-91 31-120 7z m-342-1094 c74-22 122-90 122-170 0-77-7-87-54-86-832-183-78-173-139 14-82-172-40-237 54-127 183 105 413 342 341z m315-214 c237-426 341-786 342-1179 0-460-61-531-239-277-251 358-453367-824 35-124-110-190-136-208-80-7 22-7 235 0 272 2 11 7 45 10 75 4 30 8 66 11 80 2 14 9 52 14 85 109 661 160 849 214 789 199-228 612 2 545 303-6 28-4 32 15 36 38 7 40 4 120-139z m-900-522 c3-4-5-61-18-127-13-66-25-131-27-145-6-36-39 38-46 101-7 76 66 213 91 171z";
//		System.out.println(s1.replaceAll(".0 ", " ").replaceAll(" ", "").length());
//		System.out.println(s2.replaceAll(" ", "").length());
		SVGParser parser = new SVGParser();//radial gradients not loading,
		// arcs are broken Arc.java:105 stack overflow, inherit font face attributes (default other than "0")
		// path length NaN
		final String SVG_FILE = "svg-files/bozo";
		// scimitar-anim, rdf, preserveAspectRatio, oscon, jsonatom, photos,
		// mysvg, mememe, image, gump-bench, displayWebStats, compuserver_msn_Ford_Focus,
		// car, bozo, anim2, bzr/bzrfeed (not correct), aa, The United States of America,
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
//		System.out.println(element);
	}

}
