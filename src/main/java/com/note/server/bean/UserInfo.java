package com.note.server.bean;

public class UserInfo {
	
	private String name = "";
	private String id = "";
	private String age = "";
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", id=" + id + ", age=" + age + "]";
	}
}
