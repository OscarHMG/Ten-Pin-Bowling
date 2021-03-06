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
    
    
    public static void main(String args[]) throws Exception{
        Application app = new Application();
        Game bowlingGame = new Game();

        Map<String, ArrayList<Roll>> inputData = app.readerService.readerLine(args[0]);
        bowlingGame.setPlayers(app.frameService.createPlayerFrames(inputData));
        app.gamePrinterService.printGame(bowlingGame);
        
    }
}
