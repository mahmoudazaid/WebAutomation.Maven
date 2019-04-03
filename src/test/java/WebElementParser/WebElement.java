package WebElementParser;

public class WebElement {
    private String Name;
    private String Value;
    private String Locator;

    public String getName() {
        return Name;
    }
    public void setName(String newName) {
        this.Name= newName;
    }

    public String getValue() {
        return Value;
    }
    public void setValue(String newValue) {
        this.Value= newValue;
    }

    public String getLocator() {
        return Name;
    }
    public void setLocator(String newLocator) {
        this.Locator= newLocator;
    }
}
