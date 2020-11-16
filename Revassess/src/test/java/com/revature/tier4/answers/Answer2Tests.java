package com.revature.tier4.answers;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import com.revature.config.ConnectionUtil;

import dev.ranieri.assesors.RevAssess;
import dev.ranieri.assesors.RevaTest;

/**
 * prompt: implement the ConnectionConfig class's callAbsoluteValueFunction
 * method with a callable statement to call the absolute value scalar function.
 */
@ExtendWith(RevAssess.class)
public class Answer2Tests {
	private ConnectionUtil cu, mockedConnectionUtil;
	private CallableStatement mockedCallableStatement;
	private Connection mockedConnection;

	@BeforeEach
	public void setup() {
		cu = ConnectionUtil.getInstance();
		mockedCallableStatement = mock(CallableStatement.class);
		mockedConnection = mock(Connection.class);
		mockedConnectionUtil = mock(ConnectionUtil.class);
	}

	/**
	 * This method will first check if the method returns the desired value, then
	 * checks if the method has invoked anything on a mocked object. This will only
	 * work if the method utilizes the connect() method each time it is ran.
	 */
	@RevaTest(tier = 4, points = 20)
	public void absoluteFunTest() throws SQLException {
		try {
			// test the returned value
			assertEquals(100, cu.callAbsoluteValueFunction(-100));
			assertEquals(60, cu.callAbsoluteValueFunction(60));

			// test that the method uses a callable statement
			when(mockedConnectionUtil.connect()).thenReturn(mockedConnection);
			when(mockedConnection.prepareCall(anyString())).thenReturn(mockedCallableStatement);
			when(mockedConnectionUtil.callAbsoluteValueFunction(anyLong())).thenCallRealMethod();
			mockedConnectionUtil.callAbsoluteValueFunction(10);
			//Determine if any method has been called on the callable statement
			assertFalse(Mockito.mockingDetails(mockedCallableStatement).getInvocations().isEmpty());
		} catch (Exception e) {
			fail();
		}
	}
}