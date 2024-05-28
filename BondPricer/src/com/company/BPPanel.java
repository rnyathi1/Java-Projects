package com.company;

import javax.swing.*;
import java.awt.*;

public class BPPanel extends JPanel {


    private TextField faceV;
    private TextField couponR;
    private TextField frq;
    private TextField yield;
    private TextField maturityY;
    private Label fv;
    private Label cr;
    private Label fq;
    private Label yd;
    private Label my;
    private Label answer;
    private Button submit;
    BondCalculator calc;

    public BPPanel(GridLayout gridLayout){

        setLayout(gridLayout);
        faceV = new TextField("");
        couponR = new TextField("");
        frq = new TextField("");
        yield = new TextField("");
        maturityY = new TextField("");
        fv = new Label("Face Value");
        cr = new Label("Coupon Rate");
        fq = new Label("Frequency of Payments");
        yd = new Label("Yield Rate");
        my = new Label("Maturity in Years");
        answer = new Label("");
        submit = new Button("Calculate");

        add(fv);
        add(faceV);
        add(cr);
        add(couponR);
        add(fq);
        add(frq);
        add(yd);
        add(yield);
        add(my);
        add(maturityY);
        add(submit);
        add(answer);
        submit.addActionListener(e -> submitButtonPressed());


    }

    public void submitButtonPressed() {
        double fv = Double.parseDouble(faceV.getText());
        double cr = Double.parseDouble(couponR.getText());
        double fq = Double.parseDouble(frq.getText());
        double yd = Double.parseDouble(yield.getText());
        double my = Double.parseDouble(maturityY.getText());

        calc = new BondCalculator(fv,cr,fq,yd,my);
        answer.setText(Double.toString(calc.bondPriceCalculator()));
        System.out.println(calc.bondPriceCalculator());

    }

}
