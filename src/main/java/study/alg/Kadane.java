package study.alg;

public class Kadane {

    static int kadane(int[] arr) {
        int max_iterator = 0;
        int max_so_far = 0;
        for (int x: arr) {
            max_iterator += x;
            if (max_iterator < 0) {
                max_iterator = 0;
            }
            if (max_so_far < max_iterator) {
                max_so_far = max_iterator;
            }
        }
        return max_so_far;
    }

    public static void main(String... args) {
        int[] arr = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int sum = kadane(arr);
        System.out.println("longest is " + sum);
    }
}
