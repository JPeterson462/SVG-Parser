package org.w3c.dom.svg;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.svg.impl.AttrImplementation;
import org.w3c.dom.svg.impl.NodeImplementation;

public interface SVGDocument extends Document, DocumentEvent {

	public String getTitle();
	
	public String getReferrer();
	
	public String getDomain();
	
	public String getURL();
	
	public SVGSVGElement getRootElement();
	
	public static class Implementation extends NodeImplementation implements SVGDocument {
		
		private String title, referrer, domain, url;
		
		private SVGSVGElement rootElement;
		
		public Implementation(String title, String referrer, String domain, String url, SVGSVGElement rootElement) {
			super(title);
			this.title = title;
			this.referrer = referrer;
			this.domain = domain;
			this.url = url;
			this.rootElement = rootElement;
		}

		@Override
		public String getTitle() {
			return title;
		}

		@Override
		public String getReferrer() {
			return referrer;
		}

		@Override
		public String getDomain() {
			return domain;
		}

		@Override
		public String getURL() {
			return url;
		}

		@Override
		public SVGSVGElement getRootElement() {
			return rootElement;
		}

		@Override
		public Node adoptNode(Node arg0) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Attr createAttribute(String arg0) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Attr createAttributeNS(String arg0, String arg1) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public CDATASection createCDATASection(String data) throws DOMException {
//			CDATA
			return null;
		}

		@Override
		public Comment createComment(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DocumentFragment createDocumentFragment() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Element createElement(String arg0) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Element createElementNS(String arg0, String arg1) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public EntityReference createEntityReference(String arg0) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ProcessingInstruction createProcessingInstruction(String arg0, String arg1) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Text createTextNode(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DocumentType getDoctype() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Element getDocumentElement() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getDocumentURI() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DOMConfiguration getDomConfig() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Element getElementById(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public NodeList getElementsByTagName(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public NodeList getElementsByTagNameNS(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public DOMImplementation getImplementation() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getInputEncoding() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean getStrictErrorChecking() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getXmlEncoding() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean getXmlStandalone() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String getXmlVersion() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Node importNode(Node arg0, boolean arg1) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void normalizeDocument() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Node renameNode(Node arg0, String arg1, String arg2) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setDocumentURI(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setStrictErrorChecking(boolean arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setXmlStandalone(boolean arg0) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void setXmlVersion(String arg0) throws DOMException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Event createEvent(String arg0) throws DOMException {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
}
