package com.braffa.data;

import com.braffa.model.Login;

public class LoginTestData {

	public Login setUpLogin1() {
		return new Login.LoginBuilder().userId("dave").password("password").authorityLevel("99").build();
	}

	public Login setUpLogin2() {
		return new Login.LoginBuilder().userId("dave1").password("password1").authorityLevel("01").build();
	}

	public Login setUpLogin3() {
		return new Login.LoginBuilder().userId("dave2").password("password2").authorityLevel("03").build();
	}

	public Login setUpLogin4() {
		return new Login.LoginBuilder().userId("dave3").password("password3").authorityLevel("99").build();
	}

	public Login setUpLogin5() {
		return new Login.LoginBuilder().userId("Braffa").password("amanda33").authorityLevel("99").build();
	}

	public Login setUpLogin6() {
		return new Login.LoginBuilder().userId("georgie").password("georgie").authorityLevel("01").build();
	}

	public Login setUpLogin7() {
		return new Login.LoginBuilder().userId("admin").password("root").authorityLevel("99").build();
	}

	public Login setUpLogin8() {
		return new Login.LoginBuilder().userId("999999").password("999999").authorityLevel("99").build();
	}

}
