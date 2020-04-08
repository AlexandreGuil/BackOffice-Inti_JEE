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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private Long idRole;
	private String roleName;
	private User user;
	
	public Role() {
	}
	
	public Role(String roleName, User user) {
		this.roleName = roleName;
		this.user = user;
	}	

	public Role(Long idRole, String roleName, User user) {
		this.idRole = idRole;
		this.roleName = roleName;
		this.user = user;
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
	 * @ManyToOne(fetch = FetchType.EAGER) Defines a many valued association with
	 *                  many to one multiplicity : In our case one user contain many
	 *                  role, and one user is linked to one user
	 * 
	 * @JoinColumn(name="USER_ID", referencedColumnName = "USER_ID", nullable =
	 *                             false) Specifies a column for joining an entity
	 *                             association or element collection If the
	 *                             JoinColumn annotation itself is defaulted, a
	 *                             single join column is assumed and the default
	 *                             values apply
	 * 
	 *                             name: The name of the foreign key column in the
	 *                             user table
	 * 
	 *                             referencedColumnName: The name of the column
	 *                             referenced by this foreign key column in the
	 *                             user table
	 * 
	 *                             nullable: The referenced column can be contain a
	 *                             null value in the table
	 * 
	 */
	
//	@OneToMany(mappedBy="user", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
	
	@Basic(optional = false)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", nullable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", roleName=" + roleName + ", user=" + user + "]";
	}
}
