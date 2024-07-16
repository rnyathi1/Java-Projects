package com.company;

public class Main {

    public static void main(String[] args) {
	// leetcode 443
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        int p1 = 0;
        char first = chars[0];
        StringBuilder sb = new StringBuilder();
        int k = 0;
        if(chars.length == 1) System.out.println(1);
        for(int x = 1; x < chars.length; x++){
            if(chars[x] != first ){
                sb.append(first);
                int count = x - p1;
                if(count>1) sb.append(count);
                p1 = x;
                first = chars[x];
            }
            if(chars[x] != first || x == chars.length -1){
                sb.append(first);
                int count = x - p1 + 1;
                if(count>1) sb.append(count);
                sb.append(x - p1 + 1);

            }
        }
        int num = sb.toString().length();
        for(int x = 0; x<num;x++){
            chars[x] = sb.charAt(x);
        }
        System.out.println(sb.toString().toCharArray().length);
    }
}
