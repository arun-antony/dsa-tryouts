package dsa.steps;

class Steps{

    void printPattern(int n, char ch){

        for(int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                if(j<=i){
                    System.out.print(ch);
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println("");
        }
    }


    void printPatternUpsideDown(int n, char ch){

        for(int i = 0; i<n; i++){
            for (int j = n; j>0; j--){
                if(j>i){
                    System.out.print(ch);
                }else{
                    System.out.print(' ');
                }
            }
            System.out.println("");
        }
    }

    void printPyramidwise(int n, char ch){
        for(int i = 0; i<n; i++){
            for(int j = 0;j<=n+i; j++){
                if(j>=n-i){
                    System.out.print(ch);
                    j++;
                }
                System.out.print(' ');
            }

            System.out.println("");
        }
    }


}

class Test{

    public static void main(String[] args) {
        Steps steps = new Steps();

        steps.printPyramidwise(4, '*');
    }
}