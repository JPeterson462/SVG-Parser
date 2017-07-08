package org.w3c.dom.svg;

import org.w3c.dom.events.EventTarget;
import org.w3c.dom.events.UIEvent;
import org.w3c.dom.svg.impl.UIEventImplementation;
import org.w3c.dom.views.AbstractView;

public interface SVGZoomEvent extends UIEvent {
	
	public SVGRect getZoomRectScreen();
	
	public float getPreviousScale();
	
	public SVGPoint getPreviousTranslate();
	
	public float getNewScale();
	
	public SVGPoint getNewTranslate();
	
	public static class Implementation extends UIEventImplementation implements SVGZoomEvent {

		private SVGRect zoomRectScreen;
		
		private float previousScale;
		
		private SVGPoint previousTranslate;
		
		private float newScale;
		
		private SVGPoint newTranslate;
		
		public Implementation(String type, EventTarget target, EventTarget currentTarget, short eventPhase,
				boolean bubbles, boolean cancelable, long timeStamp,
				SVGRect zoomRectScreen, float previousScale, SVGPoint previousTranslate,
				float newScale, SVGPoint newTranslate,
				int detail, AbstractView view) {
			super(type, target, currentTarget, eventPhase, bubbles, cancelable, timeStamp, detail, view);
			this.zoomRectScreen = zoomRectScreen;
			this.previousScale = previousScale;
			this.previousTranslate = previousTranslate;
			this.newScale = newScale;
			this.newTranslate = newTranslate;
		}

		@Override
		public SVGRect getZoomRectScreen() {
			return zoomRectScreen;
		}

		@Override
		public float getPreviousScale() {
			return previousScale;
		}

		@Override
		public SVGPoint getPreviousTranslate() {
			return previousTranslate;
		}

		@Override
		public float getNewScale() {
			return newScale;
		}

		@Override
		public SVGPoint getNewTranslate() {
			return newTranslate;
		}

	}

}
