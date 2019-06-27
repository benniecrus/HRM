package com.iist.hrm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role implements Comparable<Role> {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

	@Column(name = "role_description")
	private String description;

	@ManyToMany
	@JoinTable(name = "role_category",
	joinColumns = { @JoinColumn(name = "role_id") },
	inverseJoinColumns = { @JoinColumn(name = "category_id") })
	private Set<Category> categorys = new HashSet<>();

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public int hashCode() {
		return roleId + roleName.hashCode() + description.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Role role = (Role)obj;
		return this.roleId == role.getRoleId();
	}
	
	@Override
	public int compareTo(Role o) {
		if (this.roleId < o.roleId) {
			return -1;
		} else if (this.roleId > o.roleId) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", description=" + description + "]";
	}

	public Set<Category> getCategorys() {
		return categorys;
	}

	public void setCategorys(Set<Category> categorys) {
		this.categorys = categorys;
	}


	
	
	
}
