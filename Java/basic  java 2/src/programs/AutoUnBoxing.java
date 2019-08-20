
package programs;


public class AutoUnBoxing {
    public static void main(String[] args) {
        Integer number1 = new Integer(10);
        Boolean b=true;
        int number3;
       
        
        number1++; //unboxing then incremenet and autoboxing again
        if(b) 
        {
            System.out.println(number1);
        }
        char ch = 'n';
        Character c= ch;
        
           System.out.println(c);
    }
    
}
