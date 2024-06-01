package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MonteCarlo extends JPanel {

    private JPanel top;
    private JPanel centre;

    private JLabel stockP;
    private JLabel strikeP;
    private JLabel timeE;
    private JLabel riskF;
    private JLabel vol;
    private JLabel dividendY;
    private JLabel sim;
    private JLabel title;


    private JTextField stockPT;
    private JTextField strikePT;
    private JTextField timeET;
    private JTextField riskFT;
    private JTextField volT;
    private JTextField dividendYT;
    private JTextField simT;

    private JButton submit;
    private JLabel answer;




    public MonteCarlo(Main main){
        setLayout(new BorderLayout());
        top = new JPanel();
        centre = new JPanel();

        top.setLayout(new FlowLayout());
        centre.setLayout(new GridLayout(10,2));
        Button button = new Button("Black");
        Button mButton = new Button("Menu");

        button.addActionListener(e -> main.switchToBlack());
        mButton.addActionListener(e -> main.switchToMenu());

        title = new JLabel("Monte-Carlo Option Pricer Call/Put");
        title.setHorizontalAlignment(JLabel.CENTER);

        stockP = new JLabel("Stock Price");
        strikeP = new JLabel("Strike Price");
        timeE = new JLabel("Time of Expiration (In years)");
        riskF = new JLabel("Risk Free Interest Rate(Decimal)");
        vol = new JLabel("Volatility of Stock (Decimal)");
        dividendY = new JLabel("Dividend Yield");
        sim = new JLabel("Number of Monte Carlo Iterations");

        stockPT = new JTextField();
        strikePT = new JTextField();
        timeET = new JTextField();
        riskFT = new JTextField();
        volT = new JTextField();
        dividendYT = new JTextField(0);
        simT = new JTextField();

        submit = new JButton("Calculate");

        answer = new JLabel();

        submit.addActionListener(e -> submitButtonPressed());

        top.add(button);
        top.add(mButton);

        centre.add(stockP);centre.add(stockPT);centre.add(strikeP);centre.add(strikePT);centre.add(timeE);centre.add(timeET);centre.add(riskF);centre.add(riskFT);centre.add(vol);centre.add(volT);centre.add(dividendY);centre.add(dividendYT);centre.add(sim);centre.add(simT);
        centre.add(submit);
        centre.add(answer);
        add(top,BorderLayout.SOUTH);
        add(title,BorderLayout.NORTH);
        add(centre, BorderLayout.CENTER);

    }
    public void submitButtonPressed(){
        try{
            double sto=  Double.parseDouble(stockPT.getText());
            double str= Double.parseDouble(strikePT.getText());
            double t =Double.parseDouble(timeET.getText());
            double r = Double.parseDouble(riskFT.getText());
            double v = Double.parseDouble(volT.getText());
            double dy =Double.parseDouble(dividendYT.getText());
            int s =Integer.parseInt(simT.getText());

            MonteCarloCalc(sto,str,t,r,v,dy,s);
        }catch (Exception e){
            answer.setText("Check your inputs");
        }



    }
    public void MonteCarloCalc(double stockPrice, double strikePrice, double timeExpiration, double riskFreeRate, double volatility,double dividendYield ,int simulations ) {
        Random r = new Random();
        double[] stockPrices = new double[simulations];
        double[] callPayoffs = new double[simulations];
        double[] putPayoffs = new double[simulations];
        double callSum = 0d;
        double putSum = 0d;

        for (int i = 0; i < simulations; i++) {
            double z = r.nextGaussian();
            stockPrices[i] = stockPrice * Math.exp((riskFreeRate - dividendYield - 0.5*(Math.pow(volatility,2)) * timeExpiration + Math.sqrt(timeExpiration) * volatility * z)) ;
            callPayoffs[i] = Math.max(stockPrices[i]- strikePrice ,0);
            putPayoffs[i] = Math.max(strikePrice - stockPrices[i] ,0);
            callSum += Math.exp(-1 * riskFreeRate * timeExpiration ) * callPayoffs[i];
            putSum += Math.exp(-1 * riskFreeRate * timeExpiration ) * putPayoffs[i];
        }

        double callOption = callSum / simulations;
        double putOption = putSum / simulations;
        answer.setText("Call Option: " + callOption + "  Put Option: " + putOption);
    }
}
