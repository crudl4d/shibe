package com.dog;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NextDoge implements ActionListener {
    private final JButton button = new JButton("NEXT DOGE");
    private final JLabel label;

    public NextDoge(JLabel label){
        label.setBounds(200,0,800,600);
        button.setVisible(true);
        button.setBounds(0,0,200,100);
        button.addActionListener(this);
        this.label = label;
    }

    @Override public void actionPerformed(ActionEvent e) {
        try {
            getDog();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //fetches image URL from API https://shibe.online/

    private String getImageUrl() throws IOException {
        URL url = new URL("http://shibe.online/api/shibes?count=1&urls=true&httpsUrls=true");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        String content = "";
        while ((inputLine = in.readLine()) != null) {
            content = content.concat(inputLine);
        }
        in.close();
        return content.substring(2, content.length() - 2);
    }
    public void getDog() throws IOException {
        String url;
        if(DogList.dogList().getCurrentDog() == DogList.dogList().getList().size()) {
            url = getImageUrl();
            DogList.dogList().getList().add(url);
        }
        else
            url = DogList.dogList().getList().get(DogList.dogList().getCurrentDog());

        HttpURLConnection dogConnection = (HttpURLConnection) new URL(url).openConnection();
        dogConnection.setRequestMethod("GET");
        BufferedImage dog = ImageIO.read(dogConnection.getURL());
        label.setIcon(
                new ImageIcon(
                        new ImageIcon(dog)
                                .getImage()
                                .getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH)));
        DogList.dogList().incrementCurrentDog();
    }

    public JButton getButton() {
        return button;
    }
}