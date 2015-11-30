package com.braffa.tables;

import com.braffa.connection.databases.ConnEnum;
import com.braffa.connection.databases.ConnectionFactory;

public class TableFactory {

	public static GenericTable getTable(TableEnum table) {

		switch (table.getTable()) {
		case 1:
			return new LoginTable(ConnectionFactory.getConnection(ConnEnum.MYSQL));
		case 2:
			return new LoginTableHsql(ConnectionFactory.getConnection(ConnEnum.HSQL));
		case 3:
			return new RegisteredUserTable(ConnectionFactory.getConnection(ConnEnum.MYSQL));
		case 4:
			return new RegisteredUserTableHsql(ConnectionFactory.getConnection(ConnEnum.HSQL));
		case 5:
			return new ProductTable(ConnectionFactory.getConnection(ConnEnum.MYSQL));
		case 6:
			return new ProductTableHsql(ConnectionFactory.getConnection(ConnEnum.HSQL));
		case 7:
			return new UserToProductTable(ConnectionFactory.getConnection(ConnEnum.MYSQL));
		case 8:
			return new UserToProductTableHsql(ConnectionFactory.getConnection(ConnEnum.HSQL));
		default:
			return null;
		}

	}

}
