package com.example.entity;

public class SubEntity {

	private int subId;
	private String subStr;

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubStr() {
		return subStr;
	}

	public void setSubStr(String subStr) {
		this.subStr = subStr;
	}

	@Override
	public String toString() {
		return "SubEntity [subId=" + subId + ", subStr=" + subStr + "]";
	}
}
