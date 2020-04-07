package com.inti.formation.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private boolean activated;
	private Role role;

	public User() {
	}

	public User(String userFirstName, String userLastName, String eMail, String password) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMail = eMail;
		this.password = password;
	}

	public User(String userFirstName, String userLastName, String eMail, String password, boolean activated,
			Role role) {
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMail = eMail;
		this.password = password;
		this.activated = activated;
		this.role = role;
	}

	public User(Long idUser, String userFirstName, String userLastName, String eMail, String password,
			boolean activated) {
		this.idUser = idUser;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.eMail = eMail;
		this.password = password;
		this.activated = activated;
	}

	public User(Long idUser, String userFirstName, String userLastName, String eMail, String password,
			boolean activated, Role role) {
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
	 * @ManyToOne(fetch = FetchType.EAGER) Defines a many valued association with
	 *                  many to one multiplicity : In our case one role contain many
	 *                  user, and one product is linked to one role
	 * 
	 * @JoinColumn(name="ROLE_ID", referencedColumnName = "ROLE_ID", nullable =
	 *                             true) Specifies a column for joining an entity
	 *                             association or element collection If the
	 *                             JoinColumn annotation itself is defaulted, a
	 *                             single join column is assumed and the default
	 *                             values apply
	 * 
	 *                             name: The name of the foreign key column in the
	 *                             role table
	 * 
	 *                             referencedColumnName: The name of the column
	 *                             referenced by this foreign key column in the
	 *                             role table
	 * 
	 *                             nullable: The referenced column can be contain a
	 *                             null value in the table
	 * 
	 */

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID", nullable = true)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
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
