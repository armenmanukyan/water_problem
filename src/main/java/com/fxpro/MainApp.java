package com.fxpro;

public class MainApp {

    public static void main(final String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("You Should Provide Arguments");
        }
        int[] landscape = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            landscape[i] = Integer.parseInt(args[i]);
        }
        long waterAmount = WaterCalculator.calculateWaterAmount(landscape);
        System.out.println(waterAmount);
    }
}