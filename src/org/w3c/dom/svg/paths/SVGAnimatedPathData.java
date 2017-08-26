package org.w3c.dom.svg.paths;

public interface SVGAnimatedPathData {
	
	public SVGPathSegList getPathSegList();
	
	public SVGPathSegList getNormalizedPathSegList();
	
	public SVGPathSegList getAnimatedPathSegList();
	
	public SVGPathSegList getAnimatedNormalizedPathSegList();
	
	public static class Implementation implements SVGAnimatedPathData {

		private SVGPathSegList pathSegList, normalizedPathSegList, animatedPathSegList, animatedNormalizedPathSegList;
		
		public Implementation(SVGPathSegList pathSegList, SVGPathSegList normalizedPathSegList,
				SVGPathSegList animatedPathSegList, SVGPathSegList animatedNormalizedPathSegList) {
			this.pathSegList = pathSegList;
			this.normalizedPathSegList = normalizedPathSegList;
			if (animatedPathSegList == pathSegList) {
				this.animatedPathSegList = new SVGPathSegList.Implementation(pathSegList);
			} else {
				this.animatedPathSegList = animatedPathSegList;
			}
			if (animatedNormalizedPathSegList == normalizedPathSegList) {
				this.animatedNormalizedPathSegList = new SVGPathSegList.Implementation(normalizedPathSegList);
			} else {
				this.animatedNormalizedPathSegList = animatedNormalizedPathSegList;
			}
		}

		@Override
		public SVGPathSegList getPathSegList() {
			return pathSegList;
		}

		@Override
		public SVGPathSegList getNormalizedPathSegList() {
			return normalizedPathSegList;
		}

		@Override
		public SVGPathSegList getAnimatedPathSegList() {
			return animatedPathSegList;
		}

		@Override
		public SVGPathSegList getAnimatedNormalizedPathSegList() {
			return animatedNormalizedPathSegList;
		}
		
	}

}
