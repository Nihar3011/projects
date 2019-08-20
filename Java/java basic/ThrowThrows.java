
package programs;

import java.io.IOException;

class UseThrow{
    void call(){
    try{
     throw new NullPointerException("Error");
    }catch(NullPointerException e){
        System.err.println(e.getMessage());
        throw e;
    }
    
}
}

class UseThrows{
    void call() throws IllegalAccessException{
        throw new IllegalAccessException("Error using throws");
}
}

public class ThrowThrows {
    public static void main(String[] args) {
        try{
            UseThrow ut=new UseThrow();
             
            ut.call();
          
        }catch(NullPointerException e){
             System.err.println(e.getMessage());
        }
        try{
             UseThrows uts=new UseThrows();
               uts.call();
        }catch(IllegalAccessException e){
            System.err.println(e.getMessage());
        }
    }
    
    
    
}
