//package Final;

import java.util.Objects;

public class Person {
	private String name;
	private boolean hasDriverLicense;
	private int age;
	private int height;

	public Person(String name, boolean hasDriverLicense, int age, int height) {
	this.name=name;
	this.hasDriverLicense= hasDriverLicense;
	this.age= age;
	this.height= height;
	}
	public String getName() {
		return name;
	}
	public boolean hasDriverLicense() {
		return hasDriverLicense;
	}
	public int getAge() {
		return  age;
	}
	public int getHeight() {
		return height;
	}
	public Person clone() {
	Person p = new Person(this.name,this.hasDriverLicense, this.age, this.height);
	 return p;
	}
	

	@Override
	public String toString() {
		String s="";
if(this.hasDriverLicense==true)s="has license";
else s="no license";

		return (String.format( "Person [name= %10s | age= %02d | height= %02d | "+s+"]", name, age, height));


	}
	
	@Override
	public int hashCode() {
		return Objects.hash(age, hasDriverLicense, height, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Person))
			return false;
		Person other = (Person) obj;
		return age == other.age && hasDriverLicense == other.hasDriverLicense && height == other.height
				&& name.equals(other.name);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}