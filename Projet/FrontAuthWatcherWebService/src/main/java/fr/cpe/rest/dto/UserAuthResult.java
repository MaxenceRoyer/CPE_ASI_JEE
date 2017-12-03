package fr.cpe.rest.dto;

import fr.cpe.model.Role;

public class UserAuthResult {
	
	private String login;
	private Boolean validAuth;
	private String role;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Boolean getValidAuth() {
		return validAuth;
	}
	public void setValidAuth(Boolean validAuth) {
		this.validAuth = validAuth;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role2) {
		this.role = role2;
	}

}
