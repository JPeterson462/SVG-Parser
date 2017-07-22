package org.w3c.dom.svg;

// https://developer.mozilla.org/en-US/docs/Web/SVG/Attribute/requiredFeatures
public interface SVGFeatures {

	public static final String PREFIX = "http://www.w3.org/TR/SVG11/feature#";
	
	/** At least one of the following feature is supported:
	 * <ul>
		<li>http://www.w3.org/TR/SVG11/feature#SVG-static</li>
		<li>http://www.w3.org/TR/SVG11/feature#SVG-animation</li>
		<li>http://www.w3.org/TR/SVG11/feature#SVG-dynamic</li>
		<li>http://www.w3.org/TR/SVG11/feature#SVGDOM</li>
	 * </ul>
	 */
	public static final String SVG = PREFIX + "SVG";
	
	/** At least one of the following feature is supported:
	 * <ul>
		<li>http://www.w3.org/TR/SVG11/feature#SVGDOM-static</li>
		<li>http://www.w3.org/TR/SVG11/feature#SVGDOM-animation</li>
		<li>http://www.w3.org/TR/SVG11/feature#SVGDOM-dynamic</li>
	 * </ul>
	 */
	public static final String SVGDOM = PREFIX + "SVGDOM";
	
	/** The browser supports all the following features:
	 * <ul>
		<li>http://www.w3.org/TR/SVG11/feature#CoreAttribute</li>
		<li>http://www.w3.org/TR/SVG11/feature#Structure</li>
		<li>http://www.w3.org/TR/SVG11/feature#ContainerAttribute</li>
		<li>http://www.w3.org/TR/SVG11/feature#ConditionalProcessing</li>
		<li>http://www.w3.org/TR/SVG11/feature#Image</li>
		<li>http://www.w3.org/TR/SVG11/feature#Style</li>
		<li>http://www.w3.org/TR/SVG11/feature#ViewportAttribute</li>
		<li>http://www.w3.org/TR/SVG11/feature#Shape</li>
		<li>http://www.w3.org/TR/SVG11/feature#Text</li>
		<li>http://www.w3.org/TR/SVG11/feature#PaintAttribute</li>
		<li>http://www.w3.org/TR/SVG11/feature#OpacityAttribute</li>
		<li>http://www.w3.org/TR/SVG11/feature#GraphicsAttribute</li>
		<li>http://www.w3.org/TR/SVG11/feature#Marker</li>
		<li>http://www.w3.org/TR/SVG11/feature#ColorProfile</li>
		<li>http://www.w3.org/TR/SVG11/feature#Gradient</li>
		<li>http://www.w3.org/TR/SVG11/feature#Pattern</li>
		<li>http://www.w3.org/TR/SVG11/feature#Clip</li>
		<li>http://www.w3.org/TR/SVG11/feature#Mask</li>
		<li>http://www.w3.org/TR/SVG11/feature#Filter</li>
		<li>http://www.w3.org/TR/SVG11/feature#XlinkAttribute</li>
		<li>http://www.w3.org/TR/SVG11/feature#Font</li>
		<li>http://www.w3.org/TR/SVG11/feature#Extensibility</li>
	 * </ul>
	 */
	public static final String SVG_STATIC = PREFIX + "SVG-static";
	
	/** The browser supports all of the DOM interfaces and methods that
	 * 	correspond to the language features for http://www.w3.org/TR/SVG11/feature#SVG-static.
	 */
	public static final String SVGDOM_STATIC = PREFIX + "SVGDOM-static";
	
	/** The browser supports all of the language features from
	 * 	http://www.w3.org/TR/SVG11/feature#SVG-static plus the feature
	 * 	http://www.w3.org/TR/SVG11/feature#Animation.
	 */
	public static final String SVG_ANIMATION = PREFIX + "SVG-animation";
	
	/** The browser supports all of the DOM interfaces and methods that
	 * 	correspond to the language features for http://www.w3.org/TR/SVG11/feature#SVG-animation.
	 */
	public static final String SVGDOM_ANIMATION = PREFIX + "SVGDOM-animation";
	
	/** The browser supports all of the language features from
	 * 	http://www.w3.org/TR/SVG11/feature#SVG-animation plus the following features:
	 * <ul>
		<li>http://www.w3.org/TR/SVG11/feature#Hyperlinking</li>
		<li>http://www.w3.org/TR/SVG11/feature#Scripting</li>
		<li>http://www.w3.org/TR/SVG11/feature#View</li>
		<li>http://www.w3.org/TR/SVG11/feature#Cursor</li>
		<li>http://www.w3.org/TR/SVG11/feature#GraphicalEventsAttribute</li>
		<li>http://www.w3.org/TR/SVG11/feature#AnimationEventsAttribute</li>
	 * </ul>
	 */
	public static final String SVG_DYNAMIC = PREFIX + "SVG-dynamic";
	
