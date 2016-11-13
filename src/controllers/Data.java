package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import models.Term;

public class Data {
	private List<Term> rawList = new ArrayList<Term>();
	
	public Data() throws IOException{
		readIn();
	}
	
	public void readIn() throws IOException {
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
	}

	public List<Term> getRawList() {
		return rawList;
	}

	public void setRawList(List<Term> rawList) {
		this.rawList = rawList;
	}

}
