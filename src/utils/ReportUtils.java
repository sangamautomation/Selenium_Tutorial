package utils;

import data.Constants;

public class ReportUtils {
	
	
	public static void reportResult(String verdict_Pass_Fail, String header, String reportComment){
		
		int counter = Constants.counter;
		Constants.counter++;
		
		switch (verdict_Pass_Fail) {
		case "Pass":
			System.out.println("PASS ~ Test Step Passed for "+header+ " :: "+ reportComment);
 			ScreenshotUtils.screenshot(Constants.screenshotFolderPath, counter);
 			break;
		case "Fail":
			System.out.println("FAIL ~ Test Step FAILED for "+header+ " :: "+ reportComment);
 			ScreenshotUtils.screenshot(Constants.screenshotFolderPath, counter);
 			break;
		default:
			break;
		}
		
	}

}
