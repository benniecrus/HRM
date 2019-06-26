package com.iist.hrm.model;

import java.util.HashMap;
import java.util.Map;

public enum CountryEnum {

	VIETNAM("VN", "Việt Nam"),
	SINGAPORE("SG", "Singapore");

	private String countryCode;
	private String countryName;

	CountryEnum(String countryCode, String countryName) {

	}
	
	public Map<String, String> getAllCountry() {
		Map<String, String> countryMap = new HashMap<String, String>();
		CountryEnum[] arr = values();
		for(CountryEnum item : arr) {
			countryMap.put(item.countryCode, item.countryName);
		}
		return countryMap;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
