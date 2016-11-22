/**
 * Created by abhinavdas on 11/14/16.
 */
public class contigiousMinimumUnsorted {
    public int check(int[] A){
        int startIndex = 0;
        int endIndex = A.length-1;

        for(int i = 1; i < A.length; i++){
            if(A[i] < A[i-1]){
                startIndex = i-1;
                break;
            }
        }

        for(int i = A.length-2; i >=0 ;i--){
            if(A[i] > A[i+1]){
                endIndex = i+1;
                break;
            }
        }

        if(A[startIndex] <= A[endIndex] && startIndex == 0 && endIndex == A.length-1){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = startIndex; i <= endIndex; i++){
            if(min > A[i]){
                min = A[i];
            }

            if(max < A[i]){
                max = A[i];
            }
        }

        int minIndex = 0;
        int maxIndex = 0;


        for(int i = 0; i < A.length; i++){
            if(min < A[i]){
                minIndex = i;
                break;
            }
        }

        for(int i = A.length-1; i >=0 ; i--){
            if(max > A[i]){
                maxIndex = i;
                break;
            }
        }

        return maxIndex-minIndex+1;
    }
}
