package com.revature.tier1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.extension.ExtendWith;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt:
 * Create a method that, given an integer, can 
 * raise each digit to the power of the overall 
 * length and return whether the sum of the powers 
 * is equal to the original integer.
 */
@ExtendWith(RevAssess.class)
public class Answer4Tests {

    @RevaTest(tier = 1, points = 40)
    public void powerSumTest(){
		assertTrue(NumberSumLength.checkNumberPowerLength(1));
		assertFalse(NumberSumLength.checkNumberPowerLength(10));
		assertTrue(NumberSumLength.checkNumberPowerLength(153));
		assertFalse(NumberSumLength.checkNumberPowerLength(1635));
    }
}