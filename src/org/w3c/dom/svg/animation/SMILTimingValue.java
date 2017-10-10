package org.w3c.dom.svg.animation;

public interface SMILTimingValue {
	
	public static final short SMIL_TIMINGVALUE_INDEFINITE = 0;//default
	public static final short SMIL_TIMINGVALUE_OFFSETVALUE = 1;
	public static final short SMIL_TIMINGVALUE_SYNCBASEVALUE = 2;
	public static final short SMIL_TIMINGVALUE_EVENTVALUE = 3;
	public static final short SMIL_TIMINGVALUE_REPEATVALUE = 4;
	public static final short SMIL_TIMINGVALUE_ACCESSKEYVALUE = 5;
	public static final short SMIL_TIMINGVALUE_WALLCLOCKSYNC = 6;
	
	public short getType();
	
	public interface SMILTimingIndefiniteValue extends SMILTimingValue {
		
		public static class Implementation extends SMILTimingValue.Implementation implements SMILTimingIndefiniteValue {

			public Implementation() {
				super(SMIL_TIMINGVALUE_INDEFINITE);
			}
			
		}
		
	}
	
	public interface SMILTimingOffsetValue extends SMILTimingValue {
		
		public int getSign();
		
		public SMILClockValue getClockValue();
		
		public static class Implementation extends SMILTimingValue.Implementation implements SMILTimingOffsetValue {
			
			private int sign;
			
			private SMILClockValue clockValue;
			
			public Implementation(int sign, SMILClockValue clockValue) {
				super(SMIL_TIMINGVALUE_OFFSETVALUE);
				this.sign = sign;
				this.clockValue = clockValue;
			}

			@Override
			public int getSign() {
				return sign;
			}

			@Override
			public SMILClockValue getClockValue() {
				return clockValue;
			}
			
		}
		
	}
	
	public interface SMILTimingSyncbaseValue extends SMILTimingValue {
		
		public String getIDValue();
		
		public String getSuffix();
		
		public int getSign();
		
		public SMILClockValue getClockValue();
		
		public static class Implementation extends SMILTimingValue.Implementation implements SMILTimingSyncbaseValue {

			private String idValue, suffix;
			
			private int sign;
			
			private SMILClockValue clockValue;
			
			public Implementation(String idValue, String suffix, int sign, SMILClockValue clockValue) {
				super(SMIL_TIMINGVALUE_SYNCBASEVALUE);
				this.idValue = idValue;
				this.suffix = suffix;
				this.sign = sign;
				this.clockValue = clockValue;
				
			}
			
			@Override
			public String getIDValue() {
				return idValue;
			}

			@Override
			public String getSuffix() {
				return suffix;
			}

			@Override
			public int getSign() {
				return sign;
			}

			@Override
			public SMILClockValue getClockValue() {
				return clockValue;
			}
			
		}
		
	}
	
	public interface SMILTimingEventValue extends SMILTimingValue {
		
		public String getIDValue();
		
		public String getEventRef();
		
		public int getSign();
		
		public SMILClockValue getClockValue();
		
		public static class Implementation extends SMILTimingValue.Implementation implements SMILTimingEventValue {

			private String idValue, eventRef;
			
			private int sign;
			
			private SMILClockValue clockValue;
			
			public Implementation(String idValue, String eventRef, int sign, SMILClockValue clockValue) {
				super(SMIL_TIMINGVALUE_EVENTVALUE);
				this.idValue = idValue;
				this.eventRef = eventRef;
				this.sign = sign;
				this.clockValue = clockValue;
				
			}
			
			@Override
			public String getIDValue() {
				return idValue;
			}

			@Override
			public String getEventRef() {
				return eventRef;
			}

			@Override
			public int getSign() {
				return sign;
			}

			@Override
			public SMILClockValue getClockValue() {
				return clockValue;
			}
			
		}
		
	}
	
	public interface SMILTimingRepeatValue extends SMILTimingValue {
		
		public String getIDValue();
		
		public int getRepeatCount();
		
		public int getSign();
		
		public SMILClockValue getClockValue();
		
		public static class Implementation extends SMILTimingValue.Implementation implements SMILTimingRepeatValue {

			private String idValue;
			
			private int repeatCount, sign;
			
			private SMILClockValue clockValue;
			
			public Implementation(String idValue, int repeatCount, int sign, SMILClockValue clockValue) {
				super(SMIL_TIMINGVALUE_REPEATVALUE);
				this.idValue = idValue;
				this.repeatCount = repeatCount;
				this.sign = sign;
				this.clockValue = clockValue;
			}
			
			@Override
			public String getIDValue() {
				return idValue;
			}

			@Override
			public int getRepeatCount() {
				return repeatCount;
			}

			@Override
			public int getSign() {
				return sign;
			}

