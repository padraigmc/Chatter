package com.Client;

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
                //DataInputStream in = new DataInputStream(server.getInputStream());
                //System.out.println(in.readUTF());

                Thread inputThread = new InputThread(server);
                inputThread.start();

                Thread outputThread = new OutputThread(server);
                outputThread.start();

                //DataOutputStream out = new DataOutputStream(server.getOutputStream());
                //out.writeUTF("Server: Thank you for connecting to " + server.getLocalSocketAddress() + "\nGoodbye!");
                //server.close();

            } catch (SocketTimeoutException s) {
                System.out.println("Server: Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String [] args) {
        int port = Integer.parseInt(args[0]);
        try {
            Thread t = new ChatterServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

