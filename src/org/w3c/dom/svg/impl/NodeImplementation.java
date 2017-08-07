package org.w3c.dom.svg.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.DOMErrors;

public class NodeImplementation implements Node, NodeList {

	protected String nodeName = null;
	
	protected String nodeValue = null;

	private Object userObject = null;
	
	private Node parent = null;
	
	private int numChildren = 0;
	
	private NodeImplementation firstChild = null;
	
	private NodeImplementation lastChild = null;
	
	private NodeImplementation nextSibling = null;
	
	private NodeImplementation previousSibling = null;
	
	protected List<AttrImplementation> attributes = new ArrayList<>();
	
	public NodeImplementation(String nodeName) {
		this.nodeName = nodeName;
	}
	
	public void duplicate(NodeImplementation dup) {
		dup.nodeValue = nodeValue;
		dup.userObject = userObject;
		dup.parent = parent;
		dup.numChildren = numChildren;
		dup.firstChild = firstChild;
		dup.lastChild = lastChild;
		dup.nextSibling = nextSibling;
		dup.previousSibling = previousSibling;
		dup.attributes = attributes;
	}
	
	private void checkNode(Node node) throws DOMException {
		if (node == null) {
			return;
		}
		if (!(node instanceof NodeImplementation)) {
			throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, "Node not an instance of NodeImplementation");
		}
	}
	
	@Override
	public Node appendChild(Node newChild) {
		if (newChild == null) {
			throw new IllegalArgumentException("newChild == null");
		}
		checkNode(newChild);
		return insertBefore(newChild, null);
	}

	@Override
	public Node cloneNode(boolean deep) {
		NodeImplementation newNode = new NodeImplementation(nodeName);
		newNode.setUserObject(getUserObject());
		if (deep) {
			for (NodeImplementation child = firstChild; child != null; child = child.nextSibling) {
				newNode.appendChild(child.cloneNode(true));
			}
		}
		return newNode;
	}

	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		return DOMErrors.notSupported();
		}

	@Override
	public NamedNodeMap getAttributes() {
		return new NamedNodeMapImplementation(attributes);
	}

	@Override
	public String getBaseURI() {
		return DOMErrors.notSupported();
	}

	@Override
	public NodeList getChildNodes() {
		return this;
	}

	@Override
	public Object getFeature(String feature, String version) {
		return DOMErrors.notSupported();
	}

	@Override
	public Node getFirstChild() {
		return firstChild;
	}

	@Override
	public Node getLastChild() {
		return lastChild;
	}

	@Override
	public String getLocalName() {
		return nodeName;
	}

	@Override
	public String getNamespaceURI() {
		return null;
	}

	@Override
	public Node getNextSibling() {
		return nextSibling;
	}

	@Override
	public String getNodeName() {
		return nodeName;
	}

	@Override
	public short getNodeType() {
		throw new DOMException(DOMException.INVALID_STATE_ERR, "Need to implement");
	}

	@Override
	public String getNodeValue() throws DOMException {
		return nodeValue;
	}

	@Override
	public Document getOwnerDocument() {
		return null;
	}

	@Override
	public Node getParentNode() {
		return parent;
	}

	@Override
	public String getPrefix() {
		return null;
	}

	@Override
	public Node getPreviousSibling() {
		return previousSibling;
	}

	@Override
	public String getTextContent() throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public Object getUserData(String key) {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean hasAttributes() {
		return attributes.size() > 0;
	}

	@Override
	public boolean hasChildNodes() {
		return numChildren > 0;
	}

	@Override
	public Node insertBefore(Node newChild, Node refChild) throws DOMException {
		if (newChild == null) {
			throw new IllegalArgumentException("newChild == null");
		}
		checkNode(newChild);
		checkNode(refChild);
		NodeImplementation newChildNode = (NodeImplementation) newChild;
		NodeImplementation refChildNode = (NodeImplementation) refChild;
		NodeImplementation previous = null;
		NodeImplementation next = null;
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

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean isEqualNode(Node arg) {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean isSameNode(Node other) {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean isSupported(String feature, String version) {
		return false;
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		return DOMErrors.notSupported();
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		return DOMErrors.notSupported();
	}

	@Override
	public void normalize() {
		
	}

	@Override
	public Node removeChild(Node oldChild) throws DOMException {
		if (oldChild == null) {
			throw new IllegalArgumentException("oldChild == null");
		}
		checkNode(oldChild);
		NodeImplementation oldChildNode = (NodeImplementation) oldChild;
		NodeImplementation previous = oldChildNode.previousSibling;
		NodeImplementation next = oldChildNode.nextSibling;
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

	@Override
	public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
		if (newChild == null) {
			throw new IllegalArgumentException("newChild == null");
		}
		checkNode(newChild);
		checkNode(oldChild);
		NodeImplementation newChildNode = (NodeImplementation) newChild;
		NodeImplementation oldChildNode = (NodeImplementation) oldChild;
		NodeImplementation previous = oldChildNode.previousSibling;
		NodeImplementation next = oldChildNode.nextSibling;
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

	@Override
	public void setNodeValue(String nodeValue) throws DOMException {
		this.nodeValue = nodeValue;
	}

	@Override
	public void setPrefix(String prefix) throws DOMException {
		
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		return DOMErrors.notSupported();
	}

	public Object getUserObject() {
		return userObject;
	}
	
	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}

	@Override
	public int getLength() {
		return numChildren;
	}

	@Override
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

}
