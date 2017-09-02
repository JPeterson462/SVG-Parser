package org.w3c.dom.svg.parser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.impl.CSSStyleSheetImplementation;
import org.w3c.dom.css.impl.MediaListImplementation;
import org.w3c.dom.stylesheets.StyleSheet;
import org.w3c.dom.stylesheets.StyleSheetList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.document.SVGRenderingState;
import org.w3c.dom.svg.document.SVGSVGElement;

public class ParsingState {
	
	private SVGSVGElement ownerSVGElement;
	
	private Stack<SVGElement> elementHierarchy = new Stack<>();
	
	private ArrayList<SVGElement> elementsAdded = new ArrayList<>();
	
	private ArrayList<StyleSheet> stylesheets = new ArrayList<>();
	
	private SVGRenderingState renderingState;
	
	public ParsingState(SVGRenderingState renderingState) {
		this.renderingState = renderingState;
	}
	
	public SVGRenderingState getRenderingState() {
		return renderingState;
	}

	public SVGSVGElement getOwnerSVGElement() {
		return ownerSVGElement;
	}
	
	public void addElement(SVGElement element) {
		elementsAdded.add(element);
	}
	
	public void addStyleSheet(String cssText) {
		CSSStyleSheetImplementation stylesheet = new CSSStyleSheetImplementation(null, false, null, new MediaListImplementation(), ownerSVGElement, null, null, null, null, this);
		stylesheet.setCssText(cssText);
		stylesheets.add(stylesheet);
	}
	
	public StyleSheetList toStyleSheetList() {
		class StyleSheetListImplementation implements StyleSheetList {

			private ArrayList<StyleSheet> stylesheets = new ArrayList<>();
			
			public StyleSheetListImplementation(ArrayList<StyleSheet> stylesheets) {
				this.stylesheets = stylesheets;
			}
			
			@Override
			public int getLength() {
				return stylesheets.size();
			}

			@Override
			public StyleSheet item(int index) {
				return stylesheets.get(index);
			}
			
		}
		return new StyleSheetListImplementation(stylesheets);
	}
	
	public SVGElement getElement(String href) {
		if (href.startsWith("#")) {
			href = href.substring(1);
		}
		for (int i = 0; i < elementsAdded.size(); i++) {
			SVGElement element = elementsAdded.get(i);
			if (element.getID().equals(href)) {
				return element;
			}
		}
		return SVGErrors.error("Element not found: " + href);
	}
	
	@FunctionalInterface
	public interface HierarchyTraversal {
		public void visit(SVGElement element);
	}
	
	public void traverseHierarchy(HierarchyTraversal traversal) {
		Iterator<SVGElement> iterator = elementHierarchy.iterator();
		while (iterator.hasNext()) {
			traversal.visit(iterator.next());
		}
	}

	public void setOwnerSVGElement(SVGSVGElement ownerSVGElement) {
		this.ownerSVGElement = ownerSVGElement;
	}
	
	public SVGElement getViewportElement() {
		Iterator<SVGElement> elements = elementHierarchy.iterator();
		while (elements.hasNext()) {
			SVGElement element = elements.next();
			if (element instanceof SVGSVGElement) {
				return element;
			}
		}
		return ownerSVGElement;
	}
	
	public SVGElement getCurrentParent() {
		return elementHierarchy.peek();
	}
	
	public CSSRule findParentRule() {
		return null;
	}
	
	public void pushParent(SVGElement element) {
		elementHierarchy.push(element);
	}
	
	public SVGElement popParent() {
		return elementHierarchy.pop();
	}

}
