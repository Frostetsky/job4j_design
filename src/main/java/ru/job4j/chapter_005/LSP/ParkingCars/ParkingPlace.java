package ru.job4j.chapter_005.LSP.ParkingCars;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class ParkingPlace implements Parking {
    private int fullsizecar;
    private int fullsizetruck;
    private final int CAR_SIZE = 1;
    private List<AbstractVehicle> cars;
    private List<AbstractVehicle> trucks;

    public ParkingPlace(final int size_place_for_car, final int size_place_for_truck) {
        this.fullsizecar = size_place_for_car;
        this.fullsizetruck = size_place_for_truck;
        cars = new ArrayList<>(size_place_for_car);
        trucks = new ArrayList<>(size_place_for_truck);
    }

    @Override
    public boolean add(AbstractVehicle vehicle) {
        if (!accept(vehicle)) {
            return false;
        }
        if (vehicle.getSize() == CAR_SIZE) {
            cars.add(vehicle);
        } else {
            if (trucks.size() < fullsizetruck) {
                trucks.add(vehicle);
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
                (trucks.size() == fullsizetruck && (fullsizecar - cars.size()) < vehicle.getSize())) {
            return false;
        }
        return true;
    }

    @Override
    public List<AbstractVehicle> getParkingPlace(String vehicles) {
        if (vehicles.equalsIgnoreCase("truckplaces")) {
            return trucks;
        } else if (vehicles.equalsIgnoreCase("carsplaces")) {
            return cars;
        } else {
            throw new IllegalArgumentException();
        }
    }
}
