package org.w3c.dom.svg.document;

import java.util.ArrayList;

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.events.DocumentEvent;
import org.w3c.dom.events.Event;
import org.w3c.dom.DOMErrors;
import org.w3c.dom.svg.impl.AttrImplementation;
import org.w3c.dom.svg.impl.CDATASectionImplementation;
import org.w3c.dom.svg.impl.CommentImplementation;
import org.w3c.dom.svg.impl.DocumentFragmentImplementation;
import org.w3c.dom.svg.impl.ElementImplementation;
import org.w3c.dom.svg.impl.EntityReferenceImplementation;
import org.w3c.dom.svg.impl.NodeImplementation;
import org.w3c.dom.svg.impl.NodeListImplementation;
import org.w3c.dom.svg.impl.ProcessingInstructionImplementation;
import org.w3c.dom.svg.impl.TextImplementation;

public interface SVGDocument extends Document, DocumentEvent {

	public String getTitle();
	
	public String getReferrer();
	
	public String getDomain();
	
	public String getURL();
	
	public SVGSVGElement getRootElement();
	
	public static class Implementation extends NodeImplementation implements SVGDocument {
		
		private String title, referrer, domain, url;
		
		private SVGSVGElement rootElement;
		
		private String xmlVersion, xmlEncoding;
		
		private DocumentType documentType;
		
		private DOMImplementation domImplementation;
		
		private DOMConfiguration domConfiguration;
		
		private String inputEncoding;
		
		private String documentURI;
		
		private boolean strictErrorChecking = false, xmlStandalone = false;
		
		public Implementation(String title, String referrer, String domain, String url, SVGSVGElement rootElement, String xmlVersion, 
				String xmlEncoding, DocumentType documentType, DOMConfiguration domConfiguration) {
			super(title);
			this.title = title;
			this.referrer = referrer;
			this.domain = domain;
			this.url = url;
			this.rootElement = rootElement;
			this.xmlVersion = xmlVersion;
			this.xmlEncoding = xmlEncoding;
			this.documentType = documentType;
			this.domConfiguration = domConfiguration;
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
		public Node adoptNode(Node source) throws DOMException {
			switch (source.getNodeType()) {
				case ATTRIBUTE_NODE:
					getDocumentElement().appendChild(source);
					break;
				case DOCUMENT_FRAGMENT_NODE:
					getDocumentElement().appendChild(source);
					break;
				case DOCUMENT_NODE:
					throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Document nodes cannot be adopted");
				case DOCUMENT_TYPE_NODE:
					throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "DocumentType nodes cannot be adopted");
				case ELEMENT_NODE:
					getDocumentElement().appendChild(source);
					break;
				case ENTITY_NODE:
					throw new DOMException(DOMException.INVALID_STATE_ERR, "Entity nodes cannot be adopted");
				case ENTITY_REFERENCE_NODE:
					break;
				case NOTATION_NODE:
					throw new DOMException(DOMException.INVALID_STATE_ERR, "Notation nodes cannot be adopted");
				case PROCESSING_INSTRUCTION_NODE:
					getDocumentElement().appendChild(source);
					break;
				case TEXT_NODE:
					getDocumentElement().appendChild(source);
					break;
				case CDATA_SECTION_NODE:
					getDocumentElement().appendChild(source);
					break;
				case COMMENT_NODE:
					getDocumentElement().appendChild(source);
					break;
				default:
					throw new DOMException(DOMException.INVALID_STATE_ERR, "Nodes of type " + source.getNodeType() + " cannot be adopted");
			}
			return source;
		}

		@Override
		public Attr createAttribute(String name) throws DOMException {
			return new AttrImplementation(null, name, null);
		}

		@Override
		public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException {
			return new AttrImplementation(null, qualifiedName, null);
		}

		@Override
		public CDATASection createCDATASection(String data) throws DOMException {
			CDATASection cdata = new CDATASectionImplementation("CDATA");
			cdata.setData(data);
			return cdata;
		}

		@Override
		public Comment createComment(String data) {
			Comment comment = new CommentImplementation("CDATA");
			comment.setData(data);
			return comment;
		}

		@Override
		public DocumentFragment createDocumentFragment() {
			return new DocumentFragmentImplementation(null);
		}

		@Override
		public Element createElement(String tagName) throws DOMException {
			return new ElementImplementation(tagName);
		}

		@Override
		public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
			return new ElementImplementation(qualifiedName);
		}

