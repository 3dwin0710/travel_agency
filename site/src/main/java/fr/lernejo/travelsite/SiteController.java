package fr.lernejo.travelsite;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
//import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SiteController {

    @PostMapping("api/inscription")
    void savedata(@RequestBody String value){
        JsonObject Objetjson = new JsonParser().parse(value).getAsJsonObject();
        String userName = Objetjson.get("userName").getAsString();
        String userEmail = Objetjson.get("userEmail").getAsString();
        String userCountry = Objetjson.get("userCountry").getAsString();
        String weatherExpectation = Objetjson.get("weatherExpectation").getAsString();
        String minimumTemperatureDistance = Objetjson.get("minimumTemperatureDistance").getAsString();
        System.out.println(userName + " " + userEmail+" "+userCountry+" "+weatherExpectation+" "+minimumTemperatureDistance);

    }

    @GetMapping("/api/travels")
    public String getUser(@RequestParam String userName)
    {
        return userName;
    }


}
