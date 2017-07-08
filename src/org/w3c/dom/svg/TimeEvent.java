package org.w3c.dom.svg;

import org.w3c.dom.events.Event;
import org.w3c.dom.events.EventTarget;
import org.w3c.dom.svg.impl.EventImplementation;
import org.w3c.dom.views.AbstractView;

public interface TimeEvent extends Event {

	public long getDetail();
	
	public AbstractView getView();
	
	public void initTimeEvent(String typeArg, AbstractView viewArg, long detailArg);
	
	public static class Implementation extends EventImplementation implements TimeEvent {

		private long detail;
		
		private AbstractView view;
		
		public Implementation(String type, EventTarget target, EventTarget currentTarget, short eventPhase,
				boolean bubbles, boolean cancelable, long timeStamp, long detail, AbstractView view) {
			super(type, target, currentTarget, eventPhase, bubbles, cancelable, timeStamp);
			this.detail = detail;
			this.view = view;
		}

		@Override
		public long getDetail() {
			return detail;
		}

		@Override
		public AbstractView getView() {
			return view;
		}

		@Override
		public void initTimeEvent(String typeArg, AbstractView viewArg, long detailArg) {
			this.type = typeArg;
			this.detail = detailArg;
			this.view = viewArg;
		}
		
	}
	
}
