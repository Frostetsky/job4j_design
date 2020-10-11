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
        this.added = added(previous, current);
        this.changed = changed(previous, current);
        this.deleted = deleted(previous, current);
        return new Info(this.added, this.changed, this.deleted);
    }

    private int added(List<User> previous, List<User> current) {
        int added = 0;
        Set<User> users = new HashSet<>(previous);
        users.addAll(current);
        added = users.size() - previous.size();
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
        Set<User> users = new HashSet<>(previous);
        users.removeAll(current);
        deleted = users.size();
        return deleted;
    }
}
