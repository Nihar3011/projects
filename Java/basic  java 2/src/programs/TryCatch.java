
package programs;

public class TryCatch {
    public static void main(String[] args) {
        
        try{
            int a=0;
            try{
                int[] array =new int[5];
                array[5]=10;
                
            }catch(ArrayIndexOutOfBoundsException e)
            {
                System.err.println(e);
            } 
            finally{
                System.out.println("At finally..");
            }
            int div = 10/a;
            
            
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println(e);
        }catch(ArithmeticException e){
             System.err.println(e);
        }
        finally{
                System.out.println("At finally outside..");
            }
    }
    
}
