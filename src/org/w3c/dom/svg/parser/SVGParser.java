package org.w3c.dom.svg.parser;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
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
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.animation.SVGAnimationElement;
import org.w3c.dom.svg.document.SVGRenderingState;
import org.w3c.dom.svg.document.SVGSVGElement;

public class SVGParser {
	
	public SVGSVGElement readDocument(InputStream stream, SVGRenderingState renderingState) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(stream);
		document.getDocumentElement().normalize();
		if (!Parsers.hasRegistered()) {
			Parsers.registerParsers();
		}
		Element root = document.getDocumentElement();
		if (root.getTagName().equals(Tags.SVG)) {
			ParsingState parsingState = new ParsingState(renderingState);
			SVGSVGElement rootElement = (SVGSVGElement) parseElementRecursively(root, parsingState);
			parsingState.traverseHierarchy(element -> {
				if (element instanceof SVGAnimationElement) {
					((SVGAnimationElement) element).searchForTargetElement(parsingState::getElement);
				}
			});
			SVGLength.Pool.calculate();
			return rootElement;
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
			return null;
		}
		for (int i = 0; i < validNamespaces.length; i++) {
			if (split[0].equals(validNamespaces[i])) {
				return split[1];
			}
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private SVGElement parseElementRecursively(Element root, ParsingState parsingState) {
		String strippedTag = removeNamespace(root.getTagName(), "svg");
		if (strippedTag == null) {
			return null;
		}
		ElementParser parser = Parsers.getParser(strippedTag);
		if (parser == null) {
			return null;
		}
		System.out.println("'" + root.getTagName() + "'");
		SVGElement element = parser.readElement(root, parsingState);
		element.setTag(root.getTagName());
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
			Node childNode = parseElementRecursively((Element) child, parsingState);
			if (childNode != null) {
				element.appendChild(childNode);
			}
		}
		parsingState.popParent();
		return element;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Element parseElementRecursively(SVGElement root, ElementFactory factory) {
		ElementParser parser = Parsers.getParser(root.getTag());
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
	
	private boolean isInvalidNumber(String text) {
		if (text.equals("NaN")) {
			return true;
		}
		return false;
	}
	
	public void writeDocument(SVGSVGElement element, OutputStream stream) throws ParserConfigurationException, TransformerException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = dbFactory.newDocumentBuilder();
		Document document = builder.newDocument();
		ElementFactory factory = (name, attributes) -> {
			Element node = document.createElement(name);
			attributes.entrySet().forEach((entry) -> { 
				if (entry.getValue() != null && entry.getValue().length() > 0 && !isInvalidNumber(entry.getValue())) {
					node.setAttribute(entry.getKey(), entry.getValue());
				}
			});
			return node;
		};
		Element rootElement = parseElementRecursively(element, factory);
		document.appendChild(rootElement);
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
		DOMSource source = new DOMSource(document);
		StreamResult result = new StreamResult(stream);
		transformer.transform(source, result);
	}

}
