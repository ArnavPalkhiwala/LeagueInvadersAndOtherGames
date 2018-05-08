package Recipes;

public class Parents extends Grandparents {
	
	boolean likesSports;

	public Parents (String lastName, boolean likesSports) {
		
		super(lastName);
		
		this.likesSports = likesSports;
		
		
		
		
		
	}
	
	void printsLikeSports () {
		
		System.out.println(likesSports);
	}
}
