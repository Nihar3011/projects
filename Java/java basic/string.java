
class StringExample{
    
    
    char arr [] = {'j' , 'a', 'v' , 'a'};
        String s1 = new String(arr);

    byte array [] = {65,66,67};
    String s2 = new String(array);
    
      
    byte[] array1 = s2.getBytes();
        
              void show()
               {
                      System.out.println(s1);
                    System.out.println(s2);
                    System.out.println(s1.length()); // length
                    System.out.println(s1 + s2); //concat using +
                    System.out.println(s1.charAt(2)); //charAt func 
                    for(byte b: array1){        // getBytes
                        System.out.print(b);
                     }
                }
      }

    public class string {

        public static void main(String[] args) {
            
           StringExample se=new StringExample();
           se.show();
        }
        
        
    }
