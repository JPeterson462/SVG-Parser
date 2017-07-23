package org.w3c.dom.svg.parser;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGParser {
	
	public SVGSVGElement readDocument(InputStream stream) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(stream);
		document.getDocumentElement().normalize();
		if (!Parsers.hasRegistered()) {
			Parsers.registerParsers();
		}
		Element root = document.getDocumentElement();
		if (root.getTagName().equals(Tags.SVG)) {
			ParsingState parsingState = new ParsingState();
			return (SVGSVGElement) parseElementRecursively(root, parsingState);
		} else {
			throw new DOMException(DOMException.INVALID_STATE_ERR, "Invalid SVG Document");
		}
	}
	
	@SuppressWarnings("rawtypes")
	private SVGElement parseElementRecursively(Element root, ParsingState parsingState) {
		ElementParser parser = Parsers.getParser(root.getTagName());
		SVGElement element = parser.readElement(root, parsingState);
		if (element instanceof SVGSVGElement) {
			if (parsingState.getOwnerSVGElement() == null) { // TODO set viewport element each time?
				parsingState.setOwnerSVGElement((SVGSVGElement) element);
			}
		}
		NodeList children = root.getChildNodes();
		parsingState.pushParent(element);
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (!(child instanceof Element)) {
				continue;
			}
			element.appendChild(parseElementRecursively((Element) child, parsingState));
		}
		parsingState.popParent();
		return element;
	}
	
	public void writeDocument(SVGSVGElement element, OutputStream stream) {
		//TODO
	}

}
