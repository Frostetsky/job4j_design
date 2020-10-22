package ru.job4j.chapter_005.SRP;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HTMLParser implements Formatted {
    public String formatted(List<Employee> employeeList) {
        List<String> htmlEmployee = new ArrayList<>();
        for (Employee employee : employeeList) {
            final Gson gson = new GsonBuilder().create();
            String json  = gson.toJson(employee);
            htmlEmployee.add(getHtmlData(json));
        }
        return htmlEmployee
                .stream()
                .collect(Collectors.joining(" | ", "{", "}"));
    }

    private String jsonToHtml(Object obj) {
        StringBuilder html = new StringBuilder( );
        try {
            if (obj instanceof JSONObject) {
                JSONObject jsonObject = (JSONObject) obj;
                String[] keys = JSONObject.getNames(jsonObject);
                html.append("<div class=\"json_object\">");
                if (keys.length > 0) {
                    for (String key : keys) {
                        html.append("<div><span class=\"json_key\">")
                                .append(key).append("</span> : ");
                        Object val = jsonObject.get(key);
                        html.append(jsonToHtml(val));
                        html.append("</div>");
                    }
                }
                html.append("</div>");
            } else if (obj instanceof JSONArray) {
                JSONArray array = (JSONArray) obj;
                for ( int i = 0; i < array.length(); i++) {
                    html.append(jsonToHtml(array.get(i)));
                }
            } else {
                html.append(obj);
            }
        } catch (JSONException e) { return e.getLocalizedMessage() ; }
        return html.toString();
    }

    private String getHtmlData(String strJsonData) {
        return jsonToHtml(new JSONObject(strJsonData));
    }
}
