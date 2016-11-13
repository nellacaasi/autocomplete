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

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
}
