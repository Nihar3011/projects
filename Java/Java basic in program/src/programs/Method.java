
package programs;

interface First{
    public void print();
}
      

interface Second{
    public void print();
   
 }

interface Test extends First,Second{      
                      
}

public class Method {
    
    public static void main(String[] args) {
       Test test=new Test(){
           public void print(){
               System.out.println("ARGUSSOFT");
               	// \u000d System.out.println("comment executed");
           }
       };
       test.print();
       
       ((First)test).print();   
       ((Second)test).print();
       
       First testAsFirest = (First) test;
        testAsFirest.print(); 
        
        Second testAsSecond = (Second) test;
        testAsSecond.print(); 
       
    }
    
}
