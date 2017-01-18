import javax.lang.model.element.Element;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 * Created by abhinavdas on 1/18/17.
 */
public class firstRepeatingCharacter {
    public void first()
    {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char[] ch=str.toCharArray();
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        for(int i=0; i<ch.length; i++)
        {
            if(!hm.containsKey(ch[i]))
            {
                hm.put(ch[i],1);
            }
            else
            {
                hm.put(ch[i],hm.get(ch[i])+1);
            }
        }
        for(Map.Entry<Character,Integer> e: hm.entrySet())
        {
            if(e.getValue()>1)
            {
                System.out.println(e.getKey());
                break;
            }
        }
    }
}
