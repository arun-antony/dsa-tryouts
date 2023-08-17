package dsa.recursion;

public class RecursionExamples {
    
    /**
     * Recursion : Time -> O(n), Space -> O(n)
     * With Loop: Time -> O(n), Space -> O(1)
     * With formula: n*(n+1)/2 - Both complexities: O(n)
     * 
     * Use below mathematical definition to write function that does the summation using recursion:
     * Sum(0) = 0, Sum(n) = Sum(n-1)+n
     * @param n
     * @return
     */
    int sumOfNaturalNumbers(int n){

        if(n>0){
            return n + sumOfNaturalNumbers(n-1);
        }else{
            return 0;
        }
    }

    /**
     * Recursion : Time -> O(n), Space -> O(n)
     * With Loop: Time -> O(n), Space -> O(1)
     * 
     * Factorial of n, mathematical definition:
     * 1! or 0! = 1, n! = (n-1)! * n
     * @param n
     * @return
     */
    int factorial(int n){
        if(n == 1 || n == 0 || n < 0){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }

    /**
     * 
     * exp(p,0) = 1
     * exp(p,n) = exp(p,n-1)*p
     * 
     * @param p
     * @param n
     * @return
     */
    long exp(int p, int n){

        if(n == 0){
            return 1;
        }else{
            return exp(p, n-1) * p;
        }
    }


    public static void main(String[] args){
        RecursionExamples test = new RecursionExamples();
        testSumOfNaturalNumbers(test);
        testfactorial(test);
        testExp(test);
    }

    private static void testSumOfNaturalNumbers(RecursionExamples test){
        //Sum of first n natural numbers:
        int n = 10;
        int sumOfNaturalNumbers = test.sumOfNaturalNumbers(n);
        System.out.println("Sum of first "+n+"  NaturalNumbers: "+sumOfNaturalNumbers);
    }

    private static void testfactorial(RecursionExamples test){
        
        int n = 5;
        int factorial = test.factorial(n);
        System.out.println("factorial "+n+"  = "+factorial);
    }

    private static void testExp(RecursionExamples test){
        
        int n = 5;
        int p = 2;
        long power = test.exp(2,5);
        System.out.println(p+"^"+n+"!  = "+power);
    }
}


