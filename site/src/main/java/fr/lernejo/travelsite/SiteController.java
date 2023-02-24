package fr.lernejo.travelsite;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.web.bind.annotation.*;

@RestController
public class SiteController {


    @PostMapping("/api/inscription")
    void savedata(@RequestBody String value){
        Gson gson = new Gson();
        JsonObject Objetjson = gson.fromJson(value, JsonObject.class);
        String userName = Objetjson.get("userName").getAsString();
        String userEmail = Objetjson.get("userEmail").getAsString();
        String userCountry = Objetjson.get("userCountry").getAsString();
        String weatherExpectation = Objetjson.get("weatherExpectation").getAsString();
        String minimumTemperatureDistance = Objetjson.get("minimumTemperatureDistance").getAsString();
        System.out.println(userName+" "+userEmail+" "+userCountry +" " +weatherExpectation+" "+minimumTemperatureDistance+" ");


    }

    @GetMapping("/api/travels")
    public String getUser(@RequestParam String userName)
    {
        // Fixed data
        String Country = "France";
        double Temperature = 23.4;
        String AnotherCountry = "Allemagne";
        double AnotherTemperature = 7.7;
        return "[\n\t{\"country\": \""+Country+"\",\"temperature\": "+Temperature+" }, {\"country\": \""+AnotherCountry+"\",\"temperature\": "+AnotherTemperature+"}]";
    }


}
