package org.w3c.dom.svg;

import java.util.HashMap;
import java.util.HashSet;

public class SVGExtensionManager {
	
	private static HashMap<Integer, SVGExtensionManager> managers = new HashMap<>();
	
	public static final int DEFAULT_MANAGER = 1;
	
	public static void registerInstance(int id) {
		managers.put(id, new SVGExtensionManager());
	}
	
	public static SVGExtensionManager getInstance(int id) {
		return managers.get(id);
	}
	
	private HashSet<String> extensions = new HashSet<>();
	
	public void enableExtension(String extension) {
		extensions.add(extension);
	}
	
	public void disableExtension(String extension) {
		extensions.remove(extension);
	}
	
	public boolean hasExtension(String extension) {
		return extensions.contains(extension);
	}

}
