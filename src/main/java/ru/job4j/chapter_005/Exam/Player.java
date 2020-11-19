package ru.job4j.chapter_005.Exam;

import java.util.ArrayList;
import java.util.List;

public abstract class Player {
    private Figure figure;
    private Cube cube;
    private List<Building> buildings = new ArrayList<>();
    private List<Card> cards = new ArrayList<>();
    private long money;
    private boolean statusJail;

    public Player(Figure figure, Cube cube) {
        this.figure = figure;
        this.cube = cube;
    }

    protected abstract void addCard(Card card);

    protected abstract boolean addBuild(Building building);

    protected abstract void move(int position);

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public boolean isStatus() {
        return statusJail;
    }

    public void setStatus(boolean status) {
        this.statusJail = status;
    }
}
