package com.company;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class InputThread extends Thread {
    private Socket socket;
    private DataInputStream dataInputStream;
    private String serverName;

    public InputThread(Socket socket) throws IOException {
        this.socket = socket;
        dataInputStream = new DataInputStream(socket.getInputStream());
        serverName = socket.getRemoteSocketAddress().toString();
    }

    public void run() {
        int availableBytes;
        while (true) {
            try {
                availableBytes = dataInputStream.available();
                if (availableBytes > 0) {
                    System.out.println(serverName + ": " + dataInputStream.readUTF());
                }
            } catch (IOException e) {
                break;
            }
        }
    }
}
