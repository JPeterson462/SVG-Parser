package com.digiturtle.svg.datatypes;

import com.digiturtle.svg.SVGSettings;

public class Length {

	private static final float IN_TO_CM = 2.54f;
	
	private static final float CM_TO_IN = 1f / IN_TO_CM;
	
	private static final float CM_TO_MM = 10f;
	
	private static final float MM_TO_CM = 1f / CM_TO_MM;
	
	private static final float IN_TO_MM = IN_TO_CM * CM_TO_MM;
	
	private static final float MM_TO_IN = 1f / IN_TO_MM;
	
	private static final float PC_TO_PT = 12f;
	
	private static final float PT_TO_PC = 1f / PC_TO_PT;
	
	// IN_TO_PX = SVGSettings.PPI
	
	// PX_TO_IN = 1f / IN_TO_PT
	
	// EM_TO_PT = SVGSettings.FONT_SIZE
	
	// PT_TO_EM = 1f / EM_TO_PT
	
	// PX_TO_PT = SVGSettings.PIXELS_TO_PT
	
	// PT_TO_PX = 1f / PX_TO_PT
	
	// EX_TO_PT = SVGSettings.FONT_SIZE
	
	// PT_TO_EX = 1f / EX_TO_PT
	
	private float lengthEm, lengthEx, lengthPx, lengthIn, lengthCm, lengthMm, lengthPt, lengthPc, lengthPercent;

	public float getLengthEm() {
		return lengthEm;
	}

	public void setLengthEm(float lengthEm) {
		this.lengthEm = lengthEm;
		lengthEx = lengthEm * SVGSettings.FONT_SIZE * (1f / SVGSettings.FONT_SIZE); // lengthEm * EM_TO_PT * PT_TO_EX
		lengthPx = lengthEm * SVGSettings.FONT_SIZE * (1f / SVGSettings.PIXELS_TO_PT); // lengthEm * EM_TO_PT * PT_TO_PX
		lengthIn = lengthPx * (1f / SVGSettings.PPI); // lengthPx * PX_TO_IN
		lengthCm = lengthIn * IN_TO_CM;
		lengthMm = lengthCm * CM_TO_MM;
		lengthPt = lengthPx * SVGSettings.PIXELS_TO_PT;
		lengthPc = lengthPt * PT_TO_PC;
	}

	public float getLengthEx() {
		return lengthEx;
	}

	public void setLengthEx(float lengthEx) {
		lengthEm = lengthEx * SVGSettings.FONT_SIZE * (1f / SVGSettings.FONT_SIZE); // lengthEx * EX_TO_PT * PT_TO_EM
		this.lengthEx = lengthEx;
		lengthIn = lengthEx * SVGSettings.FONT_SIZE * (1f / SVGSettings.PIXELS_TO_PT) * (1f / SVGSettings.PPI); // lengthEx * EX_TO_PT * PT_TO_PX * PX_TO_IN
		lengthCm = lengthIn * IN_TO_CM;
		lengthMm = lengthCm * CM_TO_MM;
		lengthPt = lengthPx * SVGSettings.PIXELS_TO_PT;
		lengthPc = lengthPt * PT_TO_PC;
	}

	public float getLengthPx() {
		return lengthPx;
	}

	public void setLengthPx(float lengthPx) {
		lengthEm = lengthPx * SVGSettings.PIXELS_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthPx * PX_TO_PT * PT_TO_EM
		lengthEx = lengthPx * SVGSettings.PIXELS_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthPx * PX_TO_PT * PT_TO_EX
		this.lengthPx = lengthPx;
		lengthIn = lengthPx * (1f / SVGSettings.PPI); // lengthPx * PX_TO_IN
		lengthCm = lengthIn * IN_TO_CM;
		lengthMm = lengthCm * CM_TO_MM;
		lengthPt = lengthPx * SVGSettings.PIXELS_TO_PT;
		lengthPc = lengthPt * PT_TO_PC;
	}

	public float getLengthIn() {
		return lengthIn;
	}

