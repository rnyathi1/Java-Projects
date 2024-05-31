package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackScholes extends JPanel {

    public BlackScholes(Main main){
        Button button = new Button("Monte");
        button.addActionListener(e -> main.switchToMonte());
        Button mButton = new Button("Menu");
        mButton.addActionListener(e -> main.switchToMenu());
        add(button);
        add(mButton);
    }

    public double BlackScholesCalc(double strikePrice, double stockPrice, double timeExpiration, double riskFreeRate, double volatility, double dividendYield){
            
        return 0;
    }
}
