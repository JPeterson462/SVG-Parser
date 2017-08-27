package org.w3c.dom.svg.animation;

import java.util.ArrayList;

public interface SMILTimingValueList {

	public long getNumberOfItems();
	
	public SMILTimingValue getItem(long index);
	
	public static class Implementation implements SMILTimingValueList {

		private ArrayList<SMILTimingValue> list;
		
		public Implementation(ArrayList<SMILTimingValue> list) {
			this.list = list;
		}
		
		@Override
		public long getNumberOfItems() {
			return list.size();
		}

		@Override
		public SMILTimingValue getItem(long index) {
			return list.get((int) index);
		}

	}
	
}
