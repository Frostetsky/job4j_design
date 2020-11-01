package ru.job4j.chapter_005.SRP;


import java.util.List;
import java.util.StringJoiner;

public class HTMLParser implements Formatted {
    @Override
    public String formatted(List<Employee> list) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        for (Employee employee : list) {
            joiner.add("<html>");
            joiner.add(" <head>");
            joiner.add("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">");
            joiner.add("    <title>" + employee.toString() + "</title>");
            joiner.add(" </head>");
            joiner.add("</html>");
        }
        return joiner.toString();
    }
}