	/** The browser supports all of the DOM interfaces and methods that
	 * 	correspond to the language features for http://www.w3.org/TR/SVG11/feature#SVG-dynamic. 
	 */
	public static final String SVGDOM_DYNAMIC = PREFIX + "SVGDOM-dynamic";
	
	/** The browser supports the id, xml:base, xml:lang and xml:space attributes */
	public static final String CORE_ATTRIBUTE = PREFIX + "CoreAttribute";
	
	/** The browser supports &lt;svg&gt;, &lt;g&gt;, &lt;defs&gt;, &lt;desc&gt;, &lt;title&gt;, &lt;metadata&gt;, &lt;symbol&gt; and &lt;use&gt; elements. */
	public static final String STRUCTURE = PREFIX + "Structure";
	
	/** The browser supports &lt;svg&gt;, &lt;g&gt;, &lt;defs&gt;, &lt;desc&gt;, &lt;title&gt;, &lt;metadata&gt; and &lt;use&gt; elements. */
	public static final String BASIC_STRUCTURE = PREFIX + "BasicStructure";
	
	/** The browser supports the enable-background attribute */
	public static final String CONTAINER_ATTRIBUTE = PREFIX + "ContainerAttribute";
	
	/** The browser supports the &lt;switch&gt; element, and the requiredFeatures, requiredExtensions, systemLanguage attributes */
	public static final String CONDITIONAL_PROCESSING = PREFIX + "ConditionalProcessing";
	
	/** The browser supports the &lt;image&gt; element. */
	public static final String IMAGE = PREFIX + "Image";
	
	/** The browser supports the &lt;style&gt; element. */
	public static final String STYLE = PREFIX + "Style";
	
	/** The browser supports the clip and overflow attributes. */
	public static final String VIEWPORT_ATTRIBUTE = PREFIX + "ViewportAttribute";
	
	/** The browser supports the &lt;rect&gt;, &lt;circle&gt;, &lt;line&gt;, &lt;polyline&gt;,
	 * 	&lt;polygon&gt;, &lt;ellipse&gt; and &lt;path&gt; elements. */
	public static final String SHAPE = PREFIX + "Shape";
	
	/** The browser supports the &lt;text&gt;, &lt;tspan&gt;, &lt;tref&gt;, &lt;textpath&gt;, &lt;altglyph&gt;, &lt;altglyphdef&gt;,
	 * 	&lt;altglyphitem&gt; and &lt;glyphref&gt; elements. */
	public static final String TEXT = PREFIX + "Text";
	
	/** The browser supports the &lt;text&gt; element */
	public static final String BASIC_TEXT = PREFIX + "BasicText";
	
	/** The browser supports the color, fill, fill-rule, stroke, stroke-dasharray,
	 * 	stroke-dashoffset, stroke-linecap, stroke-linejoin, stroke-miterlimit,
	 * 	stroke-width, color-interpolation and color-rendering attributes
	 */
	public static final String PAINT_ATTRIBUTE = PREFIX + "PaintAttribute";
	
	/** The browser supports the color, fill, fill-rule, stroke, stroke-dasharray,
	 * 	stroke-dashoffset, stroke-linecap, stroke-linejoin, stroke-miterlimit,
	 * 	stroke-width and color-rendering attributes */
	public static final String BASIC_PAINT_ATTRIBUTE = PREFIX + "BasicPaintAttribute";
	
	/** The browser supports the opacity, stroke-opacity and fill-opacity attributes */
	public static final String OPACITY_ATTRIBUTE = PREFIX + "OpacityAttribute";
	
	/** The browser supports the display, image-rendering, pointer-events, shape-rendering,
	 * 	text-rendering and visibility attributes */
	public static final String GRAPHICS_ATTRIBUTE = PREFIX + "GraphicsAttribute";
	
	/** The browser supports the display and visibility attributes */
	public static final String BASIC_GRAPHICS_ATTRIBUTE = PREFIX + "BasicGraphicsAttribute";
	
	/** The browser supports the &lt;marker&gt; element */
	public static final String MARKER = PREFIX + "Marker";
	
	/** The browser supports the &lt;color-profile&gt; element */
	public static final String COLOR_PROFILE = PREFIX + "ColorProfile";
	
	/** The browser supports the &lt;lineargradient&gt;, &lt;radialgradient&gt; and &lt;stop&gt; elements */
	public static final String GRADIENT = PREFIX + "Gradient";
	
	/** The browser supports the &lt;pattern&gt; element */
	public static final String PATTERN = PREFIX + "Pattern";
	
	/** The browser supports the &lt;clippath&gt; element and the clip-path, clip-rule attributes */
	public static final String CLIP = PREFIX + "Clip";
	
