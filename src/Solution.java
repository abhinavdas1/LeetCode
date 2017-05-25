/**
 * Created by abhinavdas on 11/3/16.
 */
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

import java.util.*;
public class Solution {
    public static void main(String args[])
    {
//        DecodeString d=new DecodeString();
//        System.out.println(d.decodeString("a2[b]"));

//        googbob g=new googbob();
//        int n=g.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.png\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.gif");
//        System.out.println(n);

//        ArrayDuplicacyint a=new ArrayDuplicacyint();
//        int[] nums={4,2,3,1,2,4};
//        a.findDuplicates(nums);
/*        ArrayList<Integer> arr=new ArrayList<Integer>();
        arr.add(5);
        arr.add(6);
        arr.add(0);
        arr.add(4);
        arr.add(2);
        arr.add(4);
        arr.add(1);
        arr.add(0);
        arr.add(0);
        arr.add(4);
        ArrayHopper.findHopsHelper(arr); */
//        contigiousMinimumUnsorted c=new contigiousMinimumUnsorted();
//        int[] nums={};
//        System.out.println(c.check(nums));
//        areaFitting a=new areaFitting();
//        int[] nums=a.toSquares(0);
//        for(int i: nums)
//        {
//            System.out.println(i);
//        }

//        maxProduct m=new maxProduct();
//        int[] nums={0,0,0,0,-9,0,-8,-3};
//        System.out.println(m.getprod(nums));

//        sortVersion a=new sortVersion();
//        String[] s={"2.0.0"};
//        s=a.answer(s);
//        for (String s1 : s) {
//            System.out.println(s1);
//        }
//        contiguousSum c=new contiguousSum();
//        int[] n={1,2,34,3,4};
//        int[] nums=c.ans(n,7);
//        for (int i: nums) {
//            System.out.println(i);
//        }
//        int[] n={1,2,4,16};
//        GpTriplets g=new GpTriplets();
//        System.out.println(g.answer(n));
//        reduceToOne r=new reduceToOne();
//        System.out.println(r.ans("15"));
//        permuatations2 p=new permuatations2();
//        int[] n={1,1,2};
//        System.out.println(p.permuteUnique(n));
//        reverseWords r=new reverseWords();
//        System.out.println(r.reverseWords("   a   b  c d   e  "));
//        new flipBits().flip();
//        public static void main(String[] args) {
//        String input = "(A,B) (A,C) (B,D) (D,C)";
//        GraphEdgeTree gt = new GraphEdgeTree(input);
//        String error = gt.buildTree();
//        if(error != null) {
//            System.out.println(error);
//        } else {
//            String result = gt.treeString(gt.getRoot());
//            System.out.println(result);
//        }
 //   }
//        Graph g=new Graph();
//        g.constructSExpression("(A,B) (A,C) (B,D) (D,C)");
//        subStrRecurs s=new subStrRecurs();
//        System.out.println(s.getNum("gvjhgf aaaaa","aa"));
//        firstRepeatingCharacter f=new firstRepeatingCharacter();
//        f.first();
//        numformat n=new numformat();
//        n.numfor();
//        Chocolate c=new Chocolate();
//        c.countChocolates();
//        internalFragmentation inf=new internalFragmentation();
//        inf.numFragments();
//        BinaryOuroboros b=new BinaryOuroboros();
//        b.nthkth();
//        vmware v=new vmware();
//        v.translate();
//        countBinarySubstring cbs=new countBinarySubstring();
//        cbs.binary("10001110");
//        int[] n={1,2,3};
//        System.out.println(PureStorage.binSearch(n,2));
//        maxElement me=new maxElement();
//        me.getMax(Integer.MAX_VALUE,- 2);

//        String a="hello ";
//        System.out.println(a.contains("hel"));

//        PureStorageSet ps = new PureStorageSet(4);
//
//        System.out.println(ps.add(2));
//        ps.clear();
//        System.out.println(ps.add(1));
//        for(int i : ps.map)
//            System.out.println(i);
//
//
//        System.out.println(ps.contains(0));
//        System.out.println(ps.contains(2));
//        System.out.println(ps.delete(1));
//
//        for(int i : ps.map)
//        System.out.println(i);
        rotateMatrix rm = new rotateMatrix();
        int[][] mat={{1,2,3,4},{5,6,7,8},{11,12,13,14}};
        mat = rm.sol(mat,1);
        for(int i = 0; i<mat.length; i++)
        {
            for(int j = 0; j< mat[0].length; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }


    }
}
