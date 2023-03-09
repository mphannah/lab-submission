<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
=======
>>>>>>> 8f24919 (messageclarification)
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
>>>>>>> 9a2d643 (skeleton for lab3)
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
>>>>>>> 0e952b9 (done with lab 3)
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
>>>>>>> dfbb09a (messageclarification)
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
>>>>>>> 069d06e (done with lab 3)
=======
=======
import java.util.Arrays;

>>>>>>> f9e8a87 (done with lab 3)
<<<<<<< HEAD
>>>>>>> a94a887 (done with lab 3)
public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
<<<<<<< HEAD
=======
import java.util.Arrays;

=======
=======
>>>>>>> 1a96b44 (skeleton for lab3)
<<<<<<< HEAD
>>>>>>> 9a2d643 (skeleton for lab3)
=======
=======
>>>>>>> a5b275b (done with lab 3)
<<<<<<< HEAD
>>>>>>> 0e952b9 (done with lab 3)
=======
=======
=======
>>>>>>> fc0de73 (done with lab 3)
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
=======
>>>>>>> 8f24919 (messageclarification)
<<<<<<< HEAD
>>>>>>> 05121db (messageclarification)
<<<<<<< HEAD
>>>>>>> dfbb09a (messageclarification)
=======
=======
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
=======
=======
import java.util.Arrays;

>>>>>>> f9e8a87 (done with lab 3)
>>>>>>> a94a887 (done with lab 3)
>>>>>>> fc0de73 (done with lab 3)
>>>>>>> 069d06e (done with lab 3)
public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
<<<<<<< HEAD
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
=======
     *  protocols (https://en.wikipedia.org/wiki/Endianness).
>>>>>>> 1a96b44 (skeleton for lab3)
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> fc0de73 (done with lab 3)
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
<<<<<<< HEAD
=======
    public int incrementEfficient() throws CountOutOfBoundsException{
        return 0; // TODO
>>>>>>> 1a96b44 (skeleton for lab3)
=======
>>>>>>> fc0de73 (done with lab 3)
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

<<<<<<< HEAD
<<<<<<< HEAD
        // Assume the next three lines cost 0
=======
>>>>>>> 1a96b44 (skeleton for lab3)
=======
        // Assume the next three lines cost 0
>>>>>>> 0ce54de (clarification)
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 6adddd1 (done with lab 3)
=======
>>>>>>> 0ce54de (clarification)
>>>>>>> 8f24919 (messageclarification)
=======
=======
>>>>>>> 0e952b9 (done with lab 3)
=======
>>>>>>> dfbb09a (messageclarification)
<<<<<<< HEAD
>>>>>>> 0ce54de (clarification)
=======
>>>>>>> 1a96b44 (skeleton for lab3)
<<<<<<< HEAD
>>>>>>> 9a2d643 (skeleton for lab3)
=======
=======
=======
>>>>>>> 05121db (messageclarification)
=======
import java.util.Arrays;

public class Counter {
    class CountOutOfBoundsException extends Exception {}

    private int maxCount; // the maximum count assuming bits represents an unsigned int
    private int count; // the current count
    private int numBits; // the number of bits to use in the counter, typically a power of two
    private int[] bits; // little endian binary representation of count

    /*
     *  Little vs. Big Endian
     *  =====================
     *  The notion of "Endianess" refers to how a binary number is read. Binary is always read left to right, but we
     *  refer to the right end as being the little or big end (i.e. the bits of smaller or larger end).
     *
     *  Little Endian:    5 -> 0000 0000 0000 0101
     *
     *  Big Endian:       5 -> 1010 0000 0000 0000
     *
     *  You will almost always see binary with little endian ordering; big endian is mainly used in networking
     *  protocols (https://en.wikipedia.org/wiki/Endianness). .
     */

    public Counter(int numBits) {
        this.count = 0;
        this.numBits = numBits;
        this.maxCount = (int) Math.pow(2, numBits) - 1;
        this.bits = new int[numBits];
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementEfficient() throws CountOutOfBoundsException {
        if (this.count + 1 > this.maxCount) {
            throw new CountOutOfBoundsException();
        }
        this.count += 1;
        int i;
        int cost = 0;

        for (i = this.bits.length-1; i >= 0; i--) {
            if (this.bits[i] == 0) {
                this.bits[i] = 1;
                cost += 1;
                break;
            } else if (this.bits[i] == 1) {
                this.bits[i] = 0;
                cost += 1;
            }
        }

        return cost; // TODO
    }

    /**
     * Increments the value of this.count and its binary representation (remember this.bits represents a number in binary).
     *
     * E.x. if this.bits = [ 0, 1, 1, 0, 1 ], this.bits should become [ 0, 1, 1, 1, 0 ] after a call to this function and the
     * returned integer should be 2.
     *
     * @return The number of "checks" (iterations of a loop) performed during the operation
     */
    public int incrementSlow() throws CountOutOfBoundsException {
        if (this.count+1 > this.maxCount) throw new CountOutOfBoundsException();

        this.count++;

        // Assume the next three lines cost 0
        String format = "%"+this.numBits+"s";
        String countStr = Integer.toBinaryString(this.count);
        String newCountBinary = String.format(format, countStr).replaceAll(" ", "0");

        int cost = 0;
        // For-loop reversed to stay consistent with the little endian property of this.bits
        for (int i = newCountBinary.length()-1; i >= 0; i--) {
            cost++;
            this.bits[i] = Integer.parseInt(newCountBinary.charAt(i)+"");
        }

        return cost;
    }

    /**
     * toString() methods are a great addition to any class you make (remember from C212?)! They make it super simple to
     * make a visual representation of your objects like so:
     *
     * System.out.println(*your BinaryCounter obj*);
     *
     * @return A string representation of a BinaryCounter object.
     */
    @Override
    public String toString() {
        String res = "[ ";

        for (int i = 0; i < this.bits.length; i++)
            res += this.bits[i] + ", ";

        return res.substring(0, res.length() - 2) + " ]";
    }
}
>>>>>>> 6adddd1 (done with lab 3)
<<<<<<< HEAD
>>>>>>> a5b275b (done with lab 3)
<<<<<<< HEAD
>>>>>>> 0e952b9 (done with lab 3)
=======
=======
=======
>>>>>>> 0ce54de (clarification)
>>>>>>> 8f24919 (messageclarification)
>>>>>>> 05121db (messageclarification)
>>>>>>> dfbb09a (messageclarification)
