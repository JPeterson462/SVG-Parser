package org.w3c.dom.svg.impl;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.UIEvent;
import org.w3c.dom.views.AbstractView;

public class UIEventImplementation extends EventImplementation implements UIEvent {

	private int detail;
	
	private AbstractView view;
	
	public UIEventImplementation(String type, EventTarget target, EventTarget currentTarget,
			short eventPhase, boolean bubbles, boolean cancelable, long timeStamp, 
			int detail, AbstractView view) {
		super(type, target, currentTarget, eventPhase, bubbles, cancelable, timeStamp);
		this.detail = detail;
		this.view = view;
	}
	
	@Override
	public int getDetail() {
		return detail;
	}

	@Override
	public AbstractView getView() {
		return view;
	}

	@Override
	public void initUIEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, AbstractView viewArg,
			int detailArg) {
		this.type = typeArg;
		this.bubbles = canBubbleArg;
		this.cancelable = cancelableArg;
		this.view = viewArg;
		this.detail = detailArg;
	}

}
