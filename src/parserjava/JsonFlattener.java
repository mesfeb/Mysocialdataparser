/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;

/**
 *
 * @author mes
 */
public class JsonFlattener {

    public Map<String, String> parse(JSONObject jsonObject) {
        Map<String, String> flatJson = new HashMap<String, String>();
        flatten(jsonObject, flatJson, "");
        return flatJson;
    }

    public List<Map<String, String>> parse(JSONArray jsonArray) {
        List<Map<String, String>> flatJson = new ArrayList<Map<String, String>>();
        int length = jsonArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Map<String, String> stringMap = parse(jsonObject);
            flatJson.add(stringMap);
        }
        return flatJson;
    }

    public List<Map<String, String>> parseJson(String json) throws Exception {
        List<Map<String, String>> flatJson = null;
        try {
            JSONObject jsonObject = new JSONObject(json);
            flatJson = new ArrayList<Map<String, String>>();
            flatJson.add(parse(jsonObject));
        } catch (JSONException je) {
            flatJson = handleAsArray(json);
        }
        return flatJson;
    }

    private List<Map<String, String>> handleAsArray(String json) throws Exception {
        List<Map<String, String>> flatJson = null;
        try {
            JSONArray jsonArray = new JSONArray(json);
            flatJson = parse(jsonArray);
        } catch (Exception e) {
            throw new Exception("Json might be malformed");
        }
        return flatJson;
    }

    private void flatten(JSONArray obj, Map<String, String> flatJson, String prefix) {

        int length = obj.length();
        String allarrayelement = "";
        for (int i = 0; i < length; i++) {
            if (obj.get(i).getClass() == JSONArray.class) {
                JSONArray jsonArray = (JSONArray) obj.get(i);
                if (jsonArray.length() < 1) {
                    continue;
                }
                flatten(jsonArray, flatJson, prefix + i);
            } else if (obj.get(i).getClass() == JSONObject.class) {
                JSONObject jsonObject = (JSONObject) obj.get(i);
                flatten(jsonObject, flatJson, prefix + (i + 1));
            } else {
                String value = obj.getString(i);
                allarrayelement += " " + value + " ";
            }
        }
        if (allarrayelement != null) {
            flatJson.put(prefix, allarrayelement);
        }
    }

    private void flatten(JSONObject obj, Map<String, String> flatJson, String prefix) {
        Iterator iterator = obj.keys();
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            if (obj.get(key).getClass() == JSONObject.class) {
                JSONObject jsonObject = (JSONObject) obj.get(key);
                Iterator iterator2 = jsonObject.keys();
                while (iterator2.hasNext()) {
                    String nestedkey = iterator2.next().toString();
                    String newkey = key + "_" + nestedkey;
                    if (!nestedkey.equals("boundingBox")) {
                    

                    if (jsonObject.get(nestedkey).getClass() == JSONObject.class) {

                        JSONObject jsonObject2 = (JSONObject) jsonObject.get(nestedkey);
                        jsonObject2.put(newkey, jsonObject2);
                        jsonObject2.remove(nestedkey);
                        flatten(jsonObject2, flatJson, prefix);
                    } else if (jsonObject.get(nestedkey).getClass() == JSONArray.class) {

                        JSONArray jsonArray2 = (JSONArray) obj.get(nestedkey);
                        if (jsonArray2.length() < 1) {
                            continue;
                        }

                        flatten(jsonArray2, flatJson, nestedkey);
                    } else {
                        String value2 = jsonObject.getString(nestedkey);
                        if (value2 != null && !value2.equals("null")) {
                            flatJson.put(prefix + newkey, value2);
                        } else {
                            flatJson.put(prefix + newkey, "");
                        }
                    }
                }
            else continue; }
            } else if (obj.get(key).getClass() == JSONArray.class) {
                JSONArray jsonArray = (JSONArray) obj.get(key);
                if (jsonArray.length() < 1) {
                    continue;
                }

                flatten(jsonArray, flatJson, key);
            } else {
                String value = obj.getString(key);
                if (value != null && !value.equals("null")) {
                    flatJson.put(prefix + key, value);
                } else {
                    flatJson.put(prefix + key, "");
                }
            }
        }
    }

}
