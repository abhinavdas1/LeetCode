/**
 * Created by abhinavdas on 3/24/17.
 */


import java.io.IOException;
import java.util.*;

public class CatchingAnInsiderTrader {
    static String[] findPotentialInsiderTraders(String[] datafeed) {
        int curStockPrice = 0;
        Set<String> detected = new HashSet<>();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < datafeed.length; i++) {
            String[] details = datafeed[i].split("\\|");
            if (details.length == 2) {
                curStockPrice = Integer.parseInt(details[1]);
            }
            if (details.length == 4) {
                int day = Integer.parseInt(details[0]);
                String name = details[1];
                String op = details[2];
                long stock = Long.parseLong(details[3]);
                for (int j = i; j < datafeed.length; j++) {
                    String[] details2 = datafeed[j].split("\\|");
                    if (Integer.parseInt(details2[0]) - day > 3) {
                        break;
                    }
                    if (details2.length == 2) {
                        int multiplier;
                        if (op.equals("BUY")) {
                            multiplier = 1;
                        } else {
                            multiplier = -1;
                        }
                        if (stock*multiplier*(Integer.parseInt(details2[1]) - curStockPrice) > 5000000) {
                            if (!detected.contains(name)) {
                                result.add(day + "|" + name);
                                detected.add(name);
                                break;
                            }
                        }
                    }
                }
            }
        }
        String[] strArray = result.toArray(new String[0]);
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        return strArray;
    }
/*
    public static void main(String[] args) throws IOException {
        eed1 = "0|1000
        0|Shilpa|BUY|30000
        0|Will|BUY|50000
        0|Tom|BUY|40000
        0|Kristi|BUY|15000
        1|Kristi|BUY|11000
        1|Tom|BUY|1000
        1|Will|BUY|19000
        1|Shilpa|BUY|25000
        2|1500
        2|Will|SELL|7000
        2|Shilpa|SELL|8000
        2|Kristi|SELL|6000
        2|Tom|SELL|9000
        3|500
        38|1000
        78|Shilpa|BUY|30000
        79|Kristi|BUY|60000
        80|1100
        81|1200";
        Scanner in = new Scanner(feed);
        int _datafeed_size = 0;
        _datafeed_size = Integer.parseInt(in.nextLine().trim());
        String[] arr = new String[_datafeed_size];
        for (int i = 0; i < _datafeed_size; i++) {
            arr[i] = in.nextLine();
        }
        CatchingAnInsiderTrader.findPotentialInsiderTraders(arr);
    } */
}
