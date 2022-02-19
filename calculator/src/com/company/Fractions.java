package com.company;

import java.util.Scanner;

public class Fractions {

    public int numerator;
    public int denominator; // initialization num & den

    // CREATING A FRACTION
    // |        |        |
    // |        |        |
    // V        V        V
    public Fractions(int num, int den) {
        this.numerator = num;
        this.denominator = den;
        FractionReduction();
    }

    // methods for returning num/den |
    //                               V

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public int Greatestcommondivisor(int numerator, int denominator) {
        //Greatestcommondivisor == nod(russian interpretation)

        if (numerator % denominator == 0) {
            //if numerator is divisible => return denominator
            return denominator;
        }
        if (denominator % numerator == 0){
            //if denominator is divisible => return numerator
            return numerator;
        }
        return Greatestcommondivisor(denominator, numerator % denominator);
        //or using recursion call the function again
    }

    // method for reducing the fraction to its lowest possible appearance
    void FractionReduction() {
        int greatestCommonDivisor = Greatestcommondivisor(numerator, denominator);
        numerator /= greatestCommonDivisor;
        denominator /= greatestCommonDivisor;
    }

    //method for adding two fractions
    public Fractions Supplementation(Fractions SecondFraction) {

        //initialization of new num & den and calculating them

        int newNumerator = (numerator * SecondFraction.getDenominator()) +
                (SecondFraction.getNumerator() * denominator);
        int newDenominator = denominator * SecondFraction.getDenominator();

        //using this method for creating a BRAND new fraction

        return new Fractions(newNumerator, newDenominator);
    }

    //method for subtracting fractions
    public Fractions Subtraction(Fractions SecondFraction) {
        int newNumerator = (numerator * SecondFraction.denominator) -
                (SecondFraction.numerator * denominator);
        int newDenominator = denominator * SecondFraction.denominator;

        return new Fractions(newNumerator, newDenominator);
    }

    //method for two fractions multiplication
    public Fractions Generation(Fractions SecondFraction) {
        int newNumerator = numerator * SecondFraction.numerator;
        int newDenominator = denominator * SecondFraction.denominator;

        return new Fractions(newNumerator, newDenominator);
    }

    //method for dividing two fractions
    public Fractions Division(Fractions SecondFraction) {
        int newNumerator = numerator * SecondFraction.getDenominator();
        int newDenominator = denominator * SecondFraction.numerator;

        return new Fractions(newNumerator, newDenominator);
    }


    public static Fractions Supplementation (Fractions FirstFraction, Fractions SecondFraction){
        int newNumerator = FirstFraction.getNumerator() * SecondFraction.getDenominator() + SecondFraction.getNumerator() * FirstFraction.getDenominator();
        int newDenominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fractions(newNumerator, newDenominator);

    }

    public static Fractions Subtraction (Fractions FirstFraction, Fractions SecondFraction){
        int numerator = FirstFraction.getNumerator() * SecondFraction.getDenominator() - SecondFraction.getNumerator() * FirstFraction.getDenominator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fractions(numerator, denominator);
    }

    public static Fractions Generation (Fractions FirstFraction, Fractions SecondFraction){
        int numerator = FirstFraction.getNumerator() * SecondFraction.getNumerator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getDenominator();

        return new Fractions(numerator, denominator);
    }

    public static Fractions Division (Fractions FirstFraction, Fractions SecondFraction){
        int numerator = FirstFraction.getNumerator() * SecondFraction.getDenominator();
        int denominator = FirstFraction.getDenominator() * SecondFraction.getNumerator();

        return new Fractions(numerator, denominator);
    }

    public static Fractions SimplestFraction(){
        int numerator = 1;
        int denominator = 1;
        return new Fractions(numerator, denominator);
    }

    public static String ConvertingToString (Fractions OurFraction){ //method for converting Fractions into String
        int numerator = OurFraction.getNumerator();
        int denominator = OurFraction.getDenominator();

        String result;
        result = numerator+"/"+denominator;
        return result;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a nominator of the first fraction: ");
        if(!scanner.hasNextInt()){
            System.out.println("ENTER INTEGERS ONLY!");
            throw new Exception();
        }
        int nominator1 = scanner.nextInt();
        System.out.println("Type a denominator of the first fraction: ");
        if((!scanner.hasNextInt()) || (scanner.hasNext("0"))){
            System.out.println("ENTER INTEGERS ONLY!");
            throw new Exception();
        }

        int denominator1 = scanner.nextInt();
        System.out.println("Type a nominator of the second fraction: ");
        if(!scanner.hasNextInt()){
            System.out.println("ENTER INTEGERS ONLY!");
            throw new Exception();
        }

        int nominator2 = scanner.nextInt();
        System.out.println("Type a denominator of the second fraction: ");
        if((!scanner.hasNextInt()) || (scanner.hasNext("0"))){
            System.out.println("ENTER INTEGERS ONLY!");
            throw new Exception();
        }

        int denominator2 = scanner.nextInt();
        Fractions FirstFraction = new Fractions(nominator1, denominator1);
        Fractions SecondFraction = new Fractions(nominator2, denominator2);

        Fractions Finale;
        System.out.printf("The simplest fraction: %s%n", ConvertingToString(SimplestFraction()));
        System.out.printf("Your first fraction: %s%n", ConvertingToString(FirstFraction));
        System.out.printf("Your second fraction: %s%n", ConvertingToString(SecondFraction));

        Finale = FirstFraction.Supplementation(SecondFraction);
        System.out.printf("Adding res of %s to %s is : %s%n", ConvertingToString(FirstFraction), ConvertingToString(SecondFraction), ConvertingToString(Finale));
        Finale = FirstFraction.Subtraction(SecondFraction);
        System.out.printf("Subtracting res of %s and %s is : %s%n", ConvertingToString(FirstFraction), ConvertingToString(SecondFraction), ConvertingToString(Finale));
        Finale = FirstFraction.Division(SecondFraction);
        System.out.printf("Dividing res of %s by %s is : %s%n", ConvertingToString(FirstFraction), ConvertingToString(SecondFraction), ConvertingToString(Finale));
        Finale = FirstFraction.Generation(SecondFraction);
        System.out.printf("Suplementation res of %s by %s is : %s%n", ConvertingToString(FirstFraction), ConvertingToString(SecondFraction), ConvertingToString(Finale));
        Finale = Supplementation (FirstFraction, SecondFraction);
        System.out.printf("Res of adding the fractions is (two arguments): %s%n", ConvertingToString(Finale));
        Finale = Subtraction (FirstFraction, SecondFraction);
        System.out.printf("Res of subtracting the fractions is (two arguments): %s%n", ConvertingToString(Finale));
        Finale = Generation (FirstFraction, SecondFraction);
        System.out.printf("Res of generation the fractions is (two arguments): %s%n", ConvertingToString(Finale));
        Finale = Division (FirstFraction, SecondFraction);
        System.out.printf("Res of dividing the fractions is (two arguments): %s%n", ConvertingToString(Finale));
    }
}
