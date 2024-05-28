package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("What is the face value?");
        int faceValue = scan.nextInt();
        System.out.println("What is the Coupon Rate?");
        int couponRate = scan.nextInt();
        System.out.println("What is the amount of payments per year (1/2/4/12) ?");
        int Frequency = scan.nextInt();
        System.out.println("What is the Yield?");
        int Yield = scan.nextInt();
        System.out.println("How many years till maturity?");
        int maturityYear = scan.nextInt();



    }
}
