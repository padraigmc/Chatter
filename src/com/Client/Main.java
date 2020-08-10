package com.Client;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {


        Scanner uInput = new Scanner(System.in);

        while (true) {
            System.out.println("Enter username to begin logging in. Enter '0' to register.");
            String role = uInput.nextLine();

            switch (role) {
                case "9":
                    Register.register_user();
                    break;


                default:
                    // test if username exists - break if not, otherwise query user for password
                    break;
            }

            /*
            if (role.equals("y")) {
                System.out.println("Enter Server IP address: ");
                String IPAddress = uInput.nextLine();

                ChatterClient.main(new String[]{IPAddress, "6066"});
                break;
            } else if (role.equals("n")) {
                ChatterServer.main(new String[]{"6066"});
                break;
            }*/
        }
    }
}
