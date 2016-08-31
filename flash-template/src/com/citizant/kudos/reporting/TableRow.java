package com.citizant.kudos.reporting;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;

public class TableRow implements Serializable {
	private static final long serialVersionUID = -6475086974298600419L;
		
	private List<String> fields;
	
	public TableRow()
	{
		fields = new ArrayList<>(5);
		for (int index = 0; index < 5; index ++)
		{
			fields.add(index, null);
		}
	}
	
	public String getField(int index)
	{
		return fields.get(index);
	}
	
	public void setField(int index, String fieldContent)
	{
		fields.set(index, fieldContent);
	}
	
	public String getField1() {
		return fields.get(0);
	}
	public void setField1(String field1) {
		fields.set(0, field1);
	}
	public String getField2() {
		return fields.get(1);
	}
	public void setField2(String field2) {
		fields.set(1, field2);
	}
	public String getField3() {
		return fields.get(2);
	}
	public void setField3(String field3) {
		fields.set(2, field3);
	}
	public String getField4() {
		return fields.get(3);
	}
	public void setField4(String field4) {
		fields.set(3, field4);
	}
	public String getField5() {
		return fields.get(4);
	}
	public void setField5(String field5) {
		fields.set(4, field5);
	}
	
	
}
