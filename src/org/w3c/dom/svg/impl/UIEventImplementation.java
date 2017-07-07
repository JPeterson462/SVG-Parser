package org.w3c.dom.svg.impl;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.UIEvent;
import org.w3c.dom.views.AbstractView;

public class UIEventImplementation implements UIEvent {

	private String type;
	
	private EventTarget target, currentTarget;
	
	private short eventPhase;
	
	private boolean bubbles, cancelable;
	
	private long timeStamp;
	
	public UIEventImplementation(String type, EventTarget target, EventTarget currentTarget,
			short eventPhase, boolean bubbles, boolean cancelable, long timeStamp) {
		this.type = type;
		this.target = target;
		this.currentTarget = currentTarget;
		this.eventPhase = eventPhase;
		this.bubbles = bubbles;
		this.cancelable = cancelable;
		this.timeStamp = timeStamp;
	}
	
	@Override
	public boolean getBubbles() {
		return bubbles;
	}

	@Override
	public boolean getCancelable() {
		return cancelable;
	}

	@Override
	public EventTarget getCurrentTarget() {
		return currentTarget;
	}

	@Override
	public short getEventPhase() {
		return eventPhase;
	}

	@Override
	public EventTarget getTarget() {
		return target;
	}

	@Override
	public long getTimeStamp() {
		return timeStamp;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public void initEvent(String eventTypeArg, boolean canBubbleArg, boolean cancelableArg) {
		this.type = eventTypeArg;
		this.bubbles = canBubbleArg;
		this.cancelable = cancelableArg;
	}

	@Override
	public void preventDefault() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopPropagation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getDetail() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AbstractView getView() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void initUIEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, AbstractView viewArg,
			int detailArg) {
		// TODO Auto-generated method stub
		
	}

}
