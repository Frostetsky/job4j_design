package ru.job4j.chapter_001.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class MapStore {
    private static Map<User, Object> map = new HashMap<>();

    public static void main(String[] args) {
        User user1 = new User("Alexey",
                              2,
                              new GregorianCalendar(1996, Calendar.JANUARY, 21));
        User user2 = new User("Alexey",
                              2,
                              new GregorianCalendar(1996, Calendar.JANUARY, 21));
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map);
    }
}
