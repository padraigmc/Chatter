package com.company;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OutputThread {
    private Socket socket;
    private Scanner userInput;

    public OutputThread(Socket socket) {
        this.socket = socket;
        userInput = new Scanner(System.in);
    }

    public void run() {

        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(userInput.nextLine());
        } catch (IOException e) {
            // catch
        }
    }
}
