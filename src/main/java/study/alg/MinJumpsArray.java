package study.alg;

import java.util.ArrayList;

// min path to jump in an array to through the indices until the end
public class MinJumpsArray {

    public int jump(ArrayList<Integer> A) {
        if(A == null || A.size() == 0)
            return 0;
        int steps = 0;
        int max =0;
        int next =0;
        for(int i =0; i < A.size() - 1 && next < A.size() -1; i++){
            max = Math.max(max, i + A.get(i));
            if(i == next){//ready to jump
                if(max == next)
                    return -1;//unreachable
                next = max;
                steps++;
            }
        }
        return steps;
    }
}
