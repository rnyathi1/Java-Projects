package com.company;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {

    public MenuPanel(Main main) {
        Button mButton = new Button("Monte");
        mButton.addActionListener(e -> main.switchToMonte());
        Button bButton = new Button("Black");
        bButton.addActionListener(e -> main.switchToBlack());
        add(mButton);
        add(bButton);
    }
}
