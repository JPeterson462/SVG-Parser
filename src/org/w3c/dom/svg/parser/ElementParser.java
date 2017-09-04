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
import org.w3c.dom.svg.SVGUnicodeRangeList;
import org.w3c.dom.svg.animation.SMILTimingValue;
import org.w3c.dom.svg.animation.SMILTimingValueList;
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
	
	public static SVGStringList readOrNull(Element element, String attribute, String splitBy, boolean ignoreWhitespace) {
		if (!element.hasAttribute(attribute)) {
			return null;
		}
		String[] parts = element.getAttribute(attribute).split(splitBy);
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < parts.length; i++) {
			if (ignoreWhitespace) {
				list.add(parts[i].trim());
			} else {
				list.add(parts[i]);
			}
		}
		return new SVGStringList.Implementation(list);
	}

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
		if (list == null) {
			return null;
		}
		for (int i = 0; i < list.getLength(); i++) {
			if (i > 0) {
				concatenated += joinBy;
			}
			concatenated += list.item(i);
		}
		return concatenated;
	}
	
	public static String concatenate(SVGPointList list, String joinBy) {
		String concatenated = "";
		if (list == null) {
			return null;
		}
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				concatenated += joinBy;
			}
			concatenated += list.getItem(i).getX() + "," + list.getItem(i).getY();
		}
		return concatenated;
	}
	
	public static String concatenate(SVGNumberList list, String joinBy) {
		String concatenated = "";
		if (list == null) {
			return null;
		}
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				concatenated += joinBy;
			}
			concatenated += Float.toString(list.getItem(i).getValue());
		}
		return concatenated;
	}
	
	public static String concatenate(SMILTimingValueList list, String joinBy) {
		String concatenated = "";
		if (list == null) {
			return null;
		}
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				concatenated += joinBy;
			}
			concatenated += SMILTimingValue.convertTimingValue(list.getItem(i));
		}
		return concatenated;
	}
	
	public static String concatenate(SVGUnicodeRangeList list, String joinBy) {
		String concatenated = "";
		if (list == null) {
			return null;
		}
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				concatenated += joinBy;
			}
			concatenated += list.getItem(i).getValue();
		}
		return concatenated;
	}
	
