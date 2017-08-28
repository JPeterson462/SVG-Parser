package org.w3c.dom.svg.parser.animation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.css.impl.StringUtils;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGNumberList;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.animation.SMILClockValue;
import org.w3c.dom.svg.animation.SMILTimingValue;
import org.w3c.dom.svg.animation.SMILTimingValueList;
import org.w3c.dom.svg.animation.SVGAnimateMotionElement;
import org.w3c.dom.svg.animation.SVGAnimateTransformElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;
import org.w3c.dom.svg.paths.SVGPathSegList;

public class SVGAnimateMotionElementParser implements ElementParser<SVGAnimateMotionElement> {

	private HashMap<String, Short> restart_strToEnum = new HashMap<>();
	private HashMap<Short, String> restart_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> fill_strToEnum = new HashMap<>();
	private HashMap<Short, String> fill_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> attributeType_strToEnum = new HashMap<>();
	private HashMap<Short, String> attributeType_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> calcMode_strToEnum = new HashMap<>();
	private HashMap<Short, String> calcMode_enumToStr = new HashMap<>();

	private HashMap<String, Short> additive_strToEnum = new HashMap<>();
	private HashMap<Short, String> additive_enumToStr = new HashMap<>();

	private HashMap<String, Short> accumulate_strToEnum = new HashMap<>();
	private HashMap<Short, String> accumulate_enumToStr = new HashMap<>();

	private HashMap<String, Short> transformType_strToEnum = new HashMap<>();
	private HashMap<Short, String> transformType_enumToStr = new HashMap<>();
	
	public SVGAnimateMotionElementParser() {
		restart_strToEnum.put("always", SVGAnimateTransformElement.RESTART_ALWAYS);
		restart_strToEnum.put("never", SVGAnimateTransformElement.RESTART_NEVER);
		restart_strToEnum.put("whenNotActive", SVGAnimateTransformElement.RESTART_WHENNOTACTIVE);
		restart_enumToStr.put(SVGAnimateTransformElement.RESTART_ALWAYS, "always");
		restart_enumToStr.put(SVGAnimateTransformElement.RESTART_NEVER, "never");
		restart_enumToStr.put(SVGAnimateTransformElement.RESTART_WHENNOTACTIVE, "whenNotActive");
		fill_strToEnum.put("freeze", SVGAnimateTransformElement.FILL_FREEZE);
		fill_strToEnum.put("remove", SVGAnimateTransformElement.FILL_REMOVE);
		fill_enumToStr.put(SVGAnimateTransformElement.FILL_FREEZE, "freeze");
		fill_enumToStr.put(SVGAnimateTransformElement.FILL_REMOVE, "remove");
		attributeType_strToEnum.put("auto", SVGAnimateTransformElement.ANIMATIONTARGET_AUTO);
		attributeType_strToEnum.put("CSS", SVGAnimateTransformElement.ANIMATIONTARGET_CSS);
		attributeType_strToEnum.put("XML", SVGAnimateTransformElement.ANIMATIONTARGET_XML);
		attributeType_enumToStr.put(SVGAnimateTransformElement.ANIMATIONTARGET_AUTO, "auto");
		attributeType_enumToStr.put(SVGAnimateTransformElement.ANIMATIONTARGET_CSS, "CSS");
		attributeType_enumToStr.put(SVGAnimateTransformElement.ANIMATIONTARGET_XML, "XML");
		calcMode_strToEnum.put("discrete", SVGAnimateTransformElement.CALCMODE_DISCRETE);
		calcMode_strToEnum.put("linear", SVGAnimateTransformElement.CALCMODE_LINEAR);
		calcMode_strToEnum.put("paced", SVGAnimateTransformElement.CALCMODE_PACED);
		calcMode_strToEnum.put("spline", SVGAnimateTransformElement.CALCMODE_SPLINE);
		calcMode_enumToStr.put(SVGAnimateTransformElement.CALCMODE_DISCRETE, "discrete");
		calcMode_enumToStr.put(SVGAnimateTransformElement.CALCMODE_LINEAR, "linear");
		calcMode_enumToStr.put(SVGAnimateTransformElement.CALCMODE_PACED, "paced");
		calcMode_enumToStr.put(SVGAnimateTransformElement.CALCMODE_SPLINE, "spline");
		additive_strToEnum.put("replace", SVGAnimateTransformElement.ADDITIVE_REPLACE);
		additive_strToEnum.put("sum", SVGAnimateTransformElement.ADDITIVE_SUM);
		additive_enumToStr.put(SVGAnimateTransformElement.ADDITIVE_REPLACE, "replace");
		additive_enumToStr.put(SVGAnimateTransformElement.ADDITIVE_SUM, "sum");
		accumulate_strToEnum.put("none", SVGAnimateTransformElement.ACCUMULATE_NONE);
		accumulate_strToEnum.put("sum", SVGAnimateTransformElement.ACCUMULATE_SUM);
		accumulate_enumToStr.put(SVGAnimateTransformElement.ACCUMULATE_NONE, "none");
		accumulate_enumToStr.put(SVGAnimateTransformElement.ACCUMULATE_SUM, "sum");
		transformType_strToEnum.put("rotate", SVGAnimateTransformElement.TRANSFORMTYPE_ROTATE);
		transformType_strToEnum.put("scale", SVGAnimateTransformElement.TRANSFORMTYPE_SCALE);
		transformType_strToEnum.put("skewX", SVGAnimateTransformElement.TRANSFORMTYPE_SKEWX);
		transformType_strToEnum.put("skewY", SVGAnimateTransformElement.TRANSFORMTYPE_SKEWY);
		transformType_strToEnum.put("translate", SVGAnimateTransformElement.TRANSFORMTYPE_TRANSLATE);
		transformType_enumToStr.put(SVGAnimateTransformElement.TRANSFORMTYPE_ROTATE, "rotate");
		transformType_enumToStr.put(SVGAnimateTransformElement.TRANSFORMTYPE_SCALE, "scale");
		transformType_enumToStr.put(SVGAnimateTransformElement.TRANSFORMTYPE_SKEWX, "skewX");
		transformType_enumToStr.put(SVGAnimateTransformElement.TRANSFORMTYPE_SKEWY, "skewY");
		transformType_enumToStr.put(SVGAnimateTransformElement.TRANSFORMTYPE_TRANSLATE, "translate");
	}
	
