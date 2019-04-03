package WebElementParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;
import java.util.Dictionary;
import java.util.List;

public class ElementParser<T> {
    public Dictionary<String, By> Elements;
    public List<WebElement> AllElementDetails;
    private Class<T> type;

    public Dictionary<String, By> getElements()
    {
        return Elements;
    }

    public void setElements(Dictionary<String, By> newElements)
    {
        this.Elements=newElements;
    }

    public List<WebElement> getAllElementDetailes() {
        return AllElementDetails;
    }

    public void getAllElementDetailed(List<WebElement> newAllElementDetailed){
        this.AllElementDetails=newAllElementDetailed;
    }

    private T DeserializeWebElements(String fileName)throws IOException {
        System.out.println("parse json object to entity Object");
        ObjectMapper mapper = new ObjectMapper();
        T elements = mapper.readValue(fileName, type);
        return elements;
    }
}
