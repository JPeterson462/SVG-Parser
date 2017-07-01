package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.digiturtle.xml.Element;
import com.digiturtle.xml.XMLParser;

public class TestXML {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		XMLParser parser = new XMLParser();
		Element tree = parser.parseTree(new BufferedReader(new InputStreamReader(new FileInputStream("duke.svg"))));
		System.out.println(tree);
	}

}
