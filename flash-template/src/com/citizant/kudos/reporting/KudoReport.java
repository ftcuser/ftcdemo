package com.citizant.kudos.reporting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class KudoReport implements Serializable {
	
	private static final long serialVersionUID = 52436086335883654L;
	
	private List<String> columnTitles;
	
	public KudoReport()
	{
		columnTitles = new ArrayList<>(5);
		for (int index = 0; index < 5; index ++)
		{
			columnTitles.add(index, null);
		}
	}	
	
	
	private String reportTemplate;
	private String reportTitle;
	
	private List<TableRow> data;

	public String getReportTemplate() {
		return reportTemplate;
	}

	public void setReportTemplate(String reportTemplate) {
		this.reportTemplate = reportTemplate;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getColumnTitle(int index) {
		return columnTitles.get(index);
	}

	public void setColumnTitle(int index, String columnTitle) {
		this.columnTitles.set(index, columnTitle);
	}
	
	public String getColumnTitle1() {
		return columnTitles.get(0);
	}

	public void setColumnTitle1(String columnTitle1) {
		this.columnTitles.set(0, columnTitle1);
	}

	public String getColumnTitle2() {
		return columnTitles.get(1);
	}

	public void setColumnTitle2(String columnTitle2) {
		this.columnTitles.set(1, columnTitle2);
	}

	public String getColumnTitle3() {
		return columnTitles.get(2);
	}

	public void setColumnTitle3(String columnTitle3) {
		this.columnTitles.set(2, columnTitle3);
	}
	
	public String getColumnTitle4() {
		return columnTitles.get(3);
	}

	public void setColumnTitle4(String columnTitle4) {
		this.columnTitles.set(3, columnTitle4);
	}
	
	public String getColumnTitle5() {
		return columnTitles.get(4);
	}

	public void setColumnTitle5(String columnTitle5) {
		this.columnTitles.set(4, columnTitle5);
	}

	public List<TableRow> getData() {
		return data;
	}

	public void setData(List<TableRow> data) {
		this.data = data;
	}
}
