package org.w3c.dom.svg;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMException;

public interface SVGNumberList extends ElementList<SVGNumber> {
	
	public static class Implementation implements SVGNumberList {

		private ArrayList<SVGNumber> list;
		
		public Implementation(Collection<SVGNumber> source) {
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
		public SVGNumber initialize(SVGNumber newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}
		
		@Override
		public SVGNumber getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			return list.get((int) index);
		}

		@Override
		public SVGNumber insertItemBefore(SVGNumber newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGNumber replaceItem(SVGNumber newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGNumber removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			return list.remove((int) index);
		}

		@Override
		public SVGNumber appendItem(SVGNumber newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}

}
