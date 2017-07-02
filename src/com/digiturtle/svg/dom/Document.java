package com.digiturtle.svg.dom;

public class Document {
	
	private String title, referrer, domain, url;
	
	private SVGElement rootElement;

	public Document(String title, String referrer, String domain, String url, SVGElement rootElement) {
		this.title = title;
		this.referrer = referrer;
		this.domain = domain;
		this.url = url;
		this.rootElement = rootElement;
	}

	public String getTitle() {
		return title;
	}

	public String getReferrer() {
		return referrer;
	}

	public String getDomain() {
		return domain;
	}

	public String getUrl() {
		return url;
	}

	public SVGElement getRootElement() {
		return rootElement;
	}

}
