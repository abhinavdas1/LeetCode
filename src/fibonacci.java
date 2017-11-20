import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.*;

/**
 * Created by abhinavdas on 2/25/17.
 */
public class fibonacci {

    public static String calculateN( String input)
    {
        Map<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++)
        {
            if (set.contains(input.charAt(i)))
            {
                if (map.get(input.charAt(i)) != null)
                {
                    map.remove(input.charAt(i));
                }
            }
            else
            {
                map.put(input.charAt(i), i);
                set.add(input.charAt(i));
            }
        }
        return map.size() == 0 ? "" : map.entrySet().iterator().next().getKey().toString();
    }

    public static void main(String[] args)
    {
        System.out.print(calculateN("racecar"));
    }
}
