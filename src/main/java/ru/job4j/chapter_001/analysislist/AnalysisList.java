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
        this.changed = changedAndDeleted(previous, current);
        this.added = added(previous, current);
        return new Info(this.added, this.changed, this.deleted);
    }

    private int added(List<User> previous, List<User> current) {
        int added = 0;
        added = current.size() - previous.size() + this.deleted;
        return added;
    }

    private int changedAndDeleted(List<User> previous, List<User> current) {
        int changed = 0;
        this.deleted = 0;
        Map<Integer, String> users = previous.stream().collect(Collectors.toMap(User::getId, User::getName));
        for (User user : current) {
            if (users.containsKey(user.getId()) && !users.get(user.getId()).equals(user.getName())) {
                changed++;
            } else if (!users.containsKey(user.getId())) {
                deleted++;
            }
        }
        deleted = previous.size() - current.size() + this.deleted;
        return changed;
    }
}
