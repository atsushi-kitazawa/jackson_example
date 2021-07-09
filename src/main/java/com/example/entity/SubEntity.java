package com.example.entity;

public class SubEntity {

	private String subStr;

	public String getSubStr() {
		return subStr;
	}

	public void setSubStr(String subStr) {
		this.subStr = subStr;
	}

	@Override
	public String toString() {
		return "SubEntity [subStr=" + subStr + "]";
	}
}
