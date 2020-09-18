package com.revature.tier4.answers;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.extension.ExtendWith;

import com.revature.dao.UserRepository;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;
/**
 * 
 * prompt:
 * Implement only the CrudRepository 
 * interface methods within UserRepository 
 * class using the provided class diagram
 * 
 */
@ExtendWith(RevAssess.class)
public class Answer3Tests {

    @RevaTest(tier = 4, points = 30)
    public void testImplementation(){
    	try {
        Class<?>[] interfaces = UserRepository.class.getInterfaces();
        System.out.println(interfaces[0]);
        assertTrue(asList(interfaces).contains(com.revature.dao.CrudRepository.class));
    	} catch(Exception e) {
    		fail();
    	}
    }
}