package dsa.recursion;

public class HeadRecursion{

    /**
     * For an input of 5, output will be 1 2 3 4 5
     * Recursive calls are done first. Hence named Head Recursion.
     * Printing is done when functions start returning
     * Complexity is O(n)
     * @param n
     */
    void fun(int n){

        if(n>0){
            //Code before fn call is executed before return
            fun(n-1);
            //Code after fn call is executed after return
            System.out.println(n);
        }

    }

    int fun2(int n){

        if(n>0){
            int c = fun2(n-1);
            
            return c+5;
        }

        return n;
    }

    public static void main(String[] args) {

        HeadRecursion hr = new HeadRecursion();
        hr.fun(5);
    }
}