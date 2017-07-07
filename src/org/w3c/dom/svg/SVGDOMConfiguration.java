package org.w3c.dom.svg;

import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMError;
import org.w3c.dom.DOMErrorHandler;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMStringList;

public class SVGDOMConfiguration implements DOMConfiguration {

	public static final String CANONICAL_FORM = "canonical-form";
	public static final String CDATA_SECTIONS = "cdata-sections";
	public static final String CHECK_CHARACTER_NORMALIZATION = "check-character-normalization";
	public static final String COMMENTS = "comments";
	public static final String DATATYPE_NORMALIZATION = "datatype-normalization";
	public static final String ELEMENT_CONTENT_WHITESPACE = "element-content-whitespace";
	public static final String ENTITIES = "entities";
	public static final String ERROR_HANDLER = "error-handler";
	public static final String INFOSET = "infoset";
	public static final String NAMESPACES = "namespaces";
	public static final String NAMESPACE_DECLARATIONS = "namespace-declarations";
	public static final String NORMALIZE_CHARACTERS = "normalize-characters";
	public static final String SCHEMA_LOCATION = "schema-location";
	public static final String SCHEMA_TYPE = "schema-type";
	public static final String SPLIT_CDATA_SECTIONS = "split-cdata-sections";
	public static final String VALIDATE = "validate";
	public static final String VALIDATE_IF_SCHEMA = "validate-if-schema";
	public static final String WELL_FORMED = "well-formed";
	
	private SVGStringList parameterNames;
	
	private HashMap<String, Object> parameters;
	
	public SVGDOMConfiguration() {
		parameterNames = new SVGStringList.Implementation(new ArrayList<String>());
		parameterNames.appendItem(CANONICAL_FORM);
		parameterNames.appendItem(CDATA_SECTIONS);
		parameterNames.appendItem(CHECK_CHARACTER_NORMALIZATION);
		parameterNames.appendItem(COMMENTS);
		parameterNames.appendItem(DATATYPE_NORMALIZATION);
		parameterNames.appendItem(ELEMENT_CONTENT_WHITESPACE);
		parameterNames.appendItem(ENTITIES);
		parameterNames.appendItem(ERROR_HANDLER);
		parameterNames.appendItem(INFOSET);
		parameterNames.appendItem(NAMESPACES);
		parameterNames.appendItem(NAMESPACE_DECLARATIONS);
		parameterNames.appendItem(NORMALIZE_CHARACTERS);
		parameterNames.appendItem(SCHEMA_LOCATION);
		parameterNames.appendItem(SCHEMA_TYPE);
		parameterNames.appendItem(SPLIT_CDATA_SECTIONS);
		parameterNames.appendItem(VALIDATE);
		parameterNames.appendItem(VALIDATE_IF_SCHEMA);
		parameterNames.appendItem(WELL_FORMED);
		parameters = new HashMap<>();
		parameters.put(CANONICAL_FORM, false);
		parameters.put(CDATA_SECTIONS, true);
		parameters.put(CHECK_CHARACTER_NORMALIZATION, false);
		parameters.put(COMMENTS, true);
		parameters.put(DATATYPE_NORMALIZATION, false);
		parameters.put(ELEMENT_CONTENT_WHITESPACE, true);
		parameters.put(ENTITIES, true);
		parameters.put(ERROR_HANDLER, new DOMErrorHandler() {
			@Override
			public boolean handleError(DOMError error) {
				return false;
			}
		});
		parameters.put(NAMESPACES, true);
		parameters.put(NAMESPACE_DECLARATIONS, true);
		parameters.put(NORMALIZE_CHARACTERS, false);
		parameters.put(SPLIT_CDATA_SECTIONS, true);
		parameters.put(VALIDATE, false);
		parameters.put(VALIDATE_IF_SCHEMA, false);
		parameters.put(WELL_FORMED, true);
	}
	
	@Override
	public boolean canSetParameter(String name, Object value) {
		return true;
	}

	@Override
	public Object getParameter(String name) throws DOMException {
		if (!parameterNames.contains(name)) {
			throw new DOMException(DOMException.NOT_FOUND_ERR, "Parameter name not recognized: " + name);
		}
		return parameters.get(name);
	}

	@Override
	public DOMStringList getParameterNames() {
		return parameterNames;
	}

	@Override
	public void setParameter(String name, Object value) throws DOMException {
		if (!parameterNames.contains(name)) {
			throw new DOMException(DOMException.NOT_FOUND_ERR, "Parameter name not recognized: " + name);
		}
		parameters.put(name, value);
	}

}
