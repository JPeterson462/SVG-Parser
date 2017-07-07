package org.w3c.dom.svg.impl;

import org.w3c.dom.DocumentType;
import org.w3c.dom.NamedNodeMap;

public class DocumentTypeImplementation extends NodeImplementation implements DocumentType {

	private NamedNodeMap entities;
	
	private String internalSubset, name;
	
	private NamedNodeMap notations;
	
	private String publicId, systemId;
	
	public DocumentTypeImplementation(String nodeName, NamedNodeMap entities, String internalSubset, String name, NamedNodeMap notations, String publicId, String systemId) {
		super(nodeName);
		this.entities = entities;
		this.internalSubset = internalSubset;
		this.name = name;
		this.notations = notations;
		this.publicId = publicId;
		this.systemId = systemId;
	}

	@Override
	public NamedNodeMap getEntities() {
		return entities;
	}

	@Override
	public String getInternalSubset() {
		return internalSubset;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public NamedNodeMap getNotations() {
		return notations;
	}

	@Override
	public String getPublicId() {
		return publicId;
	}

	@Override
	public String getSystemId() {
		return systemId;
	}

}
