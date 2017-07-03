package org.w3c.dom.svg.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class TextImplementation extends CharacterDataImplementation implements Text {

	public TextImplementation(String nodeName) {
		super(nodeName);
	}

	@Override
	public String getWholeText() {
		return getData();
	}

	@Override
	public boolean isElementContentWhitespace() {
		int len = nodeValue.length();
		for (int i = 0; i < len; i++) {
			if (!XMLSupport.isXMLSpace(nodeValue.charAt(i))) {
				return false;
			}
		}
		Node p = getParentNode();
		if (p.getNodeType() == Node.ELEMENT_NODE) {
			String sp = XMLSupport.getXMLSpace((Element) p);
			return !sp.equals(XMLSupport.XML_PRESERVE_VALUE);
		}
		return true;
	}

	@Override
	public Text replaceWholeText(String content) throws DOMException {
		if (content.length() == 0) {
			return null;
		}
		setData(content);
		return this;
	}

	@Override
	public Text splitText(int offset) throws DOMException {
		String otherText = getData().substring(offset);
		setData(getData().substring(0, offset));
		Text newText = new TextImplementation(nodeName);
		newText.setData(otherText);
		return newText;
	}

}
