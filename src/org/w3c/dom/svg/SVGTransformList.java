package org.w3c.dom.svg;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;

public interface SVGTransformList extends ElementList<SVGTransform> {
	
	public static class Implementation implements SVGTransformList {

		private ArrayList<SVGTransform> list;
		
		public Implementation(Collection<SVGTransform> source) {
			list = new ArrayList<>(source);
		}
		
		@Override
		public long getNumberOfItems() {
			return list.size();
		}

		@Override
		public void clear() throws DOMException {
			list.clear();
		}

		@Override
		public SVGTransform initialize(SVGTransform newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}
		
		@Override
		public SVGTransform getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.get((int) index);
		}

		@Override
		public SVGTransform insertItemBefore(SVGTransform newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGTransform replaceItem(SVGTransform newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGTransform removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.remove((int) index);
		}

		@Override
		public SVGTransform appendItem(SVGTransform newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}

}