package ru.job4j.chapter_005.LSP.ParkingCars;

import java.util.ArrayList;
import java.util.List;


public class ParkingPlace implements Parking {
    private int COUNT_PLACE_FOR_CAR;
    private int COUNT_PLACE_FOR_TRACK;
    private List<AbstractVehicle> cars = new ArrayList<>(this.COUNT_PLACE_FOR_CAR);
    private List<AbstractVehicle> tracks = new ArrayList<>(this.COUNT_PLACE_FOR_TRACK);

    public ParkingPlace(int COUNT_PLACE_FOR_CAR, int COUNT_PLACE_FOR_TRACK) {
        this.COUNT_PLACE_FOR_CAR = COUNT_PLACE_FOR_CAR;
        this.COUNT_PLACE_FOR_TRACK = COUNT_PLACE_FOR_TRACK;
    }

    @Override
    public boolean add(AbstractVehicle vehicle) {
        return false;
    }

    @Override
    public boolean accept(AbstractVehicle vehicle) {
        return false;
    }

    @Override
    public List<AbstractVehicle> getParkingPlace(String vehicle) {
        return null;
    }
}
