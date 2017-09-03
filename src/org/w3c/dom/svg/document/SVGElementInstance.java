package org.w3c.dom.svg.document;

import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.impl.EventTargetImplementation;

public interface SVGElementInstance extends EventTarget {

	public SVGElement getCorrespondingElement();
	
	public SVGUseElement getCorrespondingUseElement();
	
	public SVGElementInstance getParentNode();
	
	public SVGElementInstanceList getChildNodes();

	public SVGElementInstance getFirstChild();

	public SVGElementInstance getLastChild();

	public SVGElementInstance getPreviousSibling();

	public SVGElementInstance getNextSibling();
	
	public void connect(SVGUseElement useElement);
	
	public static class Implementation extends EventTargetImplementation implements SVGElementInstance {

		private SVGElement correspondingElement;
		
		private SVGUseElement correspondingUseElement;
		
		private SVGElementInstance parentNode, firstChild, lastChild, previousSibling, nextSibling;
		
		private SVGElementInstanceList childNodes;
		
		public Implementation(SVGElement correspondingElement, SVGUseElement correspondingUseElement) {
			this.correspondingElement = correspondingElement;
			this.correspondingUseElement = correspondingUseElement;
		}
		
		@Override
		public SVGElement getCorrespondingElement() {
			return correspondingElement;
		}

		@Override
		public SVGUseElement getCorrespondingUseElement() {
			return correspondingUseElement;
		}

		@Override
		public SVGElementInstance getParentNode() {
			return parentNode;
		}

		@Override
		public SVGElementInstanceList getChildNodes() {
			return childNodes;
		}

		@Override
		public SVGElementInstance getFirstChild() {
			return firstChild;
		}

		@Override
		public SVGElementInstance getLastChild() {
			return lastChild;
		}

		@Override
		public SVGElementInstance getPreviousSibling() {
			return previousSibling;
		}

		@Override
		public SVGElementInstance getNextSibling() {
			return nextSibling;
		}

		@Override
		public void connect(SVGUseElement useElement) {
			correspondingUseElement = useElement;
			if (correspondingElement.getParentNode() != null) {
				parentNode = ((SVGElement) correspondingElement.getParentNode()).createInstance();		
			}
			if (correspondingElement.getFirstChild() != null) {
				firstChild = ((SVGElement) correspondingElement.getFirstChild()).createInstance();
			}
			if (correspondingElement.getLastChild() != null) {
				lastChild = ((SVGElement) correspondingElement.getLastChild()).createInstance();
			}
			if (correspondingElement.getPreviousSibling() != null) {
				previousSibling = ((SVGElement) correspondingElement.getPreviousSibling()).createInstance();
			}
			if (correspondingElement.getNextSibling() != null) {
				nextSibling = ((SVGElement) correspondingElement.getNextSibling()).createInstance();
			}
			ArrayList<SVGElementInstance> children = new ArrayList<>();
			NodeList childNodes = correspondingElement.getChildNodes();
			for (int i = 0; childNodes != null && i < childNodes.getLength(); i++) {
				Node child = childNodes.item(i);
				if (child instanceof SVGElement) {
					children.add(((SVGElement) child).createInstance());
				}
			}
//			if (parentNode != null) {
//				parentNode.connect(correspondingUseElement);
//			}
			if (firstChild != null) {
				firstChild.connect(correspondingUseElement);
			}
			if (lastChild != null) {
				lastChild.connect(correspondingUseElement);
			}
//			if (previousSibling != null) {
//				previousSibling.connect(correspondingUseElement);
//			}
			if (nextSibling != null) {
				nextSibling.connect(correspondingUseElement);
			}
			for (int i = 0; i < children.size(); i++) {
				children.get(i).connect(correspondingUseElement);
			}
			this.childNodes = new SVGElementInstanceList.Implementation(children);
		}
		
	}
	
}
