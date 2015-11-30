package com.braffa.sqlqueries;

import com.braffa.model.Login;

public class LoginSQL {

	public String createTableSQL() {
		StringBuffer sb = new StringBuffer(
				"CREATE TABLE LOGIN (userId VARCHAR(20), password VARCHAR(12), authorityLevel VARCHAR(2), ");
		sb.append("CRDATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, ");
		sb.append("UPDDATE TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  ON UPDATE CURRENT_TIMESTAMP,");
		sb.append("PRIMARY KEY (userId))");
		return sb.toString();
	}

	public String LoginTableHsql() {
		return "CREATE TABLE LOGIN ("
				+ " id INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) not null, "
				+ " userId VARCHAR(20), " + " password VARCHAR(12), "
				+ " authorityLevel INTEGER, CRDATE TIMESTAMP, UPDDATE TIMESTAMP, PRIMARY KEY (userId) )";
	}

	public String createSQL(Login login) {
		StringBuffer sb = new StringBuffer(
				"INSERT INTO LOGIN (userId, password, authorityLevel, CRDATE, UPDDATE) VALUES (");
		sb.append("'" + login.getUserId() + "', ");
		sb.append("'" + login.getPassword() + "', ");
		sb.append(login.getAuthorityLevel() + ", ");
		sb.append("CURRENT_TIMESTAMP,  CURRENT_TIMESTAMP)");
		return sb.toString();
	}

	public String dropSQL() {
		return "DROP TABLE LOGIN ";
	}

	public String readSQL(String userId) {
		StringBuffer sb = new StringBuffer(
				"SELECT USERID, PASSWORD, AUTHORITYLEVEL, CRDATE, UPDDATE FROM LOGIN WHERE USERID = '");
		sb.append(userId + "'");
		return sb.toString();
	}

	public String readAllSQL() {
		return "SELECT USERID, PASSWORD, AUTHORITYLEVEL, CRDATE, UPDDATE FROM LOGIN ";
	}

	public String updateSQL(Login login) {
		StringBuffer sb = new StringBuffer("UPDATE LOGIN SET ");
		if (login.getPassword().length() > 0 && login.getAuthorityLevel().length() > 0) {
			sb.append("PASSWORD = '" + login.getPassword() + "', ");
			sb.append("AUTHORITYLEVEL = '" + login.getAuthorityLevel() + "' ");
		} else if (login.getPassword().length() > 0) {
			sb.append("PASSWORD = '" + login.getPassword() + "' ");
		} else if (login.getAuthorityLevel().length() > 0) {
			sb.append("AUTHORITYLEVEL = '" + login.getAuthorityLevel() + "' ");
		}
		sb.append("WHERE USERID = '" + login.getUserId() + "'");
		return sb.toString();
	}

	public String deleteSQL(String userId) {
		StringBuffer sb = new StringBuffer("DELETE FROM LOGIN ");
		sb.append(" WHERE USERID = '" + userId + "'");
		return sb.toString();
	}
}