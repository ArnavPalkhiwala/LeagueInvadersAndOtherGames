package Recipes;

public class Grandparents {

	String lastName;

	public Grandparents(String lastName) {

		this.lastName = lastName;
		
		

	}

	String getLastName() {

		return lastName;
	}

	void setLastName(String lastName) {

		this.lastName = lastName;
	}

	void sayLastName() {

		System.out.println(lastName);
	}
}
