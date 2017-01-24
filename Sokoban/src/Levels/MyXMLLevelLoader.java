package Levels;

import javax.xml.parsers.FactoryConfigurationError;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class MyXMLLevelLoader implements LevelLoader{
		public void loadLevel() {

			XMLReader parser;

			Level l = null;
			try  {
				SAXParserFactory factory;
				
				factory = SAXParserFactory.newInstance ();
			    factory.setNamespaceAware (true);
			    parser = factory.newSAXParser ().getXMLReader ();
			    // success!

			} catch (FactoryConfigurationError err) {
			    System.err.println ("can't create JAXP SAXParserFactory, "
				+ err.getMessage ());
			} catch (ParserConfigurationException err) {
			    System.err.println ("can't create XMLReader with namespaces, "
				+ err.getMessage ());
			} catch (SAXException err) {
			    System.err.println ("Hmm, SAXException, " + err.getMessage ());
			}

				
			}

}
