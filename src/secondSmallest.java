/**
 * Created by abhinavdas on 10/25/17.
 */
public class secondSmallest {

    public static void minimumCashFlow(int[][] graph) {
        int[] amount = getAmount(graph);
        minimumCashFlow(amount);

    }

    public static void minimumCashFlow(int[] amount) {

        //@// TODO: 13/12/16
        int maximumCreditPerson = getMaxPerson(amount);
        int maximumDebitPerson = getMinPerson(amount);

        if (amount[maximumCreditPerson] == 0 && amount[maximumDebitPerson] == 0) {
            return;
        }

        int min = Math.min(-amount[maximumDebitPerson], amount[maximumCreditPerson]);

        amount[maximumCreditPerson] -= min;
        amount[maximumDebitPerson] += min;


        System.out.println("Person(" + maximumDebitPerson + ") pays " +
                min + " to Person(" + maximumCreditPerson + ")");

        minimumCashFlow(amount);
    }

    private static int getMinPerson(int[] amount) {
        int minPerson = 0;
        for (int i = 1; i < amount.length; i++) {
            if (amount[i] < amount[minPerson]) {
                minPerson = i;
            }
        }

        return minPerson;
    }

    private static int getMaxPerson(int[] amount) {
        int maxPerson = 0;
        for (int i = 1; i < amount.length; i++) {
            if (amount[i] > amount[maxPerson]) {
                maxPerson = i;
            }
        }
        return maxPerson;
    }

    private static int[] getAmount(int[][] graph) {
        int amount[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                /**
                 * Here  graph[j][i] => incoming amount
                 * and  graph[i][j] => outgoing amount
                 */
                amount[i] += graph[i][j] - graph[j][i];
            }
        }

        return amount;
    }

    public static void main(String[] args) {

        int[][] graph = {
                {0, 5, 5, 0},
                {0, 0, 10, 0},
                {0, 0, 0, 1},
                {3, 0, 0, 0}
        };

        minimumCashFlow(graph);

    }
}
