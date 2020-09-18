package com.revature.tier1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.extension.ExtendWith;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt:
 * Create a method that checks if 
 * two strings are equal and return 
 * the boolean result.
 */
@ExtendWith(RevAssess.class)
public class Answer1Tests {

    @RevaTest(tier = 1, points = 10)
    public void stringEqualityTest(){
        assertFalse(CompareStrings.compareStrings("s1", "s2"));
        assertTrue(CompareStrings.compareStrings("hello", new String("hello")));
        assertTrue(CompareStrings.compareStrings("longhorn", new String("longhorn")));
        assertTrue(CompareStrings.compareStrings("gentleman", new String("gentleman")));
        assertFalse(CompareStrings.compareStrings("jekyll", "hyde"));
        assertFalse(CompareStrings.compareStrings("giraffes", "real"));
    }

}
