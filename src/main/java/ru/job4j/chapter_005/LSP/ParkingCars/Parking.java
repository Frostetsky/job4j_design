package ru.job4j.chapter_005.LSP.ParkingCars;

public interface Parking {
    void add(AbstractVehicle vehicle);
    boolean isParking(AbstractVehicle vehicle);
}
