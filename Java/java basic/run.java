
class AboutConstructor {
  private int a;

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
    private AboutConstructor(){ setA(10); }
    
     private static AboutConstructor temp = null; 
 
  static AboutConstructor UseConstructor(){
     if(temp==null)
      temp= new AboutConstructor();
      return temp;
    }
  void display(){
      System.out.println( getA());
  }
    
}
public class run{
    public static void main(String args[]){ 
       
     AboutConstructor obj= AboutConstructor.UseConstructor();
      AboutConstructor obj1= AboutConstructor.UseConstructor();  
    		 System.out.println(obj);
          System.out.println(obj1);
          obj.setA(20);
     obj.display();
     obj1.display();  }     
}
