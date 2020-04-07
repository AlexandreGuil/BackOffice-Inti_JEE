package com.inti.formation.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	private String userName;
	private String password;
	private boolean activated;
	private Role role;
	
	public User() {
		super();
	}

	public User(Long idUser, String userName, String password, boolean activated) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.activated = activated;
	}

	public User(Long idUser, String userName, String password, boolean activated, Role role) {
		super();
		this.idUser = idUser;
		this.userName = userName;
		this.password = password;
		this.activated = activated;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name="USER_PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="USER_ACTIVATED")
	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", userName=" + userName + ", password=" + password + ", activated="
				+ activated + "]";
	}
	
	
	
	
	
	

}
