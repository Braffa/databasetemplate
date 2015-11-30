package com.braffa.tables;

import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.braffa.connection.GenericConnection;

public class RegisteredUserTableHsql extends RegisteredUserTable {

	private static final Logger logger = Logger.getLogger(RegisteredUserTableHsql.class);
	
	public RegisteredUserTableHsql (GenericConnection connection) {
		super(connection);
	}

	@Override
	public void createTable() throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("");
		}
		connection.createTable(registeredUserSQL.creatTableHSQL());
	}


}