//	public static float[] parseFloatArray(String text) {
//		String[] strings = text.split(",");
//		float[] array = new float[strings.length];
//		for (int i = 0; i < array.length; i++) {
//			array[i] = Float.parseFloat(strings[i]);
//		}
//		return array;
//	}
	
	public static void parseStyleFromAttributes(Element element, CSSStyleDeclarationImplementation declaration) {
		String[] properties = CSSPropertyNames.PROPERTIES;
		for (int i = 0; i < properties.length; i++) {
			if (element.hasAttribute(properties[i])) {
				System.out.println(properties[i]);
				declaration.setProperty(properties[i], element.getAttribute(properties[i]), "important");
			}
		}
	}
	
	public static String read(Element element, String attribute) {
		return element.getAttribute(attribute);
	}

	public static String read(Element element, String[] attribute) {
		for (int i = 0; i < attribute.length; i++) {
			if (element.hasAttribute(attribute[i])) {
				return element.getAttribute(attribute[i]);
			}
		}
		return null;
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
	
	public static String readOrDefault(Element element, String[] attribute, String... defaultValue) {
		for (int i = 0; i < attribute.length; i++) {
			if (element.hasAttribute(attribute[i])) {
				return element.getAttribute(attribute[i]);
			}
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
	
	public static ArrayList<Float> parseValues(String prefix, String text) {
		text = text.substring(prefix.length() + 1, text.length() - 1);
		ValueTokenizer tokenizer = new ValueTokenizer(text.toCharArray());
		ArrayList<Float> values = new ArrayList<>();
		tokenizer.skipWhitespace();
		while (tokenizer.moreValues()) {
			tokenizer.skipWhitespace();
			values.add(tokenizer.readValue());
		}
		return values;
	}
	
	public static SVGTransform parseTransform(String text) {
		SVGTransform transform = new SVGTransform.Implementation();
		if (text.startsWith("matrix(") && text.endsWith(")")) {
			ArrayList<Float> values = parseValues("matrix", text);
			SVGMatrix matrix = new SVGMatrix.Implementation();
			if (values.size() != 6) {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text + " " + values);
			}
			matrix.setA(values.get(0));
			matrix.setB(values.get(1));
			matrix.setC(values.get(2));
			matrix.setD(values.get(3));
			matrix.setE(values.get(4));
			matrix.setF(values.get(5));
			transform.setMatrix(matrix);
		}
		else if (text.startsWith("translate(") && text.endsWith(")")) {
			ArrayList<Float> values = parseValues("translate", text);
			if (values.size() == 1) {
				transform.setTranslate(values.get(0), 0);
			}
			else if (values.size() == 2) {
				transform.setTranslate(values.get(0), values.get(1));
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else if (text.startsWith("scale(") && text.endsWith(")")) {
			ArrayList<Float> values = parseValues("scale", text);
			if (values.size() == 1) {
				transform.setScale(values.get(0), values.get(0));
			}
			else if (values.size() == 2) {
				transform.setScale(values.get(0), values.get(1));
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else if (text.startsWith("rotate(") && text.endsWith(")")) {
			ArrayList<Float> values = parseValues("rotate", text);
			if (values.size() == 1) {
				transform.setRotate(values.get(0), 0, 0);
			}
			else if (values.size() == 3) {
				transform.setRotate(values.get(0), values.get(1), values.get(2));
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else if (text.startsWith("skewX(") && text.endsWith(")")) {
			ArrayList<Float> values = parseValues("skewX", text);
			if (values.size() == 1) {
				transform.setSkewX(values.get(0));
			}
			else {
				throw new SVGException(SVGException.SVG_INVALID_VALUE_ERR, "Invalid transform: " + text);
			}
		}
		else if (text.startsWith("skewY(") && text.endsWith(")")) {
			ArrayList<Float> values = parseValues("skewY", text);
			if (values.size() == 1) {
				transform.setSkewY(values.get(0));
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
		String attribute = readOrDefault(element, Attributes.TRANSFORM, "");
		return parseTransforms(attribute);
	}
	
	public static SVGAnimatedTransformList parseTransforms(String attribute) {
		ArrayList<SVGTransform> transforms = new ArrayList<>();
		if (attribute.length() > 0) {
			String[] rawTransforms = attribute.split("\\)");
			for (int i = 0; i < rawTransforms.length; i++) {
				if (rawTransforms[i].trim().length() == 0) {
					continue;
				}
				transforms.add(parseTransform((rawTransforms[i] + ")").trim()));
			}
		}
		return new SVGAnimatedTransformList.Implementation(new SVGTransformList.Implementation(transforms),
				new SVGTransformList.Implementation(transforms));
	}
	
	public static String getTransform(SVGTransform transform) {
		if (transform.getType() == SVGTransform.SVG_TRANSFORM_TRANSLATE) {
			return "translate(" + StringUtils.convertToWritable(transform.getMatrix().getE()) + ", " + StringUtils.convertToWritable(transform.getMatrix().getF()) + ")";
		}
		if (transform.getType() == SVGTransform.SVG_TRANSFORM_SCALE) {
			return "scale(" + StringUtils.convertToWritable(transform.getMatrix().getA()) + ", " + StringUtils.convertToWritable(transform.getMatrix().getD()) + ")";
		}
		if (transform.getType() == SVGTransform.SVG_TRANSFORM_ROTATE && transform instanceof SVGTransform.Implementation) {
			float[] values = ((SVGTransform.Implementation) transform).rotateValues;
			if (values[1] == 0 && values[2] == 0) {
				return "rotate(" + StringUtils.convertToWritable(values[0]) + ")";
			}
			return "rotate(" + StringUtils.convertToWritable(values[0]) + ", " + StringUtils.convertToWritable(values[1]) + ", " + StringUtils.convertToWritable(values[2]) + ")";
		}
		if (transform.getType() == SVGTransform.SVG_TRANSFORM_SKEWX) {
			return "skewX(" + StringUtils.convertToWritable((float) Math.atan(transform.getMatrix().getC())) + ")";
		}
		if (transform.getType() == SVGTransform.SVG_TRANSFORM_SKEWY) {
			return "skewY(" + StringUtils.convertToWritable((float) Math.atan(transform.getMatrix().getB())) + ")";
		}
		return "matrix(" + StringUtils.convertToWritable(transform.getMatrix().getA()) + ", " + 
				StringUtils.convertToWritable(transform.getMatrix().getB()) + ", " + StringUtils.convertToWritable(transform.getMatrix().getC()) + ", " +
				StringUtils.convertToWritable(transform.getMatrix().getD()) + ", " + StringUtils.convertToWritable(transform.getMatrix().getE()) + ", " +
				StringUtils.convertToWritable(transform.getMatrix().getF()) + ")";
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
		if (list == null) {
			return null;
		}
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
		if (points == null) {
			return null;
		}
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
	
	public static class ValueTokenizer {
		
		public char[] data;
		
		public int pointer = 0;
		
		public ValueTokenizer(char[] data) {
			this.data = data;
		}

		public boolean isNumber(char c) {
			return Character.isDigit(c) || c == '-' || c == '.';
		}
		
		public void skipWhitespace() {
			while (pointer < data.length && (data[pointer] == ' ' || data[pointer] == '\n' || 
					data[pointer] == '\t' || data[pointer] == '\r' || data[pointer] == ',')) {
				pointer++;
			}
		}

		public float readValue() {
			skipWhitespace();
			int digits = 0;
			char[] array = new char[data.length - pointer];
			char last = 0;
			while (pointer < data.length && digits < array.length && (Character.isDigit(data[pointer]) || Character.toLowerCase(data[pointer]) == 'e' || data[pointer] == '.' || (digits == 0 && data[pointer] == '-') || (digits > 0 && data[pointer] == '-' && last == 'e'))) {
				array[digits++] = data[pointer];
				last = Character.toLowerCase(data[pointer]);
				pointer++;
			}
			char[] result = new char[digits];
			System.arraycopy(array, 0, result, 0, digits);
			return Float.parseFloat(new String(result));
		}

		public char readType() {
			skipWhitespace();
			System.out.println(data[pointer]);
			return data[pointer++];
		}
		
		public boolean readBoolean() {
			skipWhitespace();
			char c = data[pointer];
			pointer++;
			return c == '1';
		}
		
		public boolean moreValues() {
			skipWhitespace();
			return pointer < data.length && isNumber(data[pointer]);
		}
		
		public boolean moreData() {
			skipWhitespace();
			return pointer < data.length;
		}
		
	}
	
	static class PathSegTokenizer extends ValueTokenizer {
		
		private PathSegTokenizer(String text) {
			super(text.toCharArray());
		}
		
	}
	
	public static String join(SVGPathSegList list, String joinBy) {
		String result = "";
		for (int i = 0; i < list.getNumberOfItems(); i++) {
			if (i > 0) {
				result += joinBy;
			}
			result += toString(list.getItem(i));
		}
		return result;
	}
	
	static String toString(SVGPathSeg pathSeg) {
		switch (pathSeg.getPathSegTypeAsLetter().charAt(0)) {
			case 'z': case 'Z':
				return "z";
			case 'M':
				SVGPathSegMoveToAbs moveToAbs = (SVGPathSegMoveToAbs) pathSeg;
				return "M " + StringUtils.convertToWritable(moveToAbs.getX()) + " " + StringUtils.convertToWritable(moveToAbs.getY());
			case 'm':
				SVGPathSegMoveToRel moveToRel = (SVGPathSegMoveToRel) pathSeg;
				return "m " + StringUtils.convertToWritable(moveToRel.getX()) + " " + StringUtils.convertToWritable(moveToRel.getY());
			case 'L':
				SVGPathSegLineToAbs lineToAbs = (SVGPathSegLineToAbs) pathSeg; 
				return "L " + StringUtils.convertToWritable(lineToAbs.getX()) + " " + StringUtils.convertToWritable(lineToAbs.getY());
			case 'l':
				SVGPathSegLineToRel lineToRel = (SVGPathSegLineToRel) pathSeg; 
				return "l " + StringUtils.convertToWritable(lineToRel.getX()) + " " + StringUtils.convertToWritable(lineToRel.getY());
			case 'H':
				SVGPathSegLineToHorizontalAbs lineToHorizontalAbs = (SVGPathSegLineToHorizontalAbs) pathSeg;
				return "H " + StringUtils.convertToWritable(lineToHorizontalAbs.getX());
			case 'h':
				SVGPathSegLineToHorizontalRel lineToHorizontalRel = (SVGPathSegLineToHorizontalRel) pathSeg;
				return "h " + StringUtils.convertToWritable(lineToHorizontalRel.getX());
			case 'V':
				SVGPathSegLineToVerticalAbs lineToVerticalAbs = (SVGPathSegLineToVerticalAbs) pathSeg;
				return "V " + StringUtils.convertToWritable(lineToVerticalAbs.getY());
			case 'v':
				SVGPathSegLineToVerticalRel lineToVerticalRel = (SVGPathSegLineToVerticalRel) pathSeg;
				return "v " + StringUtils.convertToWritable(lineToVerticalRel.getY());
			case 'C':
				SVGPathSegCurveToCubicAbs curveToCubicAbs = (SVGPathSegCurveToCubicAbs) pathSeg;
				return "C " + StringUtils.convertToWritable(curveToCubicAbs.getX1()) + " " + StringUtils.convertToWritable(curveToCubicAbs.getY1()) + " " + 
					StringUtils.convertToWritable(curveToCubicAbs.getX2()) + " " + StringUtils.convertToWritable(curveToCubicAbs.getY2()) +
					" " + StringUtils.convertToWritable(curveToCubicAbs.getX()) + " " + StringUtils.convertToWritable(curveToCubicAbs.getY());
			case 'c':
				SVGPathSegCurveToCubicRel curveToCubicRel = (SVGPathSegCurveToCubicRel) pathSeg;
				return "c " + StringUtils.convertToWritable(curveToCubicRel.getX1()) + " " + StringUtils.convertToWritable(curveToCubicRel.getY1()) + " " + 
					StringUtils.convertToWritable(curveToCubicRel.getX2()) + " " + StringUtils.convertToWritable(curveToCubicRel.getY2()) +
					" " + StringUtils.convertToWritable(curveToCubicRel.getX()) + " " + StringUtils.convertToWritable(curveToCubicRel.getY());
			case 'S':
				SVGPathSegCurveToCubicSmoothAbs curveToCubicSmoothAbs = (SVGPathSegCurveToCubicSmoothAbs) pathSeg;
				return "S " + StringUtils.convertToWritable(curveToCubicSmoothAbs.getX2()) + " " + StringUtils.convertToWritable(curveToCubicSmoothAbs.getY2()) +
						" " + StringUtils.convertToWritable(curveToCubicSmoothAbs.getX()) + " " + StringUtils.convertToWritable(curveToCubicSmoothAbs.getY());
			case 's':
				SVGPathSegCurveToCubicSmoothRel curveToCubicSmoothRel = (SVGPathSegCurveToCubicSmoothRel) pathSeg;
				return "s " + StringUtils.convertToWritable(curveToCubicSmoothRel.getX2()) + " " + StringUtils.convertToWritable(curveToCubicSmoothRel.getY2()) +
						" " + StringUtils.convertToWritable(curveToCubicSmoothRel.getX()) + " " + StringUtils.convertToWritable(curveToCubicSmoothRel.getY());
			case 'Q':
				SVGPathSegCurveToQuadraticAbs curveToQuadraticAbs = (SVGPathSegCurveToQuadraticAbs) pathSeg;
				return "Q " + StringUtils.convertToWritable(curveToQuadraticAbs.getX1()) + " " + StringUtils.convertToWritable(curveToQuadraticAbs.getY1()) +
						" " + StringUtils.convertToWritable(curveToQuadraticAbs.getX()) + "  " + StringUtils.convertToWritable(curveToQuadraticAbs.getY());
			case 'q':
				SVGPathSegCurveToQuadraticRel curveToQuadraticRel = (SVGPathSegCurveToQuadraticRel) pathSeg;
				return "q " + StringUtils.convertToWritable(curveToQuadraticRel.getX1()) + " " + StringUtils.convertToWritable(curveToQuadraticRel.getY1()) +
						" " + StringUtils.convertToWritable(curveToQuadraticRel.getX()) + " " + StringUtils.convertToWritable(curveToQuadraticRel.getY());
			case 'T':
				SVGPathSegCurveToQuadraticSmoothAbs curveToQuadraticSmoothAbs = (SVGPathSegCurveToQuadraticSmoothAbs) pathSeg;
				return "T " + StringUtils.convertToWritable(curveToQuadraticSmoothAbs.getX()) + " " +
					StringUtils.convertToWritable(curveToQuadraticSmoothAbs.getY());
			case 't':
				SVGPathSegCurveToQuadraticSmoothRel curveToQuadraticSmoothRel = (SVGPathSegCurveToQuadraticSmoothRel) pathSeg;
				return "t " + StringUtils.convertToWritable(curveToQuadraticSmoothRel.getX()) + " " + 
						StringUtils.convertToWritable(curveToQuadraticSmoothRel.getY());
			case 'A':
				SVGPathSegArcAbs arcAbs = (SVGPathSegArcAbs) pathSeg;
				return "A " + StringUtils.convertToWritable(arcAbs.getR1()) + " " + StringUtils.convertToWritable(arcAbs.getR2()) + " " +
						StringUtils.convertToWritable(arcAbs.getAngle()) + " " + (arcAbs.getLargeArcFlag() ? 1 : 0) + " " + (arcAbs.getSweepFlag() ? 1 : 0) +
						" " + StringUtils.convertToWritable(arcAbs.getX()) + " " + StringUtils.convertToWritable(arcAbs.getY()); 
			case 'a':
				SVGPathSegArcRel arcRel = (SVGPathSegArcRel) pathSeg;
				return "a " + StringUtils.convertToWritable(arcRel.getR1()) + " " + StringUtils.convertToWritable(arcRel.getR2()) + " " +
						StringUtils.convertToWritable(arcRel.getAngle()) + " " + (arcRel.getLargeArcFlag() ? 1 : 0) + " " + (arcRel.getSweepFlag() ? 1 : 0) +
						" " + StringUtils.convertToWritable(arcRel.getX()) + " " + StringUtils.convertToWritable(arcRel.getY()); 
		}
		return SVGErrors.error("Invalid path seg type: " + pathSeg.getPathSegTypeAsLetter() + "(" + pathSeg.getPathSegType() + ")");
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
		ArrayList<SVGPathSeg> list = new ArrayList<>();
		if (!tokenizer.moreData()) {
			return list;
		}
		char type = tokenizer.readType();
		switch (type) {
			case 'z': case 'Z':
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
					System.out.println(lineToRel.getX());
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
