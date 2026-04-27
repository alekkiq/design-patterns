package facade;

import java.io.IOException;
import java.net.URL;

public class ApiFacade {
    private ApiService apiService;
    private JSONService jsonService;

    public ApiFacade() {
        this.apiService = new ApiService();
        this.jsonService = new JSONService();
    }

    public String getAttributeValueFromJson(String urlString, String attributeName)
            throws IllegalArgumentException, IOException {
        String json = this.apiService.getJson(urlString);
        return this.jsonService.getAttribute(json, attributeName);
    }
}
