package org.w3c.dom.svg.parser;

import java.util.ArrayList;
import java.util.Arrays;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.CSSPropertyNames;
import org.w3c.dom.css.impl.CSSStyleDeclarationImplementation;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedTransformList;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGErrors;
import org.w3c.dom.svg.SVGException;
import org.w3c.dom.svg.SVGLength;
import org.w3c.dom.svg.SVGLengthList;
import org.w3c.dom.svg.SVGMatrix;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGNumberList;
import org.w3c.dom.svg.SVGPointList;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.SVGTransform;
import org.w3c.dom.svg.SVGTransformList;
import org.w3c.dom.svg.paths.SVGPathSeg;
import org.w3c.dom.svg.paths.SVGPathSegArcAbs;
import org.w3c.dom.svg.paths.SVGPathSegArcRel;
import org.w3c.dom.svg.paths.SVGPathSegClosePath;
import org.w3c.dom.svg.paths.SVGPathSegCurveToCubicAbs;
import org.w3c.dom.svg.paths.SVGPathSegCurveToCubicRel;
import org.w3c.dom.svg.paths.SVGPathSegCurveToCubicSmoothAbs;
import org.w3c.dom.svg.paths.SVGPathSegCurveToCubicSmoothRel;
import org.w3c.dom.svg.paths.SVGPathSegCurveToQuadraticAbs;
import org.w3c.dom.svg.paths.SVGPathSegCurveToQuadraticRel;
import org.w3c.dom.svg.paths.SVGPathSegCurveToQuadraticSmoothAbs;
import org.w3c.dom.svg.paths.SVGPathSegCurveToQuadraticSmoothRel;
import org.w3c.dom.svg.paths.SVGPathSegLineToAbs;
import org.w3c.dom.svg.paths.SVGPathSegLineToHorizontalAbs;
import org.w3c.dom.svg.paths.SVGPathSegLineToHorizontalRel;
import org.w3c.dom.svg.paths.SVGPathSegLineToRel;
import org.w3c.dom.svg.paths.SVGPathSegLineToVerticalAbs;
import org.w3c.dom.svg.paths.SVGPathSegLineToVerticalRel;
import org.w3c.dom.svg.paths.SVGPathSegList;
import org.w3c.dom.svg.paths.SVGPathSegMoveToAbs;
import org.w3c.dom.svg.paths.SVGPathSegMoveToRel;

public interface ElementParser<T extends SVGElement> {
	
	public T readElement(Element element, ParsingState parsingState);
	
	public Element writeElement(T element, ElementFactory factory);

	public static SVGElement getNearestViewportElement(ParsingState parsingState) {
		SVGElement[] result = { null };
		parsingState.traverseHierarchy(e -> {
			if (result[0] == null && e.getTagName().equals(Tags.SVG)) {
				result[0] = e;
			}
		});
		return result[0];
	}
	
	public static SVGElement getFarthestViewportElement(ParsingState parsingState) {
		SVGElement[] result = { null };
		parsingState.traverseHierarchy(e -> {
			if (e.getTagName().equals(Tags.SVG)) {
				result[0] = e;
			}
		});
		return result[0];
	}
	
	public static SVGStringList concatenate(String... elements) {
		ArrayList<String> list = new ArrayList<>(Arrays.asList(elements));
		return new SVGStringList.Implementation(list);
	}
	
	public static String concatenate(SVGStringList list, String joinBy) {
		String concatenated = "";
		for (int i = 0; i < list.getLength(); i++) {
			if (i > 0) {
				concatenated += joinBy;
			} else {
				concatenated += list.item(i);
			}
		}
		return concatenated;
	}
	
	public static float[] parseFloatArray(String text) {
		String[] strings = text.split(",");
		float[] array = new float[strings.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Float.parseFloat(strings[i]);
		}
		return array;
	}
	
	public static void parseStyleFromAttributes(Element element, CSSStyleDeclarationImplementation declaration) {
		String[] properties = CSSPropertyNames.PROPERTIES;
		for (int i = 0; i < properties.length; i++) {
			if (element.hasAttribute(properties[i])) {
				declaration.setProperty(properties[i], element.getAttribute(properties[i]), "important");
			}
		}
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
		String attribute = readOrDefault(element, Attributes.TRANSFORM, "");
		String[] rawTransforms = attribute.split("[ ]+");
		for (int i = 0; i < rawTransforms.length; i++) {
			transforms.add(parseTransform(rawTransforms[i]));
		}
		return new SVGAnimatedTransformList.Implementation(new SVGTransformList.Implementation(transforms),
				new SVGTransformList.Implementation(transforms));
	}
	
