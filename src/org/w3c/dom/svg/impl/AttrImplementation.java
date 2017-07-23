package org.w3c.dom.svg.impl;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.svg.DOMErrors;

public class AttrImplementation extends ElementImplementation implements Attr {

	private boolean specified = true;
	
	private Element owner;
	
	private String name, value;
	
	public AttrImplementation(Element owner, String name, String value) {
		super(name);
		this.owner = owner;
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public String getNodeName() {
		return name;
	}
	
	public short getNodeType() {
		return ATTRIBUTE_NODE;
	}
	
	public boolean getSpecified() {
		return specified;
	}
	
	public String getValue() {
		return value;
	}
	
	public String getNodeValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	public void setNodeValue(String value) {
		this.value = value;
	}
	
	public Element getOwnerElement() {
		return owner;
	}
	
	public void setOwnerElement(Element owner) {
		this.owner = owner;
	}
	
	@Override
	public short compareDocumentPosition(Node other) throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public String getBaseURI() {
		return DOMErrors.notSupported();
	}

	@Override
	public Object getFeature(String feature, String version) {
		return DOMErrors.notSupported();
		}

	@Override
	public String getTextContent() throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public Object getUserData(String key) {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean hasAttributes() {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean isEqualNode(Node arg) {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean isSameNode(Node other) {
		return DOMErrors.notSupported();
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		return DOMErrors.notSupported();
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		return DOMErrors.notSupported();
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		return DOMErrors.notSupported();
	}

	@Override
	public Attr getAttributeNode(String name) {
		return DOMErrors.notSupported();
	}

	@Override
	public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public NodeList getElementsByTagName(String name) {
		return DOMErrors.notSupported();
	}

	@Override
	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean hasAttribute(String name) {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public void removeAttribute(String name) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public Attr setAttributeNode(Attr newAttr) throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
		return DOMErrors.notSupported();
	}

	@Override
	public void setIdAttribute(String name, boolean isId) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
		DOMErrors.notSupported();
	}

	@Override
	public int getLength() {
		return DOMErrors.notSupported();
	}

	@Override
	public Node item(int index) {
		return DOMErrors.notSupported();
	}

	@Override
	public TypeInfo getSchemaTypeInfo() {
		return DOMErrors.notSupported();
	}

	@Override
	public boolean isId() {
		return DOMErrors.notSupported();
	}

}
