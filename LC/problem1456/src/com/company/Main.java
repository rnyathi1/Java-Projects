package com.company;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        String s = "abciiidef"; int k = 3;
        int i = 0; int j = k -1; int count = 0;
        HashSet<Character> map = new HashSet<Character>();
        map.add('a');
        map.add('e');
        map.add('i');
        map.add('o');
        map.add('u');
        for(int y = 0; y < k; y++){
            if(map.contains(s.charAt(y))) count++;
        }
        while(j != s.length()){
            
        }


    }
}
