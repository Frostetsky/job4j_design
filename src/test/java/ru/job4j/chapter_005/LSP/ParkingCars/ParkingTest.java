package ru.job4j.chapter_005.LSP.ParkingCars;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {
    @Test
    public void whenParkingIsFull() {
        ParkingPlace parkingPlace = new ParkingPlace(2, 1);
        AbstractVehicle toyota = new Car("Toyota", "Camry");
        AbstractVehicle kio = new Car("Kio", "Optima");
        AbstractVehicle uaz = new Truck("Uaz", "B26");
        parkingPlace.add(toyota);
        parkingPlace.add(uaz);
        parkingPlace.add(kio);
        assertThat(parkingPlace.getParkingPlace("TrackPlaces"), is(List.of(uaz)));
        assertThat(parkingPlace.getParkingPlace("CarsPlaces"), is(List.of(toyota, kio)));
    }

    @Test
    public void whenTrackIsParking() {
        ParkingPlace parkingPlace = new ParkingPlace(3, 0);
        AbstractVehicle toyota = new Car("Toyota", "Camry");
        AbstractVehicle uaz = new Truck("Uaz", "B26");
        parkingPlace.add(toyota);
        parkingPlace.add(uaz);
        assertThat(parkingPlace.getParkingPlace("CarsPlaces"), is(List.of(toyota, uaz, uaz)));
    }

    @Test
    public void whenTrackIsNotParking() {
        ParkingPlace parkingPlace = new ParkingPlace(2, 0);
        AbstractVehicle toyota = new Car("Toyota", "Camry");
        AbstractVehicle uaz = new Truck("Uaz", "B26");
        parkingPlace.add(toyota);
        parkingPlace.add(uaz);
        assertThat(parkingPlace.getParkingPlace("CarsPlaces"), is(List.of(toyota)));
    }

    @Test
    public void whenCarIsNotParking() {
        ParkingPlace parkingPlace = new ParkingPlace(0, 1);
        AbstractVehicle toyota = new Car("Toyota", "Camry");
        AbstractVehicle uaz = new Truck("Uaz", "B26");
        boolean resultCar = parkingPlace.add(toyota);
        boolean resultTrack = parkingPlace.add(uaz);
        assertThat(resultCar, is(false));
        assertThat(resultTrack, is(true));
    }

    @Test
    public void whenCarParking() {
        ParkingPlace parkingPlace = new ParkingPlace(2, 1);
        AbstractVehicle toyota = new Car("Toyota", "Camry");
        AbstractVehicle uaz = new Truck("Uaz", "B26");
        AbstractVehicle vaz = new Truck("Vaz", "V26");
        boolean resultCar = parkingPlace.add(toyota);
        boolean resultUaz = parkingPlace.add(uaz);
        boolean resultVaz = parkingPlace.add(vaz);
        assertThat(resultCar, is(true));
        assertThat(resultUaz, is(true));
        assertThat(resultVaz, is(false));
    }
}