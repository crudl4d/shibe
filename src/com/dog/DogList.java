package com.dog;

import java.util.LinkedList;
import java.util.List;

public final class DogList {
    private static DogList INSTANCE;
    private final List<String> dogList = new LinkedList<>();
    private int currentDog = 0;
    private DogList(){
    }
    public static DogList dogList(){
        if(INSTANCE == null)
            INSTANCE = new DogList();
        return INSTANCE;
    }
    public void incrementCurrentDog(){
        currentDog++;
    }
    public List<String> getList(){
        return dogList;
    }

    public void setCurrentDog(int currentDog) {
        this.currentDog = currentDog;
    }

    public int getCurrentDog() {
        return currentDog;
    }
}