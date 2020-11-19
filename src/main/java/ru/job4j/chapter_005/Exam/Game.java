package ru.job4j.chapter_005.Exam;

import java.util.*;

public class Game implements GamePlay {

    private final Map<Integer, Node<FieldElement>> gameField = new TreeMap<>();
    private final Map<Building, Auction> auction = new HashMap<>();

    @Override
    public boolean isPay(Node<FieldElement> value, Player player) {
        return false;
    }

    @Override
    public void setProperty(Player player) {

    }

    @Override
    public Player passMove(Player player) {
        return null;
    }

    @Override
    public String description(FieldElement element) {
        return null;
    }

    @Override
    public void takeCard(Player player, int position) {

    }

    @Override
    public boolean buyBuild(Player whoSell, Player whoBuy, int positionWhoBuy) {
        return false;
    }

    @Override
    public boolean moneyChange(Player player) {
        return false;
    }

    @Override
    public void sitInJail(Player player, int position) {

    }


}
