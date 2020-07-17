package com.company;

import java.io.*;
import java.net.*;

public class ChatterServer extends Thread {
    private ServerSocket serverSocket;

    public ChatterServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(90000);
    }

    public void run() {
        while(true) {
            try {
                Socket server = serverSocket.accept();

                System.out.println("You're connected to " + server.getRemoteSocketAddress() + "\n------------------------------------------------");

                IO.inputOutput(server);

            } catch (SocketTimeoutException s) {
                System.out.println("Server: Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}

