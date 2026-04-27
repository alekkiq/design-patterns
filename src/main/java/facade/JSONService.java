package facade;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONService {
    public String getAttribute(String json, String attributeName) {
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(json);

            Object value = jsonObject.get(attributeName);

            if (value == null) {
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in JSON");
            }

            return value.toString();
        } catch (Exception e) {
            throw new IllegalArgumentException("Error parsing JSON: " + e.getMessage(), e);
        }
    }
}
