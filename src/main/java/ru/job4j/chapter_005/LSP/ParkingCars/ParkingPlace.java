package ru.job4j.chapter_005.LSP.ParkingCars;

import java.util.List;


public class ParkingPlace implements Parking {
    private int PLACES;
    private int[] PLACES_FOR_TRACK_ID;

    public ParkingPlace(final int PLACES) {
        this.PLACES = PLACES;
    }

    public ParkingPlace(int PLACES, int[] PLACES_FOR_TRACK_ID) {
        this.PLACES = PLACES;
        this.PLACES_FOR_TRACK_ID = PLACES_FOR_TRACK_ID;
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
    public List<AbstractVehicle> getParkingPlace() {
        return null;
    }
}
