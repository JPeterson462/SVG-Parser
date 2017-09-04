package org.w3c.dom.svg.parser;

import java.util.HashMap;

import org.w3c.dom.svg.parser.animation.SVGAnimateColorElementParser;
import org.w3c.dom.svg.parser.animation.SVGAnimateElementParser;
import org.w3c.dom.svg.parser.animation.SVGAnimateMotionElementParser;
import org.w3c.dom.svg.parser.animation.SVGAnimateTransformElementParser;
import org.w3c.dom.svg.parser.animation.SVGMPathElementParser;
import org.w3c.dom.svg.parser.animation.SVGSetElementParser;
import org.w3c.dom.svg.parser.document.SVGDefsElementParser;
import org.w3c.dom.svg.parser.document.SVGDescElementParser;
import org.w3c.dom.svg.parser.document.SVGGElementParser;
import org.w3c.dom.svg.parser.document.SVGImageElementParser;
import org.w3c.dom.svg.parser.document.SVGSVGElementParser;
import org.w3c.dom.svg.parser.document.SVGSwitchElementParser;
import org.w3c.dom.svg.parser.document.SVGSymbolElementParser;
import org.w3c.dom.svg.parser.document.SVGTitleElementParser;
import org.w3c.dom.svg.parser.document.SVGUseElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEBlendElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEColorMatrixElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEComponentTransferElementParser;
import org.w3c.dom.svg.parser.filters.SVGFECompositeElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEConvolveMatrixElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEDiffuseLightingElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEDisplacementMapElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEDistantLightElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEFloodElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEFuncAElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEFuncBElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEFuncGElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEFuncRElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEGaussianBlurElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEImageElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEMergeElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEMergeNodeElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEMorphologyElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEOffsetElementParser;
import org.w3c.dom.svg.parser.filters.SVGFEPointLightElementParser;
import org.w3c.dom.svg.parser.filters.SVGFESpecularLightingElementParser;
import org.w3c.dom.svg.parser.filters.SVGFESpotLightElementParser;
import org.w3c.dom.svg.parser.filters.SVGFETileElementParser;
import org.w3c.dom.svg.parser.filters.SVGFETurbulenceElementParser;
import org.w3c.dom.svg.parser.filters.SVGFilterElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontFaceElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontFaceFormatElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontFaceNameElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontFaceSrcElementParser;
import org.w3c.dom.svg.parser.fonts.SVGFontFaceUriElementParser;
import org.w3c.dom.svg.parser.fonts.SVGGlyphElementParser;
import org.w3c.dom.svg.parser.fonts.SVGHKernElementParser;
import org.w3c.dom.svg.parser.fonts.SVGMissingGlyphElementParser;
import org.w3c.dom.svg.parser.fonts.SVGVKernElementParser;
import org.w3c.dom.svg.parser.paths.SVGPathElementParser;
import org.w3c.dom.svg.parser.shapes.SVGCircleElementParser;
import org.w3c.dom.svg.parser.shapes.SVGEllipseElementParser;
import org.w3c.dom.svg.parser.shapes.SVGLineElementParser;
import org.w3c.dom.svg.parser.shapes.SVGPolygonElementParser;
import org.w3c.dom.svg.parser.shapes.SVGPolylineElementParser;
import org.w3c.dom.svg.parser.shapes.SVGRectElementParser;
import org.w3c.dom.svg.parser.text.SVGAltGlyphDefElementParser;
import org.w3c.dom.svg.parser.text.SVGAltGlyphElementParser;
import org.w3c.dom.svg.parser.text.SVGAltGlyphItemElementParser;
import org.w3c.dom.svg.parser.text.SVGGlyphRefElementParser;
import org.w3c.dom.svg.parser.text.SVGTRefElementParser;
import org.w3c.dom.svg.parser.text.SVGTSpanElementParser;
import org.w3c.dom.svg.parser.text.SVGTextElementParser;
import org.w3c.dom.svg.parser.text.SVGTextPathElementParser;

@SuppressWarnings("rawtypes")
public class Parsers {
	
	private static final HashMap<String, ElementParser> parsers = new HashMap<>();
	
	private static boolean registered = false;

	private Parsers() {
		// Hidden Constructor
	}
	
