package com.iist.hrm.dto;

public class CategoryDto {

	private int categoryId;
	private int parentId;
	private String categoryName;
	private String categoryIcon;
	private String categoryLink;

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

}
