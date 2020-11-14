/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.implementations;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Game;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Player;
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
        for(Frame it : frames){
            if(it.isSpare()){
                pinfalls = pinfalls + framePrinterService.printFrameWithSpare(it);
            }else if(it.isStrike()){
                if(it.getRolls().size() == 1){
                    pinfalls = pinfalls + framePrinterService.printFrameWithStrike(it);
                }else{
                    pinfalls = pinfalls + framePrinterService.printLastFrameWithStrike(it);
                }
            }else{
                pinfalls = pinfalls + framePrinterService.printRegularFrame(it);
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
    
}
