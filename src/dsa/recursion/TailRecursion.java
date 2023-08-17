package dsa.recursion;

public class TailRecursion {
    
    /**
     * For an input of 5, output will be 5 4 3 2 1
     * Recursive calls are done at the end. Hence named Tail Recursion.
     * Printing is done before recursive calls are made
     * Complexity is O(n)
     * @param n
     */
    void fun(int n){

        if(n>0){
            
            System.out.println(n);
            
            fun(n-1);
        }

    }

    public static void main(String[] args) {

        TailRecursion hr = new TailRecursion();
        hr.fun(5);
    }

}
