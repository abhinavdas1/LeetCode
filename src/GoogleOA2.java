/**
 * Created by abhinavdas on 6/1/17.
 */
public class GoogleOA2 {
    public static void main(String[] args)
    {
        GoogleOA2 sample  = new GoogleOA2();
        System.out.println(sample.getMax("dir1\n dir11\n dir12\n  picture.jpeg\n  dir121\n  file1.txt\ndir2\n file2.gif"));
    }

    public int getMax(String S)
    {
        String[] paths = S.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s:paths){
            int lev = s.lastIndexOf(" ")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;

            if(s.contains(".jpeg") || s.contains(".png") || s.contains(".gif"))
            {
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}
