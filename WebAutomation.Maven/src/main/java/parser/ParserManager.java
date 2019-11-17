package parser;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import java.io.IOException;
import java.util.ArrayList;

public class ParserManager {

    private ArrayList<ElementParser> parsers;

    public ParserManager(String[] filesNames) throws IOException, ParseException {
        Initialize(filesNames);
    }

    private void Initialize(String[] filesNames) throws IOException, ParseException {
        parsers = new ArrayList<ElementParser>();
        for (String fileName : filesNames) {
            parsers.add(new ElementParser(fileName));
        }
    }

    public By getElementDetails(String name) throws IOException, ParseException {
        By myElement = null;
        for (ElementParser parser : parsers) {
            myElement = parser.getElementDetails(name);
        }
        return myElement;
    }
}
