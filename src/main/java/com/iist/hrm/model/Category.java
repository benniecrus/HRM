package com.iist.hrm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;

	@Column(name = "PARENT_ID", nullable = false)
	private Integer parentId;

	@Column(name = "CATEGORY_NAME", nullable = false)
	private String categoryName;
	
	@Column(name = "CATEGORY_ICON")
	private String categoryIcon;
	
	@Column(name = "CATEGORY_LINK")
	private String categoryLink;

	@Column(name = "CATEGORY_DESCRIPTION")
	private String categoryDescription;

	@ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
	private Set<Role> roles = new HashSet<>();

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public String getCategoryIcon() {
		return categoryIcon;
	}

	public void setCategoryIcon(String categoryIcon) {
		this.categoryIcon = categoryIcon;
	}

	public String getCategoryLink() {
		return categoryLink;
	}

	public void setCategoryLink(String categoryLink) {
		this.categoryLink = categoryLink;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

}
