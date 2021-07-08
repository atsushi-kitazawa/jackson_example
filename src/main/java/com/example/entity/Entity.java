package com.example.entity;

import java.util.List;
import java.util.Map;

public class Entity {

	private int id;
	private String str;
	private List<String> list;
	private Map<String, String> map;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", str=" + str + ", list=" + list + ", map="
				+ map + "]";
	}

}
