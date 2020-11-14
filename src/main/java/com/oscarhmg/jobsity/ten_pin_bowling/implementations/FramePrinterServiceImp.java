/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.implementations;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.utils.TenPinBowlingConstants;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FramePrinterService;

/**
 *
 * @author OscarHMG
 */
public class FramePrinterServiceImp implements FramePrinterService{

    
    
    /**
     * Print Regular Frame (Print third roll if exist.)
     * @param regularFrame
     * @return 
     */
    @Override
    public String printRegularFrame(Frame regularFrame) {
        return  regularFrame.getScorePointsByRoll(0)+" "
                 + regularFrame.getScorePointsByRoll(1)+"\t"
                 + regularFrame.getScorePointsByRoll(2)+" ";
    }
    

    /**
     * Print frame marked as strike.
     * @param strikeFrame
     * @return 
     */
    @Override
    public String printFrameWithStrike(Frame strikeFrame) {
        return TenPinBowlingConstants.STRIKE + "\t";
    }

    /**
     * Print frame marked as spare
     * @param spareFrame
     * @return 
     */
    @Override
    public String printFrameWithSpare(Frame spareFrame) {
        return spareFrame.getScorePointsByRoll(0)+" "
               + TenPinBowlingConstants.SPARE +"\t";
    }

    
    /**
     * Print the last Frame with striked mark.
     * @param lastFrame
     * @return 
     */
    @Override
    public String printLastFrameWithStrike(Frame lastFrame) {
        return TenPinBowlingConstants.STRIKE + " " 
                + lastFrame.getScorePointsByRoll(1)+" "
                + lastFrame.getScorePointsByRoll(2);
    }
    
    
    @Override
    public String printLastFramePerfectGame(Frame lastFrame) {
        return TenPinBowlingConstants.STRIKE + " " 
                + TenPinBowlingConstants.STRIKE +" "
                + TenPinBowlingConstants.STRIKE;
    }

    @Override
    public String printLastFrameFoulGame(Frame lastFrame) {
        return "F F F";
        
    }
    
}
