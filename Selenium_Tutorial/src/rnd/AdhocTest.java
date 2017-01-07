package rnd;

public class AdhocTest {

	public static void main(String[] args) {
		   if(("Flight Confirmation # 2017-01-05183104").matches("[a-zA-Z]+ [a-zA-Z]+ # [1-9][0-9][0-9][0-9]-[0-9][0-9]-[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]"))	
			System.out.println("lkjlkj");	   
		
		   
		   
		   if(("Flight Confirmation # 2017-01-05183104").matches("[a-zA-Z]+ [a-zA-Z]+ # ((19|20)\\d{2})-[0-9]{2}-[0-9]{2}\\d{6}"))	
				System.out.println("lkjlkj");
	
	}

}
