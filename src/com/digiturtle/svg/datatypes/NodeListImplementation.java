package com.digiturtle.svg.datatypes;

import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("rawtypes")
public class NodeListImplementation implements NodeList {

	private List nodes;
	
	public NodeListImplementation(List nodes) {
		this.nodes = nodes;
	}

	@Override
	public int getLength() {
		return nodes.size();
	}

	@Override
	public Node item(int index) {
		if (index < 0 || index > nodes.size()) {
			return null;
		}
		return (Node) nodes.get(index);
	}

}
