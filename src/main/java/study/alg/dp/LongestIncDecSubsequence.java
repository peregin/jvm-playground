package study.alg.dp;

import java.util.Arrays;
import java.util.List;

public class LongestIncDecSubsequence {

    public int longestSubsequenceLength(final List<Integer> A) {
        int n = A.size();
        int[] lis = new int[n];
        int[] lds = new int[n];
        int[] list = new int[n];
        // setup
        for (int i=0;i<n;i++){
            lis[i]=1;
            lds[i]=1;
            list[i] = A.get(i);
        }

        for (int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(list[i]>list[j] && lis[i] < lis[j]+1)
                    lis[i]=lis[j]+1;
            }
        }
        for (int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(list[i]>list[j] && lds[i] < lds[j]+1)
                    lds[i]=lds[j]+1;
            }
        }
        int ans=0;
        for(int i=0;i<n;i++) {
            ans = Math.max(ans, lis[i] + lds[i] - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestIncDecSubsequence alg = new LongestIncDecSubsequence();
        int res = alg.longestSubsequenceLength(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1));
        System.out.println("res = " + res);
    }
}
