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
public class Frame {
    private int scorePoints;
    
    //Max : 3 rolls at 10th frame. List is more easier to handle.
    private ArrayList<Roll> rolls;
    
    private boolean spare;
    private boolean strike;
    private boolean foul;
    
    public Frame(){
        this.rolls = new ArrayList<>();
    }
    
    public Frame(ArrayList<Roll> rolls){
        this.rolls = rolls;
    }
    
    
    
    public ArrayList<Roll> getRolls() {
        return rolls;
    }


    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public int getScorePoints() {
        return scorePoints;
    }

    public void setScorePoints(int scorePoints) {
        this.scorePoints = scorePoints;
    }
    
    
    public String getScorePointsByRoll(int position){ 
        String result = "";
        try{
            //result = "" + this.getRolls().get(position).getPinsDown();
            result = "" + this.getRolls().get(position).getCharValueScore();
        }catch(IndexOutOfBoundsException ex){
            result = "";
        }
    
        return result;
    }

    public boolean isFoul() {
        return foul;
    }

    public void setFoul(boolean foul) {
        this.foul = foul;
    }
    
    
    
    
}
