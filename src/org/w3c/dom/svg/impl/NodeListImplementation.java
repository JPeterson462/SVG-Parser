package org.w3c.dom.svg.impl;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@SuppressWarnings("rawtypes")
public class NodeListImplementation implements NodeList {

	private List nodes;
	
	public NodeListImplementation(List nodes) {
		this.nodes = nodes;
	}
	
	@SuppressWarnings("unchecked")
	public NodeListImplementation(NodeList... lists) {
		nodes = new ArrayList();
		for (int i = 0; i < lists.length; i++) {
			NodeList list = lists[i];
			for (int j = 0; j < list.getLength(); j++) {
				nodes.add(list.item(j));
			}
		}
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
