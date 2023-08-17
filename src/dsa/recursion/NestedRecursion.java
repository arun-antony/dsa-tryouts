package dsa.recursion;

public class NestedRecursion {
    int fun(int n){
        if(n>100){
            return n-10;
        }else{
            return fun(fun(n+11));
        }
    }

    public static void main(String[] args){
        NestedRecursion test = new NestedRecursion();
        System.out.println(test.fun(95));

        System.out.println(test.fun(195));
    }
}
