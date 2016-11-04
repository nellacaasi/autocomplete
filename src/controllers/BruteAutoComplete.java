package controllers;

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

	@Override
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

	@Override
	public Iterable<String> matches(String prefix, int k) {
		// TODO Auto-generated method stub
		return null;
	}

}
