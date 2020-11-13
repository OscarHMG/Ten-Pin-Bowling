/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.models;

import java.util.ArrayList;

/**
 *
 * @author OscarHMG
 */
public class Player {
    private String playerName;
    private ArrayList<Frame> frames;

    public Player(String playerName) {
        this.playerName = playerName;
        this.frames = new ArrayList<>();
    }

    
    
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public ArrayList<Frame> getFrames() {
        return frames;
    }

    public void setFrames(ArrayList<Frame> frames) {
        this.frames = frames;
    }
    
    
}
