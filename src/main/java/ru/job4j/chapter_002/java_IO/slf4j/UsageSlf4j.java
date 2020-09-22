package ru.job4j.chapter_002.java_IO.slf4j;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageSlf4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageSlf4j.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        String name = "Petr Arsentev";
        byte b = 1;
        int age = 33;
        float f = 3.4f;
        double d = 15.43;
        long l = 15239213912L;
        char x = 'X';
        boolean t = true;

        LOG.debug("User info name : {}, age : {}", name, age);
        LOG.debug("User info byte : {}, float : {}", b, f);
        LOG.debug("User info boolean : {}, long : {}", t, l);
        LOG.debug("User info double : {}, char : {}", d, x);

    }
}
