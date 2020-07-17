package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner uInput = new Scanner(System.in);

        while (true) {
            System.out.println("Client? (y/n)");
            String role = uInput.nextLine();

            if (role.equals("y")) {
                System.out.println("Enter Server IP address: ");
                String IPAddress = uInput.nextLine();

                ChatterClient.main(new String[]{IPAddress, "6066"});
                break;
            } else if (role.equals("n")) {
                try {
                    Thread t = new ChatterServer(6066);
                    t.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            }
        }



    }
}
