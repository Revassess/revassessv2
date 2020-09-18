package com.revature.tier3.answers;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.extension.ExtendWith;

import com.revature.config.TestConfig;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt: Create a table structure using the provided ERD, ensure that the
 * ability for auto-incrementing IDs
 */
@ExtendWith(RevAssess.class)
public class Answer3Tests {

    @RevaTest(tier = 3, points = 30)
    public void erdTest() {
        try{
        Session sess = TestConfig.getInstance().openSession();
        Transaction tx = sess.beginTransaction();
        assertNotNull(sess.createNativeQuery(
                "insert into app_user (username, password, first_name, last_name, role_id) values ('testing','testing','testing','testing',1"));
        assertNotNull(sess.createNativeQuery(
                "insert into flashcard (question, answer, category_id) values ('testing','testing',2)"));
        assertNotNull(sess.createNativeQuery("insert into study_set (name, owner_id) values ('testing',2)"));
        tx.rollback();
        } catch(Exception e){
            fail();
        }
    }

}