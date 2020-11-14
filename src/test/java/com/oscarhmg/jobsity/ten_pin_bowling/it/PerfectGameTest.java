/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.it;

import com.oscarhmg.jobsity.ten_pin_bowling.implementations.FileReaderServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.implementations.FrameServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.implementations.GamePrinterServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Game;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Player;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FileReaderService;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FrameService;
import com.oscarhmg.jobsity.ten_pin_bowling.services.GamePrinterService;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author OscarHMG
 */
public class PerfectGameTest {
    private FileReaderService readerService;
    
    private FrameService frameService;
    
    private GamePrinterService gamePrinterService;
    
    private Game bowlingGame;
    
    
    
    @Before
    public void init() throws Exception {
        bowlingGame = new Game();
        readerService = new FileReaderServiceImp();
        frameService = new FrameServiceImp();
        gamePrinterService = new GamePrinterServiceImp();
    }
    
    @Test
    public void testPerfectGameToOnePlayer(){
        Map<String, ArrayList<Roll>> inputData = readerService.readerLine(getAbsoluteTestFiles("Perfect-Game.txt"));
        bowlingGame.setPlayers(frameService.createPlayerFrames(inputData));
        boolean result = gamePrinterService.isPerfectGame(bowlingGame.getPlayers().get(0).getFrames());
        Assert.assertEquals(true, result);
    }
    
    
    @Test
    public void testPerfectGameTwoPlayers(){
        Map<String, ArrayList<Roll>> inputData = readerService.readerLine(getAbsoluteTestFiles("Perfect-Game-Two-Players.txt"));
        bowlingGame.setPlayers(frameService.createPlayerFrames(inputData));
        
        for(Player p : bowlingGame.getPlayers()){
            Assert.assertEquals(true, gamePrinterService.isPerfectGame(p.getFrames()));
        }
    }
    
    @Test
    public void testFoulGameOnePlayer(){
        Map<String, ArrayList<Roll>> inputData = readerService.readerLine(getAbsoluteTestFiles("Foul-Game.txt"));
        bowlingGame.setPlayers(frameService.createPlayerFrames(inputData));
        Assert.assertEquals(true, gamePrinterService.isFoulGame(bowlingGame.getPlayers().get(0).getFrames()));
    }
    
    
    @Test
    public void testFoulGameTwoPlayer(){
        Map<String, ArrayList<Roll>> inputData = readerService.readerLine(getAbsoluteTestFiles("Foul-Game-Two-Players.txt"));
        bowlingGame.setPlayers(frameService.createPlayerFrames(inputData));
        for(Player p : bowlingGame.getPlayers()){
            Assert.assertEquals(true, gamePrinterService.isFoulGame(p.getFrames()));
        }
    }
    
    
    
    public String getAbsoluteTestFiles(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile()).getAbsolutePath();

    }
}
