package org.w3c.dom.svg.document;

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
	
	public static class Implementation extends EventTargetImplementation implements SVGElementInstance {

		private SVGElement correspondingElement;
		
		private SVGUseElement correspondingUseElement;
		
		private SVGElementInstance parentNode, firstChild, lastChild, previousSibling, nextSibling;
		
		private SVGElementInstanceList childNodes;
		
		public Implementation(SVGElement correspondingElement, SVGUseElement correspondingUseElement,
				SVGElementInstance parentNode, SVGElementInstanceList childNodes,
				SVGElementInstance firstChild, SVGElementInstance lastChild,
				SVGElementInstance previousSibling, SVGElementInstance nextSibling) {
			this.correspondingElement = correspondingElement;
			this.correspondingUseElement = correspondingUseElement;
			this.parentNode = parentNode;
			this.childNodes = childNodes;
			this.firstChild = firstChild;
			this.lastChild = lastChild;
			this.previousSibling = previousSibling;
			this.nextSibling = nextSibling;
		}
		
		public void connect(SVGUseElement useElement) {
			correspondingUseElement = useElement;
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
		
	}
	
}
