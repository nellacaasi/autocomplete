package models;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import controllers.BruteAutoComplete;
import controllers.Data;

public class BruteAutoCompleteTest {
	
	private BruteAutoComplete brute;
	private Data data;
	private ArrayList<String> testData1;
	private ArrayList<String> testData2;

	@Before
	public void setUp() throws IOException
	{
		data = new Data();
		brute = new BruteAutoComplete();
		
		//Setting up and adding test data to ArrayList - top 5 matches for the prefix "fo"
		testData1 = new ArrayList<String>();
		testData1.add(data.getRawList().get(13).getWord()); //Adding the word "for"
		testData1.add(data.getRawList().get(142).getWord()); //Adding the word "found"
		testData1.add(data.getRawList().get(275).getWord()); //Adding the word "form"
		testData1.add(data.getRawList().get(348).getWord()); //Adding the word "four"
		testData1.add(data.getRawList().get(383).getWord()); //Adding the word "forth"
		
		//Setting up and adding test data to ArrayList - top 10 matches for the prefix "do"
		testData2 = new ArrayList<String>();
		testData2.add(data.getRawList().get(56).getWord()); //adds the word "do"
		testData2.add(data.getRawList().get(94).getWord()); //adds the word "down"
		testData2.add(data.getRawList().get(200).getWord()); //adds the word "done"
		testData2.add(data.getRawList().get(247).getWord()); //adds the word "door"
		testData2.add(data.getRawList().get(251).getWord()); //adds the word "does"
		testData2.add(data.getRawList().get(429).getWord()); //adds the word "doubt"
		testData2.add(data.getRawList().get(560).getWord()); //adds the word "doing"
		testData2.add(data.getRawList().get(664).getWord()); //adds the word "donations"
		testData2.add(data.getRawList().get(976).getWord()); //adds the word "domain"
		testData2.add(data.getRawList().get(1015).getWord()); //adds the word "doctor"

	}
	
	//Testing the weightOf method
	@Test
	public void testWeightOf() 
	{
		assertEquals(5627187200.0, brute.weightOf("the"), 0.01);
		assertEquals(8312450.0, brute.weightOf("sake"), 0.01);
		assertEquals(1159960.0, brute.weightOf("revolver"), 0.01);
		assertEquals(392481.0, brute.weightOf("cooperation"), 0.01);
	}
	
	@Test
	public void testInvalidWeightOf()
	{
		assertEquals(0.0, brute.weightOf("InvalidData"), 0.01);
		assertEquals(0.0, brute.weightOf(""), 0.01);
	}
	
	@Test
	public void testBestMatch()
	{
		assertEquals(data.getRawList().get(13).getWord(), brute.bestMatch("fo"));
		assertEquals(data.getRawList().get(3685).getWord(), brute.bestMatch("gho"));
		assertEquals(data.getRawList().get(9999).getWord(), brute.bestMatch("calv"));

	}
	
	@Test
	public void testInvalidBestMatch()
	{
		assertEquals(null, brute.bestMatch(null));
		assertEquals(null, brute.bestMatch("InvalidData"));
	}
	
	@Test
	public void testMatches()
	{
		assertEquals(testData1, brute.matches("fo", 5));
		assertEquals(testData2, brute.matches("do", 10));
	}
}