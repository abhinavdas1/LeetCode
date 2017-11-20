/**
 * Created by abhinavdas on 10/24/17.
 */
import java.util.*;
import java.util.HashMap;

public class BB1 {

    public static void main(String args[])
    {
        Scanner stdin = new Scanner(System.in);

        String target = stdin.nextLine();

        int count = Integer.parseInt(stdin.nextLine());

        Map<String, Integer> numPreReq = new HashMap<String, Integer>();
        Map<String, List<String>> preReq = new HashMap<String, List<String>>();
        StringBuilder result = new StringBuilder();

        Queue<String> q = new LinkedList<String>();

        while(stdin.hasNextLine())
        {
            String[] input = stdin.nextLine().split(" ");
            if(input.length >= 2)
            {
                numPreReq.put(input[0], Integer.parseInt(input[1]));

                preReq.put(input[0], new ArrayList<String>());

                if(numPreReq.get(input[0]) == 0)
                {
                    q.add(input[0]);
                    result.append(input[0] + " ");
                    if(input[0].equals(target))
                    {
                        System.out.print(result.substring(0,result.length() - 1));
                    }
                    continue;
                }

                for(int i = 2; i < input.length; i++)
                {
                    if(!preReq.containsKey(input[i]))
                    {
                        preReq.put(input[i], new ArrayList<String>());
                    }
                    preReq.get(input[i]).add(input[0]);
                }
            }

        }

        while(q.size() > 0)
        {
            String current = q.poll();

            for(int i = 0; i < preReq.get(current).size(); i++)
            {
                String pr = preReq.get(current).get(i);

                numPreReq.put(pr, numPreReq.get(pr) - 1);

                if(numPreReq.get(pr) == 0)
                {
                    q.add(pr);
                    result.append(pr + " ");
                    if(pr.equals(target))
                    {
                        System.out.print(result.substring(0,result.length() - 1));
                    }
                }
            }

        }

        System.out.print(result.toString());
        stdin.close();


    }
}
