package org.w3c.dom.svg;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMException;

public interface SVGLengthList extends ElementList<SVGLength> {
	
	public static class Implementation implements SVGLengthList {

		private ArrayList<SVGLength> list;
		
		public Implementation(Collection<SVGLength> source) {
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
		public SVGLength initialize(SVGLength newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}
		
		@Override
		public SVGLength getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.get((int) index);
		}

		@Override
		public SVGLength insertItemBefore(SVGLength newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGLength replaceItem(SVGLength newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGLength removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.remove((int) index);
		}

		@Override
		public SVGLength appendItem(SVGLength newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}

}
