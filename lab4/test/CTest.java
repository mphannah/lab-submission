import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CTest {

    Duration timeSeq1(Random r, int bound) {
        Instant start = Instant.now();
        C c = new C();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            a.add(r.nextInt(bound)+1);
        }

        c.removeDups(a);
        Instant end = Instant.now();
        return Duration.between(start, end);
    }

    Duration timeSeq2(Random r, int bound) {
        Instant start = Instant.now();
        C c = new C();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            a.add(r.nextInt(bound)+1);
        }

        c.removeDups2(a);
        Instant end = Instant.now();
        return Duration.between(start, end);
    }

    Duration timeSeq3(Random r, int bound) {
        Instant start = Instant.now();
        C c = new C();
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            a.add(r.nextInt(bound)+1);
        }

        c.noDups3(a);
        Instant end = Instant.now();
        return Duration.between(start, end);
    }

    // TODO: Implement tests that show the scaled growth in the methods you just implemented
    @Test
    void timeTest(){
        Random r = new Random();
        int bound = 10;
        Duration a;
        Duration b;
        Duration c;

        a = timeSeq1(r, bound);
        b = timeSeq2(r, bound);
        c = timeSeq3(r, bound);

        System.out.println("removeDups1: " + a.toMillis());
        System.out.println("removeDups2: " + b.toMillis());
        System.out.println("removeDups3: " + c.toMillis());
        assertTrue(a.toMillis() > b.toMillis());
        assertTrue(b.toMillis() < c.toMillis());
        assertTrue(c.toMillis() < a.toMillis());
    }
}
