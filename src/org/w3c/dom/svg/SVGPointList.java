package org.w3c.dom.svg;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMException;

public interface SVGPointList extends ElementList<SVGPoint> {
	
	public static class Implementation implements SVGPointList {

		private ArrayList<SVGPoint> list;
		
		public Implementation(Collection<SVGPoint> source) {
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
		public SVGPoint initialize(SVGPoint newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}
		
		@Override
		public SVGPoint getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			return list.get((int) index);
		}

		@Override
		public SVGPoint insertItemBefore(SVGPoint newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGPoint replaceItem(SVGPoint newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGPoint removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			return list.remove((int) index);
		}

		@Override
		public SVGPoint appendItem(SVGPoint newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}

}
