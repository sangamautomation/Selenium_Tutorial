package pageObjects;

// Mentions all Xpaths
public class PO_BookAFlight {
	
	// Fields (TYPEOFOBJECT_NAMEOFOBJECT)
	public static final String TEXTBOX_FIRSTNAME1= "//input[contains(@name,'passFirst0')]";
	public static final String TEXTBOX_LASTNAME1 = "//input[contains(@name,'passLast0')]";
	public static final String TEXTBOX_FIRSTNAME2="//input[contains(@name,'passFirst1')]";
	public static final String TEXTBOX_LASTNAME2="//input[contains(@name,'passLast1')]";
	
	public static final String DROPDOWN_CREDITCARDTYPE="//select[contains(@name,'creditCard')]";
	public static final String DROPDOWN_CREDITCARDEXPIRATIONMONTH="//select[contains(@name,'cc_exp_dt_mn')]";
    public static final String DROPDOWN_CREDITCARDEXPIRATIONYEAR = "//select[contains(@name,'cc_exp_dt_yr')]";
}
