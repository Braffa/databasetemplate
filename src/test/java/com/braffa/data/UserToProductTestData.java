package com.braffa.data;

import java.util.Date;

import com.braffa.model.UserToProduct;

public class UserToProductTestData {

	public UserToProduct insertUserToProductTable() {
		return new UserToProduct.UserToProductBuilder().userId("").productId("").productIndex("").crDate(new Date())
				.updDate(new Date()).build();
	}

	public UserToProduct insertUserToProductTable1() {
		return new UserToProduct.UserToProductBuilder().userId("georgie").productId("9781861005618").productIndex("0")
				.build();
	}

	public UserToProduct insertUserToProductTable2() {
		return new UserToProduct.UserToProductBuilder().userId("georgie").productId("9780789724410").productIndex("0")
				.build();
	}

	public UserToProduct insertUserToProductTable3() {
		return new UserToProduct.UserToProductBuilder().userId("Braffa").productId("9780789724410").productIndex("0")
				.build();
	}

	public UserToProduct insertUserToProductTable4() {
		return new UserToProduct.UserToProductBuilder().userId("Braffa").productId("9781861005618").productIndex("0")
				.build();
	}

	public UserToProduct insertUserToProductTable5() {
		return new UserToProduct.UserToProductBuilder().userId("Braffa").productId("978098056856").productIndex("0")
				.build();
	}

	public UserToProduct insertUserToProductTable6() {
		return new UserToProduct.UserToProductBuilder().userId("Braffa").productId("5050582388237").productIndex("0")
				.build();
	}

	public UserToProduct insertUserToProductTable7() {
		return new UserToProduct.UserToProductBuilder().userId("Braffa").productId("9781849386685").productIndex("0")
				.build();
	}

	public UserToProduct insertUserToProductTable8() {
		return new UserToProduct.UserToProductBuilder().userId("amanda33").productId("9999999999000").productIndex("0")
				.build();
	}

	public UserToProduct insertUserToProductTable9() {
		return new UserToProduct.UserToProductBuilder().userId("grimbo").productId("9999999999001").productIndex("0")
				.build();
	}
}