	@Override
	public SVGAnimateMotionElement readElement(Element element, ParsingState parsingState) {
		String id = element.getAttribute(Attributes.ID);
		String xmlBase = element.getAttribute(Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		SVGStringList requiredFeatures = ElementParser.concatenate(element.getAttribute(Attributes.REQUIRED_FEATURES).split(" "));
		SVGStringList requiredExtensions = ElementParser.concatenate(element.getAttribute(Attributes.REQUIRED_EXTENSIONS).split(" "));
		SVGStringList systemLanguage = ElementParser.concatenate(element.getAttribute(Attributes.SYSTEM_LANGUAGE).split(" "));
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		String onBegin = ElementParser.readOrDefault(element, Attributes.ON_BEGIN, "");
		String onEnd = ElementParser.readOrDefault(element, Attributes.ON_END, "");
		String onLoad = ElementParser.readOrDefault(element, Attributes.ON_LOAD, "");
		String onRepeat = ElementParser.readOrDefault(element, Attributes.ON_REPEAT, "");
		String beginStr = element.getAttribute(Attributes.BEGIN);
		SMILTimingValueList begin = null;
		if (beginStr != null) {
			String[] listed = beginStr.split(";");
			ArrayList<SMILTimingValue> values = new ArrayList<>();
			for (int i = 0; i < listed.length; i++) {
				values.add(SMILTimingValue.createTimingValue(listed[i].trim()));
			}
			begin = new SMILTimingValueList.Implementation(values);
		}
		String durationStr = ElementParser.readOrDefault(element, Attributes.DUR, "indefinite");
		SMILClockValue duration = new SMILClockValue.Implementation(SMILClockValue.INDEFINITE_MEDIA);
		duration.setValue(durationStr);
		String endStr = element.getAttribute(Attributes.END);
		SMILTimingValueList end = null;
		if (endStr != null) {
			String[] listed = endStr.split(";");
			ArrayList<SMILTimingValue> values = new ArrayList<>();
			for (int i = 0; i < listed.length; i++) {
				values.add(SMILTimingValue.createTimingValue(listed[i].trim()));
			}
			end = new SMILTimingValueList.Implementation(values);
		}
		String minStr = ElementParser.readOrDefault(element, Attributes.MIN, "0");
		SMILClockValue min = new SMILClockValue.Implementation(SMILClockValue.MEDIA);
		min.setValue(minStr);
		String maxStr = element.getAttribute(Attributes.MAX);
		SMILClockValue max = null;
		if (maxStr != null) {
			max = new SMILClockValue.Implementation(SMILClockValue.MEDIA);
			max.setValue(maxStr);
		}
		String restartStr = ElementParser.readOrDefault(element, Attributes.RESTART, "always");
		short restart = restart_strToEnum.get(restartStr);
		String repeatCountStr = ElementParser.readOrDefault(element, Attributes.REPEAT_COUNT, "indefinite");
		boolean repeatIndefinite = repeatCountStr.equals("indefinite");
		SVGNumber repeatCount = null;
		if (!repeatIndefinite) {
			repeatCount = new SVGNumber.Implementation(Float.parseFloat(repeatCountStr));
		}
		String repeatDurStr = element.getAttribute(Attributes.REPEAT_DUR);
		SMILClockValue repeatDuration = null;
		if (repeatDurStr != null) {
			repeatDuration = new SMILClockValue.Implementation(SMILClockValue.INDEFINITE);
			repeatDuration.setValue(repeatDurStr);
		}
		String fillStr = ElementParser.readOrDefault(element, Attributes.FILL, "remove");
		short fill = fill_strToEnum.get(fillStr); 
		String calcModeStr = ElementParser.readOrDefault(element, Attributes.CALC_MODE, "linear");
		short calcMode = calcMode_strToEnum.get(calcModeStr);
		String additiveStr = ElementParser.readOrDefault(element, Attributes.ADDITIVE, "replace");
		short additive = additive_strToEnum.get(additiveStr);
		String accumulateStr = ElementParser.readOrDefault(element, Attributes.ACCUMULATE, "none");
		short accumulate = accumulate_strToEnum.get(accumulateStr);
		SVGStringList values = new SVGStringList.Implementation(Arrays.asList(element.getAttribute(Attributes.VALUES).split(";")));
		SVGStringList keyTimes = new SVGStringList.Implementation(Arrays.asList(element.getAttribute(Attributes.KEY_TIMES).split(";")));
		String keySplinesStr = element.getAttribute(Attributes.KEY_SPLINES);
		List<String> keySplinesValues;
		if (keySplinesStr.contains(",")) {
			keySplinesValues = Arrays.asList(keySplinesStr.split(","));
		} else {
			keySplinesValues = StringUtils.splitByWhitespace(keySplinesStr);
		}
		for (int i = keySplinesValues.size() - 1; i >= 0; i--) {
			keySplinesValues.set(i, keySplinesValues.get(i).trim());
		}
		SVGStringList keySplines = new SVGStringList.Implementation(keySplinesValues);
		String from = element.getAttribute(Attributes.FROM);
		String to = element.getAttribute(Attributes.TO);
		String by = element.getAttribute(Attributes.BY);
		String rotateStr = ElementParser.readOrDefault(element, Attributes.ROTATE, "0");
		boolean rotateAuto = rotateStr.contains("auto"), rotateReverse = rotateStr.contains("reverse");
		SVGNumber rotate = null;
		if (!rotateAuto && !rotateReverse) {
			rotate = new SVGNumber.Implementation(Float.parseFloat(rotateStr));
		}
		String origin = element.getAttribute(Attributes.ORIGIN);
		SVGPathSegList path = ElementParser.parsePathSegList(element.getAttribute(Attributes.PATH));
		String keyPointsStr = element.getAttribute(Attributes.KEY_POINTS);
		SVGNumberList keyPoints = null;
		if (keyPointsStr != null) {
			String[] keyPointsParts = keyPointsStr.split(";");
			ArrayList<SVGNumber> keyPointsList = new ArrayList<>();
			for (int i = 0; i < keyPointsParts.length; i++) {
				keyPointsList.add(new SVGNumber.Implementation(Float.parseFloat(keyPointsParts[i].trim())));
			}
			keyPoints = new SVGNumberList.Implementation(keyPointsList);
		}
		return new SVGAnimateMotionElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, 
				requiredFeatures, requiredExtensions, systemLanguage, externalResourcesRequired, null, 
				onBegin, onEnd, onRepeat, onLoad, begin, duration, end, min, max, restart, repeatCount, 
				repeatIndefinite, repeatDuration, fill, calcMode, additive, accumulate, path, keyPoints, 
				rotate, rotateAuto, rotateReverse, origin, values, keyTimes, keySplines, from, to, by);
	}

