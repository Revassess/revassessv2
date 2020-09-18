package com.revature.tier2;

import static com.revature.config.TestConfiguration.getFileContents;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import com.revature.config.TestConfiguration;
import com.revature.tier2.model.User;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * prompt: Write a statement that will insert a new user into the APP_user table
 * with a role of PREMIUM_user
 * 
 */
@ExtendWith(RevAssess.class)
public class Answer2Tests {

    private String answer2Contents;

    @BeforeEach
    public void setup() {
        try {
            answer2Contents = getFileContents("answer2").replace(';', ' ');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RevaTest(tier = 2, points = 20)
    public void insertPremUserTest() {
        try (Session sess = TestConfiguration.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            List<User> after, before;
            before = sess.createQuery("from User where roleId=4", User.class).list();
            sess.createNativeQuery(answer2Contents, User.class).executeUpdate();
            after = sess.createQuery("from User where roleId=4", User.class).list();
            assertEquals(after.size(), before.size() + 1);
            tx.rollback();
        }
    }
}