package com.Client;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OutputThread extends Thread{
    private Socket socket;
    private Scanner userInput;

    public OutputThread(Socket socket) {
        this.socket = socket;
        userInput = new Scanner(System.in);
    }

    public void run() {
        DataOutputStream out;
        while (true) {
            try {
                out = new DataOutputStream(socket.getOutputStream());
                out.writeUTF(userInput.nextLine());
            } catch (IOException e) {
                break;
            }
        }
    }
}