	public static void registerParsers() {
		parsers.put(Tags.STYLE, new SVGStyleElementParser());
		parsers.put(Tags.CURSOR, new SVGCursorElementParser());
		parsers.put(Tags.METADATA, new SVGMetadataElementParser());
		parsers.put(Tags.CIRCLE, new SVGCircleElementParser());
		parsers.put(Tags.ELLIPSE, new SVGEllipseElementParser());
		parsers.put(Tags.LINE, new SVGLineElementParser());
		parsers.put(Tags.POLYGON, new SVGPolygonElementParser());
		parsers.put(Tags.POLYLINE, new SVGPolylineElementParser());
		parsers.put(Tags.RECT, new SVGRectElementParser());
		parsers.put(Tags.FONT_FACE_SRC, new SVGFontFaceSrcElementParser());
		parsers.put(Tags.FONT_FACE_URI, new SVGFontFaceUriElementParser());
		parsers.put(Tags.FONT_FACE_FORMAT, new SVGFontFaceFormatElementParser());
		parsers.put(Tags.FONT_FACE_NAME, new SVGFontFaceNameElementParser());
		parsers.put(Tags.SCRIPT, new SVGScriptElementParser());
		parsers.put(Tags.TEXT, new SVGTextElementParser());
		parsers.put(Tags.TSPAN, new SVGTSpanElementParser());
		parsers.put(Tags.TREF, new SVGTRefElementParser());
		parsers.put(Tags.G, new SVGGElementParser());
		parsers.put(Tags.DEFS, new SVGDefsElementParser());
		parsers.put(Tags.DESC, new SVGDescElementParser());
		parsers.put(Tags.TITLE, new SVGTitleElementParser());
		parsers.put(Tags.SYMBOL, new SVGSymbolElementParser());
		parsers.put(Tags.IMAGE, new SVGImageElementParser());
		parsers.put(Tags.SWITCH, new SVGSwitchElementParser());
		parsers.put(Tags.FONT, new SVGFontElementParser());
		parsers.put(Tags.MARKER, new SVGMarkerElementParser());
		parsers.put(Tags.TEXT_PATH, new SVGTextPathElementParser());
		parsers.put(Tags.FOREIGN_OBJECT, new SVGForeignObjectElementParser());
		parsers.put(Tags.ALT_GLYPH, new SVGAltGlyphElementParser());
		parsers.put(Tags.ALT_GLYPH_DEF, new SVGAltGlyphDefElementParser());
		parsers.put(Tags.ALT_GLYPH_ITEM, new SVGAltGlyphItemElementParser());
		parsers.put(Tags.GLYPH_REF, new SVGGlyphRefElementParser());
		parsers.put(Tags.COLOR_PROFILE, new SVGColorProfileElementParser());
		parsers.put(Tags.CLIP_PATH, new SVGClipPathElementParser());
		parsers.put(Tags.A, new SVGAElementParser());
		parsers.put(Tags.VIEW, new SVGViewElementParser());
		parsers.put(Tags.FONT_FACE, new SVGFontFaceElementParser());
		parsers.put(Tags.FILTER, new SVGFilterElementParser());
		parsers.put(Tags.FE_DISTANTLIGHT, new SVGFEDistantLightElementParser());
		parsers.put(Tags.FE_POINTLIGHT, new SVGFEPointLightElementParser());
		parsers.put(Tags.FE_SPOTLIGHT, new SVGFESpotLightElementParser());
		parsers.put(Tags.FE_BLEND, new SVGFEBlendElementParser());
		parsers.put(Tags.FE_COLORMATRIX, new SVGFEColorMatrixElementParser());
		parsers.put(Tags.FE_COMPONENTTRANSFER, new SVGFEComponentTransferElementParser());
		parsers.put(Tags.FE_FUNCA, new SVGFEFuncAElementParser());
		parsers.put(Tags.FE_FUNCB, new SVGFEFuncBElementParser());
		parsers.put(Tags.FE_FUNCG, new SVGFEFuncGElementParser());
		parsers.put(Tags.FE_FUNCR, new SVGFEFuncRElementParser());
		parsers.put(Tags.FE_COMPOSITE, new SVGFECompositeElementParser());
		parsers.put(Tags.FE_CONVOLVEMATRIX, new SVGFEConvolveMatrixElementParser());
		parsers.put(Tags.FE_DIFFUSELIGHTING, new SVGFEDiffuseLightingElementParser());
		parsers.put(Tags.FE_DISPLACEMENTMAP, new SVGFEDisplacementMapElementParser());
		parsers.put(Tags.FE_FLOOD, new SVGFEFloodElementParser());
		parsers.put(Tags.FE_GAUSSIANBLUR, new SVGFEGaussianBlurElementParser());
		parsers.put(Tags.FE_IMAGE, new SVGFEImageElementParser());
		parsers.put(Tags.FE_MERGE, new SVGFEMergeElementParser());
		parsers.put(Tags.FE_MERGENODE, new SVGFEMergeNodeElementParser());
		parsers.put(Tags.FE_MORPHOLOGY, new SVGFEMorphologyElementParser());
		parsers.put(Tags.FE_OFFSET, new SVGFEOffsetElementParser());
		parsers.put(Tags.FE_SPECULARLIGHTING, new SVGFESpecularLightingElementParser());
		parsers.put(Tags.FE_TILE, new SVGFETileElementParser());
		parsers.put(Tags.FE_TURBULENCE, new SVGFETurbulenceElementParser());
		parsers.put(Tags.PATH, new SVGPathElementParser());
		parsers.put(Tags.GLYPH, new SVGGlyphElementParser());
		parsers.put(Tags.MISSING_GLYPH, new SVGMissingGlyphElementParser());
		parsers.put(Tags.USE, new SVGUseElementParser());
		parsers.put(Tags.ANIMATE, new SVGAnimateElementParser());
		parsers.put(Tags.SET, new SVGSetElementParser());
		parsers.put(Tags.ANIMATE_COLOR, new SVGAnimateColorElementParser());
		parsers.put(Tags.ANIMATE_TRANSFORM, new SVGAnimateTransformElementParser());
		parsers.put(Tags.ANIMATE_MOTION, new SVGAnimateMotionElementParser());
		parsers.put(Tags.MPATH, new SVGMPathElementParser());
		parsers.put(Tags.SVG, new SVGSVGElementParser());
		parsers.put(Tags.HKERN, new SVGHKernElementParser());
		parsers.put(Tags.VKERN, new SVGVKernElementParser());
		parsers.put(Tags.LINEAR_GRADIENT, new SVGLinearGradientElementParser());
		parsers.put(Tags.RADIAL_GRADIENT, new SVGRadialGradientElementParser());
		parsers.put(Tags.STOP, new SVGStopElementParser());
		parsers.put(Tags.PATTERN, new SVGPatternElementParser());
		registered = true;
	}
	
	public static boolean hasRegistered() {
		return registered;
	}
	
	public static ElementParser getParser(String tag) {
		return parsers.get(tag);
	}
	
}
