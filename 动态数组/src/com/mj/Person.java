package com.mj;

public class Person {
	private String name;
	private int age;
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("Person - finalize");
	}
    @Override
    public boolean equals(Object obj) {
    	Person person = (Person) obj;
    	return this.age == person.age;
    }
}
