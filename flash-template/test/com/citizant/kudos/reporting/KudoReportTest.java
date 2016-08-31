package com.citizant.kudos.reporting;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

public class KudoReportTest {
		

	@Test
	public void testEmptyReport()
	{
         KudoReport emptyReport = new KudoReport();
         emptyReport.setColumnTitle1("");
         emptyReport.setColumnTitle2("");
         emptyReport.setColumnTitle3("");
         emptyReport.setColumnTitle4("");
         emptyReport.setColumnTitle5("");
         emptyReport.setReportTemplate("");
         emptyReport.setData(new ArrayList<TableRow>());
         Assert.assertEquals("", emptyReport.getColumnTitle1());
         Assert.assertEquals("", emptyReport.getColumnTitle2());
         Assert.assertEquals("", emptyReport.getColumnTitle3());
         Assert.assertEquals("", emptyReport.getColumnTitle4());
         Assert.assertEquals("", emptyReport.getColumnTitle5());
         Assert.assertEquals("", emptyReport.getReportTemplate());
         Assert.assertEquals(0, emptyReport.getData().size());
	}

	@Test
	public void testSomeData()
	{
         KudoReport reportWithData = new KudoReport();
         reportWithData.setColumnTitle1("1");
         reportWithData.setColumnTitle2("2");
         reportWithData.setColumnTitle3("3");
         reportWithData.setColumnTitle4("4");
         reportWithData.setColumnTitle5("5");
         reportWithData.setReportTemplate("Template");
         ArrayList<TableRow> data = new ArrayList<TableRow>();
         data.add(new TableRow());
         data.add(new TableRow());         
  		 reportWithData.setData(data);
         Assert.assertEquals("1", reportWithData.getColumnTitle1());
         Assert.assertEquals("2", reportWithData.getColumnTitle2());
         Assert.assertEquals("3", reportWithData.getColumnTitle3());
         Assert.assertEquals("4", reportWithData.getColumnTitle4());
         Assert.assertEquals("5", reportWithData.getColumnTitle5());
         Assert.assertEquals("Template", reportWithData.getReportTemplate());
         Assert.assertEquals(2, reportWithData.getData().size());
	}
	
	@Test
	public void testIndexAccess()
	{
         KudoReport reportWithData = new KudoReport();
         reportWithData.setColumnTitle(0,"1");
         reportWithData.setColumnTitle(1,"2");
         reportWithData.setColumnTitle(2,"3");
         reportWithData.setColumnTitle(3,"4");
         reportWithData.setColumnTitle(4,"5");
         reportWithData.setReportTemplate("Template");
         ArrayList<TableRow> data = new ArrayList<TableRow>();
         data.add(new TableRow());
         data.add(new TableRow());         
  		 reportWithData.setData(data);
         Assert.assertEquals("1", reportWithData.getColumnTitle(0));
         Assert.assertEquals("2", reportWithData.getColumnTitle(1));
         Assert.assertEquals("3", reportWithData.getColumnTitle(2));
         Assert.assertEquals("4", reportWithData.getColumnTitle(3));
         Assert.assertEquals("5", reportWithData.getColumnTitle(4));
         Assert.assertEquals("Template", reportWithData.getReportTemplate());
         Assert.assertEquals(2, reportWithData.getData().size());
	}

	
}
