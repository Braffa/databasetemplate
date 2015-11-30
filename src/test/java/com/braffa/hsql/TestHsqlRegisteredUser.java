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
import com.braffa.data.RegisteredUserTestData;
import com.braffa.model.RegisteredUser;
import com.braffa.tables.TableEnum;
import com.braffa.tables.TableFactory;

public class TestHsqlRegisteredUser {

	private static IDBActions hsqlRegisteredUser;
	
	private RegisteredUserTestData rutd = new RegisteredUserTestData();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		hsqlRegisteredUser = TableFactory.getTable(TableEnum.REGISTERED_USER_HSQL);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		hsqlRegisteredUser.dropTable();
	}

	@Before
	public void setUp() throws Exception {
		try {
			hsqlRegisteredUser.dropTable();
		} catch (Exception e) {
			// ignore if no table found
		}
		hsqlRegisteredUser.createTable();
	}

	@Test
	public void testSingleRow() {
		try {
			RegisteredUser registeredUser = rutd.setUpRegisteredUser1();
			hsqlRegisteredUser.create(registeredUser);
			
			List<RegisteredUser> lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.read("dave123");
			
			assertTrue("Only one row was expected ", 1 == lOfRegisteredUser.size());
			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@gmail.com", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Dave", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Allen", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "0772 234654", lOfRegisteredUser.get(0).getTelephone());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setUpRegisteredUsers () throws SQLException {
		RegisteredUser registeredUser = rutd.setUpRegisteredUser1();
		hsqlRegisteredUser.create(registeredUser);
		registeredUser = rutd.setUpRegisteredUser2();
		hsqlRegisteredUser.create(registeredUser);
		registeredUser = rutd.setUpRegisteredUser3();
		hsqlRegisteredUser.create(registeredUser);
		registeredUser = rutd.setUpRegisteredUser4();
		hsqlRegisteredUser.create(registeredUser);
	}

	@Test
	public void testMultipleRow() {
		try {
			setUpRegisteredUsers ();
			List<RegisteredUser> lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.readAll();
			assertTrue("four rows were expected ", 4 == lOfRegisteredUser.size());

			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@gmail.com", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Dave", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Allen", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "0772 234654", lOfRegisteredUser.get(0).getTelephone());

			assertEquals("Incorrect username ", "gordon456", lOfRegisteredUser.get(1).getUserId());
			assertEquals("Incorrect email ", "gordon@gmail.com", lOfRegisteredUser.get(1).getEmail());
			assertEquals("Incorrect firstname ", "gordon", lOfRegisteredUser.get(1).getFirstname());
			assertEquals("Incorrect lastname ", "Mills", lOfRegisteredUser.get(1).getLastname());
			assertEquals("Incorrect telephone ", "1111 4444444", lOfRegisteredUser.get(1).getTelephone());

			assertEquals("Incorrect username ", "naiomi876", lOfRegisteredUser.get(2).getUserId());
			assertEquals("Incorrect email ", "naiomi@gmail.com", lOfRegisteredUser.get(2).getEmail());
			assertEquals("Incorrect firstname ", "naiomi", lOfRegisteredUser.get(2).getFirstname());
			assertEquals("Incorrect lastname ", "Smith", lOfRegisteredUser.get(2).getLastname());
			assertEquals("Incorrect telephone ", "2222 5555555", lOfRegisteredUser.get(2).getTelephone());

			assertEquals("Incorrect username ", "rachel33", lOfRegisteredUser.get(3).getUserId());
			assertEquals("Incorrect email ", "rachel@gmail.com", lOfRegisteredUser.get(3).getEmail());
			assertEquals("Incorrect firstname ", "rachel", lOfRegisteredUser.get(3).getFirstname());
			assertEquals("Incorrect lastname ", "scott", lOfRegisteredUser.get(3).getLastname());
			assertEquals("Incorrect telephone ", "3333 6666666", lOfRegisteredUser.get(3).getTelephone());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		try {
			setUpRegisteredUsers ();
			List<RegisteredUser> lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.readAll();
			assertTrue("four rows were expected ", 4 == lOfRegisteredUser.size());

			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@gmail.com", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Dave", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Allen", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "0772 234654", lOfRegisteredUser.get(0).getTelephone());

			assertEquals("Incorrect username ", "gordon456", lOfRegisteredUser.get(1).getUserId());
			assertEquals("Incorrect email ", "gordon@gmail.com", lOfRegisteredUser.get(1).getEmail());
			assertEquals("Incorrect firstname ", "gordon", lOfRegisteredUser.get(1).getFirstname());
			assertEquals("Incorrect lastname ", "Mills", lOfRegisteredUser.get(1).getLastname());
			assertEquals("Incorrect telephone ", "1111 4444444", lOfRegisteredUser.get(1).getTelephone());

			assertEquals("Incorrect username ", "naiomi876", lOfRegisteredUser.get(2).getUserId());
			assertEquals("Incorrect email ", "naiomi@gmail.com", lOfRegisteredUser.get(2).getEmail());
			assertEquals("Incorrect firstname ", "naiomi", lOfRegisteredUser.get(2).getFirstname());
			assertEquals("Incorrect lastname ", "Smith", lOfRegisteredUser.get(2).getLastname());
			assertEquals("Incorrect telephone ", "2222 5555555", lOfRegisteredUser.get(2).getTelephone());

			assertEquals("Incorrect username ", "rachel33", lOfRegisteredUser.get(3).getUserId());
			assertEquals("Incorrect email ", "rachel@gmail.com", lOfRegisteredUser.get(3).getEmail());
			assertEquals("Incorrect firstname ", "rachel", lOfRegisteredUser.get(3).getFirstname());
			assertEquals("Incorrect lastname ", "scott", lOfRegisteredUser.get(3).getLastname());
			assertEquals("Incorrect telephone ", "3333 6666666", lOfRegisteredUser.get(3).getTelephone());

			hsqlRegisteredUser.delete("naiomi876");

			lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.readAll();
			assertTrue("three rows were expected ", 3 == lOfRegisteredUser.size());

			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@gmail.com", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Dave", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Allen", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "0772 234654", lOfRegisteredUser.get(0).getTelephone());

			assertEquals("Incorrect username ", "gordon456", lOfRegisteredUser.get(1).getUserId());
			assertEquals("Incorrect email ", "gordon@gmail.com", lOfRegisteredUser.get(1).getEmail());
			assertEquals("Incorrect firstname ", "gordon", lOfRegisteredUser.get(1).getFirstname());
			assertEquals("Incorrect lastname ", "Mills", lOfRegisteredUser.get(1).getLastname());
			assertEquals("Incorrect telephone ", "1111 4444444", lOfRegisteredUser.get(1).getTelephone());

			assertEquals("Incorrect username ", "rachel33", lOfRegisteredUser.get(2).getUserId());
			assertEquals("Incorrect email ", "rachel@gmail.com", lOfRegisteredUser.get(2).getEmail());
			assertEquals("Incorrect firstname ", "rachel", lOfRegisteredUser.get(2).getFirstname());
			assertEquals("Incorrect lastname ", "scott", lOfRegisteredUser.get(2).getLastname());
			assertEquals("Incorrect telephone ", "3333 6666666", lOfRegisteredUser.get(2).getTelephone());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		try {
			setUpRegisteredUsers ();;
			List<RegisteredUser> lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.readAll();
			assertTrue("four rows were expected ", 4 == lOfRegisteredUser.size());

			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@gmail.com", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Dave", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Allen", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "0772 234654", lOfRegisteredUser.get(0).getTelephone());

			assertEquals("Incorrect username ", "gordon456", lOfRegisteredUser.get(1).getUserId());
			assertEquals("Incorrect email ", "gordon@gmail.com", lOfRegisteredUser.get(1).getEmail());
			assertEquals("Incorrect firstname ", "gordon", lOfRegisteredUser.get(1).getFirstname());
			assertEquals("Incorrect lastname ", "Mills", lOfRegisteredUser.get(1).getLastname());
			assertEquals("Incorrect telephone ", "1111 4444444", lOfRegisteredUser.get(1).getTelephone());

			assertEquals("Incorrect username ", "naiomi876", lOfRegisteredUser.get(2).getUserId());
			assertEquals("Incorrect email ", "naiomi@gmail.com", lOfRegisteredUser.get(2).getEmail());
			assertEquals("Incorrect firstname ", "naiomi", lOfRegisteredUser.get(2).getFirstname());
			assertEquals("Incorrect lastname ", "Smith", lOfRegisteredUser.get(2).getLastname());
			assertEquals("Incorrect telephone ", "2222 5555555", lOfRegisteredUser.get(2).getTelephone());

			assertEquals("Incorrect username ", "rachel33", lOfRegisteredUser.get(3).getUserId());
			assertEquals("Incorrect email ", "rachel@gmail.com", lOfRegisteredUser.get(3).getEmail());
			assertEquals("Incorrect firstname ", "rachel", lOfRegisteredUser.get(3).getFirstname());
			assertEquals("Incorrect lastname ", "scott", lOfRegisteredUser.get(3).getLastname());
			assertEquals("Incorrect telephone ", "3333 6666666", lOfRegisteredUser.get(3).getTelephone());
			
			
			
			RegisteredUser registeredUser = new RegisteredUser.RegisteredUserBuilder().userId("dave123").email("dave@yahoo.co.uk")
					.firstname("").lastname("").telephone("").build();
			hsqlRegisteredUser.update(registeredUser);

			lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.read("dave123");
			assertTrue("Only one row was expected ", 1 == lOfRegisteredUser.size());
			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@yahoo.co.uk", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Dave", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Allen", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "0772 234654", lOfRegisteredUser.get(0).getTelephone());

			registeredUser = new RegisteredUser.RegisteredUserBuilder().userId("dave123").email("")
					.firstname("Roger").lastname("").telephone("").build();
			hsqlRegisteredUser.update(registeredUser);

			lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.read("dave123");
			assertTrue("Only one row was expected ", 1 == lOfRegisteredUser.size());
			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@yahoo.co.uk", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Roger", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Allen", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "0772 234654", lOfRegisteredUser.get(0).getTelephone());
			
			registeredUser = new RegisteredUser.RegisteredUserBuilder().userId("dave123").email("")
					.firstname("").lastname("Johnson").telephone("").build();
			hsqlRegisteredUser.update(registeredUser);

			lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.read("dave123");
			assertTrue("Only one row was expected ", 1 == lOfRegisteredUser.size());
			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@yahoo.co.uk", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Roger", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Johnson", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "0772 234654", lOfRegisteredUser.get(0).getTelephone());
			
			registeredUser = new RegisteredUser.RegisteredUserBuilder().userId("dave123").email("")
					.firstname("").lastname("").telephone("9999 999999").build();
			hsqlRegisteredUser.update(registeredUser);

			lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.read("dave123");
			assertTrue("Only one row was expected ", 1 == lOfRegisteredUser.size());
			assertEquals("Incorrect username ", "dave123", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "dave@yahoo.co.uk", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "Roger", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "Johnson", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "9999 999999", lOfRegisteredUser.get(0).getTelephone());

			registeredUser = new RegisteredUser.RegisteredUserBuilder().userId("naiomi876").email("susan@gmail.com")
					.firstname("susan").lastname("jones").telephone("5555 555555").build();
			hsqlRegisteredUser.update(registeredUser);

			lOfRegisteredUser = (List<RegisteredUser>) hsqlRegisteredUser.read("naiomi876");
			assertTrue("Only one row was expected ", 1 == lOfRegisteredUser.size());
			assertEquals("Incorrect username ", "naiomi876", lOfRegisteredUser.get(0).getUserId());
			assertEquals("Incorrect email ", "susan@gmail.com", lOfRegisteredUser.get(0).getEmail());
			assertEquals("Incorrect firstname ", "susan", lOfRegisteredUser.get(0).getFirstname());
			assertEquals("Incorrect lastname ", "jones", lOfRegisteredUser.get(0).getLastname());
			assertEquals("Incorrect telephone ", "5555 555555", lOfRegisteredUser.get(0).getTelephone());

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}