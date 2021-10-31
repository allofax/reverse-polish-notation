/*
    Name: Lukas
    Version 1

    Description: This program is a simple expression
    parser that adds, subtracts and finds the sum
    of multiple numbers. This program uses recursive
    methods to achieve this, and the format is in
    reverse Polish notation.

 */

package com.recursion;

import java.util.Scanner; // allows program to access user input

public class Main {

    // asks the user to enter an expression, calculates the result
    // and prints it out
    public static void main(String[] args) {
        String in = inputString("Please enter an expression");

        int answer = evaluate(in);
        System.out.println("The answer is " + answer);
        System.exit(0);
    }

    // takes the input and then checks if it is a
    // number or the start of an expression and executes
    // the corresponding method. The result is returned
    public static int evaluate(String in) {
        int result;
        int length = in.length();
        String firstChar = firstToken(in);

        if (length == 1) {
            result = evaluateDigit(in);
        } else if (firstChar.equals("+")){
            result = evaluateAdd(in);
        } else if (firstChar.equals("-")) {
            result = evaluateSub(in);
        } else if (firstChar.equals("&")){
            result = evaluateSum(in);
        } else {
            error();
            return -1;
        }

        return result;
    }

    // returns the digit as an integer
    public static int evaluateDigit(String in) {
        return Integer.parseInt(in);
    }

    // calculates addition of two numbers by calculating
    // the rest of the expression for the second number (if
    // there is any). The result is returned.
    public static int evaluateAdd(String in) {
        int arg1;
        int arg2;
        int result;

        String part1 = in.substring(1,2);
        String part2 = in.substring(2);
        arg1 = evaluateDigit(part1);
        arg2 = evaluate(part2);

        result = arg1 + arg2;
        return result;
    }


    // calculates subtraction of two numbers by calculating
    // the rest of the expression for the second number (if
    // there is any). The result is returned.
    public static int evaluateSub(String in) {
        int arg1;
        int arg2;
        int result;


        String part1 = in.substring(1,2);
        String part2 = restTokens(in);

        arg1 = evaluateDigit(part1);
        arg2 = evaluate(part2);

        result = arg1 - arg2;
        return result;
    }

    // calculates the sum of a number by evaluating the
    // rest of the expression and then doing the actual
    // sum part of the program. The result is returned
    public static int evaluateSum(String in) {
        int result = 1;

        String part1 = in.substring(1);
        int total = evaluate(part1);
        result = subtract(total);

        return result;
    }


    // finds the sum of a number by recursively
    // subtracting 1 from the number each time
    // and then returns the result
    public static int subtract(int total) {
        int result = total;

        if (total == 1) {
            return 1;
        } else {
            result += subtract(total-1);
        }

        return result;
    }

    // returns the first character in a string
    public static String firstToken(String in)
    {
        return in.substring(0,1);
    }

    // returns the string after the first line
    public static String restTokens(String in)
    {
        return in.substring(2);
    }


    // allows the user to input String values using their
    // keyboard into the program
    public static String inputString(String question) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(question);

        String answer = scanner.nextLine();
        return answer;
    }

    // prints whenever there is an error
    // and stops the program
    public static void error() {
        System.out.println("You have entered an incorrect statement");
        System.exit(0);
    }
}
