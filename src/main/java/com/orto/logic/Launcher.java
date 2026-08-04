package com.orto.logic;

public class Launcher {
    public static void main(String[] args) {
        if (args == null || args.length < 2) {
            args = new String[]{"DEMO", "GUI1"};
        }
        Main.main(args);
    }
}
