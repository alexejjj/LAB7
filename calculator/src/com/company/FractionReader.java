package com.company;

import java.util.regex.*;

public class FractionReader {
    private Fraction fraction1;
    private Fraction fraction2;

    public Fraction evaluateExpression(String expression) throws ArithmeticException {
        String regex = "(\\d+/\\d+)\\s*([+\\-*/])\\s*(\\d+/\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(expression);
        matcher.find();

        fraction1 = createFractionFromString(matcher.group(1));
        fraction2 = createFractionFromString(matcher.group(3));

        String operation = matcher.group(2);

        Fraction result = null;

        switch (operation) {
            case "+":
                result = Fraction.supply(fraction1, fraction2);
                break;
            case "-":
                result = Fraction.subtract(fraction1, fraction2);
                break;
            case "*":
                result = Fraction.multiply(fraction1, fraction2);
                break;
            case "/":
                result = Fraction.divide(fraction1, fraction2);
                break;
        }

        return result;
    }

    public Fraction createFractionFromString(String fraction) {
        Pattern pattern = Pattern.compile("(\\d+)/(\\d+)");
        Matcher matcher = pattern.matcher(fraction);
        matcher.find();
        int numerator = Integer.parseInt(matcher.group(1));
        int denominator = Integer.parseInt(matcher.group(2));
        if (denominator == 0) {
            throw new ArithmeticException("Denominator can't be 0");
        }
        Fraction parsedFraction = new Fraction(numerator, denominator);
        return parsedFraction;
    }
}