	/** The browser supports the &lt;clippath&gt; element and the clip-path attribute */
	public static final String BASIC_CLIP = PREFIX + "BasicClip";
	
	/** The browser supports the &lt;mask&gt; element */
	public static final String MASK = PREFIX + "Mask";
	
	/** The browser supports the &lt;filter&gt;, &lt;feblend&gt;, &lt;fecolormatrix&gt;, &lt;fecomponenttransfer&gt;,
	 * 	&lt;fecomposite&gt;, &lt;feconvolvematrix&gt;, &lt;fediffuselighting&gt;, &lt;fedisplacementmap&gt;, &lt;feflood&gt;,
	 * 	&lt;fegaussianblur&gt;, &lt;feimage&gt;, &lt;femerge&gt;, &lt;femergenode&gt;, &lt;femorphology&gt;, &lt;feoffset&gt;,
	 * 	&lt;fespecularlighting&gt;, &lt;fetile&gt;, &lt;fedistantlight&gt;, &lt;fepointlight&gt;, &lt;fespotlight&gt;,
	 * 	&lt;fefuncr&gt;, &lt;fefuncg&gt;, &lt;fefuncb&gt; and &lt;fefunca&gt; elements */
	public static final String FILTER = PREFIX + "Filter";
	
	/** The browser supports the &lt;filter&gt;, &lt;feblend&gt;, &lt;fecolormatrix&gt;, &lt;fecomponenttransfer&gt;,
	 * 	&lt;fecomposite&gt;, &lt;feflood&gt;, &lt;fegaussianblur&gt;, &lt;feimage&gt;, &lt;femerge&gt;, &lt;femergenode&gt;,
	 * 	&lt;feoffset&gt;, &lt;fetile&gt;, &lt;fefuncr&gt;, &lt;fefuncg&gt;, &lt;fefuncb&gt; and &lt;fefunca&gt; elements */
	public static final String BASIC_FILTER = PREFIX + "BasicFilter";
	
	/** The browser supports the onunload, onabort, onerror, onresize, onscroll and onzoom attributes */
	public static final String DOCUMENT_EVENTS_ATTRIBUTE = PREFIX + "DocumentEventsAttribute";
	
	/** The browser supports the onfocusin, onfocusout, onactivate, onclick, onmousedown,
	 * 	onmouseup, onmouseover, onmousemove, onmouseout and onload attributes */
	public static final String GRAPHICAL_EVENTS_ATTRIBUTE = PREFIX + "GraphicalEventsAttribute";
	
	/** The browser supports the onbegin, onend, onrepeat and onload attributes */
	public static final String ANIMATION_EVENTS_ATTRIBUTE = PREFIX + "AnimationEventsAttribute";
	
	/** The browser supports the &lt;cursor&gt; element */
	public static final String CURSOR = PREFIX + "Cursor";
	
	/** The browser supports the &lt;a&gt; element */
	public static final String HYPERLINKING = PREFIX + "Hyperlinking";
	
	/** The browser supports the xlink:type, xlink:href, xlink:role, xlink:arcrole,
	 * 	xlink:title, xlink:show and xlink:actuate attributes */
	public static final String XLINK_ATTRIBUTE = PREFIX + "XlinkAttribute";
	
	/** The browser supports the externalResourcesRequired attribute */
	public static final String EXTERNAL_RESOURCES_REQUIRED = PREFIX + "ExternalResourcesRequired";
	
	/** The browser supports the &lt;view&gt; element */
	public static final String VIEW = PREFIX + "View";
	
	/** The browser supports the &lt;script&gt; element */
	public static final String SCRIPT = PREFIX + "Script";
	
	/** The browser supports the &lt;animate&gt;, &lt;set&gt;, &lt;animatemotion&gt;, &lt;animatetransform&gt;,
	 * 	&lt;animatecolor&gt; and &lt;mpath&gt; elements */
	public static final String ANIMATION = PREFIX + "Animation";
	
	/** The browser supports the &lt;font&gt;, &lt;font-face&gt;, &lt;glyph&gt;, &lt;missing-glyph&gt;,
	 * 	&lt;hkern&gt;, &lt;vkern&gt;, &lt;font-face-src&gt;, &lt;font-face-uri&gt;, &lt;font-face-format&gt;
	 * 	and &lt;font-face-name&gt; elements */
	public static final String FONT = PREFIX + "Font";
	
	/** The browser supports the &lt;font&gt;, &lt;font-face&gt;, &lt;glyph&gt;, &lt;missing-glyph&gt;,
	 * 	&lt;hkern&gt;, &lt;font-face-src&gt; and &lt;font-face-name&gt; elements */
	public static final String BASIC_FONT = PREFIX + "BasicFont";
	
	/** The browser supports the &lt;foreignobject&gt; element */
	public static final String EXTENSIBILITY = PREFIX + "Extensibility";
	
}
