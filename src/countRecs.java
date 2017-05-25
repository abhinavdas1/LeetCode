/**
 * Created by abhinavdas on 1/26/17.
 */
/*
import java.util.Scanner;
import java.util.*;
public class countRecs {
    public void countR()
    {
        Scanner sc = new Scanner(System.in);
        List<List<Integer>> stickList = new ArrayList<List<>>();

        int num =  Integer.parseInt(sc.nextLine());

        int i = num;

        for(int i=0; i<num; i++)
        {
            int numSticks = Integer.parseInt(sc.nextLine());
            ArrayList<Integer> temp = new ArrayList<Integer>();
            String t = sc.nextLine();
            String[] input = t.split(" ");
            for(String k : input ){
                temp.add(Integer.parseInt(k));
            }
            stickList.add(temp);
            i--;
        }

        for(List<Integer> list : stickList){
            if(list.size() < 4)
                System.out.println("0");
            else{
                Collections.sort(list);
                int pairs = 0,j = 0;
                for(int k=1 ; k< list.size(); ){

                    if(list.get(k) == list.get(k-1)){
                        pairs++;
                        k+=2;
                    }
                    else
                        k++;
                }
                System.out.println(pairs/2);
            }
        }
    }
}
*/