package com.revature.tier1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.extension.ExtendWith;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt:
 * Create a method that iterates 
 * over an integer array and returns 
 * their sum.
 */
@ExtendWith(RevAssess.class)
public class Answer3Tests {

    @RevaTest(tier = 1, points = 30)
    public void sumOverArrayTest() {
        int[] arr = { 1, 2, 3 };
        assertNotEquals(0, SumOverArray.IterateAndSum(arr));
        try {
            SumOverArray.IterateAndSum(null);
            assertTrue(true);
        } catch (NullPointerException e) {
            fail();
        }
        int [] arr2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        assertEquals(78, SumOverArray.IterateAndSum(arr2));
        int[] arr3 = { -1, -2, -3, -4, -5, -6, -7, -8, -9 };
		assertEquals(-45, SumOverArray.IterateAndSum(arr3));
		int[] arr4 = { 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80 };
		assertEquals(1095, SumOverArray.IterateAndSum(arr4));
    }

}