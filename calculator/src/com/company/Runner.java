package com.company;

import java.util.Scanner;

public class Runner {
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
        Fraction firstFraction = new Fraction(nominator1, denominator1);
        Fraction secondFraction = new Fraction(nominator2, denominator2);


        Fraction result;
        System.out.printf("The simplest fraction: %s%n", Fraction.convertToString(Fraction.getSimplestFraction()));
        System.out.printf("Your first fraction: %s%n", Fraction.convertToString(firstFraction));
        System.out.printf("Your second fraction: %s%n", Fraction.convertToString(secondFraction));

        result = firstFraction.supply(secondFraction);
        System.out.printf("Adding res of %s to %s is : %s%n", Fraction.convertToString(firstFraction), Fraction.convertToString(secondFraction), Fraction.convertToString(result));
        result = firstFraction.subtract(secondFraction);
        System.out.printf("Subtracting res of %s and %s is : %s%n", Fraction.convertToString(firstFraction), Fraction.convertToString(secondFraction), Fraction.convertToString(result));
        result = firstFraction.divide(secondFraction);
        System.out.printf("Dividing res of %s by %s is : %s%n", Fraction.convertToString(firstFraction), Fraction.convertToString(secondFraction), Fraction.convertToString(result));
        result = firstFraction.multiply(secondFraction);
        System.out.printf("Suplementation res of %s by %s is : %s%n", Fraction.convertToString(firstFraction), Fraction.convertToString(secondFraction), Fraction.convertToString(result));
        result = Fraction.supply (firstFraction, secondFraction);
        System.out.printf("Res of adding the fractions is (two arguments): %s%n", Fraction.convertToString(result));
        result = Fraction.subtract (firstFraction, secondFraction);
        System.out.printf("Res of subtracting the fractions is (two arguments): %s%n", Fraction.convertToString(result));
        result = Fraction.multiply (firstFraction, secondFraction);
        System.out.printf("Res of generation the fractions is (two arguments): %s%n", Fraction.convertToString(result));
        result = Fraction.divide (firstFraction, secondFraction);
        System.out.printf("Res of dividing the fractions is (two arguments): %s%n", Fraction.convertToString(result));

        // FRACTION READER
        System.out.println("Enter an operation with two fractions you want to perform: ");
        try {
            Scanner sc = new Scanner(System.in);
            String expression = sc.nextLine();
            FractionReader fractionReader = new FractionReader();
            result = fractionReader.evaluateExpression(expression);
            System.out.println(result);
        } catch (ArithmeticException exception) {
            System.out.println(exception.getMessage() + ", correct an expression");
        } catch (IllegalStateException exception) {
            System.out.println("Incorrect expression. Probably, you use not valid operation");
        }
    }
}
