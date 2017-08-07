package org.w3c.dom.svg;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.DOMErrors;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMStringList;

public interface SVGStringList extends ElementList<String>, DOMStringList {
	
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
				DOMErrors.indexTooHigh();
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
				DOMErrors.indexTooHigh();
			}
			list.set((int) index, newItem);
			return newItem;
		}

		@Override
		public String removeItem(long index) throws DOMException {
			if (index >= getNumberOfItems()) {
				DOMErrors.indexTooHigh();
			}
			return list.remove((int) index);
		}

		@Override
		public String appendItem(String newItem) throws DOMException {
			list.add(newItem);
			return newItem;
		}

		@Override
		public boolean contains(String str) {
			return list.contains(str);
		}

		@Override
		public int getLength() {
			return list.size();
		}

		@Override
		public String item(int index) {
			return list.get(index);
		}
		
	}

}
