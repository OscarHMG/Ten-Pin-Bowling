/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oscarhmg.jobsity.ten_pin_bowling.unit;

import com.oscarhmg.jobsity.ten_pin_bowling.models.Roll;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author OscarHMG
 */
public class RolTest {
    
    @Test
    public void testFoulRoll(){
        Roll R1 = createRoll("f");
        Assert.assertEquals("F", R1.getCharValueScore());
    }
    
    
    @Test
    public void testNormalRoll(){
        Roll R1 = createRoll("9");
        Assert.assertEquals("9", R1.getCharValueScore());
    }
    
    public Roll createRoll(String value){
        Roll R1 = new Roll(value);
        return R1;
    }
    
}
