/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.unit;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author OscarHMG
 */
public class FrameTest {
    
    @Test
    public void testStrikeFrame(){
        Frame f = new Frame();
        
        f.setStrike(true);
        
        Assert.assertTrue(f.isStrike());
    }
    
    @Test
    public void testSpareFrame(){
        Frame f = new Frame();
        f.setSpare(true);
        Assert.assertTrue(f.isSpare());
    }
    
    @Test
    public void testFoulFrame(){
        Frame f = new Frame();
        f.setFoul(true);
        Assert.assertTrue(f.isFoul()); 
    }
    
    @Test
    public void testRegularFrame(){
        Frame f = new Frame();

        Assert.assertTrue(!f.isStrike() && !f.isSpare()); 
    }
    
    
    
    
    
}
