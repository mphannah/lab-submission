import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Math;

public class DP {

    /**
     * subsetSum: take an ArrayList list, a desired sum 's', and return
     * T/F depending on whether it is possible to find the sum
     * from the elements in the list
     */
    static boolean subsetSum (ArrayList<Integer> s, int sum) {
        if (sum == 0 ){
            return true;
        }
        if (sum < 0){
            return false;
        }
        if (s.size() == 0){
            return false;
        }
        Integer first = s.remove(0);
        ArrayList<Integer> s_cloned = (ArrayList<Integer>) s.clone();
        return subsetSum(s, sum - first) || subsetSum(s_cloned, sum);
    }

    // TODO
    // Hint: Look at the number of arguments/what we have to compare to start
    static boolean busubsetSum(ArrayList<Integer> s, int sum){
        boolean[][] sumArray = new boolean[s.size()+1][sum+1];

        for (int x = 0; x < sumArray.length; x++) {
            sumArray[x][0] = true;
        }

        for (int i = s.size()-1; i >= 0; i--) {
            int j = 1;

            while (j <= sum) {
                if (j - s.get(i) == 0) {
                    sumArray[i][j] = true;
                } else if (j - s.get(i) > 0) {
                    int check = j - s.get(i);
                    sumArray[i][j] = sumArray[i+1][check];
                } else {
                    sumArray[i][j] = sumArray[i+1][j];
                }

                if (sumArray[i+1][j] == true && sumArray[i][j] != sumArray[i+1][j]) {
                    sumArray[i][j] = sumArray[i+1][j];
                }
                j += 1;
            }
        }

        for (int x = 0; x < sumArray.length; x++) {
            System.out.println(Arrays.toString(sumArray[x]));
        }

        return sumArray[0][sum];
    }

    static int makeChange (int amount) {
        if (amount < 0) return 0;
        else if (amount == 0) return 1;
        else return makeChange(amount - 25) +
                    makeChange(amount - 10) +
                    makeChange(amount - 5) +
                    makeChange(amount - 1);
    }

    // TODO
    // permutations of the ways to make change
    // i. e 6 = 3 because {1, 1, 1, 1, 1, 1}, {5, 1}, {1, 5}
    // Hint: Look at number of arguments for how to start the problem
    static int bumakeChange(int amount) {
        int[] amountArray = new int[amount+1];
        amountArray[0] = 1;

        for (int i = amountArray.length-1; i >= 0; i--) {
            int j = amount;

            if (j >= 25) {

            }
        }

        return 0;
    }
}