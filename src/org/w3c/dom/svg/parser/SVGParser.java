package org.w3c.dom.svg.parser;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
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
	
	private String removeNamespace(String tag, String... validNamespaces) {
		String[] split = tag.split(":");
		if (split.length == 1) {
			return tag;
		}
		if (split.length > 2) {
			SVGErrors.error("Invalid namespace: " + tag);
		}
		for (int i = 0; i < validNamespaces.length; i++) {
			if (split[0].equals(validNamespaces[i])) {
				return split[1];
			}
		}
		return SVGErrors.error("Invalid namespace: " + tag);
	}
	
	@SuppressWarnings("rawtypes")
	private SVGElement parseElementRecursively(Element root, ParsingState parsingState) {
		ElementParser parser = Parsers.getParser(removeNamespace(root.getTagName(), "svg"));
		SVGElement element = parser.readElement(root, parsingState);
		parsingState.addElement(element);
		if (element instanceof SVGSVGElement) {
			if (parsingState.getOwnerSVGElement() == null) {
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Element parseElementRecursively(SVGElement root, ElementFactory factory) {
		ElementParser parser = Parsers.getParser(root.getTagName());
		Element element = parser.writeElement(root, factory);
		NodeList children = root.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node child = children.item(i);
			if (!(child instanceof SVGElement)) {
				continue;
			}
			element.appendChild(parseElementRecursively((SVGElement) child, factory));
		}
		return element;
	}
	
	public void writeDocument(SVGSVGElement element, OutputStream stream) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		Document document = builder.newDocument();
		ElementFactory factory = (name, attributes) -> {
			Element node = document.createElement(name);
			attributes.entrySet().forEach((entry) -> node.setAttribute(entry.getKey(), entry.getValue()));
			return node;
		};
		Element rootElement = parseElementRecursively(element, factory);
		document.appendChild(rootElement);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(stream);
		transformer.transform(source, result);
	}

}
