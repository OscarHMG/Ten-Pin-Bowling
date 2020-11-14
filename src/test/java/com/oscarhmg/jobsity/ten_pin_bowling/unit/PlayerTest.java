/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.unit;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Frame;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Player;
import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author OscarHMG
 */
public class PlayerTest {
    @Test
    public void testNamePlayer() {
        Player p = new Player("Oscar");
        Assert.assertEquals( "Oscar", p.getPlayerName() );
    }

    
    @Test
    public void testEmptyFrames(){
        Player p = new Player("Oscar");
        ArrayList<Frame> frames = new ArrayList<>();
        frames.add(buildFrame());
        p.setFrames(frames);
        
        Assert.assertFalse(p.getFrames().isEmpty());
    }
    
    public Frame buildFrame(){
        Frame f = new Frame();
        f.setStrike(true);
        Roll R1 = new Roll("10");
        ArrayList<Roll> rolls = new ArrayList<>();
        rolls.add(R1);
        f.setRolls(rolls);
        
        return f;
    }
    
}
