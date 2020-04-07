package com.inti.formation.entities;

import java.io.Serializable;
import java.util.Collection;

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
@Table(name = "role")
public class Role implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Long idRole;
	private String roleName;
	private Collection<User> users;
	
	public Role() {
	}
	
	public Role(String roleName, Collection<User> users) {
		this.roleName = roleName;
		this.users = users;
	}	

	public Role(Long idRole, String roleName, Collection<User> users) {
		this.idRole = idRole;
		this.roleName = roleName;
		this.users = users;
	}

	@Id
	@Column(name="ROLE_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	
	@Basic(optional = false)
	@Column(name="ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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
	
	@Basic(optional = false)
	@OneToMany(mappedBy="role", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	public Collection<User> getUsers() {
		return users;
	}

	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", roleName=" + roleName + "]";
	}
}
