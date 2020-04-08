package com.inti.formation.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idUser;
	private String userFirstName;
	private String userLastName;
	private String eMail;
	private String password;
	private Boolean activated;
	private List<Role> role;

	public User() {
	}

	public User(String userFirstName, String userLastName, String eMail, String password) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMail = eMail;
		this.password = password;
	}

	public User(String userFirstName, String userLastName, String eMail, String password, Boolean activated,
			List<Role> role) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMail = eMail;
		this.password = password;
		this.activated = activated;
		this.role = role;
	}

	public User(Long idUser, String userFirstName, String userLastName, String eMail, String password,
			Boolean activated) {
		this.idUser = idUser;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMail = eMail;
		this.password = password;
		this.activated = activated;
	}

	public User(Long idUser, String userFirstName, String userLastName, String eMail, String password,
			Boolean activated, List<Role> role) {
		this.idUser = idUser;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMail = eMail;
		this.password = password;
		this.activated = activated;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Basic(optional = false)
	@Column(name = "USER_FIRST_NAME")
	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	@Basic(optional = false)
	@Column(name = "USER_LAST_NAME")
	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userFirstName = userLastName;
	}

	@Basic(optional = false)
	@Column(name = "E_MAIL")
	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Basic(optional = false)
	@Column(name = "USER_PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Basic(optional = false)
	@Column(name = "USER_ACTIVATED")
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	/**
	 * 
	 * @OneToMany(mappedBy = "role", cascade = CascadeType.REMOVE, fetch =
	 *                     FetchType.LAZY)
	 * 
	 *                     Defines a many valued association with one to many
	 *                     multiplicity : In our case one user contain many
	 *                     products, and one product is linked to one category
	 * 
	 *                     mappedBy: The role field in the user table that
	 *                     owns the relationship
	 * 
	 *                     cascade: The drop of the user lead to the drop of
	 *                     all the product link with this user
	 * 
	 */

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userFirstName=" + userFirstName + ", userLastName=" + userLastName
				+ ", e-mail=" + eMail + ", password=" + password + ", activated=" + activated + "]";
	}
}
