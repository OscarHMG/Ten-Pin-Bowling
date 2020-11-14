/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.services;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Game;
import java.util.ArrayList;

/**
 *
 * @author OscarHMG
 */
public interface GamePrinterService {
    
    public void printGame(Game game);
    
    public String printHeaderFrames();
    
    public String printFrames(ArrayList<Frame> frames);
    
    public String printScore(ArrayList<Frame> frames);
    
}
