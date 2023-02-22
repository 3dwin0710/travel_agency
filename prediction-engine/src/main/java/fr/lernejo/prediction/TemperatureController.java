package fr.lernejo.prediction;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TemperatureController {

    private final List<String> list_of_data = new ArrayList<>();
    private final long Date_Today =System.currentTimeMillis();
    private final long Date_Yesterday = System.currentTimeMillis()- 1000L * 60L * 60L * 24L;


    public String newFeatures(String Pays, List<String> list){
        String newFeatures = "{\n\t\"country\": \""+Pays+"\",\n\t\"temperatures\": "+list+"\n\t \n}";
        return newFeatures;

    }
    @GetMapping("/api/temperature")
    public String getCountry(@RequestParam String country)
    {
        java.sql.Date date = new java.sql.Date(Date_Today);
        java.sql.Date yesterday =  new java.sql.Date(Date_Yesterday);
        TemperatureService service = new TemperatureService();
        String prefeature = "\n\t\t{\n\t\t\t\"date\":\""+date+"\",\n\t\t\t\"temperature\": "+service.getTemperature(country)+"\n\t\t}";
        String prefeaturas = "\n\t\t{\n\t\t\t\"date\":\""+yesterday+"\",\n\t\t\t\"temperature\": "+service.getTemperature(country)+"\n\t\t}\n\n\t";
        list_of_data.add(prefeature);
        list_of_data.add(prefeaturas);
        return newFeatures(country,list_of_data);
    }




}
