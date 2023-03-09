import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class C {

    int makeChange (int amount) {
        int[] coinsArray = {1, 5, 10, 25};
        int next = 0;
        int permutations = 0;

        if (amount == 0) {
            return 1;
        }

        for (int i = 0; i < coinsArray.length; i++) {
            next = 0;
            if (coinsArray[i] <= amount) {
                next = makeChange(amount - coinsArray[i]);
            }
            if (next != 0) {
                permutations += 1;
            }
        }
        // TODO
        return permutations;
    }

}

class CHash extends C {
    private HashMap<Integer, Integer> hm;
    CHash() { hm = new HashMap<>(); }

    int makeChange (int amount) {

        // TODO
        return 0;
    }
}


