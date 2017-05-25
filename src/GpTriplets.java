/**
 * Created by abhinavdas on 11/20/16.
 */
class GpTriplets
{
        public static int answer( int[] l)
        {
            int count = 0;
            int[] step1 = new int[l.length];
            for (int i = 1; i < l.length - 1; ++i) {
                for (int j = 0; j < i; ++j) {
                    if (l[i] % l[j] == 0)
                        ++step1[i];
                }
            }
            for (int i = 2; i < l.length; i++) {
                for (int j = 1; j < i; ++j) {
                    if (l[i] % l[j] == 0)
                        count += step1[j];
                }
            }

            return count;
        }
}