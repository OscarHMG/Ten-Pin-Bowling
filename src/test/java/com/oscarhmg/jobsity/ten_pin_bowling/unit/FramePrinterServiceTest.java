/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.unit;

import com.oscarhmg.jobsity.ten_pin_bowling.implementations.FramePrinterServiceImp;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import com.oscarhmg.jobsity.ten_pin_bowling.services.FramePrinterService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author OscarHMG
 */
public class FramePrinterServiceTest {
    
    
    private FramePrinterService framePrinterService;

    @Before
    public void init() {
        framePrinterService = new FramePrinterServiceImp();
    }
    
    
    @Test
    public void testPerfectLastFrameLine() {
        Frame frame = new Frame();
        Roll R1 = new Roll("10");
        Roll R2 = new Roll("10");
        Roll R3 = new Roll("10");

        frame.getRolls().add(R1);
        frame.getRolls().add(R2);
        frame.getRolls().add(R3);

        Assert.assertEquals("X X X", framePrinterService.printLastFramePerfectGame(frame));
    }
    
    
    
    @Test
    public void testFoulLastFrameLine() {
        Frame frame = new Frame();
        Roll R1 = new Roll("F");
        Roll R2 = new Roll("F");
        Roll R3 = new Roll("F");

        frame.getRolls().add(R1);
        frame.getRolls().add(R2);
        frame.getRolls().add(R3);

        Assert.assertEquals("F F F", framePrinterService.printLastFrameFoulGame(frame));
    }
    
    
    @Test
    public void testRegularFrameLine() {
        Frame frame = new Frame();
        Roll R1 = new Roll("1");
        Roll R2 = new Roll("5");

        frame.getRolls().add(R1);
        frame.getRolls().add(R2);


        Assert.assertNotEquals("5 1\t", framePrinterService.printRegularFrame(frame));
    }
    
    @Test
    public void testStrikeFrameLine() {
        Frame frame = new Frame();
        frame.setStrike(true);
        Roll R1 = new Roll("10");
        frame.getRolls().add(R1);

        Assert.assertEquals("X\t", framePrinterService.printFrameWithStrike(frame));
    }
}
