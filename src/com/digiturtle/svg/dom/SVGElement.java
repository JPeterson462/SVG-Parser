package com.digiturtle.svg.dom;

import com.digiturtle.svg.datatypes.Element;
import com.digiturtle.svg.datatypes.ExternalResourcesRequired;
import com.digiturtle.svg.datatypes.FitToViewBox;
import com.digiturtle.svg.datatypes.LangSpace;
import com.digiturtle.svg.datatypes.Locatable;
import com.digiturtle.svg.datatypes.Stylable;
import com.digiturtle.svg.datatypes.Tests;
import com.digiturtle.svg.datatypes.ZoomAndPan;
import com.digiturtle.svg.datatypes.animated.AnimatedLength;

public class SVGElement { // TODO

	// TODO which elements can be set to readonly?, setting ElementList to readonly.
	// TODO methods like newValueSpecifiedUnits, convertToSpecifiedUnits
	
	// SVG ICC Color
	
	// StyleDeclaration, Value
	
	// check that readonly elements are set in constructor
	
	// Transformable
	
	// CSSRule (and SVGCSSRule)
	
	// implement DocumentEvent, ViewCSS, DocumentCSS
	
	// GElement, DefsElement, DescElement, TitleElement,
	// SymbolElement, UseElement, ElementInstance, 
	// ElementInstanceList, ImageElement, SwitchElement,
	// GetSVGDocument
	
	// Styling
	
	// Start with Section 7
	
	private Element element;
	
	private Tests tests;
	
	private LangSpace langSpace;
	
	private ExternalResourcesRequired externalResourcesRequires;
	
	private Stylable stylable;
	
	private Locatable locatable;
	
	private FitToViewBox fitToViewBox;
	
	private ZoomAndPan zoomAndPan;
	
	private AnimatedLength x, y, width, height;
	
}
