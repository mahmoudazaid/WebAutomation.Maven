package utilities;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonReader {
    public String firstName, lastName, email, password;

    public void LoadJson() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "Data/UserData.json";
        File scrFile = new File(filePath);

        JSONParser parser = new JSONParser();
        JSONArray jarray = (JSONArray) parser.parse(new FileReader(scrFile));

        for (Object jsonObject : jarray) {
            JSONObject person = (JSONObject) jsonObject;
            firstName =(String)person.get("firstName");
            System.out.println(firstName);

            lastName=(String)person.get("lastName");
            System.out.println(lastName);

            email=(String)person.get("email");
            System.out.println(email);

            password=(String)person.get("password");
            System.out.println(password);
        }
    }
}
