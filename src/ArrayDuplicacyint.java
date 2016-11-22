/**
 * Created by abhinavdas on 11/4/16.
 */
import java.util.*;
public class ArrayDuplicacyint {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> l = new ArrayList<Integer>();
        for(int i=0; i<nums.length; i++)
        {
            if(nums[i]==nums[nums[i]-1] && nums[i]!=i+1)
                l.add(nums[i]);
            else if(nums[i]!=nums[nums[i]-1])
            {
                int temp=nums[i];
                nums[i]=nums[nums[i]-1];
                nums[nums[i]-1]=temp;
            }

        }
        return l;
    }
}
