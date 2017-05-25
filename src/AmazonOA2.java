import java.util.Stack;

/**
 * Created by abhinavdas on 2/12/17.
 */
public class AmazonOA2 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int hasPathSum(TreeNode root) {
        if(root == null)
            return 0;
        return findMinimum(root);
    }


    public int findMinimum(TreeNode root)
    {
        if(root == null)
            return 0;
        else
            return Math.min(findMinimum(root.left),findMinimum(root.right)) + root.val;
    }


    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;


        ListNode slow=head;
        ListNode fast=head;

        while(fast.next!=null && fast.next.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }

        ListNode temp=slow.next;
        ListNode prev=null;
        ListNode nex=null;

        while(temp!=null)
        {
            nex=temp.next;
            temp.next=prev;
            prev=temp;
            temp=nex;
        }
        slow.next=prev;
        return head;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}