			@Override
			public SMILClockValue getClockValue() {
				return clockValue;
			}
			
		}
		
	}
	
	public interface SMILTimingAccessKeyValue extends SMILTimingValue {
		
		public char getAccessKey();
		
		public int getSign();
		
		public SMILClockValue getClockValue();
		
		public static class Implementation extends SMILTimingValue.Implementation implements SMILTimingAccessKeyValue {

			private char accessKey;
			
			private int sign;
			
			private SMILClockValue clockValue;
			
			public Implementation(char accessKey, int sign, SMILClockValue clockValue) {
				super(SMIL_TIMINGVALUE_ACCESSKEYVALUE);
				this.accessKey = accessKey;
				this.sign = sign;
				this.clockValue = clockValue;
				
			}
			
			@Override
			public char getAccessKey() {
				return accessKey;
			}

			@Override
			public int getSign() {
				return sign;
			}

			@Override
			public SMILClockValue getClockValue() {
				return clockValue;
			}
			
		}
		
	}
	
	public interface SMILTimingWallclockSyncValue extends SMILTimingValue {
		
		public SMILWallclockValue getWallclockValue();
		
		public static class Implementation extends SMILTimingValue.Implementation implements SMILTimingWallclockSyncValue {

			private SMILWallclockValue wallclockValue;
			
			public Implementation(SMILWallclockValue wallclockValue) {
				super(SMIL_TIMINGVALUE_WALLCLOCKSYNC);
				this.wallclockValue = wallclockValue;
			}

			@Override
			public SMILWallclockValue getWallclockValue() {
				return wallclockValue;
			}
			
		}
		
	}
	
	public static class Implementation implements SMILTimingValue {

		private short type;
		
		public Implementation(short type) {
			this.type = type;
		}
		
		@Override
		public short getType() {
			return type;
		}
		
	}
	
	public static int determineSign(String signedClockValue) {
		if (signedClockValue.startsWith("+")) {
			return 1;
		}
		if (signedClockValue.startsWith("-")) {
			return -1;
		}
		return 1;
	}
	
	public static SMILTimingValue createTimingValue(String text) {
		if (text.equals("indefinite")) {
			return new SMILTimingIndefiniteValue.Implementation();
		}
		if (text.startsWith("wallclock")) {
			SMILWallclockValue wallclock = new SMILWallclockValue.Implementation();
			wallclock.setValue(text.substring("wallclock".length() + 1, text.length() - 1));
			return new SMILTimingWallclockSyncValue.Implementation(wallclock);
		}
		if (text.startsWith("accessKey")) {
			char accessKey = text.charAt("accessKey".length() + 1);
			String signedClockValue = text.substring("accessKey".length() + 3).trim();
			int sign = 0;
			SMILClockValue clockValue = new SMILClockValue.Implementation((short) 0);
			if (signedClockValue.length() > 0) {
				sign = determineSign(signedClockValue);
				clockValue.setValue(signedClockValue.startsWith("+") || signedClockValue.startsWith("-") ? signedClockValue.substring(1) : signedClockValue);
			}
			return new SMILTimingAccessKeyValue.Implementation(accessKey, sign, clockValue);
		}
		if (text.contains("repeat")) {
			String rawIdValue = text.substring(0, text.indexOf("repeat"));
			String idValue = null;
			if (rawIdValue.length() > 0) {
				idValue = rawIdValue.substring(0, rawIdValue.length() - 1);
			}
			String restOfString = text.substring(text.indexOf("repeat") + "repeat(".length());
			String repeatCountStr = restOfString.substring(0, restOfString.indexOf(')'));
			int repeatCount = Integer.parseInt(repeatCountStr);
			String signedClockValue = restOfString.substring(repeatCountStr.length() + 1);
			int sign = 0;
			SMILClockValue clockValue = new SMILClockValue.Implementation((short) 0);
			if (signedClockValue.length() > 0) {
				sign = determineSign(signedClockValue);
				clockValue.setValue(signedClockValue.startsWith("+") || signedClockValue.startsWith("-") ? signedClockValue.substring(1) : signedClockValue);
			}
			return new SMILTimingRepeatValue.Implementation(idValue, repeatCount, sign, clockValue);
		}
		int plusMinus = text.indexOf('+') > -1 ? text.indexOf('+') : text.indexOf('-');
		if (text.contains("begin") || text.contains("end")) {
			String rawIdValue = text.substring(0, Math.max(text.indexOf("."), 0));
			String idValue = null;
			if (rawIdValue.length() > 0) {
				idValue = rawIdValue.substring(0, rawIdValue.length());
			}
			String suffix = text.substring(rawIdValue.length() + 1, plusMinus >= 0 ? plusMinus : text.length());
			String signedClockValue = plusMinus >= 0 ? text.substring(plusMinus) : "";
			int sign = 0;
			SMILClockValue clockValue = new SMILClockValue.Implementation((short) 0);
			if (signedClockValue.length() > 0) {
				sign = determineSign(signedClockValue);
				clockValue.setValue(signedClockValue.startsWith("+") || signedClockValue.startsWith("-") ? signedClockValue.substring(1) : signedClockValue);
			}
			return new SMILTimingSyncbaseValue.Implementation(idValue, suffix, sign, clockValue);
		}
		if ((plusMinus < 0 || text.indexOf('.') < plusMinus) && containsLetters(text)) {
			String rawIdValue = text.indexOf('.') >= 0 ? text.substring(0, text.indexOf(".")) : "";
			String idValue = null;
			if (rawIdValue.length() > 0) {
				idValue = rawIdValue;
			}
			String eventRef = text.substring(rawIdValue.length() > 0 ? rawIdValue.length() + 1 : 0, plusMinus > 0 ? plusMinus : text.length());
			int sign = 0;
			SMILClockValue clockValue = null;
			if (plusMinus > 0) {
				String signedClockValue = text.substring(plusMinus);
				sign = 0;
				clockValue = new SMILClockValue.Implementation((short) 0);
				if (signedClockValue.length() > 0) {
					sign = determineSign(signedClockValue);
					clockValue.setValue(signedClockValue.startsWith("+") || signedClockValue.startsWith("-") ? signedClockValue.substring(1) : signedClockValue);
				}
			}
			return new SMILTimingEventValue.Implementation(idValue, eventRef, sign, clockValue);
		}
		int sign = 0;
		SMILClockValue clockValue = new SMILClockValue.Implementation((short) 0);
		if (text.length() > 0) {
			sign = determineSign(text);
			clockValue.setValue(text.startsWith("+") || text.startsWith("-") ? text.substring(1) : text);
		}
		return new SMILTimingOffsetValue.Implementation(sign, clockValue);
	}
	
