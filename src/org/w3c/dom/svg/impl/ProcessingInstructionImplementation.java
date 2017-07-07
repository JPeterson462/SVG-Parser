package org.w3c.dom.svg.impl;

import org.w3c.dom.DOMException;
import org.w3c.dom.ProcessingInstruction;

public class ProcessingInstructionImplementation extends NodeImplementation implements ProcessingInstruction {

	private String target, data;
	
	public ProcessingInstructionImplementation(String nodeName, String target, String data) {
		super(nodeName);
		this.target = target;
		this.data = data;
	}

	@Override
	public String getData() {
		return data;
	}

	@Override
	public String getTarget() {
		return target;
	}

	@Override
	public void setData(String data) throws DOMException {
		this.data = data;
	}

}
