package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code
        char operator;
        Double number1, number2, result;
        Main main = new Main();
        // create an object of Scanner class
        Scanner input = new Scanner(System.in);

        // ask users to enter operator
        System.out.println("Choose an operator: +, -, *, or /");
        operator = input.next().charAt(0);

        // ask users to enter numbers
        System.out.println("Enter first number");
        number1 = input.nextDouble();

        System.out.println("Enter second number");
        number2 = input.nextDouble();

        switch (operator) {

            // performs addition between numbers
            case '+':
                result = main.addition(number1,number2);
                System.out.println(number1 + " + " + number2 + " = " + result);
                break;

            // performs subtraction between numbers
            case '-':
                result = main.subtraction(number1,number2);
                System.out.println(number1 + " - " + number2 + " = " + result);
                break;

            // performs multiplication between numbers
            case '*':
                result = main.multiplication(number1,number2);
                main.multiplication(number1,number2);
                System.out.println(number1 + " * " + number2 + " = " + result);
                break;

            // performs division between numbers
            case '/':
                result = main.division(number1,number2);
                System.out.println(number1 + " / " + number2 + " = " + result);
                break;

            default:
                System.out.println("Invalid operator!");
                break;
        }

        input.close();
    }

    public double addition(double number1, double number2){
       return number1 + number2;
    }
    public double subtraction(double number1, double number2){
        return number1 - number2;
    }
    public double multiplication(double number1, double number2){
        return number1 * number2;
    }
    public double division(double number1, double number2){
        return number1 / number2;
    }
}
