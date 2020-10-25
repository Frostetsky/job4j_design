package ru.job4j.chapter_005.LSP.ParkingCars;

import java.util.Objects;

public abstract class AbstractVehicle {
    private String vehicle;
    private String name;
    private int size;

    public AbstractVehicle(String vehicle, String name, int size) {
        this.vehicle = vehicle;
        this.name = name;
        this.size = size;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractVehicle that = (AbstractVehicle) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
