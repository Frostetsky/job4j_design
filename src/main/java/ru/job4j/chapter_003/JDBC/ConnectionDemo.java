package ru.job4j.chapter_003.JDBC;

import ru.job4j.chapter_002.java_IO.config.Config;
import ru.job4j.chapter_002.java_IO.serveranalysis.IncorrectInitialDataException;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IncorrectInitialDataException {
        Class.forName("org.postgresql.Driver");
        Config config = new Config("./src/main/java/ru/job4j/chapter_003/app.properties");
        config.load();
        String url = config.value("url");
        String login = config.value("login");
        String password = config.value("password");
        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
