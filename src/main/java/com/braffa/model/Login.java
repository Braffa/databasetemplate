package com.braffa.model;

import java.util.Date;

public class Login {

	private String userId;

	private String password;

	private String authorityLevel;
	
	private Date crDate;
	
	private Date updDate;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorityLevel() {
		return authorityLevel;
	}

	public void setAuthorityLevel(String authorityLevel) {
		this.authorityLevel = authorityLevel;
	}
	
	public Date getCrDate() {
		return crDate;
	}

	public void setCrDate(Date crDate) {
		this.crDate = crDate;
	}

	public Date getUpdDate() {
		return updDate;
	}

	public void setUpdDate(Date updDate) {
		this.updDate = updDate;
	}

	public static class LoginBuilder {
		private String userId;
		private String password;
		private String authorityLevel;
		private Date crDate;
		private Date updDate;

		public LoginBuilder() {

		}

		public LoginBuilder userId(String userId) {
			this.userId = userId;
			return this;
		}

		public LoginBuilder password(String password) {
			this.password = password;
			return this;
		}

		public LoginBuilder authorityLevel(String authorityLevel) {
			this.authorityLevel = authorityLevel;
			return this;
		}
		
		public LoginBuilder crDate(Date crDate) {
			this.crDate = crDate;
			return this;
		}
		
		public LoginBuilder updDate(Date updDate) {
			this.updDate = updDate;
			return this;
		}

		public Login build() {
			return new Login(this);
		}
	}

	private Login(LoginBuilder loginBuilder) {
		this.authorityLevel = loginBuilder.authorityLevel;
		this.password = loginBuilder.password;
		this.userId = loginBuilder.userId;
		this.crDate = loginBuilder.crDate;
		this.updDate = loginBuilder.updDate;
	}
	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(" authorityLevel - " + authorityLevel);
		sb.append("\n password - " + password);
		sb.append("\n userId - " + userId);
		sb.append("\n crDate - " + crDate);
		sb.append("\n updDate - " + updDate);
		return sb.toString();
	}

}
