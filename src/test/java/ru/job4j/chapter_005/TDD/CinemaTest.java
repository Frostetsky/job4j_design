package ru.job4j.chapter_005.TDD;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {

    @Test@Ignore
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test@Ignore
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(List.of(new Session3D())));
    }

    @Test(expected = IncorrectOrOccupiedPositionException.class)@Ignore
    public void whenPlacesTaken() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 9, 23, 22, 15);
        Ticket ticket = cinema.buy(account, 1, 2, date);
    }

    @Test(expected = IncorrectDateException.class)@Ignore
    public void whenCinemaIsStarting() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 25, 15, 30);
        Ticket ticket = cinema.buy(account, 3, 4, date);
    }
}