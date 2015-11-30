package com.braffa.tables;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.braffa.connection.GenericConnection;

public class LoginTableHsql extends LoginTable {
	
	private static final Logger logger = Logger.getLogger(LoginTableHsql.class);

	public LoginTableHsql(GenericConnection connection) {
		super(connection);
	}
	
	public void createTable() throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("");
		}
		connection.createTable(loginSQL.LoginTableHsql());
	}


}
