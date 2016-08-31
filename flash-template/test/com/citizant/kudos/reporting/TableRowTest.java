package com.citizant.kudos.reporting;

import org.junit.Assert;
import org.junit.Test;

public class TableRowTest {
	
	@Test
	public void testEmptyData()
	{
	    TableRow emptyData = new TableRow();
	    emptyData.setField1("");
	    emptyData.setField2("");
	    emptyData.setField3("");
	    emptyData.setField4("");
	    emptyData.setField5("");
	    Assert.assertEquals("",emptyData.getField1());
	    Assert.assertEquals("",emptyData.getField2());
	    Assert.assertEquals("",emptyData.getField3());
	    Assert.assertEquals("",emptyData.getField4());
	    Assert.assertEquals("",emptyData.getField5());
	}

	@Test
	public void testTypicalData()
	{
	    TableRow someData = new TableRow();
	    someData.setField1("1");
	    someData.setField2("2");
	    someData.setField3("3");
	    someData.setField4("4");
	    someData.setField5("5");
	    Assert.assertEquals("1",someData.getField1());
	    Assert.assertEquals("2",someData.getField2());
	    Assert.assertEquals("3",someData.getField3());
	    Assert.assertEquals("4",someData.getField4());
	    Assert.assertEquals("5",someData.getField5());
	}

	@Test
	public void testIndexAccess()
	{
	    TableRow someData = new TableRow();
	    someData.setField(0,"1");
	    someData.setField(1,"2");
	    someData.setField(2,"3");
	    someData.setField(3,"4");
	    someData.setField(4,"5");
	    Assert.assertEquals("1",someData.getField(0));
	    Assert.assertEquals("2",someData.getField(1));
	    Assert.assertEquals("3",someData.getField(2));
	    Assert.assertEquals("4",someData.getField(3));
	    Assert.assertEquals("5",someData.getField(4));
	}
	
	
}
