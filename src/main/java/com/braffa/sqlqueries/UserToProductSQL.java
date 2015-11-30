package com.braffa.sqlqueries;

import java.sql.SQLException;

import com.braffa.model.UserToProduct;

public class UserToProductSQL {
	
	public String createTableSQL() throws SQLException {
		StringBuffer sql = new StringBuffer("CREATE TABLE USERTOPRODUCT ");
		sql.append(" (id INT NOT NULL AUTO_INCREMENT, ");
		sql.append(" userId VARCHAR(20), " + " productId VARCHAR(20), ");
		sql.append(" productIndex INT, ");
		sql.append(" CRDATE TIMESTAMP,      ");
		sql.append(" UPDDATE TIMESTAMP,     ");
		sql.append(" PRIMARY KEY ( id ))");
		return sql.toString();
	}
	
	public String createTableHsql() throws SQLException {
		StringBuffer sql = new StringBuffer("CREATE TABLE USERTOPRODUCT ");
		sql.append(" (id INTEGER GENERATED BY DEFAULT AS IDENTITY (START WITH 1, INCREMENT BY 1) not null, ");
		sql.append(" userId VARCHAR(20), " + " productId VARCHAR(20), ");
		sql.append(" productIndex VARCHAR(20), ");
		sql.append(" CRDATE TIMESTAMP,      ");
		sql.append(" UPDDATE TIMESTAMP,     ");
		sql.append(" PRIMARY KEY ( id ))");
		return sql.toString();
	}
	
	public String createSQL(UserToProduct userToProduct) throws SQLException {
		StringBuffer sql = new StringBuffer(
				"INSERT INTO USERTOPRODUCT (userId, productId, productIndex, CRDATE, UPDDATE) VALUES (");
		sql.append("'" + userToProduct.getUserId() + "', ");
		sql.append("'" + userToProduct.getProductId() + "', ");
		sql.append("'" + userToProduct.getProductIndex() + "', ");
		sql.append("CURRENT_TIMESTAMP, ");
		sql.append("CURRENT_TIMESTAMP ");
		sql.append(")");
		return sql.toString();
	}
	
	public String deleteSQL(String userId) throws SQLException {
		StringBuffer sb = new StringBuffer("DELETE FROM USERTOPRODUCT ");
		sb.append(" WHERE USERID = '" + userId + "'");
		return sb.toString();
	}
	
	public String dropSQL() throws SQLException {
		return "DROP TABLE USERTOPRODUCT ";
	}
	
	public String readSQL(String userId) throws SQLException {
		StringBuffer sb = new StringBuffer(
				"SELECT USERID, productId, productIndex, CRDATE, UPDDATE FROM USERTOPRODUCT WHERE USERID = '");
		sb.append(userId + "'");
		return sb.toString();
	}
	
	public String readAllSQL() throws SQLException {
		return "SELECT USERID, productId, productIndex, CRDATE, UPDDATE FROM USERTOPRODUCT ";
	}
	
	public String updateSQL(UserToProduct userToProduct) {
		StringBuffer sb = new StringBuffer("UPDATE USERTOPRODUCT SET ");
		boolean comma = false;
		if (userToProduct.getProductId().length() > 0) {
			sb.append("productId = '" + userToProduct.getProductId() + "' ");
			comma = true;
		}
		if (userToProduct.getProductIndex().length() > 0) {
			if (comma) {
				sb.append(", productIndex = '" + userToProduct.getProductIndex() + "' ");
				comma = false;
			} else {
				sb.append("productIndex = '" + userToProduct.getProductIndex() + "' ");
				comma = true;
			}
		}
		sb.append("WHERE USERID = '" + userToProduct.getUserId() + "'");
		return sb.toString();
	}
	
}
