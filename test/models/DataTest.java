package models;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import controllers.Data;

public class DataTest {

	private Data data;
	
	@Before
	public void setUp() throws IOException 
	{
		data = new Data();
	}

	@Test
	public void testSize() { //Tests that the size of the ArrayList actually has 10,000 terms
		assertEquals(data.getRawList().size(), 10000);
	}

}
