package fr.lernejo.prediction;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.assertTrue;


class TemperatureControllerTest {


    @Test
    void Verify_Solution() throws JSONException {
        TemperatureController temperatureController = new TemperatureController();
        String verification = temperatureController.getCountry("France");
        assertTrue("Structure Températures attendues", verification.contains("\"temperature\""));
        assertTrue("Structure Date attendues", verification.contains("\"date\""));
        assertTrue("Pays attendues", verification.contains("\"France\""));
        assertTrue("Erreur sur le format",verification.endsWith("}"));
        assertTrue("Erreur sur le format",verification.startsWith("{"));
        JSONObject json = new JSONObject(verification);
        int test_temperature_date = json.getJSONArray("temperatures").length();
        assertTrue("Attention! Que des données des 2 derniers jours",test_temperature_date==2);
        System.out.println(verification);
    }


}
