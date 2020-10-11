package ru.job4j.chapter_001.analysislist;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class AnalysisListTest {
    @Test
    public void when2UserAdded() {
        AnalysisList analize = new AnalysisList();
        List<User> initialDataUsers = List.of(
                new User(1, "Nikita"),
                new User(2, "Dmitriy")

        );
        List<User> finalDataUsers = List.of(
                new User(1, "Nikita"),
                new User(2, "Dmitriy"),
                new User(3, "Aleksandr"),
                new User(4, "Josh")
        );
        Info info = analize.diff(initialDataUsers, finalDataUsers);
        assertThat(info.getAdded(), is(2));
    }

    @Test
    public void when1UserAddedAnd1ChangedAnd1Deleted() {
        AnalysisList analize = new AnalysisList();
        List<User> initialDataUsers = List.of(
                new User(1, "Nikita"),
                new User(2, "Dmitriy")

        );
        List<User> finalDataUsers = List.of(
                new User(1, "Josh"),
                new User(3, "Maksim")
        );
        Info info = analize.diff(initialDataUsers, finalDataUsers);
        assertThat(new Info(1, 1, 1), is(info));
    }

    @Test
    public void when1Deleted() {
        AnalysisList analize = new AnalysisList();
        List<User> initialDataUsers = List.of(
                new User(1, "Nikita"),
                new User(2, "Dmitriy")

        );
        List<User> finalDataUsers = List.of(
                new User(1, "Nikita")
        );
        Info info = analize.diff(initialDataUsers, finalDataUsers);
        assertThat(info.getDeleted(), is(1));
    }

    @Test
    public void when1UserChangedAnd1DeletedAnd2Add() {
        AnalysisList analize = new AnalysisList();
        List<User> initialDataUsers = List.of(
                new User(1, "Nikita"),
                new User(2, "Dmitriy"),
                new User(5, "Aleksandr"),
                new User(12, "Sonya")

        );
        List<User> finalDataUsers = List.of(
                new User(1, "Nikita"),
                new User(2, "Petr"),
                new User(12,"Sonya"),
                new User(4, "Konstantin"),
                new User(10,"Roman")
        );
        Info info = analize.diff(initialDataUsers, finalDataUsers);
        assertThat(info, is(new Info(2, 1, 1)));
    }

    @Test
    public void when2UserDeleted() {
        AnalysisList analize = new AnalysisList();
        List<User> initialDataUsers = List.of(
                new User(1, "Nikita"),
                new User(2, "Dmitriy"),
                new User(5, "Aleksandr"),
                new User(12, "Sonya")

        );
        List<User> finalDataUsers = List.of(
                new User(1, "Nikita"),
                new User(12, "Sonya")

        );
        Info info = analize.diff(initialDataUsers, finalDataUsers);
        assertThat(info.getDeleted(), is(2));
    }

    @Test
    public void AllUsersInfo() {
        AnalysisList analize = new AnalysisList();
        List<User> initialDataUsers = List.of(
                new User(25, "Aleksandra"),
                new User(41, "Sergey"),
                new User(14, "Josh"),
                new User(63, "Vladimir"),
                new User(54, "Polina")
        );
        List<User> finalDataUsers = List.of(
                new User(41, "Sergey"),
                new User(14, "Josh"),
                new User(54, "Pavel"),
                new User(85, "Roman"),
                new User(82, "Denis")
        );
        Info info = analize.diff(initialDataUsers, finalDataUsers);
        assertThat(info.getAdded(), is(2));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getDeleted(), is(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCollectionsAreEmpty() {
        AnalysisList analize = new AnalysisList();
        List<User> initialDataUsers = List.of();
        List<User> finalDataUsers = List.of();
        Info info = analize.diff(initialDataUsers, finalDataUsers);
    }
}