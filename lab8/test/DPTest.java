import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class DPTest {

    DP dp = new DP();

    @Test
    void busubsetSum(){
        ArrayList<Integer> s = new ArrayList<>();
        s.add(4);
        s.add(5);
        s.add(7);
        s.add(1);
        s.add(9);
        assertTrue(dp.busubsetSum(s, 6));
        assertTrue(dp.busubsetSum(s, 22));
        assertFalse(dp.busubsetSum(s, 50));
        // TODO

    }

    @Test
    void bumakeChange(){
        assertEquals(3, dp.bumakeChange(6));
        // TODO
    }

}