	public static String getTransform(SVGTransform transform) {
		return "matrix(" + transform.getMatrix().getA() + ", " + transform.getMatrix().getB() + ", " + transform.getMatrix().getC() + ", "
				+ transform.getMatrix().getD() + ", " + transform.getMatrix().getE() + ", " + transform.getMatrix().getF() + ")";
	}
	
	public static String getTransforms(SVGAnimatedTransformList transforms) {
		SVGTransformList list = transforms.getBaseValue();
		String text = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			SVGTransform transform = list.getItem(i);
			if (i > 0) {
				text += " ";
			}
			text += getTransform(transform);
		}
		return text;
	}
	
	public static String join(SVGStringList list, String joinBy) {
		String text = "";
		for (int i = 0; i < list.getLength(); i++) {
			if (i > 0) {
				text += joinBy;
			}
			text += list.getItem(i);
		}
		return text;
	}
	
	public static String getPointList(SVGPointList points) {
		String text = "";
		for (int i = 0; i < points.getNumberOfItems(); i++) {
			if (i > 0) {
				text += " ";
			}
			text += points.getItem(i).getX() + "," + points.getItem(i).getY();
		}
		return text;
	}
	
	public static String validate(String value, String... possible) {
		for (int i = 0; i < possible.length; i++) {
			if (value.equals(possible[i])) {
				return value;
			}
		}
		return SVGErrors.error("Invalid value: " + value);
	}
	
	public static SVGLengthList parseLengthList(String text, ParsingState parsingState) {
		ArrayList<String> textSplit = StringUtils.splitByWhitespace(text);
		ArrayList<SVGLength> list = new ArrayList<>();
		if (text.length() > 0) {
			for (int i = 0; i < textSplit.size(); i++) {
				String lengthStr = textSplit.get(i);
				if (lengthStr.endsWith(",")) {
					lengthStr = lengthStr.substring(0, lengthStr.length() - 1);
				}
				else if (i == textSplit.size() - 1) {
					// Valid
				}
				else if (textSplit.get(i + 1).equals(",")) {
					i++;
				}
				else {
					SVGErrors.error("Invalid length list");
				}
				SVGLength length = new SVGLength.Implementation(SVGLength.SVG_LENGTHTYPE_UNKNOWN, 0, parsingState.getCurrentParent());
				length.setValueAsString(lengthStr);
				list.add(length);
			}
		}
		return new SVGLengthList.Implementation(list);
	}
	
	public static String convertLengthList(SVGLengthList list) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += ", ";
			}
			result += list.getItem(i).getValueAsString();
		}
		return result;
	}
	
	public static SVGNumberList parseNumberList(String text) {
		ArrayList<String> textSplit = StringUtils.splitByWhitespace(text);
		ArrayList<SVGNumber> list = new ArrayList<>();
		if (text.length() > 0) {
			for (int i = 0; i < textSplit.size(); i++) {
				String numberStr = textSplit.get(i);
				if (numberStr.endsWith(",")) {
					numberStr = numberStr.substring(0, numberStr.length() - 1);
				}
				else if (i == textSplit.size() - 1) {
					// Valid
				}
				else if (textSplit.get(i + 1).equals(",")) {
					i++;
				}
				else {
					SVGErrors.error("Invalid length list");
				}
				list.add(new SVGNumber.Implementation(Float.parseFloat(numberStr)));
			}
		}
		return new SVGNumberList.Implementation(list);
	}

	public static String convertNumberList(SVGNumberList list) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += ", ";
			}
			result += Float.toString(list.getItem(i).getValue());
		}
		return result;
	}
	
	static class PathSegTokenizer {
		
		private char[] data;
		
		private int pointer = 0;
		
		private PathSegTokenizer(String text) {
			data = text.toCharArray();
		}
		
		private void skipWhitespace() {
			while (data[pointer] == ' ' || data[pointer] == '\n' || 
					data[pointer] == '\t' || data[pointer] == '\r') {
				pointer++;
			}
		}
		
		private boolean isNumber(char c) {
			return Character.isDigit(c) || c == '-' || c == '.';
		}
		
		private char readPathSegType() {
			skipWhitespace();
			return data[pointer++];
		}
		
		private float readValue() {
			skipWhitespace();
			int digits = 0;
			char[] array = new char[data.length - pointer];
			while (isNumber(data[pointer])) {
				array[digits++] = data[pointer];
				pointer++;
			}
			char[] result = new char[digits];
			System.arraycopy(array, 0, result, 0, digits);
			return Float.parseFloat(new String(result));
		}
		
		private boolean readBoolean() {
			skipWhitespace();
			char c = data[pointer];
			pointer++;
			return c == '1';
		}
		
		private boolean moreValues() {
			skipWhitespace();
			return isNumber(data[pointer]);
		}
		
		private boolean moreData() {
			return pointer < data.length;
		}
		
	}
	
	public static SVGPathSegList parsePathSegList(String text) {
		PathSegTokenizer tokenizer = new PathSegTokenizer(text);
		ArrayList<SVGPathSeg> list = new ArrayList<>();
		while (tokenizer.moreData()) {
			list.addAll(parsePathSeg(tokenizer));
		}
		return new SVGPathSegList.Implementation(list);
	}
	
	static ArrayList<SVGPathSeg> parsePathSeg(PathSegTokenizer tokenizer) {
		char type = tokenizer.readPathSegType();
		ArrayList<SVGPathSeg> list = new ArrayList<>();
		switch (type) {
			case 'z':
				list.add(new SVGPathSegClosePath.Implementation());
				break;
			case 'M':
				SVGPathSegMoveToAbs moveToAbs = new SVGPathSegMoveToAbs.Implementation();
				moveToAbs.setX(tokenizer.readValue());
				moveToAbs.setY(tokenizer.readValue());
				list.add(moveToAbs);
				while (tokenizer.moreValues()) {
					SVGPathSegLineToAbs lineToAbs = new SVGPathSegLineToAbs.Implementation();
					lineToAbs.setX(tokenizer.readValue());
					lineToAbs.setY(tokenizer.readValue());
					list.add(lineToAbs);
				}
				break;
			case 'm':
				SVGPathSegMoveToRel moveToRel = new SVGPathSegMoveToRel.Implementation();
				moveToRel.setX(tokenizer.readValue());
				moveToRel.setY(tokenizer.readValue());
				list.add(moveToRel);
				while (tokenizer.moreValues()) {
					SVGPathSegLineToRel lineToRel = new SVGPathSegLineToRel.Implementation();
					lineToRel.setX(tokenizer.readValue());
					lineToRel.setY(tokenizer.readValue());
					list.add(lineToRel);
				}
				break;
			case 'L':
				while (tokenizer.moreValues()) {
					SVGPathSegLineToAbs lineToAbs = new SVGPathSegLineToAbs.Implementation();
					lineToAbs.setX(tokenizer.readValue());
					lineToAbs.setY(tokenizer.readValue());
					list.add(lineToAbs);
				}
				break;
			case 'l':
				while (tokenizer.moreValues()) {
					SVGPathSegLineToRel lineToRel = new SVGPathSegLineToRel.Implementation();
					lineToRel.setX(tokenizer.readValue());
					lineToRel.setY(tokenizer.readValue());
					list.add(lineToRel);
				}
				break;
			case 'H':
				while (tokenizer.moreValues()) {
					SVGPathSegLineToHorizontalAbs lineToHorizontalAbs = new SVGPathSegLineToHorizontalAbs.Implementation();
					lineToHorizontalAbs.setX(tokenizer.readValue());
					list.add(lineToHorizontalAbs);
				}
				break;
			case 'h':
				while (tokenizer.moreValues()) {
					SVGPathSegLineToHorizontalRel lineToHorizontalRel = new SVGPathSegLineToHorizontalRel.Implementation();
					lineToHorizontalRel.setX(tokenizer.readValue());
					list.add(lineToHorizontalRel);
				}
				break;
			case 'V':
				while (tokenizer.moreValues()) {
					SVGPathSegLineToVerticalAbs lineToVerticalAbs = new SVGPathSegLineToVerticalAbs.Implementation();
					lineToVerticalAbs.setY(tokenizer.readValue());
					list.add(lineToVerticalAbs);
				}
				break;
			case 'v':
				while (tokenizer.moreValues()) {
					SVGPathSegLineToVerticalRel lineToVerticalRel = new SVGPathSegLineToVerticalRel.Implementation();
					lineToVerticalRel.setY(tokenizer.readValue());
					list.add(lineToVerticalRel);
				}
				break;
			case 'C':
				while (tokenizer.moreValues()) {
					SVGPathSegCurveToCubicAbs curveToCubicAbs = new SVGPathSegCurveToCubicAbs.Implementation();
					curveToCubicAbs.setX1(tokenizer.readValue());
					curveToCubicAbs.setY1(tokenizer.readValue());
					curveToCubicAbs.setX2(tokenizer.readValue());
					curveToCubicAbs.setY2(tokenizer.readValue());
					curveToCubicAbs.setX(tokenizer.readValue());
					curveToCubicAbs.setY(tokenizer.readValue());
					list.add(curveToCubicAbs);
				}
				break;
			case 'c':
				while (tokenizer.moreValues()) {
					SVGPathSegCurveToCubicRel curveToCubicRel = new SVGPathSegCurveToCubicRel.Implementation();
					curveToCubicRel.setX1(tokenizer.readValue());
					curveToCubicRel.setY1(tokenizer.readValue());
					curveToCubicRel.setX2(tokenizer.readValue());
					curveToCubicRel.setY2(tokenizer.readValue());
					curveToCubicRel.setX(tokenizer.readValue());
					curveToCubicRel.setY(tokenizer.readValue());
					list.add(curveToCubicRel);
				}
				break;
			case 'S':
				while (tokenizer.moreValues()) {
					SVGPathSegCurveToCubicSmoothAbs curveToCubicSmoothAbs = new SVGPathSegCurveToCubicSmoothAbs.Implementation();
					curveToCubicSmoothAbs.setX2(tokenizer.readValue());
					curveToCubicSmoothAbs.setY2(tokenizer.readValue());
					curveToCubicSmoothAbs.setX(tokenizer.readValue());
					curveToCubicSmoothAbs.setY(tokenizer.readValue());
					list.add(curveToCubicSmoothAbs);
				}
				break;
			case 's':
				while (tokenizer.moreValues()) {
					SVGPathSegCurveToCubicSmoothRel curveToCubicSmoothRel = new SVGPathSegCurveToCubicSmoothRel.Implementation();
					curveToCubicSmoothRel.setX2(tokenizer.readValue());
					curveToCubicSmoothRel.setY2(tokenizer.readValue());
					curveToCubicSmoothRel.setX(tokenizer.readValue());
					curveToCubicSmoothRel.setY(tokenizer.readValue());
					list.add(curveToCubicSmoothRel);
				}
				break;
			case 'Q':
				while (tokenizer.moreValues()) {
					SVGPathSegCurveToQuadraticAbs curveToQuadraticAbs = new SVGPathSegCurveToQuadraticAbs.Implementation();
					curveToQuadraticAbs.setX1(tokenizer.readValue());
					curveToQuadraticAbs.setY1(tokenizer.readValue());
					curveToQuadraticAbs.setX(tokenizer.readValue());
					curveToQuadraticAbs.setY(tokenizer.readValue());
					list.add(curveToQuadraticAbs);
				}
				break;
			case 'q':
				while (tokenizer.moreValues()) {
					SVGPathSegCurveToQuadraticRel curveToQuadraticRel = new SVGPathSegCurveToQuadraticRel.Implementation();
					curveToQuadraticRel.setX1(tokenizer.readValue());
					curveToQuadraticRel.setY1(tokenizer.readValue());
					curveToQuadraticRel.setX(tokenizer.readValue());
					curveToQuadraticRel.setY(tokenizer.readValue());
					list.add(curveToQuadraticRel);
				}
				break;
			case 'T':
				while (tokenizer.moreValues()) {
					SVGPathSegCurveToQuadraticSmoothAbs curveToQuadraticSmoothAbs = new SVGPathSegCurveToQuadraticSmoothAbs.Implementation();
					curveToQuadraticSmoothAbs.setX(tokenizer.readValue());
					curveToQuadraticSmoothAbs.setY(tokenizer.readValue());
					list.add(curveToQuadraticSmoothAbs);
				}
				break;
			case 't':
				while (tokenizer.moreValues()) {
					SVGPathSegCurveToQuadraticSmoothRel curveToQuadraticSmoothRel = new SVGPathSegCurveToQuadraticSmoothRel.Implementation();
					curveToQuadraticSmoothRel.setX(tokenizer.readValue());
					curveToQuadraticSmoothRel.setY(tokenizer.readValue());
					list.add(curveToQuadraticSmoothRel);
				}
				break;
			case 'A':
				while (tokenizer.moreValues()) {
					SVGPathSegArcAbs arcAbs = new SVGPathSegArcAbs.Implementation();
					arcAbs.setR1(tokenizer.readValue());
					arcAbs.setR2(tokenizer.readValue());
					arcAbs.setAngle(tokenizer.readValue());
					arcAbs.setLargeArcFlag(tokenizer.readBoolean());
					arcAbs.setSweepFlag(tokenizer.readBoolean());
					arcAbs.setX(tokenizer.readValue());
					arcAbs.setY(tokenizer.readValue());
					list.add(arcAbs);
				}
				break;
			case 'a':
				while (tokenizer.moreValues()) {
					SVGPathSegArcRel arcRel = new SVGPathSegArcRel.Implementation();
					arcRel.setR1(tokenizer.readValue());
					arcRel.setR2(tokenizer.readValue());
					arcRel.setAngle(tokenizer.readValue());
					arcRel.setLargeArcFlag(tokenizer.readBoolean());
					arcRel.setSweepFlag(tokenizer.readBoolean());
					arcRel.setX(tokenizer.readValue());
					arcRel.setY(tokenizer.readValue());
					list.add(arcRel);
				}
				break;
		}
		return list;
	}
	
}
