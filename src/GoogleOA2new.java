import java.util.ArrayList;
import java.util.List;

/**
 * Created by abhinavdas on 6/1/17.
 */
public class GoogleOA2new {

    public static void main(String[] args)
    {
        GoogleOA2new sample = new GoogleOA2new();
        int[] a ={1,4,3,2,5};
        int[] res = new int[3];
        res = sample.solution(a, 3);
        for(int num : res)
            System.out.print(num);
    }



    public int[] solution(int[] A, int K) {

            int[] result = new int[K];

            List<Integer> starts = new ArrayList<Integer>();

            int max = Integer.MIN_VALUE;

            for (int i = 0; i <= A.length - K; i++)

                max = Math.max(max, A[i]);

            for (int i = 0; i <= A.length - K; i++) {

                if (A[i] == max)
                {

                    for(int j = 0; j  <K; j++)
                    {
                        result[j] = A[i + j];
                    }
                    break;
                }

            }

            return result;

    }

}