	public void setLengthIn(float lengthIn) {
		lengthEm = lengthIn * SVGSettings.PPI * SVGSettings.PIXELS_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthIn * PPI * PX_TO_PT * PT_TO_EM
		lengthEx = lengthIn * SVGSettings.PPI * SVGSettings.PIXELS_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthIn * PPI * PX_TO_PT * PT_TO_EX
		lengthPx = lengthIn * SVGSettings.PPI;
		this.lengthIn = lengthIn;
		lengthCm = lengthIn * IN_TO_CM;
		lengthMm = lengthCm * CM_TO_MM;
		lengthPt = lengthPx * SVGSettings.PIXELS_TO_PT;
		lengthPc = lengthPt * PT_TO_PC;
	}

	public float getLengthCm() {
		return lengthCm;
	}

	public void setLengthCm(float lengthCm) {
		lengthEm = lengthCm * CM_TO_IN * SVGSettings.PPI * SVGSettings.PIXELS_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthCm * CM_TO_IN * PPI * PX_TO_PT * PT_TO_EM
		lengthEx = lengthCm * CM_TO_IN * SVGSettings.PPI * SVGSettings.PIXELS_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthCm * CM_TO_IN * PPI * PX_TO_PT * PT_TO_EX
		lengthPx = lengthCm * CM_TO_IN * SVGSettings.PPI;
		lengthIn = lengthCm * CM_TO_IN;
		this.lengthCm = lengthCm;
		lengthMm = lengthCm * CM_TO_MM;
		lengthPt = lengthPx * SVGSettings.PIXELS_TO_PT;
		lengthPc = lengthPt * PT_TO_PC;
	}

	public float getLengthMm() {
		return lengthMm;
	}

	public void setLengthMm(float lengthMm) {
		lengthEm = lengthMm * MM_TO_IN * SVGSettings.PPI * SVGSettings.PIXELS_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthCm * MM_TO_IN * PPI * PX_TO_PT * PT_TO_EM
		lengthEx = lengthMm * MM_TO_IN * SVGSettings.PPI * SVGSettings.PIXELS_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthCm * MM_TO_IN * PPI * PX_TO_PT * PT_TO_EX
		lengthPx = lengthMm * MM_TO_IN * SVGSettings.PPI;
		lengthIn = lengthMm * MM_TO_IN;
		lengthCm = lengthMm * MM_TO_CM;
		this.lengthMm = lengthMm;
		lengthPt = lengthPx * SVGSettings.PIXELS_TO_PT;
		lengthPc = lengthPt * PT_TO_PC;
	}

	public float getLengthPt() {
		return lengthPt;
	}

	public void setLengthPt(float lengthPt) {
		lengthEm = lengthPt * (1f / SVGSettings.FONT_SIZE); // lengthPt * PT_TO_EM
		lengthEx = lengthPt * (1f / SVGSettings.FONT_SIZE); // lengthPt * PT_TO_EX
		lengthPx = lengthPt * (1f / SVGSettings.PIXELS_TO_PT); // lengthPt * PT_TO_PX
		lengthIn = lengthPt * (1f / SVGSettings.PIXELS_TO_PT) * (1f / SVGSettings.PPI); // lengthPt * PT_TO_PX * PX_TO_IN
		lengthCm = lengthIn * IN_TO_CM;
		lengthMm = lengthIn * IN_TO_MM;
		this.lengthPt = lengthPt;
		lengthPc = lengthPt * PT_TO_PC;
	}

	public float getLengthPc() {
		return lengthPc;
	}

	public void setLengthPc(float lengthPc) {
		lengthEm = lengthPc * PC_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthPc * PC_TO_PT * PT_TO_EM
		lengthEx = lengthPc * PC_TO_PT * (1f / SVGSettings.FONT_SIZE); // lengthPc * PC_TO_PT * PT_TO_EX
		lengthPx = lengthPc * PC_TO_PT * (1f / SVGSettings.PIXELS_TO_PT); // lengthPc * PC_TO_PT * PT_TO_PX
		lengthIn = lengthPc * PC_TO_PT * (1f / SVGSettings.PIXELS_TO_PT) * (1f / SVGSettings.PPI); // lengthPc * PC_TO_PT * PT_TO_PX * PX_TO_IN
		lengthCm = lengthIn * IN_TO_CM;
		lengthMm = lengthIn * IN_TO_MM;
		lengthPt = lengthPc * (1f / SVGSettings.PIXELS_TO_PT);
		this.lengthPc = lengthPc;
	}

	public float getLengthPercent() {
		return lengthPercent;
	}

	public void setLengthPercent(float lengthPercent) {
		this.lengthPercent = lengthPercent;
	}

}
