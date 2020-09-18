package com.revature.tier2;

import static com.revature.config.TestConfiguration.getFileContents;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import com.revature.config.TestConfiguration;
import com.revature.tier2.model.UserStudySet;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * prompt: Write a query that will find all user and study set info related to
 * the user with an id of 5
 * 
 */
@ExtendWith(RevAssess.class)
public class Answer3Tests {

    private String answer3Contents;

    @BeforeEach
    public void setup() {
        try {
            answer3Contents = getFileContents("answer3").replace(';', ' ');
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RevaTest(tier = 2, points = 30)
    public void userAndStudySetTest() {
        try (Session sess = TestConfiguration.getSessionFactory().openSession()) {
            Transaction tx = sess.beginTransaction();
            List<UserStudySet> users = sess.createNativeQuery(answer3Contents, UserStudySet.class).list();
            assertEquals(3, users.size());
            tx.rollback();
        }
    }

}