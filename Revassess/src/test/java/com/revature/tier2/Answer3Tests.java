package com.revature.tier2;

import static com.revature.config.TestConfiguration.getFileContents;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import com.revature.config.TestConfiguration;
import com.revature.tier2.model.UserStudySet;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

/**
 * prompt: Write a query that will find all user and study set info related to
 * the user with an id of 5
 * 
 */
public class Answer3Tests {

    private String answer3Contents;

    @Before
    public void setup() {
        try {
            answer3Contents = getFileContents("answer3").replace(';', ' ');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test3() {
        try (Session sess = TestConfiguration.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            List<UserStudySet> users = sess.createNativeQuery(answer3Contents, UserStudySet.class).list();
            assertEquals(3, users.size());
            tx.rollback();
            PointsTests.addPoints(30);
        } catch(Exception e){
            fail();
        }
    }

}
