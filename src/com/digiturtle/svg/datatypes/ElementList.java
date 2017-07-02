package com.digiturtle.svg.datatypes;

import java.util.ArrayList;

public class ElementList<T> {
	
	private ArrayList<T> list = new ArrayList<>();
	
	public int getNumberOfItems() {
		return list.size();
	}
	
	public void clear() {
		list.clear();
	}
	
	public T initialize(T newItem) {
		list.clear();
		list.add(newItem);
		return newItem;
	}
	
	public T getItem(int index) {
		return list.get(index);
	}
	
	public T insertItemBefore(T newItem, int index) {
		list.add(index, newItem);
		return newItem;
	}
	
	public T replaceItem(T newItem, int index) {
		list.set(index, newItem);
		return newItem;
	}
	
	public T remoteItem(int index) {
		return list.remove(index);
	}
	
	public T appendItem(T newItem) {
		list.add(newItem);
		return newItem;
	}

}
