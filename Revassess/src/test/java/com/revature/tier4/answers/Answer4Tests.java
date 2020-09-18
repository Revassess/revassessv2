package com.revature.tier4.answers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.extension.ExtendWith;

import com.revature.dao.CrudRepository;
import com.revature.dao.FlashcardRepository;
import com.revature.exception.ResourceNotfoundException;
import com.revature.exception.ResourcePersistenceException;
import com.revature.model.Role;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt: Implement the entire class structure indicated in the provided class
 * diagram
 */
@ExtendWith(RevAssess.class)
public class Answer4Tests {

    @RevaTest(tier = 4, points = 40)
    public void testClasses() {
    	try {
        assertEquals("BASIC_USER", String.valueOf(Role.class .getEnumConstants()[2]));
        assertEquals(ResourceNotfoundException.class.getSuperclass(), Exception.class);
        assertEquals(CrudRepository.class, FlashcardRepository.class.getInterfaces()[0]);
        assertEquals(ResourcePersistenceException.class.getSuperclass(), Exception.class);
    	} catch(Exception e) {
    		fail();
    	}
    }
}