package com.iist.hrm.dto.request;

public class NewPositionDto {
	private int positonId;
	private String positionName;
	private String positionDescription;

	public int getPositonId() {
		return positonId;
	}

	public void setPositonId(int positonId) {
		this.positonId = positonId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public String getPositionDescription() {
		return positionDescription;
	}

	public void setPositionDescription(String positionDescription) {
		this.positionDescription = positionDescription;
	}

}
