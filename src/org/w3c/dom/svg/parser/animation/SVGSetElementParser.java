package org.w3c.dom.svg.parser.animation;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Element;
import org.w3c.dom.svg.SVGAnimatedBoolean;
import org.w3c.dom.svg.SVGElement;
import org.w3c.dom.svg.SVGNumber;
import org.w3c.dom.svg.SVGStringList;
import org.w3c.dom.svg.animation.SMILClockValue;
import org.w3c.dom.svg.animation.SMILTimingValue;
import org.w3c.dom.svg.animation.SMILTimingValueList;
import org.w3c.dom.svg.animation.SVGSetElement;
import org.w3c.dom.svg.document.SVGSVGElement;
import org.w3c.dom.svg.parser.Attributes;
import org.w3c.dom.svg.parser.ElementFactory;
import org.w3c.dom.svg.parser.ElementParser;
import org.w3c.dom.svg.parser.ParsingState;
import org.w3c.dom.svg.parser.Tags;

public class SVGSetElementParser implements ElementParser<SVGSetElement> {

	private HashMap<String, Short> restart_strToEnum = new HashMap<>();
	private HashMap<Short, String> restart_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> fill_strToEnum = new HashMap<>();
	private HashMap<Short, String> fill_enumToStr = new HashMap<>();
	
	private HashMap<String, Short> attributeType_strToEnum = new HashMap<>();
	private HashMap<Short, String> attributeType_enumToStr = new HashMap<>();
	
	public SVGSetElementParser() {
		restart_strToEnum.put("always", SVGSetElement.RESTART_ALWAYS);
		restart_strToEnum.put("never", SVGSetElement.RESTART_NEVER);
		restart_strToEnum.put("whenNotActive", SVGSetElement.RESTART_WHENNOTACTIVE);
		restart_enumToStr.put(SVGSetElement.RESTART_ALWAYS, "always");
		restart_enumToStr.put(SVGSetElement.RESTART_NEVER, "never");
		restart_enumToStr.put(SVGSetElement.RESTART_WHENNOTACTIVE, "whenNotActive");
		fill_strToEnum.put("freeze", SVGSetElement.FILL_FREEZE);
		fill_strToEnum.put("remove", SVGSetElement.FILL_REMOVE);
		fill_enumToStr.put(SVGSetElement.FILL_FREEZE, "freeze");
		fill_enumToStr.put(SVGSetElement.FILL_REMOVE, "remove");
		attributeType_strToEnum.put("auto", SVGSetElement.ANIMATIONTARGET_AUTO);
		attributeType_strToEnum.put("CSS", SVGSetElement.ANIMATIONTARGET_CSS);
		attributeType_strToEnum.put("XML", SVGSetElement.ANIMATIONTARGET_XML);
		attributeType_enumToStr.put(SVGSetElement.ANIMATIONTARGET_AUTO, "auto");
		attributeType_enumToStr.put(SVGSetElement.ANIMATIONTARGET_CSS, "CSS");
		attributeType_enumToStr.put(SVGSetElement.ANIMATIONTARGET_XML, "XML");
	}
	
	@Override
	public SVGSetElement readElement(Element element, ParsingState parsingState) {
		String id = ElementParser.read(element, Attributes.ID);
		String xmlBase = ElementParser.read(element, Attributes.XML_BASE);
		SVGSVGElement ownerSVGElement = parsingState.getOwnerSVGElement();
		SVGElement viewportElement = parsingState.getViewportElement();
		SVGStringList requiredFeatures = ElementParser.readOrNull(element, Attributes.REQUIRED_FEATURES, " ", true);
		SVGStringList requiredExtensions = ElementParser.readOrNull(element, Attributes.REQUIRED_EXTENSIONS, " ", true);
		SVGStringList systemLanguage = ElementParser.readOrNull(element, Attributes.SYSTEM_LANGUAGE, " ", true);
		boolean externalResourcesRequiredAsBoolean = Boolean.parseBoolean(ElementParser.readOrDefault(element, Attributes.EXTERNAL_RESOURCES_REQUIRED, Boolean.toString(false)));
		SVGAnimatedBoolean externalResourcesRequired = new SVGAnimatedBoolean.Implementation(externalResourcesRequiredAsBoolean, externalResourcesRequiredAsBoolean);
		String onBegin = ElementParser.readOrDefault(element, Attributes.ON_BEGIN, "");
		String onEnd = ElementParser.readOrDefault(element, Attributes.ON_END, "");
		String onLoad = ElementParser.readOrDefault(element, Attributes.ON_LOAD, "");
		String onRepeat = ElementParser.readOrDefault(element, Attributes.ON_REPEAT, "");
		String attributeTypeStr = ElementParser.readOrDefault(element, Attributes.ATTRIBUTE_TYPE, "auto");
		short attributeType = attributeType_strToEnum.get(attributeTypeStr);
		String attributeName = ElementParser.read(element, Attributes.ATTRIBUTE_NAME);
		String beginStr = ElementParser.read(element, Attributes.BEGIN);
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
		String endStr = ElementParser.read(element, Attributes.END);
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
		String maxStr = ElementParser.read(element, Attributes.MAX);
		SMILClockValue max = null;
		if (maxStr != null && maxStr.length() > 0) {
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
		String repeatDurStr = ElementParser.read(element, Attributes.REPEAT_DUR);
		SMILClockValue repeatDuration = null;
		if (repeatDurStr != null && repeatDurStr.length() > 0) {
			repeatDuration = new SMILClockValue.Implementation(SMILClockValue.INDEFINITE);
			repeatDuration.setValue(repeatDurStr);
		}
		String fillStr = ElementParser.readOrDefault(element, Attributes.FILL, "remove");
		short fill = fill_strToEnum.get(fillStr); 
		String to = ElementParser.read(element, Attributes.TO);
		return new SVGSetElement.Implementation(id, xmlBase, ownerSVGElement, viewportElement, requiredFeatures,
				requiredExtensions, systemLanguage, externalResourcesRequired, null, onBegin, onEnd,
				onRepeat, onLoad, attributeType, attributeName, begin, duration, end, min, max, restart,
				repeatCount, repeatIndefinite, repeatDuration, fill, to);
	}

	@Override
	public Element writeElement(SVGSetElement element, ElementFactory factory) {
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
		attributes.put(Attributes.ATTRIBUTE_TYPE, attributeType_enumToStr.get(element.getAttributeType()));
		attributes.put(Attributes.ATTRIBUTE_NAME, element.getAttributeName());
		attributes.put(Attributes.BEGIN, ElementParser.concatenate(element.getBegin(), ";"));
		attributes.put(Attributes.DUR, element.getDuration().getValue());
		attributes.put(Attributes.END, ElementParser.concatenate(element.getEnd(), ";"));
		attributes.put(Attributes.MIN, element.getMin().getValue());
		if (element.getMax() != null) {
			attributes.put(Attributes.MAX, element.getMax().getValue());
		}
		attributes.put(Attributes.RESTART, restart_enumToStr.get(element.getRestart()));
		attributes.put(Attributes.REPEAT_COUNT, element.isRepeatIndefinite() ? "indefinite" : Float.toString(element.getRepeatCount().getValue()));
		if (element.getRepeatDuration() != null) {
			attributes.put(Attributes.REPEAT_DUR, element.getRepeatDuration().getValue());
		}
		attributes.put(Attributes.FILL, fill_enumToStr.get(element.getFill()));
		attributes.put(Attributes.TO, element.getTo());
		return factory.createElement(Tags.SET, attributes);
	}

}
