package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Term;

public class BruteAutoComplete implements AutoComplete {
	Data data;
	List<String> matchesList;
	
	public BruteAutoComplete() throws IOException{
		data = new Data();
	}
	
	@Override
	public double weightOf(String term) { //returns weight of a term if not null, else returns 0
		if(term != null){
			for(int i = 0; i < data.getRawList().size(); i++){
				if(term.equals(data.getRawList().get(i).getWord())){
					return data.getRawList().get(i).getWeight();
				}
			}
		}
		return 0;
	}

	public String bestMatch(String prefix) { //returns the best match for a prefix if not null
		if(prefix != null){
			for(int i = 0; i < data.getRawList().size();i++){
				if(data.getRawList().get(i).getWord().startsWith(prefix)){
					return data.getRawList().get(i).getWord();
				}
			}
		}
		return null;
	}

	public Iterable<String> matches(String prefix, int k) { //returns k matches for a specified prefix if not null
		matchesList = new ArrayList<String>();
		
		if(prefix != null){
			for(Term term : data.getRawList()){
				if((term.getWord().startsWith(prefix))&&(matchesList.size() < k)){
					matchesList.add(term.getWord());
				}
			}
			return matchesList;
		}
		else{
			return null;
		}
	}

}
