/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programs;

import java.io.FileNotFoundException;
import java.io.IOException;

class college{
    void call() throws IOException{
        System.out.println("hello college");
    }
}
class depatment extends college{
    void call() throws IOException{ //No error because same order of exception
         System.out.println("hello depatment");
    }
}

public class OverridingException {
    
    public static void main(String[] args) {
        
        college c = new depatment();
         try{
	  c.call();
	}catch(Exception e){
	   System.out.println(e);
	 }
    }
}
