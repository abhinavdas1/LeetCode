/**
 * Created by abhinavdas on 6/25/17.
 */
public class HackerrankRemoveNodes {
     static class LinkedListNode
    {
        int val;
        LinkedListNode next;

        LinkedListNode(int val , LinkedListNode t)
        {
            this.val = val;
            next = t;
        }
    }

    static LinkedListNode removeNodes(LinkedListNode list, int x)
    {
        LinkedListNode head;

        head = list;

        while(head != null)
        {
            if(head.val > x)
            {
                head = head.next;
                continue;
            }
            break;
        }

        list = head;
        LinkedListNode prev = head;
        while(list != null)
        {
            if (list.val > x) {
                prev.next = list.next;
                list = list.next;
            }
            else {
                prev = list;
                list = list.next;
            }
        }

        return head;

    }

    public static void main(String[] args)
    {
        LinkedListNode a = new LinkedListNode(1, null);
        LinkedListNode b = new LinkedListNode(2,a);
        LinkedListNode c = new LinkedListNode(3,b);
        LinkedListNode d = new LinkedListNode(4,c);
        LinkedListNode e = new LinkedListNode(1, d);
        LinkedListNode f = new LinkedListNode(2, e);
        LinkedListNode g = new LinkedListNode(3, f);

        a = removeNodes(b, 1);

        while(a != null)
        {
            System.out.println(a.val);
            a = a.next;
        }

    }

}
