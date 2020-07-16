package com.company;

import java.io.*;
import java.net.*;

public class ChatterClient {

    public static void main(String [] args) {
        String serverName = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            System.out.println("Client: Connecting to " + serverName + " on port " + port);
            Socket client = new Socket(serverName, port);

            System.out.println("Client: Just connected to " + client.getRemoteSocketAddress());
            //OutputStream outToServer = client.getOutputStream();
            //DataOutputStream out = new DataOutputStream(outToServer);

            //out.writeUTF("Client: Hello from " + client.getLocalSocketAddress());

            //InputStream inFromServer = client.getInputStream();
            //DataInputStream in = new DataInputStream(inFromServer);
            //System.out.println("Client: Server says " + in.readUTF());

            Thread inputThread = new InputThread(client);
            inputThread.start();

            Thread outputThread = new OutputThread(client);
            outputThread.start();

            //client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
