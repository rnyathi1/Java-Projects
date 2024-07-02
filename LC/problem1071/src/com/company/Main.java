package com.company;

public class Main {

    public static void main(String[] args) {
	// LeetCode Problem 1071

        String str1 = "ABCABC", str2 = "ABC";

        if(!(str1 + str2).equals(str2+str1)){
            System.out.println("");
        }
        System.out.println(str1.substring(0,gcd(str1.length(),str2.length())));
    }

    static int gcd(int a,int b){

        return b == 0 ? a: gcd(b, a % b);
     }


}
