package dsa.recursion;

class TreeRecursion{

    void fun(int n){
        System.out.print(" "+n);

        if(n>0){
            fun(n-1);
            fun(n-1);
        }
        
    }

    public static void main(String[] args){
        TreeRecursion test = new TreeRecursion();
        test.fun(3);
    }

    


}

