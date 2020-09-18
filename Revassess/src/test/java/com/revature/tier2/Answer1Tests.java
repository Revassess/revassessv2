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
 * prompt: Write a query that will find all user info related to users with a
 * role of BASIC_USER
 */
@ExtendWith(RevAssess.class)
public class Answer1Tests {

    private String answer1Contents;

    @BeforeEach
    public void setup() {
        try {
            answer1Contents = getFileContents("answer1").replace(';', ' ');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RevaTest(tier = 2, points = 10)
    public void basicUserTest() {
        try (Session sess = TestConfiguration.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            List<User> users = sess.createNativeQuery(answer1Contents, User.class).list();
            assertEquals(1, users.size());
            assertEquals(3, users.get(0).getUserRole());
            assertEquals("Jason", users.get(0).getFirstName());
            assertEquals("Knighten", users.get(0).getLastName());
            assertEquals("knifehand", users.get(0).getPassword());
            assertEquals("mknighten", users.get(0).getUsername());
            tx.rollback();
        }
    }
}