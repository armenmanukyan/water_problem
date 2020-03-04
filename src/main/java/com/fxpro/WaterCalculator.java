package com.fxpro;

import static java.lang.Math.min;
import static com.fxpro.validator.LandScapeValidator.validateLandScape;

public class WaterCalculator {

    public static long calculateWaterAmount(int[] landscape) {
        if (landscape.length == 0) {
            return 0;
        }
        validateLandScape(landscape);
        int[] leftBorderHeight = new int[landscape.length];
        int[] rightBorderHeight = new int[landscape.length];
        fillBorderHeights(landscape, leftBorderHeight, rightBorderHeight);
        long amount = 0;
        for (int i = 0; i < landscape.length; i++) {
            amount += min(leftBorderHeight[i], rightBorderHeight[i]) - landscape[i];
        }
        return amount;
    }


    private static void fillBorderHeights(int[] landscape,
                                          int[] leftBorderHeight,
                                          int[] rightBorderHeight) {
        int currentLeftHeight = landscape[0];
        int currentRightHeight = landscape[landscape.length - 1];
        for (int i = 0; i < landscape.length; i++) {
            if (currentLeftHeight < landscape[i]) {
                leftBorderHeight[i] = landscape[i];
                currentLeftHeight = landscape[i];
            } else {
                leftBorderHeight[i] = currentLeftHeight;
            }
            int rightIndex = landscape.length - i - 1;
            if (currentRightHeight < landscape[rightIndex]) {
                rightBorderHeight[rightIndex] = landscape[rightIndex];
                currentRightHeight = landscape[rightIndex];
            } else {
                rightBorderHeight[rightIndex] = currentRightHeight;
            }
        }
    }
}
