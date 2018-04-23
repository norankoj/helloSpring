package com.javaex.vo;

public class UserVO {
	
	private int age;
	private String name;
	
	
	
	@Override
	public String toString() {
		return "UserVO [age=" + age + ", name=" + name + "]";
	}
	public UserVO() {
	}
	public UserVO(int age, String name) {
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
