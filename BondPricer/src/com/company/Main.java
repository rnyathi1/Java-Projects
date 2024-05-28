package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("What is the face value?");
        double faceValue = scan.nextDouble();
        System.out.println("What is the Coupon Rate?");
        double couponRate = scan.nextDouble() / 100;
        System.out.println("What is the amount of payments per year (1/2/4/12) ?");
        double frequency = scan.nextDouble();
        System.out.println("What is the Yield?");
        double yield = scan.nextDouble() / 100;
        System.out.println("How many years till maturity?");
        double maturityYear = scan.nextDouble();
        BondCalculator calc = new BondCalculator(faceValue,couponRate,frequency,yield,maturityYear);

        System.out.println(calc.bondPriceCalculator(faceValue,couponRate,frequency,yield,maturityYear));

    }


}
