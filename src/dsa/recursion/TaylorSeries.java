package dsa.recursion;

public class TaylorSeries {

    float p = 1;
    float f = 1;
    
    /**
     * 1 + x + x^2/2! + x^3/3! + .... + x^n/n!
     * 
     * @param x
     * @param n
     * @return
     */
    double taylorSeries1(int x, int n){
        if(n>0){
            double result = taylorSeries1(x, n-1);
            p = p * x;
            f = f * n;

            return p/f + result;
        }else{
            return 1;
        }
    }

    public static void main(String[] arg){

        TaylorSeries series = new TaylorSeries();

        double result = series.taylorSeries1(3, 10);

        System.out.println("Result:"+result);
    }
}
