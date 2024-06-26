package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //If we list all the natural numbers below 10 that are multiples of 3 or 5 ,we get 3,5,6 and 9. The sum of these multiples is 23 .
        // Find the sum of all the multiples of  3 or 5 below 1000 .

        int nums = 1000;
        int sum = 0;

        for(int i = 0; i < nums; i++){
            if(i % 3 == 0 || i % 5 == 0){
                sum += i;
            }
        }
        System.out.println(sum);

        Arrays.stream(new int[] {2,3}).map(n -> n+1 );



    }
}
