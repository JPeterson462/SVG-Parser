package com.digiturtle.svg.datatypes;

import org.w3c.dom.DOMException;

public interface ElementList<T> {
	
	public long getNumberOfItems();
	
	public void clear() throws DOMException;
	
	public T initialize(T newItem) throws DOMException;
	
	public T getItem(long index) throws DOMException;

	public T insertItemBefore(T newItem, long index) throws DOMException;

	public T replaceItem(T newItem, long index) throws DOMException;

	public T removeItem(long index) throws DOMException;

	public T appendItem(T newItem) throws DOMException;

}
