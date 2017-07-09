package org.w3c.dom.svg;

import java.util.HashMap;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.svg.document.SVGDocument;
import org.w3c.dom.svg.impl.DocumentTypeImplementation;
import org.w3c.dom.svg.impl.NamedNodeMapImplementation;

public class SVGDOMImplementation implements DOMImplementation {
	
	private HashMap<String, String[]> features = new HashMap<>();
	
	public SVGDOMImplementation() {
		features.put("SVG", new String[] { "1.0", "1.1" });
		features.put("SVGEvents", new String[] { "1.0", "1.1" });
	}
	
	@Override
	public Document createDocument(String namespaceURI, String qualifiedName, DocumentType doctype)
			throws DOMException {
		return new SVGDocument.Implementation(null, null, null, null, null, qualifiedName, null, doctype, new SVGDOMConfiguration());
	}

	@Override
	public DocumentType createDocumentType(String qualifiedName, String publicId, String systemId) throws DOMException {
		return new DocumentTypeImplementation(qualifiedName, new NamedNodeMapImplementation(), null, qualifiedName, 
				new NamedNodeMapImplementation(), publicId, systemId);
	}

	@Override
	public Object getFeature(String feature, String version) {
		if (hasFeature(feature, version)) {
			return this;
		}
		return null;
	}

	@Override
	public boolean hasFeature(String feature, String version) {
		if (features.containsKey(feature)) {
			String[] versions = features.get(feature);
			for (int i = 0; i < versions.length; i++) {
				if (versions[i].equalsIgnoreCase(version)) {
					return true;
				}
			}
		}
		return false;
	}

}
