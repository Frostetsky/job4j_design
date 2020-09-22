package ru.job4j.chapter_002.java_IO.consolechat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bot {

    private static final Bot bot = new Bot();
    private static BufferedWriter writer;
    private static final String logname = "./src/main/java/ru/job4j/chapter_002/java_IO/consolechat/log.txt";
    private static final String genword = "./src/main/java/ru/job4j/chapter_002/java_IO/consolechat/generationword.txt";
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static boolean instart = true;
    private static boolean outstart = true;
    private static boolean flag = true;

    static {
        try {
            writer = new BufferedWriter(
                        new FileWriter(logname));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int lineNumber() throws Exception {
        int line = 0;
        LineNumberReader reader = new LineNumberReader(new FileReader(genword));
        while (reader.readLine() != null) {
            line++;
        }
        return line;
    }

    private void question() throws Exception {
        String question = reader.readLine();
        switch (question) {
            case "stop": {
                writeInTXT(question);
                instart = false;
                break;
            }
            case "exit": {
                writeInTXT(question);
                instart = false;
                outstart = false;
                break;
            }
            default: {
                writeInTXT(question);
                answer();
            }
        }
    }

    private void answer() throws Exception {
        int N = (int) ( Math.random() * lineNumber() );
        String answer = Files.lines(Paths.get(genword)).skip(N).findFirst().get();
        writeInTXT(answer);
        System.out.println(answer);
    }

    private void firstIterationAndContinue() throws Exception {
        String contin = reader.readLine();
        if (contin.equals("continue")) {
            instart = true;
            writeInTXT(contin);
        } else if (flag) {
            writeInTXT(contin);
            bot.answer();
            flag = false;
        } else {
            writeInTXT(contin);
        }
    }

    private static void writeInTXT(String massage) throws IOException {
        writer.write(massage);
        writer.write(System.lineSeparator());
    }

    public static void main(String[] args) throws Exception {
        Bot bot = new Bot();
        do {
            bot.firstIterationAndContinue();
            while (instart) {
                bot.question();
            }
        } while (outstart);
        reader.close();
        writer.close();
    }
}
