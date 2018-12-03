package study.alg.heaps;

import java.util.*;

public class Inversions {

    // if A[i] > A[j] and i < j
    //O(n2)
    public int countInversions1(ArrayList<Integer> A) {
        int n = A.size();
        int res = 0;
        for(int i=0; i<n-1; i++) {
            ArrayList<Integer> coll = new ArrayList<>();
            for (int j=i+1; j<n; j++) {
                if (A.get(i) > A.get(j)) {
                    res++;
                    coll.add(A.get(j));
                }
            }
            coll.sort(Comparator.comparingInt(a -> a));
            //System.out.println("111 adding "+A.get(i) + ", greater than "+coll);
        }
        return res;
    }

    // if A[i] > A[j] and i < j
    public int countInversions3(ArrayList<Integer> A) {
        // count duplicates
        HashMap<Integer, Integer> frequency = new HashMap();
        A.forEach(a -> {
            int f = frequency.getOrDefault(a, 0);
            frequency.put(a, f+1);
        });
        TreeMap<Integer, Integer> map = new TreeMap();
        int n = A.size();
        for(int i=0; i<n; i++) {
            int v = A.get(i);
            SortedMap<Integer, Integer> greater = map.tailMap(v);
            greater.remove(v);
            //System.out.println("333 adding "+v + ", greater than "+greater.keySet());
            int inv = greater.size();
            map.put(v, inv);
        }
        //sum times frequency
        int res = 0;
        for(int k: frequency.keySet()) {
            int f = frequency.get(k);
            res += map.get(k) * f;
        }
        //int sum = map.values().stream().reduce(0, (a, b) -> a+b);
        return res;
    }

    int count = 0;
    ArrayList<Integer> merge(List<Integer> left, List<Integer> right) {
        int nl = left.size();
        int nr = right.size();
        count = 0;
        ArrayList<Integer> sorted = new ArrayList<>();
        for (int i = 0, j = 0; i < nl || j < nr;) {
            if (j < nr && i < nl) {
                if (left.get(i) < right.get(j)) {
                    sorted.add(left.get(i++));
                } else {
                    sorted.add(right.get(j++));
                    count += nl - i;
                }
            } else if (i < nl) {
                sorted.add(left.get(i++));
            } else if (j < nr) {
                sorted.add(right.get(j++));
            }
        }
        return sorted;
    }

    ArrayList<Integer> mergeSort(ArrayList<Integer> A) {
        int n = A.size();
        if (n == 1) return A;
        ArrayList<Integer> left = mergeSort(new ArrayList(A.subList(0, n / 2)));
        ArrayList<Integer> right = mergeSort(new ArrayList(A.subList(n / 2, n)));
        return merge(left, right);
    }

    public int countInversions5(ArrayList<Integer> A) {
        ArrayList<Integer> integers = mergeSort(A);
        System.out.println("integers="+integers);
        return count;
    }

    // if A[i] > A[j] and i < j
    public int countInversions4(ArrayList<Integer> A) {
        TreeMap<Integer, Integer> map = new TreeMap();
        A.forEach(a -> map.put(a, a));
        int n = A.size();
        int res = 0;
        for(int i=0; i<n; i++) {
            int v = A.get(i);
            SortedMap<Integer, Integer> greater = map.headMap(v);
            greater.remove(v);
            //System.out.println("444 adding "+v + ", greater than "+greater.keySet());
            res += greater.size();
            map.put(v, v);
        }
        return res;
    }

    public int countInversions(ArrayList<Integer> A) {
        int count = 0;
        count = merge(A, 0, A.size() - 1);
        return count;
    }

    static int merge(ArrayList<Integer> A, int low, int high) {
        int a = 0, b = 0, c = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            a = merge(A, low, mid);
            b = merge(A, mid + 1, high);
            c = mergesort(A, low, mid, high);
        }
        return a + b + c;
    }

    static int mergesort(ArrayList<Integer> A, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();
        int i = low, j = mid + 1;
        int count = 0;

        while (i <= mid && j <= high) {
            if (A.get(i) <= A.get(j)) {
                temp.add(A.get(i));
                i++;
            } else {
                temp.add(A.get(j));
                j++;
                count += (mid + 1 - i);
            }
        }

        while (i <= mid) {
            temp.add(A.get(i));
            i++;
        }

        while (j <= high) {
            temp.add(A.get(j));
            j++;
        }

        for (i = 0; i < temp.size(); i++) {
            A.set(i + low, temp.get(i));
        }

        return count;
    }

    // if A[i] > A[j] and i < j
    public static void main(String[] args) {
        Inversions alg = new Inversions();  // 278 -> 290
        //ArrayList in = new ArrayList(Arrays.asList(19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60)); //, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60));
        //ArrayList in = new ArrayList(Arrays.asList(84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60)); //, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60));
        //ArrayList in = new ArrayList(Arrays.asList(84, 2, 37, 3, 67, 82, 19, 97, 91, 63, 27, 6, 13, 90, 63, 89, 100, 60, 47, 96, 54, 26, 64, 50, 71, 16, 6, 40, 84, 93, 67, 85, 16, 22, 60));
        ArrayList in = new ArrayList(Arrays.asList(2, 6, 4, 1, 5, 3));
        //ArrayList in = new ArrayList(Arrays.asList(2, 4, 1, 3, 5)); // 3
        System.out.println("input="+in);
        int res1 = alg.countInversions1(in);
        int res2 = alg.countInversions(in);
        int res3 = alg.countInversions3(in);
        System.out.println("res " + res1 + "("+res2+")");
    }
}
