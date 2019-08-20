package Usethis;

 class nested1 {
     int a=10;
     static int b=20;
    
    static class nested2 {
      
        void print(){
            System.out.println("hello");
            System.out.println(b);
        }
    }
    class nested3{
       int c=30;
        void print(){
             System.out.println("welcome");
            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
        }
    }
    
}

public class nested{
    public static void main(String[] args) {
       nested1.nested2 nn= new nested1.nested2();
       nn.print();
       nested1 n= new nested1();
       nested1.nested3 n3=n.new nested3();
       n3.print();
    }
}
