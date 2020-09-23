package ru.job4j.chapter_002.java_IO.consolechat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Bot {

    private static final String logname = "./src/main/java/ru/job4j/chapter_002/java_IO/consolechat/log.txt";
    private static final String genword = "./src/main/java/ru/job4j/chapter_002/java_IO/consolechat/generationword.txt";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean instart = true;
    private static boolean outstart = true;
    private static boolean flag = true;
    private static List<String> words = new ArrayList<>();
    private static int amount = 0;
    private static List<String> log = new ArrayList<>();

    private void startBot() throws Exception {
        initializeList(genword);
        do {
            firstIterationAndContinue();
            while (instart) {
                question();
            }
        } while (outstart);
        reader.close();
        writeInTXT(log);
    }

    private void question() throws Exception {
        String question = reader.readLine();
        switch (question) {
            case "stop": {
                log.add(question);
                instart = false;
                break;
            }
            case "exit": {
                log.add(question);
                instart = false;
                outstart = false;
                break;
            }
            default: {
                log.add(question);
                answer();
            }
        }
    }

    private void initializeList(String pathtowordfile) throws IOException {
           Files.lines(Paths.get(pathtowordfile))
                .forEach(word -> { words.add(word); amount++;});
    }

    private void answer() {
        int N = (int) ( Math.random() * amount );
        String answer = words.get(N);
        log.add(answer);
        System.out.println(answer);
    }

    private void firstIterationAndContinue() throws Exception {
        String contin = reader.readLine();
        if (contin.equals("continue")) {
            instart = true;
            log.add(contin);
        } else if (flag) {
            log.add(contin);
                answer();
            flag = false;
        } else {
            log.add(contin);
        }
    }

    private static void writeInTXT(List<String> loglist) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logname))) {
            for (String log : loglist) {
                writer.write(log);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Bot bot = new Bot();
        bot.startBot();
    }
}
