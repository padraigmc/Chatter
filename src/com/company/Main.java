package com.company;

public class Main {


    public static void main(String[] args) {

        ChatterServer.main(new String[]{"6066"});
        ChatterClient.main(new String[]{"localhost", "6066"});
    }
}
