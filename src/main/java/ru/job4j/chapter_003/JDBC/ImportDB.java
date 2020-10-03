package ru.job4j.chapter_003.JDBC;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {

    private Properties cfg;
    private String dump;

    public ImportDB(Properties cfg, String dump) {
        this.cfg = cfg;
        this.dump = dump;
    }

    public List<User> load() throws IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(dump))) {
            String line;
            while ((line = rd.readLine()) != null) {
                String[] element = line.split(";");
                if (element.length > 2) {
                    throw new IllegalArgumentException();
                }
                users.add(new User(element[0], element[1]));
            }
        }
        return users;
    }

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(cfg.getProperty("jdbc.driver"));
        try (Connection cnt = DriverManager.getConnection(
                cfg.getProperty("jdbc.url"),
                cfg.getProperty("jdbc.username"),
                cfg.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement ps = cnt.prepareStatement
                        ("INSERT INTO spammer.public.spammers(name, email) VALUES (?, ?)")) {
                    ps.setString(1, user.name);
                    ps.setString(2, user.email);
                    ps.execute();
                } catch (SQLException sql) {
                    sql.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws Exception {
        Properties cfg = new Properties();
        try (FileInputStream in = new FileInputStream
                ("./src/main/java/ru/job4j/chapter_003/NameEmail.properties")) {
            cfg.load(in);
        }
        ImportDB db = new ImportDB(cfg, "./src/main/java/ru/job4j/chapter_003/JDBC/dump.txt");
        db.save(db.load());
    }
}

