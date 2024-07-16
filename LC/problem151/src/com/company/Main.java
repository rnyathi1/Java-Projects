package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// Leetcode 151

       String s = "  hello world  ";
       String[] st = s.trim().split("\\s+");

       StringBuilder sb = new StringBuilder();

       for(int x = st.length - 1; x >= 0; x--){
            sb.append(st[x]).append(" ");
       }
       System.out.println(sb.toString());
    }
}
