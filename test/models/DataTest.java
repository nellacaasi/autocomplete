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
	public void testSize() {
		assertEquals(data.getRawList().size(), 10000);
	}

}
