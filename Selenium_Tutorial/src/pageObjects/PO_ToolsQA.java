package pageObjects;

public class PO_ToolsQA {


	//	public static final String TEXT_TABLE = "//div[@id='content']//table//tbody/tr["+i+"]/td["+j+"]"

	public static String text_Table(int i, int j){
		return "//div[@id='content']//table//tbody/tr["+i+"]/td["+j+"]";
	}

}
