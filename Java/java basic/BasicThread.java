
package programs;

class NewThread implements Runnable{
    String name;
    Thread t;

    public NewThread(String name) {
        this.name = name;
        this.t = new Thread(this,name);
        t.start();
    }
    
    
    public void run(){
        try{
            for(int i=10 ; i>0 ;i--){
                System.out.println( name +":" + i);
                Thread.sleep(1000); 
            }
            
        }catch(Exception e){
            System.err.println(e);
        }
        
    }
}

public class BasicThread {
    public static void main(String[] args) {
        NewThread nt1= new NewThread("one");
        NewThread nt2= new NewThread("Two");
        NewThread nt3=  new NewThread("Three");
        
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
