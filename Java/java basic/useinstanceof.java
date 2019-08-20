
package javaapplication1;

interface temp{}
class A implements temp{
public void a(){System.out.println("a method");}
}
class B implements temp{
public void b(){System.out.println("b method");}
}

class Call{
    
        void invoke(temp p){
        if(p instanceof A){
        A a=(A)p;
        a.a();
        }
        if(p instanceof B){
        B b=(B)p;
        }

        }
}

class useinstanceof{
public static void main(String args[]){
temp p=new A();
Call c=new Call();
c.invoke(p);
}
}