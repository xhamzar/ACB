package com.example.accessibilitybridge;

import java.io.*;
import java.net.*;

public class SocketServer {

    public static void startServer() {
        try (ServerSocket serverSocket = new ServerSocket(8765)) {
            while (true) {
                Socket client = serverSocket.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                String input = in.readLine();
                out.write("Diterima: " + input + "\n");
                out.flush();
                client.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
