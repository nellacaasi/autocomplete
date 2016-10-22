package models;

public class Term {
	private double weight;
	private String word;

	public Term(double weight, String word){
		this.weight = weight;
		this.word = word;
	}
	
	public String toString(){
		return weight+"	"+word;
	}
}
