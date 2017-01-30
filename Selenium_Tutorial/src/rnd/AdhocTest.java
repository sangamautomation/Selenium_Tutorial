package rnd;

import java.sql.Date;
import java.util.HashMap;

import javax.swing.JOptionPane;

import data.Constants;
import data.TestDataPool;
import utils.DateUtils;
import utils.ExcelUtils;
import utils.FileSystemUtils;
import utils.KeyboardUtils;
import utils.PasswordUtils;
import utils.PropertyUtils;
import utils.XMLUtils;

public class AdhocTest {

	public static void main(String[] args) throws Exception {
		KeyboardUtils k = new KeyboardUtils();
		

	FileSystemUtils.createFolder("D:\\Selenium_Backup\\CheckingONe");
	FileSystemUtils.createFile("D:\\Selenium_Backup\\CheckingONe\\", "hi", "doc");

	//	Thread.sleep(1000000); //Delay
		System.exit(0); // Kill or Abort Java Process
	//	JOptionPane.showMessageDialog(null, "Debug it!!!"); // Pause by Dialog
		
		
		
		// Read XML Request File
	HashMap<String,String> xmlRequestData =	new XMLUtils().getHashMapFromXML(Constants.path_RequestXMLFile);
		
	String requestCode = xmlRequestData.get("StateName");
	System.out.println(requestCode);
	
	
		Runtime.getRuntime().exec("notepad.exe");
		KeyboardUtils.typeString("abcdefgh");;
 	 	k.type("abcdefgh@gmail.com"); //abcdefgh@gmail.com
		//*[@id="bx-close-inside-437260"]/svg
		DateUtils.getCurrentDate("MMddyyyy");
		DateUtils.getCurrentTimestamp("MMddyyyy HH:mm:ss"); //"MM-dd-yyyy HH:mm:ss"
		
		
		JOptionPane.showMessageDialog(null, "Debug it!!!");

		
		PasswordUtils.encryptString("Automation12345");
 		PasswordUtils.decryptString("I/mTPwYhe6w4srmtx2x/Tg==");
		
 		
		PropertyUtils.propertyFile_Read(Constants.path_PropertyFile_config, "browserType");
		PropertyUtils.propertyFile_Write(Constants.path_PropertyFile_config, "Price", "$1300");
		
		
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
