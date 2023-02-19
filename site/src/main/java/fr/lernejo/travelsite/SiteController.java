package fr.lernejo.travelsite;

import com.google.gson.Gson;
import org.json.JSONObject;

import com.google.gson.JsonObject;

//import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class SiteController {

    @PostMapping("/api/inscription")
    void savedata(@RequestBody String value){
        Gson gson = new Gson();
        JsonObject objetJson = gson.fromJson(value, JsonObject.class);
        String userName = objetJson.get("userName").getAsString();
        String userEmail = objetJson.get("userEmail").getAsString();
        String userCountry = objetJson.get("userCountry").getAsString();
        String weatherExpectation = objetJson.get("weatherExpectation").getAsString();
        int minimumTemperatureDistance = objetJson.get("minimumTemperatureDistance").getAsInt();
        System.out.println(userName+" "+userEmail+" "+userCountry + " " +weatherExpectation+" "+minimumTemperatureDistance+" ");

    }

    @GetMapping("/api/travels")
    public String getUser(@RequestParam String userName)
    {

        return userName;
    }


}
