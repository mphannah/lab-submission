import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises {
    private static List<Integer> ints = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,2,8,8,8));

    // ------------------------------------------------------------------------
    // Exercise I: multiply the elements in the list using the five approaches
    // ------------------------------------------------------------------------

    static int mul1 () {
        int res = 1;
        for (int i=0; i<ints.size(); i++) res *= ints.get(i);
        return res;
    }

    static int mul2 () {
        int res = 1;
        for (int k : ints) res *= k;
        return res;
    }

    static int mul3 () {
        int res = 1;
        ListIterator<Integer> iterator = ints.listIterator();
        while (iterator.hasNext()) res *= iterator.next();
        return res;
    }

    /* Notice that we have two of the same solutions for mul. Exercises 2-4 have multiple
     * unique solutions using Streams, so please find at least two Stream solutions for
     * those exercises!
     */
    static int mul4 () {
        return ints.stream().reduce(1, (res,k) -> res * k);
    }

    static int mul5 () {
        return ints.stream().reduce((res, k) -> res * k).orElse(1);
    }

    // ------------------------------------------------------------------------
    // Exercise II: check if all elements in the list are even
    // ------------------------------------------------------------------------

    static boolean even1 () {
        for (int i = 0; i < ints.size(); i++) {
            if (!(ints.get(i) % 2 == 0)) {
                return false;
            }
        }
        // TODO
        return true;
    }

    static boolean even2 () {
        for (Integer i : ints) {
            if (!(i % 2 == 0)) {
                return false;
            }
        }
        // TODO
        return true;
    }

    static boolean even3 () {
        List<Integer> checkList = new ArrayList<>();

        for (Integer i : ints) {
            if (i % 2 == 0) {
                checkList.add(i);
            }
         }

        if (checkList.containsAll(ints)) {
            return true;
        } else {
            return false;
        }
        // TODO
    }

    static boolean even4 () {
        boolean allEven = ints.stream()
                .allMatch(elem -> elem%2==0);
        // TODO
        return allEven;
    }

    static boolean even5 () {
        boolean allEven = ints.stream().map(elem -> elem%2)
                .allMatch(elem -> elem==0);
        // TODO
        return allEven;
    }

    // ------------------------------------------------------------------------
    // Exercise III: compute the maximum
    // ------------------------------------------------------------------------

    static int max1 () {
        int max = ints.get(0);

        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) > max) {
                max = ints.get(i);
            }
        }
        // TODO
        return max;
    }

    static int max2 () {
        int max = ints.get(0);

        for (Integer i : ints) {
            if (i > max) {
                max = i;
            }
        }
        // TODO
        return max;
    }

    static int max3 () {
        int max = ints.get(0);
        ListIterator<Integer> iterator = ints.listIterator();

        while (iterator.hasNext()) {
            if (iterator.next() > max) {
                max = iterator.next();
            }
        }
        // TODO
        return max;
    }

    static int max4 () {
        Integer max = ints.stream()
                .mapToInt(elem -> elem).max().orElseThrow(NoSuchElementException::new);
        // TODO
        return max;
    }

    static int max5 () {
        ints.sort(Comparator.naturalOrder());
        // TODO
        return ints.get(ints.size()-1);
    }

    // ------------------------------------------------------------------------
    // Exercise IV: count occurrences
    // ------------------------------------------------------------------------

    static int count1 (int c) {
        int count = 0;

        for (int i = 0; i < ints.size(); i++) {
            if (ints.get(i) == c) {
                count += 1;
            }
        }
        // TODO
        return count;
    }

    static int count2 (int c) {
        int count = 0;

        for (Integer i : ints) {
            if (i == c) {
                count += 1;
            }
        }
        // TODO
        return count;
    }

    static int count3 (int c) {
        int count = 0;
        ListIterator<Integer> iterator = ints.listIterator();

        while (iterator.hasNext()) {
            if (iterator.next() == c) {
                count += 1;
            }
        }
        // TODO
        return count;
    }

    static int count4 (int c) {
        List<Integer> cList = ints.stream()
                .filter(elem -> elem==c).collect(Collectors.toList());
        // TODO
        return cList.size();
    }

    static int count5 (int c) {
        List<Integer> cList = new ArrayList<>();

        for (Integer i : ints) {
            if (i == c) {
                cList.add(i);
            }
        }
        // TODO
        return cList.size();
    }

    // ------------------------------------------------------------------------
    // Exercise V: triplicate
    // ------------------------------------------------------------------------

    static List<Integer> trip1 () {
        List<Integer> tripList = new ArrayList<>();

        for (int i = 0; i < ints.size(); i++) {
            tripList.add(ints.get(i));
            tripList.add(ints.get(i));
            tripList.add(ints.get(i));
        }
        // TODO
        return tripList;
    }

    static List<Integer> trip2 () {
        List<Integer> tripList = new ArrayList<>();

        for (Integer i : ints) {
            tripList.add(i);
            tripList.add(i);
            tripList.add(i);
        }
        // TODO
        return tripList;
    }

    static List<Integer> trip3 () {
        List<Integer> tripList = new ArrayList<>();
        ListIterator<Integer> iterator = ints.listIterator();

        while (iterator.hasNext()) {
            tripList.add(iterator.next());
            tripList.add(tripList.get(tripList.size()-1));
            tripList.add(tripList.get(tripList.size()-1));
        }
        // TODO
        return tripList;
    }

    static List<Integer> trip4 () {
        List<Integer> tripList = ints.stream()
                .flatMap(num -> Stream.of(num, num, num)).collect(Collectors.toList());
        // TODO
        return tripList;
    }


}
