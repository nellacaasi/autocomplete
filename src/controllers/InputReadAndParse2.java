package controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputReadAndParse2 {		
	public static void main(String[] args) throws IOException{
		readIn();
	}
	
	public static void readIn() throws IOException {
		URL sourceData = new URL("https://wit-computing.github.io/algorithms-2016/topic04/book-2/data/wiktionary.txt");
		  BufferedReader in = new BufferedReader(
		        new InputStreamReader(
		        sourceData.openStream()));

		  String inputLine;
		  
		  HashMap<String,String> rawList = new HashMap<String,String>();
		  while ((inputLine = in.readLine()) != null)
		    {
		        String[] parts = inputLine.split("/t", 2);
		        String key = parts[0];
		        String value = parts[1];
		        rawList.put(key, value);
		    }
		  
		  in.close();		  
	}
}

