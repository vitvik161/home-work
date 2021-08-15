package com.sbrf.reboot.calculator;

public class Calculator {

        public static int getAddition(int firstNumber, int secondNumber) {
            return firstNumber+secondNumber;
        }

        public static int getSubtraction(int firstNumber, int secondNumber) {
            return firstNumber - secondNumber;
        }
        public static int getMultiplication(int firstNumber, int secondNumber) {
            return firstNumber * secondNumber;
        }

        public static double getDivision(int firstNumber, int secondNumber) {
            return (double) firstNumber / (double) secondNumber;
        }

    public static int getSqr(int firstNumber) {
        return firstNumber * firstNumber;
    }

    public static int getMod(int firstNumber, int secondNumber) {
        return firstNumber % secondNumber;
    }

    public static double getSqrt(int firstNumber) {
        return Math.sqrt(firstNumber);
    }

}
