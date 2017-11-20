/**
 * Created by abhinavdas on 11/2/17.
 */
public class IMC {
    public static void main(String[] args)
    {
        int [][] sample = {{1,1,1,2}, {-4,3,1,2}};
        getCountries(sample);
    }

    public static void getCountries(int[][] A)
    {
        int count = 0;
        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < A[0].length; j++)
            {
                if (A[i][j] != Integer.MIN_VALUE)
                {
                    recordCountry(A, i, j, A[i][j]);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static void recordCountry(int [][] A, int i, int j, int code)
    {
        A[i][j] = Integer.MIN_VALUE;

        if (i > 0)
        {
            if (A[i - 1][j] == code)
                recordCountry(A, i - 1, j, code);
        }
        if (j > 0)
        {
            if (A[i][j - 1] == code)
            {
                recordCountry(A, i, j - 1, code);
            }
        }
        if (i < A.length - 1)
        {
            if (A[i + 1][j] == code)
                recordCountry(A, i + 1, j, code);
        }
        if (j < A[0].length - 1)
        {
            if (A[i][j + 1] == code)
                recordCountry(A, i , j + 1, code);
        }

    }



}