	@Override
	public Element writeElement(SVGAnimateMotionElement element, ElementFactory factory) {
		HashMap<String, String> attributes = new HashMap<>();
		attributes.put(Attributes.ID, element.getID());
		attributes.put(Attributes.XML_BASE, element.getXMLBase());
		attributes.put(Attributes.REQUIRED_FEATURES, ElementParser.join(element.getRequiredFeatures(), " "));
		attributes.put(Attributes.REQUIRED_EXTENSIONS, ElementParser.join(element.getRequiredExtensions(), " "));
		attributes.put(Attributes.SYSTEM_LANGUAGE, ElementParser.join(element.getSystemLanguage(), " "));
		attributes.put(Attributes.EXTERNAL_RESOURCES_REQUIRED, element.getExternalResourcesRequired().getBaseValue().toString());
		attributes.put(Attributes.ON_BEGIN, element.getOnBegin());
		attributes.put(Attributes.ON_END, element.getOnEnd());
		attributes.put(Attributes.ON_LOAD, element.getOnLoad());
		attributes.put(Attributes.ON_REPEAT, element.getOnRepeat());
		attributes.put(Attributes.BEGIN, ElementParser.concatenate(element.getBegin(), ";"));
		attributes.put(Attributes.DUR, element.getDuration().getValue());
		attributes.put(Attributes.END, ElementParser.concatenate(element.getEnd(), ";"));
		attributes.put(Attributes.MIN, element.getMin().getValue());
		attributes.put(Attributes.MAX, element.getMax().getValue());
		attributes.put(Attributes.RESTART, restart_enumToStr.get(element.getRestart()));
		attributes.put(Attributes.REPEAT_COUNT, element.isRepeatIndefinite() ? "indefinite" : Float.toString(element.getRepeatCount().getValue()));
		attributes.put(Attributes.REPEAT_DUR, element.getRepeatDuration().getValue());
		attributes.put(Attributes.FILL, fill_enumToStr.get(element.getFill()));
		attributes.put(Attributes.CALC_MODE, calcMode_enumToStr.get(element.getCalcMode()));
		attributes.put(Attributes.ADDITIVE, additive_enumToStr.get(element.getAdditive()));
		attributes.put(Attributes.ACCUMULATE, accumulate_enumToStr.get(element.getAccumulate()));
		attributes.put(Attributes.VALUES, ElementParser.concatenate(element.getValues(), ";"));
		attributes.put(Attributes.KEY_TIMES, ElementParser.concatenate(element.getKeyTimes(), ";"));
		attributes.put(Attributes.KEY_SPLINES, ElementParser.concatenate(element.getKeySplines(), ","));
		attributes.put(Attributes.FROM, element.getFrom());
		attributes.put(Attributes.TO, element.getTo());
		attributes.put(Attributes.BY, element.getBy());
		attributes.put(Attributes.PATH, ElementParser.join(element.getPath(), " "));
		attributes.put(Attributes.KEY_POINTS, ElementParser.concatenate(element.getKeyPoints(), ";"));
		attributes.put(Attributes.ROTATE, element.isRotateAuto() ? (element.isRotateReverse() ? "auto-reverse" : "auto") : Float.toString(element.getRotate().getValue()));
		attributes.put(Attributes.ORIGIN, element.getOrigin());
		return factory.createElement(Tags.ANIMATE_MOTION, attributes);
	}

}
