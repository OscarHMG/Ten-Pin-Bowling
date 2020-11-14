/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.utils;

import com.oscarhmg.jobsity.ten_pin_bowling.exception.InvalidLineFormatException;

/**
 *
 * @author OscarHMG
 */
public class ValidatorFileParseUtils {
    public boolean checkGeneralInputFormat(String line) throws InvalidLineFormatException{
        boolean match = false;
        boolean pinValidator = false;
        if(line.matches(TenPinBowlingConstants.REGEX_EXPRESSION)){
            match = true;
            pinValidator = checkPinDataFormat(line.split(" ")[1]);
        }
        
        return match && pinValidator;
    }
    
    
    public boolean checkPinDataFormat(String pin){
        boolean match = false;
        if(pin.equalsIgnoreCase("F") || Integer.parseInt(pin) <= TenPinBowlingConstants.MAX_PINS_GAME){
            match = true;
        }
        return match;
        

    }
}
