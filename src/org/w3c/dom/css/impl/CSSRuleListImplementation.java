package org.w3c.dom.css.impl;

import java.util.ArrayList;

import org.w3c.dom.css.CSSRule;
import org.w3c.dom.css.CSSRuleList;

public class CSSRuleListImplementation implements CSSRuleList {
	
	private ArrayList<CSSRule> rules;
	
	public CSSRuleListImplementation(ArrayList<CSSRule> rules) {
		this.rules = rules;
	}
	
	public void insertRule(int index, CSSRule rule) {
		rules.add(index, rule);
	}
	
	public void removeRule(int index) {
		rules.remove(index);
	}

	@Override
	public int getLength() {
		return rules.size();
	}

	@Override
	public CSSRule item(int index) {
		return rules.get(index);
	}

}
