package org.w3c.dom.svg.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventException;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.events.EventTarget;

public class EventTargetImplementation implements EventTarget {

	private HashMap<String, List<EventListener>> listeners = new HashMap<>();
	
	@Override
	public void addEventListener(String type, EventListener listener, boolean useCapture) {
		if (!listeners.containsKey(type)) {
			listeners.put(type, new ArrayList<>());
		}
		listeners.get(type).add(listener);
	}

	@Override
	public boolean dispatchEvent(Event evt) throws EventException {
		if (!listeners.containsKey(evt.getType())) {
			return true;
		}
		List<EventListener> pool = listeners.get(evt.getType());
		for (int i = 0; i < pool.size(); i++) {
			pool.get(i).handleEvent(evt);
		}
		return false;
	}

	@Override
	public void removeEventListener(String type, EventListener listener, boolean useCapture) {
		if (!listeners.containsKey(type)) {
			return;
		}
		List<EventListener> pool = listeners.get(type);
		for (int i = pool.size() - 1; i >= 0; i--) {
			if (!pool.get(i).equals(listener)) {
				pool.remove(i);
				return;
			}
		}
	}

}
