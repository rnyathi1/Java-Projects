package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String s = "abciiidef"; int k = 3;
        int i = 0; int j = k -1; int count = 0; int maxC = Integer.MIN_VALUE;
        HashSet<Character> map = new HashSet<Character>();
        map.add('a');
        map.add('e');
        map.add('i');
        map.add('o');
        map.add('u');
        for(int y = 0; y < k; y++){
            if(map.contains(s.charAt(y))) count++;
        }
        maxC = Math.max(count, maxC);
        while(j != s.length()){

            if(map.contains(s.charAt(i))) count--;
            j++;
            i++;

            if(j!= s.length()) if(map.contains(s.charAt(j)))count++;
            maxC = Math.max(count, maxC);
        }

        System.out.println(maxC);
    }
}
