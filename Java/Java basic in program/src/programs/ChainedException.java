
package programs;

import java.io.IOException;

class car{
    static void call(){
        NullPointerException e = new NullPointerException("Error.!!");
        e.initCause(new IOException("IOError"));
        throw e;
    }
    
}

public class ChainedException {
    public static void main(String[] args) {
          try{
                   car.call();
               }catch(NullPointerException e){
                           System.err.println(e);
                           System.err.println(e.getCause());
               }
    }
   
    
}
