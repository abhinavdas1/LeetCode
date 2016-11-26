/**
 * Created by abhinavdas on 11/18/16.
 */
public class sortVersion {
    public static String[] answer(String[] l) {

        mergeSort(l);
        return l;
    }
    public static void mergeSort(String[] l) {
        if (l.length >= 2) {
            String[] left = new String[l.length / 2];
            String[] right = new String[l.length - l.length / 2];

            for (int i = 0; i < left.length; i++)
                left[i] = l[i];

            for (int i = 0; i < right.length; i++) {
                right[i] = l[i + l.length / 2];
            }

            mergeSort(left);
            mergeSort(right);
            merge(l, left, right);
        }
    }
    public static void merge(String[] names, String[] left, String[] right) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < names.length; i++) {
            if (b >= right.length || (a < left.length && compare(left[a],right[b]) > 0)) {
                names[i] = left[a];
                a++;
            } else {
                names[i] = right[b];
                b++;
            }
        }
    }
    public static int compare(String a, String b)
    {
        int i=0,j=0;
        String[] first=a.split("\\.");
        String[] second=b.split("\\.");
        while(i<first.length && j<second.length)
        {
            if(Integer.parseInt(first[i])>Integer.parseInt(second[j]))
                return -1;
            else if(Integer.parseInt(first[i])<Integer.parseInt(second[j]))
                return 1;
            i++;
            j++;
        }
        if(i==first.length)
            return 1;
        return-1;

    }
}
