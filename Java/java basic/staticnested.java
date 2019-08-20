
package javaapplication1;

    abstract class Person{  
      abstract void eat();  
      
      static class test{
            void print(){
                  System.out.println("hello");
              } 
      }
    }  


   public class staticnested{  
     public static void main(String args[]){  
      Person p=new Person(){  
      void eat(){System.out.println("nice ");}  
      };  
      p.eat();  
      Person.test pt = new Person.test();
      pt.print();
     }  
    }  
