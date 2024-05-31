package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BlackScholes extends JPanel {

    private JPanel top;
    private JPanel centre;

    private JLabel stockP;
    private JLabel strikeP;
    private JLabel timeE;
    private JLabel riskF;
    private JLabel vol;
    private JLabel dividendY;
    private JLabel title;


    private JTextField stockPT;
    private JTextField strikePT;
    private JTextField timeET;
    private JTextField riskFT;
    private JTextField volT;
    private JTextField dividendYT;


    private JButton submit;
    private JLabel answer;

    public BlackScholes(Main main){
        setLayout(new BorderLayout());
        top = new JPanel();
        centre = new JPanel();

        top.setLayout(new FlowLayout());
        centre.setLayout(new GridLayout(10,2));
        Button button = new Button("Black");
        Button mButton = new Button("Menu");


        button.addActionListener(e -> main.switchToMonte());
        mButton.addActionListener(e -> main.switchToMenu());

        title = new JLabel("Black-Scholes Option Pricer Call/Put");
        title.setHorizontalAlignment(JLabel.CENTER);

        stockP = new JLabel("Stock Price");
        strikeP = new JLabel("Strike Price");
        timeE = new JLabel("Time of Expiration (In years)");
        riskF = new JLabel("Risk Free Interest Rate(Decimal)");
        vol = new JLabel("Volatility of Stock (Decimal)");
        dividendY = new JLabel("Dividend Yield");


        stockPT = new JTextField();
        strikePT = new JTextField();
        timeET = new JTextField();
        riskFT = new JTextField();
        volT = new JTextField();
        dividendYT = new JTextField("0");

        submit = new JButton("Calculate");

        answer = new JLabel();

        submit.addActionListener(e -> submitButtonPressed());

        top.add(button);
        top.add(mButton);

        centre.add(stockP);centre.add(stockPT);centre.add(strikeP);centre.add(strikePT);centre.add(timeE);centre.add(timeET);centre.add(riskF);centre.add(riskFT);centre.add(vol);centre.add(volT);centre.add(dividendY);centre.add(dividendYT);
        centre.add(submit);
        centre.add(answer);
        add(top,BorderLayout.SOUTH);
        add(title,BorderLayout.NORTH);
        add(centre, BorderLayout.CENTER);


    }
    public void submitButtonPressed(){
        double sto=  Double.parseDouble(stockPT.getText());
        double str= Double.parseDouble(strikePT.getText());
        double t =Double.parseDouble(timeET.getText());
        double r = Double.parseDouble(riskFT.getText());
        double v = Double.parseDouble(volT.getText());
        double dy =Double.parseDouble(dividendYT.getText());


        BlackScholesCalc(sto,str,t,r,v,dy);
    }

    public void BlackScholesCalc(double stockPrice, double strikePrice, double timeExpiration, double riskFreeRate, double volatility, double dividendYield ){
        double d1 = 1/ (volatility * Math.sqrt(timeExpiration)) * (Math.log(stockPrice / strikePrice) + (riskFreeRate - dividendYield + 0.5*(Math.pow(volatility,2))*timeExpiration));
        double d2 = d1 - (volatility * Math.sqrt(timeExpiration));
        double callOption = (stockPrice * Math.exp(-1 * dividendYield * timeExpiration) * CNDF(d1)) - (strikePrice * Math.exp(-1 * riskFreeRate * timeExpiration) * CNDF(d2));
        double putOption = (strikePrice * Math.exp(-1 * riskFreeRate * timeExpiration) * CNDF(-d2)) - (stockPrice * Math.exp(-1 * dividendYield * timeExpiration) * CNDF(-d1));
        answer.setText("Call Option: " + callOption + "  Put Option: " + putOption);
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
