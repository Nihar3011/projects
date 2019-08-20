
package programs;


class StringBufferExample{

        StringBuffer s = new StringBuffer("ARGUSOFT"); 
        int p = s.length(); 
        int q = s.capacity(); 
        
        void show(){
        System.out.println(" Length of string ARGUSOFT=" + p); 
         System.out.println("Capacity of string ARGUSOFT=" + q); 
     }

}
class StringBuilderExample{
                StringBuilder sb = new StringBuilder("ARGUSOFT"); 
         void show(){
            System.out.println("StringBuilder length = "+sb.length()); 
            System.out.println("StringBuilder capacity = "+sb.capacity()); 
         }
}

public class StringBufferBuilder{
    public static void main(String[] args) {
        
   
	StringBufferExample see=new StringBufferExample();
        StringBuilderExample sbe=new StringBuilderExample();
        see.show();
        sbe.show();
	 }
        
}