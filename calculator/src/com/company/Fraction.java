package com.company;

public class Fraction {

    private int numerator;
    private int denominator; // initialization num & den

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }


    // CREATING A FRACTION
    // |        |        |
    // V        V        V

    public Fraction(int num, int den) {
       // int numerator =
        this.numerator = num;
        this.denominator = den;
        reduct();
    }

    // methods for returning num/den |
    //                               V

    private int getGreatestCommonDivisor(int numerator, int denominator) {
        //greatestCommonDivisor == nod(russian interpretation)

        if (numerator % denominator == 0) {
            //if numerator is divisible => return denominator
            return denominator;
        }
        if (denominator % numerator == 0) {
            //if denominator is divisible => return numerator
            return numerator;
        }
        return getGreatestCommonDivisor(denominator, numerator % denominator);
        //or using recursion call the function again
    }

    // method for reducing the fraction to its lowest possible appearance
    private void reduct() {
        int greatestCommonDivisor = getGreatestCommonDivisor(numerator, denominator);
        numerator /= greatestCommonDivisor;
        denominator /= greatestCommonDivisor;
    }

    //method for adding two fractions
    public Fraction supply(Fraction secondFraction) {

        //initialization of new num & den and calculating them

        int newNumerator = (numerator * secondFraction.getDenominator()) +
                (secondFraction.getNumerator() * denominator);
        int newDenominator = denominator * secondFraction.getDenominator();

        //using this method for creating a new fraction

        return new Fraction(newNumerator, newDenominator);
    }

    //method for subtracting fractions
    public Fraction subtract(Fraction secondFraction) {
        int newNumerator = (numerator * secondFraction.denominator) -
                (secondFraction.numerator * denominator);
        int newDenominator = denominator * secondFraction.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    //method for two fractions multiplication
    public Fraction multiply(Fraction secondFraction) {
        int newNumerator = numerator * secondFraction.numerator;
        int newDenominator = denominator * secondFraction.denominator;

        return new Fraction(newNumerator, newDenominator);
    }

    //method for dividing two fractions
    public Fraction divide(Fraction secondFraction) {
        int newNumerator = numerator * secondFraction.getDenominator();
        int newDenominator = denominator * secondFraction.numerator;

        return new Fraction(newNumerator, newDenominator);
    }


    public static Fraction supply(Fraction firstFraction, Fraction secondFraction) {
        int newNumerator = firstFraction.getNumerator() * secondFraction.getDenominator() + secondFraction.getNumerator() * firstFraction.getDenominator();
        int newDenominator = firstFraction.getDenominator() * secondFraction.getDenominator();

        return new Fraction(newNumerator, newDenominator);

    }

    public static Fraction subtract(Fraction firstFraction, Fraction secondFraction) {
        int numerator = firstFraction.getNumerator() * secondFraction.getDenominator() - secondFraction.getNumerator() * firstFraction.getDenominator();
        int denominator = firstFraction.getDenominator() * secondFraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction multiply(Fraction firstFraction, Fraction secondFraction) {
        int numerator = firstFraction.getNumerator() * secondFraction.getNumerator();
        int denominator = firstFraction.getDenominator() * secondFraction.getDenominator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction divide(Fraction firstFraction, Fraction secondFraction) {
        int numerator = firstFraction.getNumerator() * secondFraction.getDenominator();
        int denominator = firstFraction.getDenominator() * secondFraction.getNumerator();

        return new Fraction(numerator, denominator);
    }

    public static Fraction getSimplestFraction() {
        int numerator = 1;
        int denominator = 1;
        return new Fraction(numerator, denominator);
    }

    public static String convertToString(Fraction ourFraction) { //method for converting Fractions into String
        int numerator = ourFraction.getNumerator();
        int denominator = ourFraction.getDenominator();

        String result;
        result = numerator + "/" + denominator;
        return result;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}

