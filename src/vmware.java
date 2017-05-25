/**
 * Created by abhinavdas on 1/26/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.util.Scanner;

public class vmware {

    public static void translate() {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        sc.nextLine();
        Word[] dict=new Word[count];
        HashMap<String,Word> hm=new HashMap<String,Word>();
        for(int i=0; i<count; i++)
        {
            String abc=sc.nextLine();
            String[] inp=abc.split(" ");
            String eng=inp[0];
            String other=inp[1];
            int weight=Integer.parseInt(inp[2]);
            dict[i]=new Word(other,weight);
            hm.put(eng,dict[i]);
        }
        PriorityQueue<Word> pq=new PriorityQueue<Word>((a,b) -> a.weight - b.weight);
        String fin=sc.nextLine();
        String[] inps=fin.split(" ");
        int j=Integer.parseInt(inps[0]);
        for(int i=1; i<=j; i++)
        {
            String english=inps[i];
            if(!hm.containsKey(english))
                continue;
            else
            {
                Word w=hm.get(english);
                pq.add(w);
            }
        }
        StringBuilder sb=new StringBuilder("");

        while(pq.size()>0)
        {
            sb.append(pq.poll().word);
            if(pq.size()!=0)
                sb.append(" ");
        }
        System.out.println(sb.toString());

    }

    static class Word
    {
        String word;
        int weight;
        Word(String a, int b)
        {
            word=a;
            weight=b;
        }
    }
}