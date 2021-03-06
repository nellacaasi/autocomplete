package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import models.Term;

public class Data {
	private List<Term> rawList = new ArrayList<Term>();
	
	public Data() throws IOException{
		readIn();
	}
	
	public void readIn() throws IOException { //Reads in, sorts and Parses Data from URL
		URL sourceData = new URL("https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt");
		  BufferedReader in = new BufferedReader(new InputStreamReader(sourceData.openStream()));

		  String inputLine;
		  double weight;
		  String word;
		  String delims = "[	]";
		  
		  in.readLine();
		  inputLine = null;
		  while ((inputLine = in.readLine()) != null) {
			    String[] splitTerms = inputLine.split(delims);
			    weight = Double.parseDouble(splitTerms[0]);
			    word = splitTerms[1];
		      getRawList().add(new Term (weight, word.toLowerCase()));
		  }
		  
		  in.close();
		  
		  rawList = rawList.stream()
		            .sorted(Comparator.comparing(Term::getWeight).reversed())
		            .collect(Collectors.toList());
		  //Uses Java 8 Lambda expressions to sort the list, by turning the arrayList
		  //into a stream and then replacing the unsorted list
	}

	public List<Term> getRawList() {
		return rawList;
	}

	public void setRawList(List<Term> rawList) {
		this.rawList = rawList;
	}

}
