package com.company;

public class Main {

    public static void main(String[] args) {
    //Leetcode 1768

        int j = 0,k = 0,i = 0;
        String word1 = "abcd";
        String word2 = "pq";
        String merged = new String();

        while(i< word1.length() && j < word2.length()){

            if(k % 2 == 0) {
                merged += word1.charAt(i++);
            } else{
                merged += word2.charAt(j++);
            }
            k++;
        }

        if(i == word1.length()){
            while(j < word2.length() ){
                merged += word2.charAt(j++);
            }
        }
        if(j== word2.length()){
            while(i < word1.length() ){
                merged += word1.charAt(i++);
            }
        }
        System.out.println(merged != null? merged:" ");

    }
}
