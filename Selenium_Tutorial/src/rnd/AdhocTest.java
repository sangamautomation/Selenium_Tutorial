package rnd;

import java.util.HashMap;

import data.TestDataPool;
import utils.ExcelUtils;

public class AdhocTest {

	public static void main(String[] args) throws Exception {
		
		
		TestDataPool td = new TestDataPool(3);
		
		td.rowData.get("FirstName");
		
		System.out.println("First Name is "+td.rowData.get("FirstName") );
		
		HashMap<String,String> rowData = new HashMap<String,String>();
		
		rowData = ExcelUtils.getTestDataXls("D:/Selenium_Logs/TestData/TestDatapool.xls", "Automation", 2, 3)	;
	
	
		System.out.println(rowData.get("FirstName"));
		
		
		
		
		if(("Flight Confirmation # 2017-01-05183104").matches("[a-zA-Z]+ [a-zA-Z]+ # [1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))	
			System.out.println("lkjlkj");	   
		
		   
		   
		   if(("Flight Confirmation # 2017-01-05183104").matches("[a-zA-Z]+ [a-zA-Z]+ # ((19|20)\\d{2})-[0-9]{2}-[0-9]{2}\\d{6}"))	
				System.out.println("lkjlkj");
	
	}

}
