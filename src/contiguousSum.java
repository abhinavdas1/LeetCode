/**
 * Created by abhinavdas on 11/18/16.
 */
public class contiguousSum {

    public int[] answer(int[] l,int t)
    {


        // Your code goes here.
        int i=0,j=1;
        int sum=0;
        int[] result={-1,-1};
        if(l[0]==t)
        {
            result[0]=0;
            result[1]=0;
            return result;
        }

        sum=l[i];
        while(i<l.length && j<l.length)
        {

            while(sum > t && i<j)
            {
                sum=sum-l[i];
                i++;
//                if(i>j)
//                {
//                    j++;
//                    sum=sum + l[j];
//                }
            }
            if(sum<t )
            {
                sum=sum + l[j];
            }
            if(sum == t)
            {
                result[0]=i;
                result[1]=j;
                return result;
            }
            j++;
        }

        return result;
    }
    public int[] ans(int[] l, int t)
    {
        int curr_sum = l[0], start = 0, i;
        int[] result={-1,-1};

        // Pick a starting point
        for (i = 1; i <= l.length; i++)
        {
            // If curr_sum exceeds the sum, then remove the starting elements
            while (curr_sum > t && start < i-1)
            {
                curr_sum = curr_sum - l[start];
                start++;
            }

            // If curr_sum becomes equal to sum, then return true
            if (curr_sum == t)
            {
                int p = i-1;
                result[0]=start;
                result[1]=p;
                return result;
            }

            // Add this element to curr_sum
            if (i < l.length)
                curr_sum = curr_sum + l[i];

        }
        return result;
    }
}
