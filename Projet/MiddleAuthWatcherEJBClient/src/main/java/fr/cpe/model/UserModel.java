package fr.cpe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * UserModel
 * @author Camille
 */

@Entity
@Table(name= "tbl_users")
@NamedQuery(name = "UserModel.list", query = "select u from UserModel u")
public class UserModel implements Serializable {
	private static final long serialVersionUID = -1676431979922218106L;
	
	@Id
	@Column(name = "id", nullable = false)
	private String id;
	
	@Column(name = "login", nullable = false)
	private String login;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "sur_name", nullable = false)
	private String surName;

	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;
	
	/**
	 * Constructor 
	 */
	public UserModel(){
	}
	
	
	/**
	 * Constructor 
	 * @param login
	 * @param password
	 */
	public UserModel(String login, String password){
		this.password = password;
		this.login =login;
		this.lastName = null;
		this.surName = null;
		this.role = null;
	}
	
	/**
	 * Constructor using fields 
	 * @param login
	 * @param password
	 * @param lastName
	 * @param surName
	 * @param role
	 */
	public UserModel(String login, String password, String lastName, String surName, Role role){
		this.password = password;
		this.login = login;
		this.lastName = lastName;
		this.surName = surName;
		this.role = role;
	}

	/**
	 * Authenticate
	 * @param login
	 * @param password
	 */
	public void authenticate(String login, String password) {
		new UserModel(login, password);
		System.out.println(this);	
	}


	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}


	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}


	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	/**
	 * @return the surName
	 */
	public String getSurName() {
		return surName;
	}


	/**
	 * @param surName the surName to set
	 */
	public void setSurName(String surName) {
		this.surName = surName;
	}


	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}


	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}

