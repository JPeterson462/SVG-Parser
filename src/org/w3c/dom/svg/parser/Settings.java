package org.w3c.dom.svg.parser;

/**
 * This class is for settings that don't relate to the specification but rather weird implementations
 */
public class Settings {
	
	/**
	 * On Firefox, writing the gaussian blur dimensions causes rendering to be buggy.
	 * <br>
	 * Setting this to true will write those values.
	 * <br>
	 * The default is false to allow the parser to work on Firefox.
	 */
	public static boolean WRITE_GAUSSIANBLUR_DIMENSIONS = false;

}
