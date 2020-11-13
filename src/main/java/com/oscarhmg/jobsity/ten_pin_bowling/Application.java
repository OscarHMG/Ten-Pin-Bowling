/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling;

import com.oscarhmg.jobsity.ten_pin_bowling.implementations.FileReaderServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.implementations.FrameServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FileReaderService;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FrameService;
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
    
    
    public Application(){
        readerService = new FileReaderServiceImp();
        frameService = new FrameServiceImp();
    }
    
    
    public static void main(String args[]){
        //System.out.println("Hello World!");
        Application app = new Application();
        //String path = args[0];
        
        String path = "C:\\Users\\Usuario\\Desktop\\example1.txt";
        Map<String, ArrayList<Roll>> inputData = app.readerService.readerLine(path);
        app.frameService.createPlayerFrames(inputData);
    }
}
