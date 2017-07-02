package com.digiturtle.svg.datatypes;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMException;

public interface SVGStringList extends ElementList<String> {
	
	public static class Implementation implements SVGStringList {

		private ArrayList<String> list;
		
		public Implementation(Collection<String> source) {
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
		public String initialize(String newItem) throws DOMException {
			list.clear();
			list.add(newItem);
			return newItem;
		}
		
		@Override
		public String getItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			return list.get((int) index);
		}

		@Override
		public String insertItemBefore(String newItem, long index) throws DOMException {
			list.add((int) index, newItem);
			return newItem;
		}

		@Override
		public String replaceItem(String newItem, long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public String removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				throw new DOMException(DOMException.INDEX_SIZE_ERR, "Index >= Size");
			}
			return list.remove((int) index);
		}

		@Override
		public String appendItem(String newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}
		
	}

}
