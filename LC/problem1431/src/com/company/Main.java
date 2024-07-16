package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	//Leetcode 1431
        int max = 0;
       int[] candies = new int[]{2,3,5,1,3};
       List<Boolean> b = new ArrayList<Boolean>();
       int extraCandies = 3;


       for(int x: candies){
         max = x > max ? x:max;
       }
        System.out.println(max);
       for(int x = 0; x < candies.length;x++){
           if(candies[x] + extraCandies >= max){
               b.add(true);
           } else{
               b.add(false);
           }

       }
        System.out.println(b);
    }
}
