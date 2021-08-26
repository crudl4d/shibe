package com.dog;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame("Shibecore");
        frame.setLayout(null);
        frame.setBounds(0,0,1000,600);
        JLabel label = new JLabel();
        NextDoge nextDoge = new NextDoge(label);

        PreviousDoge previousDogeButton = new PreviousDoge(label);
        JLabel filler = new JLabel(new ImageIcon(
            new ImageIcon("resources/shiba.jpg")
                .getImage()
                .getScaledInstance(200,400, Image.SCALE_SMOOTH)));
        filler.setBounds(0,200,200,400);
        frame.add(filler);

        frame.setResizable(false);
        frame.add(nextDoge.getButton());
        frame.add(previousDogeButton.getButton());
        frame.add(label);
        label.setBounds(200,0,800,600);
        nextDoge.getDog();
        frame.setVisible(true);
    }
}