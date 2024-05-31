package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonteCarlo extends JPanel {
    private Label l;
    public MonteCarlo(Main main){
        Button button = new Button("Black");
        button.addActionListener(e -> main.switchToBlack());
        Button mButton = new Button("Menu");
        mButton.addActionListener(e -> main.switchToMenu());

        add(button);
        add(mButton);
    }
}
