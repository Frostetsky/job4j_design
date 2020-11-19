package ru.job4j.chapter_005.Exam;

public interface GamePlay {
    public static final int START_INDEX = 1;
    public static final int END_INDEX = 45;

    boolean isPay(Node<FieldElement> value, Player player);
    void setProperty(Player player);
    Player passMove(Player player);
    String description(FieldElement element);
    void takeCard(Player player, int position);
    boolean buyBuild(Player whoSell, Player whoBuy, int positionWhoBuy);
    boolean moneyChange(Player player);
    void sitInJail(Player player, int position);
}
