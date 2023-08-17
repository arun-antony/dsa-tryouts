package dsa.recursion;

public class RecursionWithVariables{

    private int x = 0;
    
    /**
     * For an input of 5, output is 25
     * Global variable is incremented every time a recusrive call is made.
     * Addition of the final value of global variable is performed only after the functions start returning
     * 
     * Complexity is O(n)
     * @param n
     */
    int fun(int n){

        if(n>0){
            x++;
            return fun(n-1)+x;
            
        }
        return 0;
    }

    /**
     * For an input of 5, output is 15
     * The value of local variable at the time of recursive call will be added when the 
     * function returns from a recusrive call. Local variable is stored in 
     * Activation record for that function
     * 
     * 
     * Complexity is O(n)
     * @param n
     */
    int funLocal(int n){
        if(n>0){
            return funLocal(n-1)+n;
        }
        return 0;
    }

    public static void main(String[] args) {

        RecursionWithVariables hr = new RecursionWithVariables();
        int result = hr.fun(5);
        System.out.println("With Global Variable: "+result);

        result = hr.funLocal(5);
        System.out.println("With Local Variable: "+result);
    }
}