package ug.lab.proj160518;

public class Person {

	private int id;
	private String firstName;
	private String lastName;
	private int age;

	public Person(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.firstName;
	}

	public void setName(String name) {
		this.firstName = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int i) {
		this.age = i;
	}

}
