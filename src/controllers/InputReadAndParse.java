package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class InputReadAndParse {		
	public static void main(String[] args) throws IOException{
		readIn();
	}
	
	public static void readIn() throws IOException {
		URL sourceData = new URL("https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt");
		  BufferedReader in = new BufferedReader(
		        new InputStreamReader(
		        sourceData.openStream()));

		  String inputLine;
		  
		  List<String> rawList = new ArrayList<String>();
		  while ((inputLine = in.readLine()) != null) {
		      rawList.add(inputLine);
		  }
		  
		  in.close();
		  rawList.remove(0);
		  
		  for (String object: rawList){
			  System.out.println(object);
		  }
	}
}
