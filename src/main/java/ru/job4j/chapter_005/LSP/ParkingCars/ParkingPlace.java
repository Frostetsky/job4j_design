package ru.job4j.chapter_005.LSP.ParkingCars;

import java.util.ArrayList;
import java.util.List;


public class ParkingPlace implements Parking {
    private int fullsizecar;
    private int fullsizetrack;
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
        boolean result = false;
        if (vehicle instanceof Car) {
            if (accept(vehicle)) {
                cars.add(vehicle);
                result = true;
            }
        } else if (vehicle instanceof Track) {
            if (accept(vehicle)) {
                tracks.add(vehicle);
                result = true;
            } else if (trackPlacesIsFull()) {
                for (int i = 0; i < vehicle.getSize(); i++) {
                    cars.add(vehicle);
                    result = true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean accept(AbstractVehicle vehicle) {
        if (vehicle instanceof Car) {
            return fullsizecar != cars.size();
        } else if (vehicle instanceof Track) {
            return fullsizetrack != tracks.size();
        } else {
            throw new IllegalArgumentException();
        }
    }

    private boolean trackPlacesIsFull() {
        return fullsizetrack == tracks.size() && ( (fullsizecar - cars.size()) >= 2 );
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
