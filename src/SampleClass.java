import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class SampleClass {

    public void divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
          throw new ArithmeticException("Division by zero");
        }
      
        int result = a / b;
        System.out.println(result);
      }
    public static void main(String[] args) {
       TreeSet<String> player = new TreeSet<String>();
       player.add("S");
       player.add("B");
       player.add("M");
       player.add("Z");
       player.add("M");

       System.out.println(player.toString());

       TreeMap map = new TreeMap();
       map.put(10, "I");
       map.put(2, "2");
       map.put(3, "3");
       //map.put(null, "null");
       System.out.println(map.toString());

       //int[] array = new int[-1];

       //throw

       

       
       

    }


    /**
     * MyComparere
     */
    public class MyCompare<T> implements Comparator<T>{
    
        @Override
        public int compare(Object o1, Object o2) {
            String s1 = o1.toString();
            String s2 = o2.toString();
            return -s1.compareTo(s2);
        }
    }

}  


