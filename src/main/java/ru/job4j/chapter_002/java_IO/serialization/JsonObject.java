package ru.job4j.chapter_002.java_IO.serialization;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.List;

import java.util.ArrayList;

public class JsonObject {
    public static void main(String[] args) {

        /* JSONObject из json-строки строки */
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());
        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(person).toString());

        JSONObject jsonC = new JSONObject("{\"name\":\"Petr\"}");

        List<String> projects = new ArrayList<>();
        projects.add("job4j_grabber");
        projects.add("job4j_tracker");
        JSONArray jsonA = new JSONArray(projects);

        final JavaDeveloper developer =
                new JavaDeveloper(true, 21, "Nikita",
                                   new Mentor("Rail"), new String[] {"job4_middle"});
        JSONObject json = new JSONObject();
        json.put("isworking", developer.isworking());
        json.put("age", developer.getAge());
        json.put("name", developer.getName());
        json.put("mentor", jsonC);
        json.put("projects", jsonA);
        System.out.println(json.toString());

        System.out.println(new JSONObject(developer).toString());
    }
}
