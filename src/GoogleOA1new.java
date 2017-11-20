/**
 * Created by abhinavdas on 6/1/17.
 */
public class GoogleOA1new {
    public static void main(String[] args)
    {
        GoogleOA1new sample = new GoogleOA1new();
        System.out.println( sample.checkIfSmall("abcd","aaa"));
    }
    public int[] solution (String A, String B)
    {
        String[] inputA = A.split(" ");
        String[] inputB = B.split(" ");
        int[] result = new int[inputB.length];


        for(int i  = 0; i < inputB.length; i++)
        {
            int count  = 0;
            for(int j = 0; j < inputA.length; j++)
            {
                if(checkIfSmall(inputA[j], inputB[i]))
                {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public boolean checkIfSmall(String A, String B)
    {
        char[] inpA = A.toCharArray();
        char[] inpB = B.toCharArray();

        int minA = 0, minB = 0;
        char min = '{';

        for(int i = 0; i < inpA.length; i++)
        {
            if(inpA[i]  < min)
            {
                min = inpA[i];
                minA = 1;
            }
            else if(inpA[i] == min)
            {
                minA++;
            }
        }

        min = '{';

        for(int i = 0; i < inpB.length; i++)
        {
            if(inpB[i]  < min)
            {
                min = inpB[i];
                minB = 1;
            }
            else if(inpB[i] == min)
            {
                minB++;
            }
        }

        return minB > minA ? true : false;
    }
}
