package org.w3c.dom.svg;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;

public interface SVGUnicodeRangeList extends ElementList<SVGUnicodeRange> {
	
	public static class Implementation implements SVGUnicodeRangeList {

		private ArrayList<SVGUnicodeRange> list;
		
		public Implementation(Collection<SVGUnicodeRange> source) {
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
		public SVGUnicodeRange initialize(SVGUnicodeRange newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}
		
		@Override
		public SVGUnicodeRange getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.get((int) index);
		}

		@Override
		public SVGUnicodeRange insertItemBefore(SVGUnicodeRange newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGUnicodeRange replaceItem(SVGUnicodeRange newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGUnicodeRange removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.remove((int) index);
		}

		@Override
		public SVGUnicodeRange appendItem(SVGUnicodeRange newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}

}