import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by abhinavdas on 2/14/17.
 */
public class LongestAbsoluteFilePAth {
    public static int lengthLongestPath(String S) {
        String[] paths = S.split("\n");
        int[] stack = new int[paths.length+1];
        int maxLen = 0;
        for(String s:paths){
            int lev = s.lastIndexOf(" ")+1, curLen = stack[lev+1] = stack[lev]+s.length()-lev+1;

            if(s.contains(".jpeg") || s.contains(".png") || s.contains(".gif")) maxLen = Math.max(maxLen, stack[lev]);
        }
        return maxLen;
    }
    public static void main(String args[])
    {
        String inp="dir\n subdir1\n  file1.gif\n  subsubdir1\n subdir2\n  subsubdir2\n   file2.ext";
        System.out.println(lengthLongestPath(inp));
    }
}
