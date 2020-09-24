package ru.job4j.chapter_002.java_IO.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JSONmain {
    public static void main(String[] args) {
        final JavaDeveloper developer = new JavaDeveloper(false, 21, "Nikita",
                    new Mentor("Petr Arsentev"), new String[] {"job4j_junior, job4j_middle"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(developer));

        /* Модифицируем json-строку */
        final String developerJson =
                "{"
                        + "\"isworking\":false,"
                        + "\"age\":21,"
                        + "\"name\":Nikita,"
                        + "\"mentor\":"
                        + "{"
                        + "\"name\":\"Petr Arsentev\""
                        + "},"
                        + "\"projects\":"
                        + "[\"job4j_junior\",\"job4j_middle\"]"
                        + "}";
        final JavaDeveloper developerMod = gson.fromJson(developerJson, JavaDeveloper.class);
        System.out.println(developerMod);
    }
}
