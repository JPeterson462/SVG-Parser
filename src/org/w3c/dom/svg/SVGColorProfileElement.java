package org.w3c.dom.svg;

import org.w3c.dom.svg.document.SVGSVGElement;

public interface SVGColorProfileElement extends SVGElement, SVGURIReference, SVGRenderingIntent {

	public String getLocal();
	
	public void setLocal(String local);
	
	public String getName();
	
	public void setName(String name);
	
	public short getRenderingIntent();
	
	public void setRenderingIntent(short renderingIntent);
	
	public static class Implementation extends SVGElement.Implementation implements SVGColorProfileElement {

		private SVGAnimatedString href;
		
		private String local, name;
		
		private short renderingIntent;
		
		public Implementation(String id, String xmlBase, SVGSVGElement ownerSVGElement, SVGElement viewportElement,
				SVGAnimatedString href,
				String local, String name, short renderingIntent) {
			super(id, xmlBase, ownerSVGElement, viewportElement);
			this.href = href;
			this.local = local;
			this.name = name;
			this.renderingIntent = renderingIntent;
		}

		@Override
		public SVGAnimatedString getHref() {
			return href;
		}

		@Override
		public String getLocal() {
			return local;
		}

		@Override
		public void setLocal(String local) {
			this.local = local;
		}

		@Override
		public String getName() {
			return name;
		}

		@Override
		public void setName(String name) {
			this.name = name;
		}

		@Override
		public short getRenderingIntent() {
			return renderingIntent;
		}

		@Override
		public void setRenderingIntent(short renderingIntent) {
			this.renderingIntent = renderingIntent;
		}
		
	}
	
}
