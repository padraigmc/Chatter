package com.company;

import java.io.*;
import java.net.*;

public class ChatterClient {

    public ChatterClient(String server, int port) {
        try {
            System.out.println("Client: Connecting to " + server + " on port " + port);
            Socket client = new Socket(server, port);

            System.out.println("Client: Just connected to " + client.getRemoteSocketAddress());

            IO.inputOutput(client);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
