package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;


public class JsonReader {

    public static HashMap<String, String> getMapFromJson(String filePath, String testCaseId) {

        String jsonFile = filePath;

        JSONParser jsonParser = new JSONParser();
        Object obj;
        HashMap<String, String> testCaseValues = new HashMap<String, String>();
        try {
            obj = jsonParser.parse(new FileReader(jsonFile));
            JSONObject jsonObject = (JSONObject) obj;
            Object tc = jsonObject.get(testCaseId);
            String[] abc = tc.toString().replace("\":\"", "\"::\"").replace("{", "").replace("}", "").replace("\\", "").split("\",\"");
            for (String a : abc) {
                String[] mapValues = a.split("::");
                if (mapValues.length > 1)
                    testCaseValues.put(mapValues[0].replace("\"", ""), mapValues[1].replace("\"", ""));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return testCaseValues;
    }
}
