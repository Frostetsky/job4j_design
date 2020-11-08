package ru.job4j.chapter_005.LSP.ParkingCars;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ParkingTest {
    @Test
    public void whenParkingIsFull() {
        ParkingPlace parkingPlace = new ParkingPlace(4);
        AbstractVehicle toyota = new Car("Toyota", "Camry", 1);
        AbstractVehicle kio = new Car("Kio", "Optima", 1);
        AbstractVehicle uaz = new Track("Uaz", "B26", 2);
        parkingPlace.add(toyota);
        parkingPlace.add(uaz);
        parkingPlace.add(kio);
        assertThat(parkingPlace.getParkingPlace(), is(List.of(toyota, uaz, uaz, kio)));
    }

    @Test
    public void whenTrackIsNotParking() {
        ParkingPlace parkingPlace = new ParkingPlace(2);
        AbstractVehicle toyota = new Car("Toyota", "Camry", 1);
        AbstractVehicle uaz = new Track("Uaz", "B26", 2);
        parkingPlace.add(toyota);
        parkingPlace.add(uaz);
        assertThat(parkingPlace.accept(uaz), is(false));
    }

    @Test
    public void whenTrackIsNotParkingInMiddle() {
        ParkingPlace parkingPlace = new ParkingPlace(3);
        AbstractVehicle toyota = new Car("Toyota", "Camry", 1);
        AbstractVehicle uaz = new Track("Uaz", "B26", 2);
        parkingPlace.add(toyota);
        parkingPlace.add(uaz);
        assertThat(parkingPlace.accept(uaz), is(false));
        assertThat(parkingPlace.getParkingPlace(), is(List.of(null, toyota, null)));
    }

    @Test
    public void whenParkPlacesHavePlaceForTrack() {
        ParkingPlace parkingPlace = new ParkingPlace(2, new int[] {1});
        AbstractVehicle toyota = new Car("Toyota", "Camry", 1);
        AbstractVehicle uaz = new Track("Uaz", "B26", 2);
        parkingPlace.add(toyota);
        parkingPlace.add(uaz);
        assertThat(parkingPlace.getParkingPlace(), is(List.of(toyota, uaz)));
    }

}