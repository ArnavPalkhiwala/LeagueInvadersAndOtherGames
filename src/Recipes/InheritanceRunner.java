package Recipes;

public class InheritanceRunner {
	
	public static void main(String[] args) {
		
		
		Grandparents gp = new Grandparents("Satish");
		
		gp.sayLastName();
		
		Parents p = new Parents("Satish", true);
		
		p.printsLikeSports();
		
		
	}

}
