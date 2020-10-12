package ru.job4j.chapter_001.analysislist;

import java.util.*;
import java.util.stream.Collectors;

public class AnalysisList {

    private int changed;
    private int added;
    private int deleted;

    public Info diff(List<User> previous, List<User> current) {
        if (previous.isEmpty() || current.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.deleted = deleted(previous, current);
        this.added = added(previous, current);
        this.changed = changed(previous, current);
        return new Info(this.added, this.changed, this.deleted);
    }

    private int added(List<User> previous, List<User> current) {
        int added = 0;
        added = current.size() - previous.size() + this.deleted;
        System.out.println(deleted);
        return added;
    }

    private int changed(List<User> previous, List<User> current) {
        int changed = 0;
        Map<Integer, String> users = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (User user : current) {
            if (users.containsKey(user.getId()) && !users.get(user.getId()).equals(user.getName())) {
                changed++;
            }
        }
        return changed;
    }

    private int deleted(List<User> previous, List<User> current) {
        int deleted = 0;
        for (User user : previous) {
            if (current.contains(user)) {
                deleted++;
            }
        }
        deleted = previous.size() - deleted;
        return deleted;
    }
}
