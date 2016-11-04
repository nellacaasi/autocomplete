package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Term;

public class BruteAutoComplete implements AutoComplete {

	
	@Override
	public double weightOf(String term) {
			for(int i = 0; i < InputReadAndParse.getRawList().size(); i++){
				if(term.equals(InputReadAndParse.getRawList().get(i).getWord())){
					return InputReadAndParse.getRawList().get(i).getWeight();
				}
			}
		return 0;
	}

	public String bestMatch(String prefix) {
		if(prefix != null){
			for(int i = 0; i < InputReadAndParse.getRawList().size();i++){
				if(InputReadAndParse.getRawList().get(i).getWord().startsWith(prefix)){
					return InputReadAndParse.getRawList().get(i).getWord();
				}
			}
		}
		return null;
	}

	public Iterable<String> matches(String prefix, int k) {
		List<String> matchesList = new ArrayList<String>();
		
		for (int i = 0;k < matchesList.size(); i++)
		{
			if (InputReadAndParse.getRawList().get(i).getWord().startsWith(prefix)){
				matchesList.add(InputReadAndParse.getRawList().get(i).getWord());
			}
			return matchesList;
		}
		return null;
	}

}
