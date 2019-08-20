
package programs;
import java.util.*;


class MyComp implements Comparator<Employee>{
    @Override
    public int compare(Employee a,Employee b){ 
            return a.getSalary()-b.getSalary();
    }
}
public class TreeSetMap {
    public static void main(String[] args) {
        TreeSet<Employee> ts=new TreeSet<Employee>(new MyComp());
        
    
         ts.add(new Employee(1,"Manthan","Project Manager",25000));
        ts.add(new Employee(2,"Priyam","Project Lead",35000));
        ts.add(new Employee(3,"Nikunj","Programmer Analyst",10000));
        ts.add(new Employee(4,"Purvit","System Analyst",20000));
        ts.add(new Employee(5,"Nihar","Software Engineer",45000));
        
      
         Iterator<Employee> itr= ts.iterator();
          
         
          while(itr.hasNext()){
            Employee element= itr.next();
                itr.remove();
                System.out.println(element); 
        }
          
          
            HashSet<Employee> hs=new  HashSet<Employee>();
        System.out.println("");
        hs.add(new Employee(1,"Manthan","Project Manager",25000));
        hs.add(new Employee(1,"Manthan","Project Manager",25000));
       
         Iterator<Employee> itr1= hs.iterator();
            
           while(itr1.hasNext()){
            Employee element= itr1.next();
                System.out.println(element); 
        }
        
          TreeMap<Integer,Employee> tm=new TreeMap<>();
                  tm.put(1,new Employee(1,"Manthan","Project Manager",25000));
                  tm.put(2,new Employee(2,"Priyam","Project Lead",35000));
                  tm.put(3,new Employee(3,"Nikunj","Programmer Analyst",10000));
                  tm.put(4,new Employee(4,"Purvit","System Analyst",20000));
                  tm.put(5,new Employee(5,"Nihar","Software Engineer",45000));
                  
                   System.out.println();  
               
                  for(Map.Entry<Integer,Employee> me : tm.entrySet()){
                     
                      System.out.println(me.getValue());
                  }
                  
                  Set<Integer> keys=tm.keySet();
                  System.out.println(keys);
   
                    Employee e1=new Employee(1,"Manthan","Project Manager",25000);
                    Employee e2= new Employee(2,"Priyam","Project Lead",35000);
                    
                    System.out.println(e1);
                    
    
     HashMap<Employee,Employee> tm1=new HashMap<>();
      tm1.put(e1, e2);
     
        
       e1=null;
       e1=new Employee(1,"Manthan","Project Manager",25000);
                 
      Object value = tm1.get(e1);
       System.out.println(value);
    }
    
                
    
}
