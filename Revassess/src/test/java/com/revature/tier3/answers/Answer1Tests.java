package com.revature.tier3.answers;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.hibernate.Session;
import org.junit.jupiter.api.extension.ExtendWith;

import com.revature.config.TestConfig;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt: Add an AWS RDS Instance jdbc url and credentials to the configuration
 * file (vendor can be either Oracle or PostgreSQL)
 */
@ExtendWith(RevAssess.class)
public class Answer1Tests {

    /**
     * tests the connection to the db instance to ensure there is one
     */
    @RevaTest(tier = 3, points = 10)
    public void connectionTest() {
        try{
        Session sess = TestConfig.getInstance().openSession();
        assertTrue(sess.isConnected());
        } catch(Exception e){
            fail();
        }
    }
}