package com.company;

import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        JFrame obj = new JFrame();
        Gameplay gamePlay = new Gameplay();
        obj.setVisible(true)
        obj.setBounds(10,10,700,600);
        obj.setTitle("Brick Break");
        obj.setResizable(true);
        ;
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(gamePlay);

    }
}
