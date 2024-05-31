package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JFrame   {
    private BlackScholes bs;
    private MonteCarlo mc;
    private MenuPanel mp;
    private CardLayout cards;


    public Main(){
        mp = new MenuPanel(this);
        bs = new BlackScholes(this);
        mc = new MonteCarlo(this);

        setSize(900,900);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Options Pricing");
        cards = new CardLayout();
        setLayout(cards);

        add(mp,"Menu");
        add(bs,"Black");
        add(mc,"Monte");

        cards.show(this.getContentPane(), "Menu");

        setVisible(true);
    }
    public static void main(String[] args) {
        new Main();
    }

    public void switchToBlack(){
        cards.show(this.getContentPane(),"Black");
    }

    public void switchToMonte(){
        cards.show(this.getContentPane(),"Monte");
    }

    public void switchToMenu(){
        cards.show(this.getContentPane(),"Menu");
    }


}
