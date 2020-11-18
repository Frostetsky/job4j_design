package ru.job4j.chapter_005.LSP.ParkingCars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class ParkingPlace implements Parking {
    private int fullsizecar;
    private int fullsizetrack;
    private final int CAR_SIZE = 1;
    private List<AbstractVehicle> cars;
    private List<AbstractVehicle> tracks;

    public ParkingPlace(final int size_place_for_car,final int size_place_for_track) {
        this.fullsizecar = size_place_for_car;
        this.fullsizetrack = size_place_for_track;
        cars = new ArrayList<>(size_place_for_car);
        tracks = new ArrayList<>(size_place_for_track);
    }

    @Override
    public boolean add(AbstractVehicle vehicle) {
        if (!accept(vehicle)) {
            return false;
        }
        if (vehicle.getSize() == CAR_SIZE) {
            cars.add(vehicle);
        } else {
            if (tracks.size() < fullsizetrack) {
                tracks.add(vehicle);
            } else {
                IntStream.range(0, vehicle.getSize()).forEach(i -> cars.add(vehicle));
            }
        }
        return true;
    }

    @Override
    public boolean accept(AbstractVehicle vehicle) {
        if (vehicle.getSize() == CAR_SIZE && fullsizecar == cars.size()) {
            return false;
        }
        if (vehicle.getSize() != CAR_SIZE &&
                (tracks.size() == fullsizetrack && (fullsizecar - cars.size()) < vehicle.getSize())) {
            return false;
        }
        return true;
    }

    @Override
    public List<AbstractVehicle> getParkingPlace(String vehicles) {
        if (vehicles.equalsIgnoreCase("trackplaces")) {
            return tracks;
        } else if (vehicles.equalsIgnoreCase("carsplaces")) {
            return cars;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
