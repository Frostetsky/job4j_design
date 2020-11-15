package ru.job4j.chapter_005.LSP.ParkingCars;

import java.util.List;

public interface Parking {
    boolean add(AbstractVehicle vehicle);
    boolean accept(AbstractVehicle vehicle);
    List<AbstractVehicle> getParkingPlace(String vehicles);
}