	public static boolean containsLetters(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (Character.isAlphabetic(text.charAt(i)) && text.charAt(i) != 's') {
				return true;
			}
		}
		return false;
	}
	
	public static String convertTimingValue(SMILTimingValue timingValue) {
		if (timingValue instanceof SMILTimingIndefiniteValue) {
			return "indefinite";
		}
		if (timingValue instanceof SMILTimingWallclockSyncValue) {
			return ((SMILTimingWallclockSyncValue) timingValue).getWallclockValue().getValue();
		}
		if (timingValue instanceof SMILTimingAccessKeyValue) {
			SMILTimingAccessKeyValue accessKeyValue = (SMILTimingAccessKeyValue) timingValue;
			String sign = accessKeyValue.getSign() > 0 ? "+" : "-";
			return "accessKey(" + accessKeyValue.getAccessKey() + ")" + (accessKeyValue.getSign() != 0 ? sign + accessKeyValue.getClockValue().getValue() : "");
		}
		if (timingValue instanceof SMILTimingRepeatValue) {
			SMILTimingRepeatValue repeatValue = (SMILTimingRepeatValue) timingValue;
			String idValueStr = repeatValue.getIDValue() != null ? repeatValue.getIDValue() + "." : "";
			String sign = repeatValue.getSign() > 0 ? "+" : "-";
			return idValueStr + "repeat(" + repeatValue.getRepeatCount() + ")" + (repeatValue.getSign() != 0 ? sign + repeatValue.getClockValue().getValue() : "");
		}
		if (timingValue instanceof SMILTimingEventValue) {
			SMILTimingEventValue eventValue = (SMILTimingEventValue) timingValue;
			String idValueStr = eventValue.getIDValue() != null ? eventValue.getIDValue() + "." : "";
			String sign = eventValue.getSign() > 0 ? "+" : "-";
			return idValueStr + eventValue.getEventRef() + (eventValue.getSign() != 0 ? sign + eventValue.getClockValue().getValue() : "");
		}
		if (timingValue instanceof SMILTimingSyncbaseValue) {
			SMILTimingSyncbaseValue syncbaseValue = (SMILTimingSyncbaseValue) timingValue;
			String sign = syncbaseValue.getSign() > 0 ? "+" : "-";
			return syncbaseValue.getIDValue() + "." + syncbaseValue.getSuffix() + (syncbaseValue.getSign() != 0 ? sign + syncbaseValue.getClockValue().getValue() : "");
		}
		if (timingValue instanceof SMILTimingOffsetValue) {
			SMILTimingOffsetValue offsetValue = (SMILTimingOffsetValue) timingValue;
			String sign = offsetValue.getSign() > 0 ? "+" : "-";
			return offsetValue.getSign() != 0 ? sign + offsetValue.getClockValue().getValue() : "";
		}
		return null;
	}
	
}
