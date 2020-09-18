package com.revature.tier4.answers;

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
			verify(mockedCallableStatement).execute();
		} catch (Exception e) {
			fail();
		}
	}
}