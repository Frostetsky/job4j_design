package ru.job4j.chapter_002.java_IO.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String msg = null;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("GET /?msg=")) {
                            msg = (str.split(" ")[1]).split("=")[1];
                            if (msg.equals("Exit")) {
                                System.out.println(msg);
                                server.close();
                                break;
                            } else if (msg.equals("Hello")) {
                                System.out.println("Hello");
                            } else {
                                System.out.println(msg);
                            }
                        }
                    }
                    if (server.isClosed()) {
                        break;
                    }
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (msg != null) {
                        out.write(msg.getBytes());
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("error", e);
        }
    }
}