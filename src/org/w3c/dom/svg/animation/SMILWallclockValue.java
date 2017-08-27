package org.w3c.dom.svg.animation;

public interface SMILWallclockValue {

	public int getYear();
	
	public int getMonth();
	
	public int getDay();
	
	public int getHour();
	
	public int getMinutes();
	
	public float getSeconds();
	
	public int getTimezoneSign();
	
	public int getTimezoneHours();
	
	public int getTimezoneMinutes();
	
	public void setValue(String value);
	
	public String getValue();
	
	public static class Implementation implements SMILWallclockValue {

		private int year, month, day, hour, minutes;
		
		private float seconds;
		
		private int timezoneSign, timezoneHours, timezoneMinutes;
		
		private String value;
		
		@Override
		public int getYear() {
			return year;
		}

		@Override
		public int getMonth() {
			return month;
		}

		@Override
		public int getDay() {
			return day;
		}

		@Override
		public int getHour() {
			return hour;
		}

		@Override
		public int getMinutes() {
			return minutes;
		}

		@Override
		public float getSeconds() {
			return seconds;
		}

		@Override
		public int getTimezoneSign() {
			return timezoneSign;
		}

		@Override
		public int getTimezoneHours() {
			return timezoneHours;
		}

		@Override
		public int getTimezoneMinutes() {
			return timezoneMinutes;
		}

		@Override
		public void setValue(String value) {
			value = value.trim();
			this.value = value;
			year = 0;
			month = 0;
			day = 0;
			hour = 0;
			minutes = 0;
			seconds = 0;
			timezoneHours = 0;
			timezoneMinutes = 0;
			timezoneSign = 0;
			if (value.contains("T")) {
				// DateTime
				String[] values = value.split("T");
				parseDate(values[0]);
				parseWallTime(values[1]);
			}
			else if (value.contains(":")) {
				// WallTime
				parseWallTime(value);
			}
			else {
				// Date
				parseDate(value);
			}
		}
		
		private void parseDate(String value) {
			String[] date = value.split("-");
			month = Integer.parseInt(date[1]);
			day = Integer.parseInt(date[2]);
			year = Integer.parseInt(date[0]);
		}
		
		private void parseWallTime(String value) {
			String[] timezoneSplit = value.split("Z");
			String[] timeValue = timezoneSplit[0].split(":");
			if (timezoneSplit.length > 1) {
				timezoneSign = timezoneSplit[0].startsWith("+") ? 1 : -1;
				String[] timezoneValue = timezoneSplit[0].substring(1).split(":");
				timezoneHours = Integer.parseInt(timezoneValue[0]);
				timezoneMinutes = Integer.parseInt(timezoneValue[1]);
			}
			hour = Integer.parseInt(timeValue[0]);
			minutes = Integer.parseInt(timeValue[1]);
			seconds = timeValue.length > 2 ? Float.parseFloat(timeValue[2]) : 0;
		}

		@Override
		public String getValue() {
			return value;
		}
		
	}
	
}
