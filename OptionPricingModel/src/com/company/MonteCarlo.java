package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MonteCarlo extends JPanel {
    private Label l;
    public MonteCarlo(Main main){
        Button button = new Button("Black");
        button.addActionListener(e -> main.switchToBlack());
        Button mButton = new Button("Menu");
        mButton.addActionListener(e -> main.switchToMenu());

        add(button);
        add(mButton);
        System.out.println("Monte: " + MonteCarloCalc(100,105,1,0.05,0.2,0,100000,true));
    }

    public double MonteCarloCalc(double stockPrice, double strikePrice, double timeExpiration, double riskFreeRate, double volatility,double dividendYield ,int simulations , boolean call) {
        Random r = new Random();
        double[] stockPrices = new double[simulations];
        double[] payoffs = new double[simulations];

        double sum = 0d;

        for (int i = 0; i < simulations; i++) {
            double z = r.nextGaussian();
            stockPrices[i] = stockPrice * Math.exp((riskFreeRate - dividendYield - 0.5*(Math.pow(volatility,2)) * timeExpiration + Math.sqrt(timeExpiration) * volatility * z)) ;
            payoffs[i] = Math.max(stockPrices[i]- strikePrice ,0);
            sum += Math.exp(-1 * riskFreeRate * timeExpiration ) * payoffs[i];
        }

        double callOption = sum / simulations;
        return callOption;
    }
}
