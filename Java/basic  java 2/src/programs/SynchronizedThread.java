
package programs;

class Call{
    void print(String name){
        try{ 
            for(int i=10 ; i>0 ;i--){
                System.out.println( name +":" + i);
                Thread.sleep(1000); 
            }
        }catch(InterruptedException e){
            
        }
        
    }
}
class NewSynchronizedThread implements Runnable{
    String name;
    Thread t;
    Call obj;
    public NewSynchronizedThread(Call obj,String name) {
        this.obj=obj;
        this.name = name;
       
        this.t = new Thread(this,name);
        t.start();
    }
    
    public void run(){
        try{
            synchronized(obj){         
                obj.print(name);  
             }
            
        }catch(Exception e){
            System.err.println(e);
        }
        
    }
}

public class SynchronizedThread {
    
     public static void main(String[] args) {
         Call call=new Call();
        
        NewSynchronizedThread nt1= new NewSynchronizedThread(call,"one");
        NewSynchronizedThread nt2= new NewSynchronizedThread(call,"Two");
        NewSynchronizedThread nt3=  new NewSynchronizedThread(call,"Three");
        
        try{
           nt1.t.join();
           nt2.t.join();
           nt3.t.join();
            //Thread.sleep(1000);//wait for other Thread
        }catch(Exception e)
        {
            System.err.println(e);
        }
    }
    
}
