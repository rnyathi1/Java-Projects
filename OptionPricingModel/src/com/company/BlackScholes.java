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

    public double[] BlackScholesCalc(double stockPrice, double strikePrice, double timeExpiration, double riskFreeRate, double volatility, double dividendYield ){
        double d1 = 1/ (volatility * Math.sqrt(timeExpiration)) * (Math.log(stockPrice / strikePrice) + (riskFreeRate - dividendYield + 0.5*(Math.pow(volatility,2))*timeExpiration));
        double d2 = d1 - (volatility * Math.sqrt(timeExpiration));
        double callOption = (stockPrice * Math.exp(-1 * dividendYield * timeExpiration) * CNDF(d1)) - (strikePrice * Math.exp(-1 * riskFreeRate * timeExpiration) * CNDF(d2));
        double putOption = (strikePrice * Math.exp(-1 * riskFreeRate * timeExpiration) * CNDF(-d2)) - (stockPrice * Math.exp(-1 * dividendYield * timeExpiration) * CNDF(-d1));
        return new double[] {callOption,putOption};
    }

    double CNDF(double x)
    {
        int neg = (x < 0d) ? 1 : 0;
        if ( neg == 1)
            x *= -1d;

        double k = (1d / ( 1d + 0.2316419 * x));
        double y = (((( 1.330274429 * k - 1.821255978) * k + 1.781477937) * k - 0.356563782) * k + 0.319381530) * k;
        y = 1.0 - 0.398942280401 * Math.exp(-0.5 * x * x) * y;

        return (1d - neg) * y + neg * (1d - y);
    }
}
