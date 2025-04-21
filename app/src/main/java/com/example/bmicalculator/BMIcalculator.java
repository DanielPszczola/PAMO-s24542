package com.example.bmicalculator;

public class BMIcalculator {
    public static String getBMIStatus(double weight, double heightCm) {
        if (heightCm <= 0 || weight <= 0) return "Nieprawidłowe dane";

        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);

        if (bmi < 18.5) return "Niedowaga";
        else if (bmi < 25) return "Optimum";
        else if (bmi < 30) return "Nadwaga";
        else return "Otyłość";
    }
}
