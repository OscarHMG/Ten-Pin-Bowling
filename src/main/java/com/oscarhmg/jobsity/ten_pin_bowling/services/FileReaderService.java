/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.services;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author OscarHMG
 */
public interface FileReaderService {
    public Map<String, ArrayList<Roll>> readerLine(String pathFile);
}
