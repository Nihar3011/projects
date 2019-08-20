
package programs;

import java.util.*;

class Employee{
    private int empNo;
    private String name;
    private String designation;
    private int salary;

    public Employee(int empNo, String name, String designation, int salary) {
        this.empNo = empNo;
        this.name = name;
        this.designation = designation;
        this.salary = salary;
    }
    
    public String toString(){
        return "My Employee No: " + empNo + " and Name is: " + name + ". Wroking with post: "
                + designation + " and my salary is: " + salary + ".";
    }

    public int getSalary() {
        return salary;
    }
    
    public String getDesignation(){
        return designation;
    }
}


public class Collection  {
    
    public static void main(String[] args) {

        LinkedList<Employee> l1= new LinkedList<Employee>();

        l1.add(new Employee(1,"Manthan","Project Manager",7500));
        l1.add(new Employee(2,"Priyam","Project Lead",5500));
        l1.add(new Employee(3,"Nikunj","Programmer Analyst",4500));
        l1.add(new Employee(4,"Purvit","System Analyst",3500));
        l1.add(new Employee(5,"Nihar","Software Engineer",2500));
        l1.add(new Employee(6,"Abhi","Project Manager",6500));
        l1.add(new Employee(7,"Rahul","Project Manager",6500));
        l1.add(new Employee(8,"Varshil","Project Lead",5500));
        l1.add(new Employee(9,"Bhavan","System Analyst",3500));
        l1.add(new Employee(10,"Jay","Software Engineer",2500));   
        l1.add(new Employee(11,"Viren","Programmer Analyst",4500));
     
        LinkedHashMap<String,Integer[]> tm= new LinkedHashMap<String,Integer[]>();
         
        ListIterator<Employee> litr= l1.listIterator();
      
        tm.put("Project Manager",new Integer[]{0,0});
        tm.put("Project Lead",new Integer[]{0,0});
        tm.put("Programmer Analyst", new Integer[]{0,0});
        tm.put("Software Engineer",new Integer[]{0,0});
        tm.put("System Analyst", new Integer[]{0,0});
        
        while(litr.hasNext()){
            Employee element= litr.next();
            tm.put(element.getDesignation(),new Integer[]{tm.get(element.getDesignation())[0]
                    +element.getSalary(),tm.get(element.getDesignation())[1]+1 });
        }
           
         Set<Map.Entry<String,Integer[]>> set =tm.entrySet();
                   
                  for(Map.Entry<String,Integer[]> me : set){
                      System.out.println(me.getKey());
                     Integer[] temp= me.getValue();
                      System.out.println("Count:"+ temp[1]);
                      System.out.println("salary:"+ temp[0]);
                    
                  }    
    }
}
