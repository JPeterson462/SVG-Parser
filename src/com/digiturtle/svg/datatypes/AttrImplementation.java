package com.digiturtle.svg.datatypes;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

public class AttrImplementation extends ElementImplementation implements Attr {

	private boolean specified = true;
	
	private Element owner;
	
	private String name, value;
	
	public AttrImplementation(Element owner, String name, String value) {
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
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public String getBaseURI() {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Object getFeature(String feature, String version) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
		}

	@Override
	public String getTextContent() throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Object getUserData(String key) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean hasAttributes() {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean isDefaultNamespace(String namespaceURI) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean isEqualNode(Node arg) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean isSameNode(Node other) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public String lookupNamespaceURI(String prefix) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public String lookupPrefix(String namespaceURI) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setTextContent(String textContent) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Object setUserData(String key, Object data, UserDataHandler handler) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Attr getAttributeNode(String name) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Attr getAttributeNodeNS(String namespaceURI, String localName) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public NodeList getElementsByTagName(String name) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public NodeList getElementsByTagNameNS(String namespaceURI, String localName) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean hasAttribute(String name) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean hasAttributeNS(String namespaceURI, String localName) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void removeAttribute(String name) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void removeAttributeNS(String namespaceURI, String localName) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Attr removeAttributeNode(Attr oldAttr) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setAttributeNS(String namespaceURI, String qualifiedName, String value) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Attr setAttributeNode(Attr newAttr) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Attr setAttributeNodeNS(Attr newAttr) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setIdAttribute(String name, boolean isId) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setIdAttributeNS(String namespaceURI, String localName, boolean isId) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public void setIdAttributeNode(Attr idAttr, boolean isId) throws DOMException {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public int getLength() {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public Node item(int index) {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public TypeInfo getSchemaTypeInfo() {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

	@Override
	public boolean isId() {
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Method not supported");
	}

}
