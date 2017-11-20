/**
 * Created by abhinavdas on 6/13/17.
 */
import java.util.*;

public class removeBandAC {

    public static void main(String[] args) {
        remove("ad");
        remove("acbac");
        remove("aaac");
        remove("react");
        remove("aa");
        remove("ababcac");
        remove("aaabbccc");
    }

    public static void remove(String str) {
        int n = str.length(), i;
        int ptr = 0;
        char[] arr = str.toCharArray();
        int state  = 0;
        for (i = 0; i < n; ++i) {
            if (ptr>1 && arr[ptr-2] == 'a' && arr[ptr-1] =='c')
                ptr = ptr-2;

            if(arr[i] == 'a')
            {
                if(state == 1)
                {
                    arr[ptr++] = 'a';
                }
                state = 1;
                continue;
            }
            else if (arr[i] == 'b') {
                if(state == 1)
                {
                    arr[ptr++] = 'a';
                }
                state = 0;
                continue;
            } else if (state == 1 && arr[i] == 'c') {
                state  = 0;
                continue;
            } else {
                if (state == 1) {
                    state = 0;
                    arr[ptr++] = 'a';
                }
                arr[ptr++] = arr[i]; // Copy char to head.
            }

        }

        if (state == 1) {
            arr[ptr++] = 'a';
        }

        if (ptr>1 && arr[ptr-2] == 'a' && arr[ptr-1] =='c')
            ptr = ptr-2;

        char[] ret = Arrays.copyOfRange(arr, 0, ptr);
        System.out.println(new String(ret));
    }
}