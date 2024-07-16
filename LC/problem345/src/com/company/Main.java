package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// LeetCode 345
        String s = "hello";
        StringBuilder sbuild = new StringBuilder();
        Stack<Integer> t = new Stack<>();

        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'a' ||s.charAt(i) == 'e' ||s.charAt(i) == 'i' ||s.charAt(i) == 'o' ||s.charAt(i) == 'u' || s.charAt(i) == 'A' ||s.charAt(i) == 'E' ||s.charAt(i) == 'I' ||s.charAt(i) == 'O' ||s.charAt(i) == 'U'  ){
                t.push(i);
            }
        }
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'a' ||s.charAt(i) == 'e' ||s.charAt(i) == 'i' ||s.charAt(i) == 'o' ||s.charAt(i) == 'u' || s.charAt(i) == 'A' ||s.charAt(i) == 'E' ||s.charAt(i) == 'I' ||s.charAt(i) == 'O' ||s.charAt(i) == 'U'  ){
                sbuild.append(s.charAt(t.pop()));
            } else {
                sbuild.append(s.charAt(i));
            }
        }

        System.out.println(sbuild.toString());
    }
}
