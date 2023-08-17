package dsa.recursion;

public class IndirectRecursion {
    
    void funA(int n){

        if(n>0){
            System.out.print(n+" ");
            funB(n-1);
        }
    }

    void funB(int n){
        if(n>0){
            System.out.print(n+" ");
            funA(n/2);
        }
    }

    public static void main(String[] args){
        IndirectRecursion test = new IndirectRecursion();
        test.funA(20);
    }
}
