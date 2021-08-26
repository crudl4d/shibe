package com.dog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PreviousDoge implements ActionListener {
    private final JButton button = new JButton("PREVIOUS DOGE");
    private final JLabel label;

    public PreviousDoge(JLabel label){
        button.setBounds(0,100,200,100);
        button.setVisible(true);
        button.addActionListener(this);
        button.updateUI();
        this.label = label;
    }
    public JButton getButton() {
        return button;
    }

    @Override public void actionPerformed(ActionEvent e){
        try {
            getDog();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    private void getDog() throws IOException{
        try {
            DogList.dogList().setCurrentDog(DogList.dogList().getCurrentDog() - 1);
            String url = DogList.dogList().getList().get(DogList.dogList().getCurrentDog() - 1);
            HttpURLConnection dogConnection = (HttpURLConnection) new URL(url).openConnection();
            dogConnection.setRequestMethod("GET");
            BufferedImage dog = ImageIO.read(dogConnection.getURL());
            label.setIcon(
                    new ImageIcon(
                            new ImageIcon(dog)
                                    .getImage()
                                    .getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
        }catch (IndexOutOfBoundsException e){
            DogList.dogList().setCurrentDog(1);
        }
    }
}