package com.example.bmicalculator;

import org.junit.Test;
import static org.junit.Assert.*;

public class BMICalculatorTest {

    @Test
    public void testNiedowaga() {
        assertEquals("Niedowaga", BMIcalculator.getBMIStatus(45, 170));
    }

    @Test
    public void testOptimum() {
        assertEquals("Optimum", BMIcalculator.getBMIStatus(65, 170));
    }

    @Test
    public void testNadwaga() {
        assertEquals("Nadwaga", BMIcalculator.getBMIStatus(80, 170));
    }

    @Test
    public void testOtylosc() {
        assertEquals("Otyłość", BMIcalculator.getBMIStatus(100, 170));
    }

    @Test
    public void testBledneDane() {
        assertEquals("Nieprawidłowe dane", BMIcalculator.getBMIStatus(0, 0));
    }
}
