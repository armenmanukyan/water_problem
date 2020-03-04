package com.fxpro;

import org.junit.Test;

import static com.fxpro.WaterCalculator.calculateWaterAmount;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class WaterCalculatorTest {
    @Test
   public void Should_Calculate_Water_Amount_When_Landscape_Is_Valid() {
         int[] landscape = {4, 6, 3, 2, 9, 1, 0, 0, 3};

         long waterAmount = WaterCalculator.calculateWaterAmount(landscape);

        assertEquals(15, waterAmount);
    }

    @Test
    public void Should_Return_Zero_When_Landscape_Length_Equals_To_One() {
         int[] landscape = {7};

         long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    public void Should_Return_Zero_When_Landscape_Length_Equals_To_Zero() {
        int[] landscape = {};

        long waterAmount = calculateWaterAmount(landscape);

        assertEquals(0, waterAmount);
    }

    @Test
    public void Should_Throw_Illegal_Argument_Exception_When_Landscape_Height_Is_Negative() {
        int[] landscape = {7, 4, -5};

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

    @Test
    public void Should_Throw_Illegal_Argument_Exception_When_Landscape_Contains_Height_Bigger_Than_32000() {
         int[] landscape = {4, 7, 32567, 1};

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

    @Test
    public void Should_Throw_Illegal_Argument_Exception__When_Landscape_Contains_More_Than_32000_Elements() {
         int[] landscape = new int[32976];

        assertThrows(IllegalArgumentException.class, () -> calculateWaterAmount(landscape));
    }

}
