package com.revature.tier2;

import static com.revature.config.TestConfiguration.getFileContents;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import com.revature.config.TestConfiguration;
import com.revature.tier2.model.User;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

/**
 * prompt: Write a statement that will insert a new user into the APP_user table
 * with a role of PREMIUM_user
 * 
 */
public class Answer2Tests {

    private String answer2Contents;

    @Before
    public void setup() {
        try {
            answer2Contents = getFileContents("answer2").replace(';', ' ');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() {
        try (Session sess = TestConfiguration.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            List<User> after, before;
            before = sess.createQuery("from User where roleId=4", User.class).list();
            sess.createNativeQuery(answer2Contents, User.class).executeUpdate();
            after = sess.createQuery("from User where roleId=4", User.class).list();
            assertEquals(after.size(), before.size() + 1);
            tx.rollback();

            PointsTests.addPoints(20);
        } catch(Exception e){
            fail();
        }
    }
}
