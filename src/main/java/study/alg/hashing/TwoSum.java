package study.alg.hashing;

import java.util.*;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        int i1 = -1, i2 = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (map.containsKey(nums[i])) {
                i1 = map.get(nums[i]);
                i2 = i;
                break;
            } else if (!map.containsKey(target - nums[i])) {
                map.put(target - nums[i], i);
            }
        }
        List<Integer> result = Arrays.asList(i1, i2);
        return result.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        int i1 = -1, i2 = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<A.size(); i++) {
            if (map.containsKey(A.get(i))) {
                i1 = map.get(A.get(i));
                i2 = i;
                break;
            } else if (!map.containsKey(B - A.get(i))) {
                map.put(B - A.get(i), i);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        if (i1 > -1) {
            list.add(i1+1);
            list.add(i2+1);
            Collections.sort(list);
        }
        return list;
    }

    public static void main(String[] args) {
        TwoSum alg = new TwoSum();
        ArrayList<Integer> res = alg.twoSum(Arrays.asList(2, 7, 11, 15), 9);
        System.out.println("res = " + res);
    }
}
