package org.w3c.dom.svg.parser;

import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGException;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGTransform;
import org.w3c.dom.svg.SVGTransformList;

public interface ElementParser<T extends SVGElement> {
	
	public T readElement(Element element, ParsingState parsingState);
	
	public Element writeElement(T element, ElementFactory factory);

	public static SVGStringList concatenate(String... elements) {
		ArrayList<String> list = new ArrayList<>(Arrays.asList(elements));
		return new SVGStringList.Implementation(list);
	}
	
	public static float[] parseFloatArray(String text) {
		String[] strings = text.split(",");
		float[] array = new float[strings.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Float.parseFloat(strings[i]);
		}
		return array;
	}
	
	public static String readOrDefault(Element element, String attribute, String... defaultValue) {
		if (element.hasAttribute(attribute)) {
			return element.getAttribute(attribute);
		}
		for (int i = 0; i < defaultValue.length - 1; i++) {
			if (defaultValue[i] != null) {
				return defaultValue[i];
			}
		}
		if (defaultValue.length == 0) {
			return null;
		}
		return defaultValue[defaultValue.length - 1];
	}
	
	public static SVGTransform parseTransform(String text) {
		SVGTransform transform = new SVGTransform.Implementation();
		if (text.startsWith("matrix(") && text.endsWith(")")) {
			text = text.substring(7, text.length() - 1).replaceAll(" ", "");
			float[] values = parseFloatArray(text);
			SVGMatrix matrix = new SVGMatrix.Implementation();
			if (values.length != 6) {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
			matrix.setA(values[0]);
			matrix.setB(values[1]);
			matrix.setC(values[2]);
			matrix.setD(values[3]);
			matrix.setE(values[4]);
			matrix.setF(values[5]);
			transform.setMatrix(matrix);
		}
		else if (text.startsWith("translate(") && text.endsWith(")")) {
			text = text.substring(10, text.length() - 1).replaceAll(" ", "");
			float[] values = parseFloatArray(text);
			if (values.length == 1) {
				transform.setTranslate(values[0], 0);
			}
			else if (values.length == 2) {
				transform.setTranslate(values[0], values[1]);
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else if (text.startsWith("scale(") && text.endsWith(")")) {
			text = text.substring(6, text.length() - 1).replaceAll(" ", "");
			float[] values = parseFloatArray(text);
			if (values.length == 1) {
				transform.setScale(values[0], values[0]);
			}
			else if (values.length == 2) {
				transform.setScale(values[0], values[1]);
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else if (text.startsWith("rotate(") && text.endsWith(")")) {
			text = text.substring(7, text.length() - 1).replaceAll(" ", "");
			float[] values = parseFloatArray(text);
			if (values.length == 1) {
				transform.setRotate(values[0], 0, 0);
			}
			else if (values.length == 3) {
				transform.setRotate(values[0], values[1], values[2]);
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else if (text.startsWith("skewX(") && text.endsWith(")")) {
			text = text.substring(6, text.length() - 1).replaceAll(" ", "");
			float[] values = parseFloatArray(text);
			if (values.length == 1) {
				transform.setSkewX(values[0]);
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else if (text.startsWith("skewY(") && text.endsWith(")")) {
			text = text.substring(6, text.length() - 1).replaceAll(" ", "");
			float[] values = parseFloatArray(text);
			if (values.length == 1) {
				transform.setSkewY(values[0]);
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else {
			throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
		}
		return transform;
	}
	
	public static SVGAnimatedTransformList parseTransforms(Element element) {
		ArrayList<SVGTransform> transforms = new ArrayList<>();
		String attribute = readOrDefault(element, "transform", "");
		String[] rawTransforms = attribute.split(" ");
		for (int i = 0; i < rawTransforms.length; i++) {
			transforms.add(parseTransform(rawTransforms[i]));
		}
		return new SVGAnimatedTransformList.Implementation(new SVGTransformList.Implementation(transforms),
				new SVGTransformList.Implementation(transforms));
	}
	
}
