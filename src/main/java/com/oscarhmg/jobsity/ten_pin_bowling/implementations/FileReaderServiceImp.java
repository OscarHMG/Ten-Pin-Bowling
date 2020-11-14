/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.implementations;

import com.oscarhmg.jobsity.ten_pin_bowling.exception.InvalidLineFormatException;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FileReaderService;
import com.oscarhmg.jobsity.ten_pin_bowling.utils.ValidatorFileParseUtils;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.xml.bind.Validator;

/**
 *
 * @author OscarHMG
 */
public class FileReaderServiceImp implements FileReaderService{

    
    public ValidatorFileParseUtils validator = new ValidatorFileParseUtils();
    
    /**
     * Read the file and store in a map. 
     * If the user exist in the map, add the rolls to the current player.
     * If not exist, create a new Key(PlayerName) and create the rolls to add the scores.
     * @param pathFile File path
     * @return 
     */
    @Override
    public Map<String, ArrayList<Roll>> readerLine(String pathFile) {
        Map<String, ArrayList<Roll>> playerRolls = null;
        try{
            playerRolls = new HashMap<>();
            
            Stream<String> streamData = Files.lines(Paths.get(pathFile));
            
            for (String iterator : streamData.collect(Collectors.toList())) {
                /*String [] line = iterator.split(" ");
                String playerName = line[0];
                String score = line[1];
                ArrayList<Roll> rolls = playerRolls.get(playerName) == null ? new ArrayList<>() : playerRolls.get(playerName);
                rolls.add(new Roll(score));
                playerRolls.put(playerName, rolls);*/
                
                if(validator.checkGeneralInputFormat(iterator)){
                    String [] line = iterator.split(" ");
                    String playerName = line[0];
                    String score = line[1];
                    ArrayList<Roll> rolls = playerRolls.get(playerName) == null ? new ArrayList<>() : playerRolls.get(playerName);
                    rolls.add(new Roll(score));
                    playerRolls.put(playerName, rolls);
                }else{
                    throw new InvalidLineFormatException("The lines of the file do not comply with the established format.");
                }
                
            }
            
            
        }catch(IOException ex){
            System.out.println("Error could not read the file. Make sure the path entered is correct.");
        }catch(InvalidLineFormatException ex){
            System.out.println(ex.getMessage());
            
        }
        
        return playerRolls;
    }
    
}
