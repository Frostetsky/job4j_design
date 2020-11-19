package ru.job4j.chapter_005.Exam;

public abstract class FieldElement {
    private Building building;
    private String name;
    private String description;
    private int cost;
    private final float improvement = 1.5f;

    public FieldElement(Building building, String name, String description, int cost) {
        this.building = building;
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public FieldElement(String name, String description, int cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public FieldElement(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Building getProperty() {
        return building;
    }

    public FieldElement(Building building) {
        this.building = building;
    }

    public long getFinalCostWithImprovement() {
        return (int) (cost * improvement);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
