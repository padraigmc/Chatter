package com.Client;

import java.io.IOException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws IOException {


        Scanner uInput = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------------------------------------------------------------------------------------");
            System.out.println("1: Login");
            System.out.println("2: Register");
            System.out.println("--------------------------------------------------------------------------------------------------");
            String action = uInput.nextLine();

            switch (action) {
                case "1":
                    Login.login_user();
                    break;

                case "2":
                    Register.register_user();
                    break;

                default:
                    // catch all for unsupported characters
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
