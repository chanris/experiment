package com.chenyue.experiment.net.blockedio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8080);
            System.out.println("Connected to server.");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("Hello, Server.");
            String response  = reader.readLine();
            System.out.println("Server response: " + response);

            reader.close();
            writer.close();
            socket.close();

            System.out.println("Disconnected from server.");
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
