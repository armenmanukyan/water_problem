package com.fxpro.validator;

public class LandScapeValidator {
    public static void validateLandScape(final int[] landscape) {
        if (landscape.length > 32000) {
            throw new IllegalArgumentException("Landscape should not contain more than 32000 elements.");
        }
        for (int height : landscape) {
            if (height < 0) {
                throw new IllegalArgumentException("Landscape heights should not be negative!");
            }
            if (height > 32_000) {
                throw new IllegalArgumentException("Landscape heights should not be higher than 32000.");
            }
        }
    }
}
