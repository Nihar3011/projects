
package Usethis;

public final class UseThis {
     void invoke(UseThis obj){
        System.out.println(obj);
    }
    UseThis(int number1,int number2,int number3)
    { 
        System.out.println(number1);
             System.out.println(number2);
                  System.out.println(number3);
                  
    }
    UseThis(int number1,int number2,int number3,int number4)
    {  
            this(number1,number2,number3); // Use other constructor by this
           
              System.out.println(number4);
             this.invoke(this);
          
    }
    
   
    
   UseThis call(){
        invoke(this);// pass current class object using this
        return this; // return current class object using this
    }
}
class main
 {
    public static void main(String[] args) {
        
        UseThis ut=new UseThis(10, 20, 30,40);
        UseThis ut1 = ut.call();
        ut1.invoke(ut1); 
            
    }
}
