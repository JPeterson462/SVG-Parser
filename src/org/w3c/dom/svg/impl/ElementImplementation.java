package org.w3c.dom.svg.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.DOMErrors;

@SuppressWarnings("rawtypes")
public class ElementImplementation extends NodeImplementation implements Element, NodeList {

	public ElementImplementation(String nodeName) {
		super(nodeName);
	}

	@Override
	public String getAttribute(String name) {
		Attr attr = getAttributeNode(name);
		if (attr == null) {
			return "";
		}
		return attr.getValue();	
	}

	@Override
	public String getAttributeNS(String namespaceURI, String localName) {
		return getAttribute(localName);
	}

	@Override
	public Attr getAttributeNode(String name) {
		return (Attr) getAttributes().getNamedItem(name);
	}

	@Override
	public Attr getAttributeNodeNS(String namespaceURI, String localName) {
		return getAttributeNode(localName);
	}

	@Override
	public NodeList getElementsByTagName(String name) {
		List list = new ArrayList<>();
		getElementsByTagName(name, list);
		return new NodeListImplementation(list);
	}
	
	@SuppressWarnings("unchecked")
	private void getElementsByTagName(String name, List list) {
		if (nodeName.equals(name)) {
			list.add(this);
		}
		Node child = getFirstChild();
		while (child != null) {
			((ElementImplementation) child).getElementsByTagName(name, list);
			child = child.getNextSibling();
		}
	}
	
	@Override
	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public TypeInfo getSchemaTypeInfo() {
		return DOMErrors.notSupported();
	}

	@Override
	public String getTagName() {
		return nodeName;
	}

	@Override
	public boolean hasAttribute(String name) {
		return getAttributeNode(name) != null;
	}

	@Override
	public boolean hasAttributeNS(String namespaceURI, String localName) {
		return hasAttribute(localName);
	}

	@Override
	public void removeAttribute(String name) {
		removeAttribute(name, true);
	}
	
	private void removeAttribute(String name, boolean checkPresent) {
		int numAttributes = attributes.size();
		for (int i = 0; i < numAttributes; i++) {
			AttrImplementation attr = attributes.get(i);
			if (name.equals(attr.getName())) {
				attr.setOwnerElement(null);
				attributes.remove(i);
				return;
			}
		}
		if (checkPresent) {
			throw new DOMException(DOMException.NOT_FOUND_ERR, "No such attribute!");
		}
	}

	@Override
	public void removeAttributeNS(String namespaceURI, String localName) {
		removeAttribute(localName);
	}

	@Override
	public Attr removeAttributeNode(Attr oldAttr) {
		removeAttribute(oldAttr.getName());
		return oldAttr;
	}

	@Override
	public void setAttribute(String name, String value) {
		boolean valid = true;
		char[] chars = name.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] > 0xFFFE) {
				valid = false;
				break;
			}
		}
		if (!valid) {
			throw new DOMException(DOMException.INVALID_CHARACTER_ERR, "Attribute name is illegal!");
		}
		removeAttribute(name, false);
		attributes.add(new AttrImplementation(this, name, value));
	}

	@Override
	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) {
		setAttribute(qualifiedName, value);
	}

	@Override
	public Attr setAttributeNode(Attr newAttr) throws DOMException {
		Element owner = newAttr.getOwnerElement();
		if (owner != null) {
			if (owner == this) {
				return null;
			} else {
				throw new DOMException(DOMException.INUSE_ATTRIBUTE_ERR, "Attribute is already in use");
			}
		}
		AttrImplementation attr;
		if (newAttr instanceof AttrImplementation) {
			attr = (AttrImplementation) newAttr;
			attr.setOwnerElement(this);
		} else {
			attr = new AttrImplementation(this, newAttr.getName(), newAttr.getValue());
		}
		Attr oldAttr = getAttributeNode(attr.getName());
		if (oldAttr != null) {
			removeAttributeNode(oldAttr);
		}
		attributes.add(attr);
		return oldAttr;
	}

	@Override
	public Attr setAttributeNodeNS(Attr newAttr) {
		return setAttributeNode(newAttr);
	}
	
	@Override
	public void setIdAttribute(String name, boolean isId) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
		DOMErrors.notSupported();
	}
	
}
