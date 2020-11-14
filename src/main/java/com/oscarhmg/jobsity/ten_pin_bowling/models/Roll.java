/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.models;

/**
 *
 * @author OscarHMG
 */
public class Roll {
    private int pinsDown;
    private String stringPinsDownScore;

    public Roll() {
        this.pinsDown = 0;
        this.stringPinsDownScore = "";
    }

    
    /**
     * Create Roll based on char value
     * @param charValueScore If F, then 0. Otherwise, the representation of the number.
     */
    public Roll(String charValueScore) {
        if(charValueScore.equalsIgnoreCase("F")){
            this.pinsDown = 0;
            this.stringPinsDownScore = "F";
        }else{
            this.pinsDown = Integer.parseInt(charValueScore);
            this.stringPinsDownScore = charValueScore;
        }
    }
    
    
    
    

    public int getPinsDown() {
        return pinsDown;
    }

    public void setPinsDown(int pinsDown) {
        this.pinsDown = pinsDown;
    }

    public String getCharValueScore() {
        return stringPinsDownScore;
    }

    public void setCharValueScore(String charValueScore) {
        this.stringPinsDownScore = charValueScore;
    }
    
    
    
}
