package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(600,600);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel BPP = new BPPanel(new GridLayout(10,2));
        BPP.setVisible(true);
        frame.setTitle("Bond Price Calculator");
        frame.add(BPP);


    }


}
