/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.implementations;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Player;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FrameService;
import com.oscarhmg.jobsity.ten_pin_bowling.utils.TenPinBowlingConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author OscarHMG
 */
public class FrameServiceImp implements FrameService{

    @Override
    public ArrayList<Player> createPlayerFrames(Map<String, ArrayList<Roll>> rolls){
        ArrayList<Player> players = new ArrayList<Player>();
        
        Frame newFrame = null;
        
        for(String playerIt: rolls.keySet()){
            Player player = new Player(playerIt);
            ArrayList<Roll> rollChances = rolls.get(playerIt);
            boolean skipRoll = false;
            boolean lastFrame = false;
            ArrayList<Frame> framesByPlayer = new ArrayList<>();
            for(int counter = 0; counter < rollChances.size(); counter++){
                newFrame = null;
                if(skipRoll || lastFrame){
                    skipRoll = false;
                    continue;
                }
                
                //Minimun: 2 Rolls - LastFrame have 3 Rolls.
                Roll R1 = rollChances.get(counter);
                Roll R2 = rollChances.get(counter + 1);
                Roll R3 = counter + 2 < rollChances.size() ? rollChances.get(counter + 2) : null;
                
                if(R1.getPinsDown() == TenPinBowlingConstants.PINS_STRIKE){
                    if(framesByPlayer.size() == TenPinBowlingConstants.MAX_FRAMES - 1)
                        newFrame = createFrame(true, false, R1, R2, R3, R1.getPinsDown(), R2.getPinsDown(), R3.getPinsDown());
                    else
                        newFrame = createFrame(true, false, R1, null, null, R1.getPinsDown(), R2.getPinsDown(), (R3 != null)? R3.getPinsDown() : 0);
                    skipRoll = false;
                }else{
                    //Spare Case: only with 2 rolls
                    skipRoll = true;
                    if(R1.getPinsDown() + R2.getPinsDown() == TenPinBowlingConstants.PINS_STRIKE)
                        newFrame = createFrame(false, true, R1, R2, null, R1.getPinsDown(), R2.getPinsDown(), (R3 != null)? R3.getPinsDown() : 0);
                    else //Create roll with the fallen pins.
                        newFrame = createFrame(false, false, R1, R2, null, R1.getPinsDown(), R2.getPinsDown(), 0);
                }
                framesByPlayer.add(newFrame);
                lastFrame = framesByPlayer.size() == 10;
            }
            
            
            player.setFrames(framesByPlayer);
            //When you load all the frames, calculate the score.
            player.calculateGlobalScore();
            players.add(player);
        }
        return players;
    }
    
    @Override
    public Frame createFrame(boolean strike, boolean spare, Roll R1 , Roll R2, Roll R3, int scoreR1, int scoreR2, int scoreR3){
        Frame frame = new Frame();
        frame.setStrike(strike);
        frame.setSpare(spare);
        frame.getRolls().add(R1);
        if(R2 != null)
            frame.getRolls().add(R2);
        if(R3 != null)
            frame.getRolls().add(R3);
        
        
        frame.setScorePoints(scoreR1 + scoreR2 + scoreR3);
        return frame;
    }
}
