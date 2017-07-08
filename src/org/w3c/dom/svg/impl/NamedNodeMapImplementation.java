package org.w3c.dom.svg.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.DOMException;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

@SuppressWarnings("rawtypes")
public class NamedNodeMapImplementation implements NamedNodeMap {

	private List nodes;
	
	public NamedNodeMapImplementation() {
		nodes = new ArrayList();
	}
	
	public NamedNodeMapImplementation(List nodes) {
		this.nodes = nodes;
	}
	
	@Override
	public int getLength() {
		return nodes.size();
	}

	@Override
	public Node getNamedItem(String name) {
		Iterator iterator = nodes.iterator();
		while (iterator.hasNext()) {
			Node node = (Node) iterator.next();
			if (name.equals(node.getNodeName())) {
				return node;
			}
		}
		return null;
	}

	@Override
	public Node getNamedItemNS(String namespaceURI, String localName) throws DOMException {
		return getNamedItem(localName);
	}

	@Override
	public Node item(int index) {
		return (Node) nodes.get(index);
	}

	@Override
	public Node removeNamedItem(String name) throws DOMException {
		throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR, "This NamedNodeMap is readonly");
	}

	@Override
	public Node removeNamedItemNS(String arg0, String arg1) throws DOMException {
		throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR, "This NamedNodeMap is readonly");
	}

	@Override
	public Node setNamedItem(Node node) throws DOMException {
		throw new DOMException(DOMException.NO_MODIFICATION_ALLOWED_ERR, "This NamedNodeMap is readonly");
	}

	@Override
	public Node setNamedItemNS(Node node) throws DOMException {
		return setNamedItem(node);
	}

}
