package org.w3c.dom.svg.paths;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMException;
import org.w3c.dom.svg.ElementList;

public interface SVGPathSegList extends ElementList<SVGPathSeg> {
	
	public static class Implementation implements SVGPathSegList {

		private ArrayList<SVGPathSeg> list;
		
		public Implementation(Collection<SVGPathSeg> source) {
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
		public SVGPathSeg initialize(SVGPathSeg newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}
		
		@Override
		public SVGPathSeg getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			return list.get((int) index);
		}

		@Override
		public SVGPathSeg insertItemBefore(SVGPathSeg newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGPathSeg replaceItem(SVGPathSeg newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGPathSeg removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			return list.remove((int) index);
		}

		@Override
		public SVGPathSeg appendItem(SVGPathSeg newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}

}