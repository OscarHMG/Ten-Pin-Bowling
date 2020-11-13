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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author OscarHMG
 */
public class FrameServiceImp implements FrameService{

    @Override
    public ArrayList<Player> createPlayerFrames(Map<String, ArrayList<Roll>> rolls) {
        ArrayList<Player> players = new ArrayList<Player>();
        
        Frame newFrame = null;
        
        for(String playerIt: rolls.keySet()){
            Player player = new Player(playerIt);
            ArrayList<Roll> rollChances = rolls.get(playerIt);
            boolean skipRoll = false;
            ArrayList<Frame> framesByPlayer = new ArrayList<>();
            for(int counter = 0; counter < rollChances.size(); counter++){
                
                
                
                if(skipRoll){
                    //skip and go next
                    skipRoll = false;
                    continue;
                }
                
                //Minimun: 2 Rolls - LastFrame have 3 Rolls.
                Roll R1 = rollChances.get(counter);
                Roll R2 = rollChances.get(counter + 1);
                Roll R3 = counter + 2 < rollChances.size() ? rollChances.get(counter + 2) : null;
                
                //Create frame.
                newFrame = new Frame();
                
                
                //////this need to be refactor.
                
                //STRIKE CASE: Strike at R1 only! (At last frame ???? chekc later)
                if(R1.getPinsDown() == 10){
                    //PENDING!???????
                    newFrame.setSpare(false);
                    newFrame.setStrike(true);
                    newFrame.getRolls().add(R1);
                    int score =R1.getPinsDown() + R2.getPinsDown() + ((R3 != null)? R3.getPinsDown() : 0);
                    newFrame.setScorePoints(score);
                    skipRoll = false;
                }else{
                    //Spare Case: only with 2 rolls
                    skipRoll = true;
                    if(R1.getPinsDown() + R2.getPinsDown() == 10){
                        newFrame.setStrike(false);
                        newFrame.setSpare(true);
                        newFrame.getRolls().add(R1);
                        newFrame.getRolls().add(R2);
                        int scoreSpare = R1.getPinsDown() + R2.getPinsDown() + ((R3 != null)? R3.getPinsDown() : 0);
                        newFrame.setScorePoints(scoreSpare);
                    }else{
                        //Create roll with the fallen pins.
                        newFrame.setStrike(false);
                        newFrame.setSpare(false);
                        newFrame.getRolls().add(R1);
                        newFrame.getRolls().add(R2);
                        newFrame.setScorePoints(R1.getPinsDown() + R2.getPinsDown());
                    }
                }
                //counter++;
                framesByPlayer.add(newFrame);
            }
            player.setFrames(framesByPlayer);
            players.add(player);
        }
        
        
        return players;
        
    }
    
//    Frame frame;
//        if (rollValidator.isStrike(currentRoll)) {
//            frame = createStrikeFrame(currentRoll, nextRoll, overNextRoll, resultSize);
//        } else {
//            if (rollValidator.isSpare(currentRoll, nextRoll)) {
//                frame = createSpareFrame(currentRoll, nextRoll, overNextRoll);
//            } else {
//                frame = createStandardFrame(currentRoll, nextRoll);
//            }
//        }
//        return frame;
    
    
}
