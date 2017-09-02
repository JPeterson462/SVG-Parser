package org.w3c.dom.svg.document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public interface SVGState {

	public long suspendRedraw(long maxWaitMilliseconds);
	
	public void unsuspendRedraw(long suspendHandleID);
	
	public void unsuspendRedrawAll();
	
	public void pauseAnimations();
	
	public void unpauseAnimations();
	
	public boolean animationsPaused();
	
	public float getCurrentTime();
	
	public void setCurrentTime(float seconds);
	
	public void update(float delta);
	
	public boolean canRedraw();
	
	public void forceRedraw();

	public static class Implementation implements SVGState {

		private boolean animationsPaused = false;
		
		private float time = 0;
		
		private HashMap<Long, Suspension> suspensions = new HashMap<>();
		
		private class Suspension {
			long endNanoTime;
		}
		
		@Override
		public long suspendRedraw(long maxWaitMilliseconds) {
			maxWaitMilliseconds = Math.min(maxWaitMilliseconds, 60_000);
			long handle = System.nanoTime();
			Suspension suspension = new Suspension();
			suspension.endNanoTime = handle + maxWaitMilliseconds * 1_000_000;
			suspensions.put(handle, suspension);
			return handle;
		}

		@Override
		public void unsuspendRedraw(long suspendHandleID) {
			suspensions.remove(suspendHandleID);
		}

		@Override
		public void unsuspendRedrawAll() {
			suspensions.clear();
		}

		@Override
		public void pauseAnimations() {
			animationsPaused = true;
		}

		@Override
		public void unpauseAnimations() {
			animationsPaused = false;
		}

		@Override
		public boolean animationsPaused() {
			return animationsPaused;
		}

		@Override
		public float getCurrentTime() {
			return time;
		}

		@Override
		public void setCurrentTime(float seconds) {
			time = seconds;
		}

		@Override
		public void update(float delta) {
			time += delta;
		}

		@Override
		public boolean canRedraw() {
			synchronized (suspensions) {
				ArrayList<Long> entriesToRemove = new ArrayList<>();
				for (Map.Entry<Long, Suspension> suspensionEntry : suspensions.entrySet()) {
					if (System.nanoTime() >= suspensionEntry.getValue().endNanoTime) {
						entriesToRemove.add(suspensionEntry.getKey());
					}
				}
				for (int i = 0; i < entriesToRemove.size(); i++) {
					suspensions.remove(entriesToRemove.get(i));
				}
			}
			return suspensions.size() == 0;
		}

		@Override
		public void forceRedraw() {
			suspensions.clear();
		}
		
	}
	
}
