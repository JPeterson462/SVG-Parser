package com.digiturtle.svg.datatypes;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

@SuppressWarnings("rawtypes")
public class ElementImplementation implements Element, NodeList {
	
	private String nodeName = null;
	
	private String nodeValue = null;
	
	private Object userObject = null;
	
	private Element parent = null;
	
	private int numChildren = 0;
	
	private ElementImplementation firstChild = null;
	
	private ElementImplementation lastChild = null;
	
	private ElementImplementation nextSibling = null;
	
	private ElementImplementation previousSibling = null;
	
	private List<AttrImplementation> attributes = new ArrayList<>();
	
	public ElementImplementation() {
		
	}
	
	public ElementImplementation(String nodeName) {
		this.nodeName = nodeName;
	}
	
	private void checkNode(Node node) throws DOMException {
		if (node == null) {
			return;
		}
		if (!(node instanceof ElementImplementation)) {
			throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, "Node not an instance of ElementImplementation");
		}
	}
	
	public String getNodeName() {
		return nodeName;
	}
	
	public String getNodeValue() throws DOMException {
		return nodeValue;
	}
	
	public void setNodeValue(String nodeValue) throws DOMException {
		this.nodeValue = nodeValue;
	}
	
	public short getNodeType() {
		return ELEMENT_NODE;
	}
	
	public Node getParentNode() {
		return parent;
	}
	
	public NodeList getChildNodes() {
		return this;
	}
	
	public Node getFirstChild() {
		return firstChild;
	}
	
	public Node getLastChild() {
		return lastChild;
	}
	
	public Node getPreviousSibling() {
		return previousSibling;
	}
	
	public Node getNextSibling() {
		return nextSibling;
	}
	
	public NamedNodeMap getAttributes() {
		return new NamedNodeMapImplementation(attributes);
	}

	public Document getOwnerDocument() {
		return null;
	}
	
	public Node insertBefore(Node newChild, Node refChild) {
		if (newChild == null) {
			throw new IllegalArgumentException("newChild == null");
		}
		checkNode(newChild);
		checkNode(refChild);
		ElementImplementation newChildNode = (ElementImplementation) newChild;
		ElementImplementation refChildNode = (ElementImplementation) refChild;
		ElementImplementation previous = null;
		ElementImplementation next = null;
		if (refChild == null) {
			previous = lastChild;
			next = null;
			this.lastChild = newChildNode;
		} else {
			previous = refChildNode.previousSibling;
			next = refChildNode;
		}
		if (previous != null) {
			previous.nextSibling = newChildNode;
		}
		if (next != null) {
			next.previousSibling = newChildNode;
		}
		newChildNode.parent = this;
		newChildNode.previousSibling = previous;
		newChildNode.nextSibling = next;
		if (firstChild == refChildNode) {
			firstChild = newChildNode;
		}
		numChildren++;
		return newChildNode;
	}
	
	public Node replaceChild(Node newChild, Node oldChild) {
		if (newChild == null) {
			throw new IllegalArgumentException("newChild == null");
		}
		checkNode(newChild);
		checkNode(oldChild);
		ElementImplementation newChildNode = (ElementImplementation) newChild;
		ElementImplementation oldChildNode = (ElementImplementation) oldChild;
		ElementImplementation previous = oldChildNode.previousSibling;
		ElementImplementation next = oldChildNode.nextSibling;
		if (previous != null) {
			previous.nextSibling = newChildNode;
		}
		if (next != null) {
			next.previousSibling = newChildNode;
		}
		newChildNode.parent = this;
		newChildNode.previousSibling = previous;
		newChildNode.nextSibling = next;
		if (firstChild == oldChildNode) {
			firstChild = newChildNode;
		}
		if (lastChild == oldChildNode) {
			lastChild = newChildNode;
		}
		oldChildNode.parent = null;
		oldChildNode.previousSibling = null;
		oldChildNode.nextSibling = null;
		return newChildNode;
	}
	
	public Node removeChild(Node oldChild) {
		if (oldChild == null) {
			throw new IllegalArgumentException("oldChild == null");
		}
		checkNode(oldChild);
		ElementImplementation oldChildNode = (ElementImplementation) oldChild;
		ElementImplementation previous = oldChildNode.previousSibling;
		ElementImplementation next = oldChildNode.nextSibling;
		if (previous != null) {
			previous.nextSibling = next;
		}
		if (next != null) {
			next.previousSibling = previous;
		}
		if (firstChild == oldChildNode) {
			firstChild = next;
		}
		if (lastChild == oldChildNode) {
			lastChild = previous;
		}
		oldChildNode.parent = null;
		oldChildNode.previousSibling = null;
		oldChildNode.nextSibling = null;
		numChildren--;
		return oldChildNode;
	}
	
	public Node appendChild(Node newChild) {
		if (newChild == null) {
			throw new IllegalArgumentException("newChild == null");
		}
		checkNode(newChild);
		return insertBefore(newChild, null);
	}
	
	public boolean hasChildNodes() {
		return numChildren > 0;
	}
	
	public Node cloneNode(boolean deep) {
		ElementImplementation newNode = new ElementImplementation(nodeName);
		newNode.setUserObject(getUserObject());
		if (deep) {
			for (ElementImplementation child = firstChild; child != null; child = child.nextSibling) {
				newNode.appendChild(child.cloneNode(true));
			}
		}
		return newNode;
	}
	
	public void normalize() {
		
	}
	
	public boolean isSupported(String feature, String version) {
		return false;
	}
	
	public String getNamespaceURI() throws DOMException {
		return null;
	}
	
	public String getPrefix() {
		return null;
	}
	
	public void setPrefix(String prefix) {
		
	}
	
	public String getLocalName() {
		return nodeName;
	}
	
	public String getTagName() {
		return nodeName;
	}
	
	public String getAttribute(String name) {
		Attr attr = getAttributeNode(name);
		if (attr == null) {
			return "";
		}
		return attr.getValue();	
	}
	
	public String getAttributeNS(String namespaceURI, String localName) {
		return getAttribute(localName);
	}
	
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
	
	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) {
		setAttribute(qualifiedName, value);
	}
	
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
	
	public void removeAttributeNS(String namespaceURI, String localName) {
		removeAttribute(localName);
	}
	
	public Attr getAttributeNode(String name) {
		return (Attr) getAttributes().getNamedItem(name);
	}
	
	public Attr getAttributeNodeNS(String namespaceURI, String localName) {
		return getAttributeNode(localName);
	}
	
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
	
	public Attr setAttributeNodeNS(Attr newAttr) {
		return setAttributeNode(newAttr);
	}
	
	public Attr removeAttributeNode(Attr oldAttr) {
		removeAttribute(oldAttr.getName());
		return oldAttr;
	}
	
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
	
	public NodeList getElementsByTagName(String namespace, String localName) {
		return getElementsByTagName(localName);
	}
	
	public boolean hasAttributes() {
		return attributes.size() > 0;
	}
	
	public boolean hasAttribute(String name) {
		return getAttributeNode(name) != null;
	}
	
	public boolean hasAttributeNS(String namespaceURI, String localName) {
		return hasAttribute(localName);
	}
	
	public int getLength() {
		return numChildren;
	}
	
	public Node item(int index) {
		if (index < 0) {
			return null;
		}
		Node child = getFirstChild();
		while (child != null && index-- > 0) {
			child = child.getNextSibling();
		}
		return child;
	}
	
	public Object getUserObject() {
		return userObject;
	}
	
	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}

	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public String getBaseURI() {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Object getFeature(String feature, String version) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public String getTextContent() throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Object getUserData(String key) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean isEqualNode(Node arg) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean isSameNode(Node other) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public TypeInfo getSchemaTypeInfo() {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setIdAttribute(String name, boolean isId) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

}
