package samples;
public class JosepheusProblem {
    
    public static void main(String[] args) {
        JosepheusProblem test = new JosepheusProblem();
        int array[] = {1,2,3,4,5,6,7};
        int k = 5;

        int w1 = test.findWinner(array, k, 0);
        int w2 = test.findWinnerPosition(array.length, k);

        System.out.println("Winner 1:"+w1);
        System.out.println("Winner 2:"+array[w2]);

    }

    /**
     * Only recursion - so O(n)
     * @param size
     * @param k
     * @return
     */
    int findWinnerPosition(int size, int k){
        if(size == 1) return 0;

        int prevIterWinnerPos = findWinnerPosition(size-1, k);

        return (prevIterWinnerPos + k) % size;
   
    }

    /**
     * O(n^2) - array removal loop and recursion
     * @param array
     * @param k
     * @param start
     * @return
     */
    int findWinner(int[] array, int k, int start){
        if(array.length == 1){
            return array[0];
        }

        int indexToRemove = (start + k - 1) % array.length;

        array = remove(indexToRemove, array);
        
        return findWinner(array, k, indexToRemove);
    }

    int[] remove(int index, int[] input){
        int[] out = new int[input.length - 1];

        for(int i = 0, j = 0; i<input.length; i++){
            if(i == index){
                continue;
            }else{
                out[j] = input[i];
                j++;
            }
        }

        return out;
    }


}
