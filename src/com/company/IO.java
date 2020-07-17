package com.company;

import java.io.IOException;
import java.net.Socket;

public class IO {

    public static void inputOutput(Socket socket) {
        try {
            Thread inputThread = new InputThread(socket);
            inputThread.start();

            Thread outputThread = new OutputThread(socket);
            outputThread.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
