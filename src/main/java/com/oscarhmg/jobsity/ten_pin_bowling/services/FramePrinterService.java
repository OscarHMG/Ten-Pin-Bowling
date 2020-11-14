/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.services;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;


/**
 *
 * @author OscarHMG
 */
public interface FramePrinterService {
    
    public String printRegularFrame(Frame regularFrame );
    public String printFrameWithStrike(Frame strikeFrame);
    public String printFrameWithSpare(Frame spareFrame);
    public String printLastFrameWithStrike(Frame lastFrame);
}
