
package programs;


public class CustomeException {
    public static void main(String args[]) 
	{ 
		try
		{ 
			throw new MyException("ARGUSOFT",10); 
		} 
		catch (MyException ex) 
		{ 
			System.err.println("Caught"); 

			
			System.err.println(ex.getMessage()); 
		} 
	} 
}
class MyException extends Exception 
{ 
	public MyException(String s,int a) 
	{               super(s); 
		          System.err.println("a");
		
	} 
} 

