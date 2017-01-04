/**
 * Created by abhinavdas on 1/4/17.
 */
import java.util.*;
public class permuatations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backtrack(result,new ArrayList<Integer>(),nums,new ArrayList<Integer>());
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> temp, int[] nums,List<Integer> index)
    {
        if(temp.size()==nums.length)
            result.add(new ArrayList<Integer>(temp));
        else
            for(int i=0; i<nums.length; i++)
            {
                if(index.contains(i) || (i>0 && nums[i]==nums[i-1] && index.contains(i-1))) continue;
                temp.add(nums[i]);
                index.add(i);
                backtrack(result,temp,nums,index);
                index.remove(index.size()-1);
                temp.remove(temp.size()-1);
            }
    }
}