		@Override
		public EntityReference createEntityReference(String name) throws DOMException {
			return new EntityReferenceImplementation(name);
		}

		@Override
		public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
			return new ProcessingInstructionImplementation("ProcessingInstruction", target, data);
		}

		@Override
		public Text createTextNode(String data) {
			Text text = new TextImplementation("TextNode");
			text.setData(data);
			return text;
		}

		@Override
		public DocumentType getDoctype() {
			return documentType;
		}

		@Override
		public Element getDocumentElement() {
			return rootElement;
		}

		@Override
		public String getDocumentURI() {
			return documentURI;
		}

		@Override
		public DOMConfiguration getDomConfig() {
			return domConfiguration;
		}

		@Override
		public Element getElementById(String elementId) {
			Element[] result = new Element[1];
			visitNodes(getDocumentElement(), (node) -> {
				if (node instanceof Element) {
					if (((Element) node).hasAttribute("id") && ((Element) node).getAttribute("id").equals(elementId)) {
						if (result[0] == null) {
							result[0] = (Element) node;
						}
					}
				}
			});
			return result[0];
		}

		@Override
		public NodeList getElementsByTagName(String tagName) {
			ArrayList<Node> nodes = new ArrayList<>();
			visitNodes(getDocumentElement(), (node) -> {
				if (node instanceof Element) {
					if (((Element) node).getTagName().equalsIgnoreCase(tagName)) {
						nodes.add(node);
					}
				}
			});
			return new NodeListImplementation(nodes);
		}

		@Override
		public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
			return getElementsByTagName(localName);
		}
		
		private void visitNodes(Node root, Visitor visitor) {
			NodeList children = root.getChildNodes();
			for (int i = 0; i < children.getLength(); i++) {
				Node node = children.item(i);
				visitor.visit(node);
				visitNodes(node, visitor);
			}
		}
		
		@FunctionalInterface
		interface Visitor {
			void visit(Node node);
		}

		@Override
		public DOMImplementation getImplementation() {
			return domImplementation;
		}

		@Override
		public String getInputEncoding() {
			return inputEncoding;
		}

		@Override
		public boolean getStrictErrorChecking() {
			return strictErrorChecking;
		}

		@Override
		public String getXmlEncoding() {
			return xmlEncoding;
		}

		@Override
		public boolean getXmlStandalone() {
			return xmlStandalone;
		}

		@Override
		public String getXmlVersion() {
			return xmlVersion;
		}

		@Override
		public Node importNode(Node importedNode, boolean deep) throws DOMException {
			return DOMErrors.notSupported();
		}

		@Override
		public void normalizeDocument() {
			
		}
		
		@Override
		public Node renameNode(Node node, String namespaceURI, String qualifiedName) throws DOMException {
			if (node.getNodeType() != ELEMENT_NODE && node.getNodeType() != ATTRIBUTE_NODE) {
				throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "Nodes of this type cannot be renamed");
			}
			if (node instanceof NodeImplementation) {
				Node renamed = new NodeImplementation(node.getNodeName());
				((NodeImplementation) node).duplicate((NodeImplementation) renamed);
				node.getParentNode().appendChild(renamed);
				node.getParentNode().removeChild(node);
				return renamed;
			}
			else if (node instanceof ElementImplementation) {
				Element renamed = new ElementImplementation(node.getNodeName());
				((ElementImplementation) node).duplicate((NodeImplementation) renamed);
				node.getParentNode().appendChild(renamed);
				node.getParentNode().removeChild(node);
				return renamed;
			}
			else {
				throw new DOMException(DOMException.WRONG_DOCUMENT_ERR, "This node is from another document");
			}
		}

		@Override
		public void setDocumentURI(String documentURI) {
			this.documentURI = documentURI;
		}

		@Override
		public void setStrictErrorChecking(boolean strictErrorChecking) {
			this.strictErrorChecking = strictErrorChecking;
		}

		@Override
		public void setXmlStandalone(boolean xmlStandalone) throws DOMException {
			this.xmlStandalone = xmlStandalone;
		}

		@Override
		public void setXmlVersion(String xmlVersion) throws DOMException {
			this.xmlVersion = xmlVersion;
		}

		@Override
		public Event createEvent(String type) throws DOMException {
//			if (type.equals("UIEvents")) {
//				
//			}
//			return null;
			return DOMErrors.notSupported();
		}
		
	}
	
}
