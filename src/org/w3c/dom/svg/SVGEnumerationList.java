package org.w3c.dom.svg;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;

public interface SVGEnumerationList extends ElementList<Short> {

	public static class Implementation implements SVGEnumerationList {

		private ArrayList<Short> list;
		
		public Implementation(Collection<Short> source) {
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
		public Short initialize(Short newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}

		@Override
		public Short getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.get((int) index);
		}

		@Override
		public Short insertItemBefore(Short newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public Short replaceItem(Short newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public Short removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.remove((int) index);
		}

		@Override
		public Short appendItem(Short newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}
	
}
