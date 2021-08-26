package com.dog;

import javax.swing.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Shibecore");
        frame.setSize(1000,600);
        JLabel label = new JLabel();
        NextDoge nextDoge = new NextDoge(label);

        PreviousDoge previousDogeButton = new PreviousDoge(label);

        frame.setVisible(true);
        frame.setLayout(null);
        frame.setResizable(false);
        frame.add(nextDoge.getButton());
        frame.add(previousDogeButton.getButton());
        frame.add(label);
        label.setBounds(200,0,800,600);
        nextDoge.getDog();
    }
}