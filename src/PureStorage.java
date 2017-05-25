import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abhinavdas on 1/27/17.
 */
public class PureStorage {
    static int palindrome(String str)
    {
        List<String> result=new ArrayList<String>();

        int pivot;

        for(int i=0; i<str.length(); i++)
        {
            checkPalindrome(str, i, i+1, result);
            checkPalindrome(str, i, i, result);
        }

        return result.size();
    }

    static void checkPalindrome(String input, int pivot1, int pivot2, List<String> set)
    {
        while(pivot1 >=0 && pivot2 < input.length() && input.charAt(pivot1) == input.charAt(pivot2))
        {
            set.add(input.substring(pivot1--, ++pivot2));
        }
    }
    static int binSearch(int[] elements, int target)
    {

        if(elements == null || elements.length<= 0) return -1;

        int left=0, right =  elements.length - 1;

        while(left < right){
            int middle = (left + right +1)/2;

            if(elements[middle] > target){

                right = middle -1;

            }else{

                left = middle +1;
            }


        }

        if(elements[right] == target) return right;
        return -1;
    }
}
