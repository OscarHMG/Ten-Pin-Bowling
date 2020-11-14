/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling;

import com.oscarhmg.jobsity.ten_pin_bowling.implementations.FileReaderServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.implementations.FrameServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.implementations.GamePrinterServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Game;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FileReaderService;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FrameService;
import com.oscarhmg.jobsity.ten_pin_bowling.services.GamePrinterService;
import java.util.ArrayList;
import java.util.Map;
import javax.print.DocFlavor;

/**
 *
 * @author Usuario
 */
public class Application {
    
    private FileReaderService readerService;
    
    private FrameService frameService;
    
    private GamePrinterService gamePrinterService;
    
    
    public Application(){
        readerService = new FileReaderServiceImp();
        frameService = new FrameServiceImp();
        gamePrinterService = new GamePrinterServiceImp();
    }
    
    
    public static void main(String args[]){
        //System.out.println("Hello World!");
        Application app = new Application();
        Game bowlingGame = new Game();
        //String path = args[0];
        
        String path = "C:\\Users\\Usuario\\Desktop\\example1.txt";
        Map<String, ArrayList<Roll>> inputData = app.readerService.readerLine(path);
        bowlingGame.setPlayers(app.frameService.createPlayerFrames(inputData));
        
        System.out.println(app.gamePrinterService.printHeaderFrames());    
        System.out.println(app.gamePrinterService.printFrames(bowlingGame.getPlayers().get(0).getFrames()));
        System.out.println(app.gamePrinterService.printScore(bowlingGame.getPlayers().get(0).getFrames()));
        //app.gamePrinterService.printScore(bowlingGame.getPlayers().get(0).getFrames());
    }
}
