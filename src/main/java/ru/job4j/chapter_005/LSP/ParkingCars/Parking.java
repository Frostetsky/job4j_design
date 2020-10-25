package ru.job4j.chapter_005.LSP.ParkingCars;

public interface Parking {
    boolean add(AbstractVehicle vehicle);
    boolean accept(AbstractVehicle vehicle);
}
