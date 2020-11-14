/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.services;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Player;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author OscarHMG
 */
public interface FrameService {
    
    public ArrayList<Player> createPlayerFrames(Map<String, ArrayList<Roll>> rolls);
    
    public Frame createFrame(boolean strike, boolean spare, Roll R1 , Roll R2, Roll R3, int scoreR1, int scoreR2, int scoreR3);
}
