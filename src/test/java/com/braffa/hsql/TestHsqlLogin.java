package com.braffa.hsql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.braffa.actions.IDBActions;
import com.braffa.data.LoginTestData;
import com.braffa.model.Login;
import com.braffa.tables.TableEnum;
import com.braffa.tables.TableFactory;

public class TestHsqlLogin {

	private static IDBActions hSQLLogin;
	
	private LoginTestData ltd = new LoginTestData();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hSQLLogin = TableFactory.getTable(TableEnum.LOGIN_HSQL);
	} 

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		try {
			hSQLLogin.dropTable();
		} catch (Exception e) {
			// ignore if no table found
		}
		hSQLLogin.createTable();
	}

	@Test
	public void testSingleRow() {
		try {
			Login login = ltd.setUpLogin1();
			hSQLLogin.create(login);	
			List<Login> lOfLogins = (List<Login>) hSQLLogin.read("dave");
			assertTrue("Only one row was expected ", 1 == lOfLogins.size());
			assertEquals("Incorrect username ", "dave", lOfLogins.get(0).getUserId());
			assertEquals("Incorrect password ", "password", lOfLogins.get(0).getPassword());
			assertEquals("Incorrect authority Level ", "99", lOfLogins.get(0).getAuthorityLevel());
			System.out.println(lOfLogins.get(0).toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setUpLogins () throws SQLException {
		Login login = ltd.setUpLogin2();
		hSQLLogin.create(login);
		login = ltd.setUpLogin3();
		hSQLLogin.create(login);
		login = ltd.setUpLogin4();
		hSQLLogin.create(login);
	}
	
	@Test
	public void testMultipleRow() {
		try {
			setUpLogins (); 
			List<Login> lOfLogins = (List<Login>) hSQLLogin.readAll();
			assertTrue("Only one row was expected ", 3 == lOfLogins.size());

			assertEquals("Incorrect username ", "dave1", lOfLogins.get(0).getUserId());
			assertEquals("Incorrect password ", "password1", lOfLogins.get(0).getPassword());
			assertEquals("Incorrect authority Level ", "1", lOfLogins.get(0).getAuthorityLevel());

			assertEquals("Incorrect username ", "dave2", lOfLogins.get(1).getUserId());
			assertEquals("Incorrect password ", "password2", lOfLogins.get(1).getPassword());
			assertEquals("Incorrect authority Level ", "3", lOfLogins.get(1).getAuthorityLevel());

			assertEquals("Incorrect username ", "dave3", lOfLogins.get(2).getUserId());
			assertEquals("Incorrect password ", "password3", lOfLogins.get(2).getPassword());
			assertEquals("Incorrect authority Level ", "99", lOfLogins.get(2).getAuthorityLevel());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			setUpLogins (); 
			List<Login> lOfLogins = (List<Login>) hSQLLogin.readAll();
			assertTrue("Three rows were expected ", 3 == lOfLogins.size());

			assertEquals("Incorrect username ", "dave1", lOfLogins.get(0).getUserId());
			assertEquals("Incorrect password ", "password1", lOfLogins.get(0).getPassword());
			assertEquals("Incorrect authority Level ", "1", lOfLogins.get(0).getAuthorityLevel());

			assertEquals("Incorrect username ", "dave2", lOfLogins.get(1).getUserId());
			assertEquals("Incorrect password ", "password2", lOfLogins.get(1).getPassword());
			assertEquals("Incorrect authority Level ", "3", lOfLogins.get(1).getAuthorityLevel());

			assertEquals("Incorrect username ", "dave3", lOfLogins.get(2).getUserId());
			assertEquals("Incorrect password ", "password3", lOfLogins.get(2).getPassword());
			assertEquals("Incorrect authority Level ", "99", lOfLogins.get(2).getAuthorityLevel());

			hSQLLogin.delete("dave2");

			lOfLogins = (List<Login>) hSQLLogin.readAll();
			assertTrue("Only one row was expected ", 2 == lOfLogins.size());

			assertEquals("Incorrect username ", "dave1", lOfLogins.get(0).getUserId());
			assertEquals("Incorrect password ", "password1", lOfLogins.get(0).getPassword());
			assertEquals("Incorrect authority Level ", "1", lOfLogins.get(0).getAuthorityLevel());

			assertEquals("Incorrect username ", "dave3", lOfLogins.get(1).getUserId());
			assertEquals("Incorrect password ", "password3", lOfLogins.get(1).getPassword());
			assertEquals("Incorrect authority Level ", "99", lOfLogins.get(1).getAuthorityLevel());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		try {
			setUpLogins (); 
			List<Login> lOfLogins = (List<Login>) hSQLLogin.readAll();
			assertTrue("Only one row was expected ", 3 == lOfLogins.size());

			assertEquals("Incorrect username ", "dave1", lOfLogins.get(0).getUserId());
			assertEquals("Incorrect password ", "password1", lOfLogins.get(0).getPassword());
			assertEquals("Incorrect authority Level ", "1", lOfLogins.get(0).getAuthorityLevel());

			assertEquals("Incorrect username ", "dave2", lOfLogins.get(1).getUserId());
			assertEquals("Incorrect password ", "password2", lOfLogins.get(1).getPassword());
			assertEquals("Incorrect authority Level ", "3", lOfLogins.get(1).getAuthorityLevel());

			assertEquals("Incorrect username ", "dave3", lOfLogins.get(2).getUserId());
			assertEquals("Incorrect password ", "password3", lOfLogins.get(2).getPassword());
			assertEquals("Incorrect authority Level ", "99", lOfLogins.get(2).getAuthorityLevel());


			Login login = new Login.LoginBuilder().userId("dave1").password("newpassword").authorityLevel("").build();
			hSQLLogin.update(login);
			
			lOfLogins = (List<Login>) hSQLLogin.read("dave1");

			assertTrue("Only one row was expected ", 1 == lOfLogins.size());
			assertEquals("Incorrect username ", "dave1", lOfLogins.get(0).getUserId());
			assertEquals("Incorrect password ", "newpassword", lOfLogins.get(0).getPassword());
			assertEquals("Incorrect authority Level ", "1", lOfLogins.get(0).getAuthorityLevel());

			login = new Login.LoginBuilder().userId("dave2").password("").authorityLevel("66").build();
			hSQLLogin.update(login);
			lOfLogins = (List<Login>) hSQLLogin.read("dave2");

			assertTrue("Only one row was expected ", 1 == lOfLogins.size());
			assertEquals("Incorrect username ", "dave2", lOfLogins.get(0).getUserId());
			assertEquals("Incorrect password ", "password2", lOfLogins.get(0).getPassword());
			assertEquals("Incorrect authority Level ", "66", lOfLogins.get(0).getAuthorityLevel());

			login = new Login.LoginBuilder().userId("dave3").password("newpassword").authorityLevel("88").build();
			hSQLLogin.update(login);
			lOfLogins = (List<Login>) hSQLLogin.read("dave3");

			assertTrue("Only one row was expected ", 1 == lOfLogins.size());
			assertEquals("Incorrect username ", "dave3", lOfLogins.get(0).getUserId());
			assertEquals("Incorrect password ", "newpassword", lOfLogins.get(0).getPassword());
			assertEquals("Incorrect authority Level ", "88", lOfLogins.get(0).getAuthorityLevel());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
