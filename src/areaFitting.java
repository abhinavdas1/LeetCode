import java.util.ArrayList;

/**
 * Created by abhinavdas on 11/17/16.
 */
public class areaFitting {
    public int[] toSquares(int area)
    {
        ArrayList<Integer> result= new ArrayList<Integer>();
        while(area>1)
        {
            int sqrt= (int)Math.sqrt((double)area);
            if(sqrt==1)
                break;
            area=area-sqrt*sqrt;
            result.add(sqrt*sqrt);
        }
        for(int i=0; i<area; i++)
        {
            result.add(1);
        }
        int[] res = new int[result.size()];
        for(int i=0; i<result.size(); i++)
        {
            res[i]=result.get(i);
        }
        return res;
    }
}
