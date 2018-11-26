package study.alg.math;

public class Excel {

    public static int titleToNumber(String A) {
        int base = 26; // A -> Z
        int size = A.length();
        int number = 0;
        for (int i = 0; i < size; i++) {
            int digit = ((int)A.charAt(i) - (int)'A') + 1;
            number += (int) Math.pow(base, size - i - 1) * digit;
        }
        return number;
    }

    public static void main(String... args) {
        System.out.println("it is " + titleToNumber("A"));  // 28
    }
}
