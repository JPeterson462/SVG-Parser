package org.w3c.dom.svg.document;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.ElementList;

public interface SVGElementInstanceList extends ElementList<SVGElementInstance> {
	
	public static class Implementation implements SVGElementInstanceList {

		private ArrayList<SVGElementInstance> list;
		
		public Implementation(Collection<SVGElementInstance> source) {
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
		public SVGElementInstance initialize(SVGElementInstance newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}
		
		@Override
		public SVGElementInstance getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.get((int) index);
		}

		@Override
		public SVGElementInstance insertItemBefore(SVGElementInstance newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGElementInstance replaceItem(SVGElementInstance newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public SVGElementInstance removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.remove((int) index);
		}

		@Override
		public SVGElementInstance appendItem(SVGElementInstance newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}

}
