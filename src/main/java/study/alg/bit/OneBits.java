package study.alg.bit;

public class OneBits {

    public static int numSetBits(long a) {
        int bits = 0;
        while (a > 0) {
            if (a % 2 > 0) bits++;
            a >>= 1;
        }
        return bits;
    }

    public static void main(String[] args) {
        int res = numSetBits(11);
        System.out.println("bits = "+res);
    }
}
