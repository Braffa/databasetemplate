package com.braffa.tables;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.braffa.connection.GenericConnection;
import com.braffa.model.Login;
import com.braffa.sqlqueries.LoginSQL;

public class LoginTable extends GenericTable  {

	private static final Logger logger = Logger.getLogger(LoginTable.class);

	protected LoginSQL loginSQL = new LoginSQL();

	public LoginTable(GenericConnection connection) {
		this.connection = connection;
	}

	public void createTable() throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("");
		}
		connection.createTable(loginSQL.createTableSQL());
	}

	public void create(Object l) throws SQLException {
		Login login = (Login) l;
		connection.create(loginSQL.createSQL(login));
		connection.shutdown();
	}

	public void delete(Object userId) throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("");
		}
		connection.create(loginSQL.deleteSQL(userId.toString()));
		connection.shutdown();
	}

	public void dropTable() throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("");
		}
		super.dropTable(loginSQL.dropSQL());
	}

	public List<Login> read(Object userId) throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("");
		}
		connection.configure();
		ResultSet rs = connection.executeQuery(loginSQL.readSQL(userId.toString()));
		List<Login> lOfLogins = processResultSet(rs);
		connection.shutdown();
		return lOfLogins;
	}

	public List<Login> readAll() throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("");
		}
		connection.configure();
		ResultSet rs = connection.executeQuery(loginSQL.readAllSQL());
		List<Login> lOfLogins = processResultSet(rs);
		connection.shutdown();
		return lOfLogins;
	}

	private List<Login> processResultSet(ResultSet rs) throws SQLException {
		if (logger.isDebugEnabled()) {
			logger.debug("");
		}
		List<Login> lOfLogins = new ArrayList<Login>();
		while (rs.next()) {
			Login login = new Login.LoginBuilder().userId(rs.getString("userId")).password(rs.getString("password"))
					.authorityLevel(rs.getString("authorityLevel")).crDate(rs.getTimestamp("crDate")).updDate(rs.getTimestamp("updDate")).build();
			System.out.println(rs.getDate("crDate"));
			System.out.println(rs.getDate("updDate"));
			lOfLogins.add(login);
		}
		return lOfLogins;
	}

	public void update(Object l) throws SQLException {
		Login login = (Login) l;
		connection.update(loginSQL.updateSQL(login));
		connection.shutdown();
	}

}
