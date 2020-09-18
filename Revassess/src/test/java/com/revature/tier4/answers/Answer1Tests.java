package com.revature.tier4.answers;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import com.revature.config.ConnectionUtil;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt: Establish a connection to a deployed database using JDBC.
 */
@ExtendWith(RevAssess.class)
public class Answer1Tests {

	private ConnectionUtil cu;

	@BeforeEach
	public void setup() {
		cu = ConnectionUtil.getInstance();
	}

	@RevaTest(tier = 4, points = 10)
	public void testConnection() throws SQLException {
		try {
			assertNotNull(cu.connect());
			assertTrue(cu.connect().isValid(5));
		} catch (Exception e) {
			fail();
		}
	}
}