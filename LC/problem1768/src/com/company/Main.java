package com.company;

public class Main {

    public static void main(String[] args) {
/*
        Example 1:
        Input: word1 = "abc", word2 = "pqr"
        Output: "apbqcr"
        Explanation: The merged string will be merged as so:
        word1:  a   b   c
        word2:    p   q   r
        merged: a p b q c r
        Example 2:
        Input: word1 = "ab", word2 = "pqrs"
        Output: "apbqrs"
        Explanation: Notice that as word2 is longer, "rs" is appended to the end.
                word1:  a   b
        word2:    p   q   r   s
        merged: a p b q   r   s
        Example 3:

        Input: word1 = "abcd", word2 = "pq"
        Output: "apbqcd"
        Explanation: Notice that as word1 is longer, "cd" is appended to the end.
                word1:  a   b   c   d
        word2:    p   q
        merged: a p b q c   d
        */

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
