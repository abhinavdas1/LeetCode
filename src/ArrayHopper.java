/**
 * Created by abhinavdas on 11/11/16.
 */
import java.util.*;
public class ArrayHopper {
    public static  void  findHopsHelper(ArrayList<Integer> input) {
        ArrayList<String> jumps = new ArrayList<String>();
        int last = 0, current = 0, selected = 0;
        int i;
        for (i = 0; i < input.size(); i++) {
            if (i > current) break;
            if (i > last) {
                last = current;
                jumps.add(String.valueOf(selected));
            }
            int sum = i + input.get(i);
            if (sum > current) selected = i;
            current = Math.max(current, sum);
        }
        if ((i > last) && (jumps.size() > 0) && (Integer.parseInt(jumps.get(jumps.size() - 1)) != selected)) {
            jumps.add(String.valueOf(selected));
        }
        if (last >= input.size() - 1)
            if (jumps == null || jumps.size() == 0) {
                System.out.println("Failure");
            } else {
                jumps.add("out");
                String result = jumps.toString();
                System.out.println(result.substring(1, result.length() - 1));
            }
        else
            System.out.println("Failure");
    }
}
