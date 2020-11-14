/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.implementations;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Game;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Player;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FramePrinterService;
import com.oscarhmg.jobsity.ten_pin_bowling.services.GamePrinterService;
import java.util.ArrayList;

/**
 *
 * @author OscarHMG
 */
public class GamePrinterServiceImp implements GamePrinterService{

    
    public FramePrinterService framePrinterService = new FramePrinterServiceImp();
    
    
    @Override
    public String printHeaderFrames() {
        String header = "Frame\t\t";    
        for(int i = 1; i <= 10; i++)
        {
            header = header + i +"\t";
        }
        
        return header;
    }

    @Override
    public String printFrames(ArrayList<Frame> frames) {
        String pinfalls = "Pinfalls\t";
        
        if (isPerfectGame(frames)) {
            for (Frame it : frames) {
                if (it.getRolls().size() == 1) {
                    pinfalls = pinfalls + framePrinterService.printFrameWithStrike(it);
                } else {
                    pinfalls = pinfalls + framePrinterService.printLastFramePerfectGame(it);
                }
            }
            
        }
        else if(isFoulGame(frames)){
            int counterFrames = 0;
            for (Frame it : frames) {
                if(frames.size() == counterFrames + 1){
                    pinfalls = pinfalls + framePrinterService.printLastFrameFoulGame(it);
                }else{
                    pinfalls = pinfalls + framePrinterService.printRegularFrame(it);
                }
                counterFrames++;
            }
        }else {
            for (Frame it : frames) {
                if (it.isSpare()) {
                    pinfalls = pinfalls + framePrinterService.printFrameWithSpare(it);
                } else if (it.isStrike()) {
                    if (it.getRolls().size() == 1) {
                        pinfalls = pinfalls + framePrinterService.printFrameWithStrike(it);
                    } else {
                        pinfalls = pinfalls + framePrinterService.printLastFrameWithStrike(it);
                    }
                } else {
                    pinfalls = pinfalls + framePrinterService.printRegularFrame(it);
                }
            }
        }
        
        
        
        
        return pinfalls;
    }
    
    
    public String printScore(ArrayList<Frame> frames){
        String score = "Score\t\t";
        int acum = 0;
        for(Frame it : frames){
            acum = acum + it.getScorePoints();
            score = score + acum + "\t";
        }
        return score;
    }

    @Override
    public void printGame(Game game) {
        System.out.println("");
        System.out.println("------------------------------------------------- CHALLENGE JOBSITY -------------------------------------------------");
        System.out.println("");

        for(Player it : game.getPlayers()){
            System.out.println(printHeaderFrames());
            System.out.println("Player: " +it.getPlayerName());
            System.out.println(printFrames(it.getFrames()));
            System.out.println(printScore(it.getFrames()));
            System.out.println("");
            System.out.println("------------------------------------------------------------------------------------------------------------");
            System.out.println("");
        }
    }
    
    @Override
    public boolean isPerfectGame(ArrayList<Frame> frames){
        boolean isPerfectGame = true;
        
        for(Frame it: frames){
            if(!it.isStrike() && isPerfectGame){
                isPerfectGame = false;
                break;
            }
        }
        
        return isPerfectGame;
    }
    
    @Override
    public boolean isFoulGame(ArrayList<Frame> frames){
        boolean isFoulGame = true;
        
        for (Frame it : frames) {
            if (isFoulGame) {
                for (Roll roll : it.getRolls()) {
                    if (!roll.getCharValueScore().equalsIgnoreCase("f")) {
                        isFoulGame = false;
                        break;
                    }
                }
            }

        }
        
        return isFoulGame;
    }
    
}
