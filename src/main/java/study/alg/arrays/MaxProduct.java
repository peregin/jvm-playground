package study.alg.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class MaxProduct {

    static public int maxSpecialProduct1(ArrayList<Integer> A) {
        long mod = 1000000007;
        long max = 0;
        for (int i=0; i<A.size(); i++) {
            int lsv = -1;
            for(int j=0;j<i;j++) {
                if (A.get(j) > A.get(i)) {
                    lsv = j;
                }
            }
            if (lsv <= 0) {
                continue;
            }
            int rsv = -1;
            for(int j=A.size()-1;j>i;j--) {
                if (A.get(j) > A.get(i)) {
                    rsv = j;
                }
            }
            if (rsv <= 0) {
                continue;
            }
            long prod = (lsv % mod * rsv % mod) % mod;
            if (prod > max) {
                //System.out.println("lsv="+lsv+", rsv="+rsv);
                max = prod;
            }
        }
        return (int) (max % mod);
    }

    static public int maxSpecialProduct2(ArrayList<Integer> A) {
        long mod = 1000000007;
        long max = 0;
        for (int i=0; i<A.size(); i++) {

            int lsv = -1;
            for(int j=0;j<i;j++) {
                if (A.get(j) > A.get(i)) {
                    lsv = j;
                }
            }
            if (lsv <= 0) {
                continue;
            }
            int rsv = -1;
            for(int j=A.size()-1;j>i;j--) {
                if (A.get(j) > A.get(i)) {
                    rsv = j;
                }
            }
            if (rsv <= 0) {
                continue;
            }
            long prod = (lsv % mod * rsv % mod) % mod;
            if (prod > max) {
                //System.out.println("lsv="+lsv+", rsv="+rsv);
                max = prod;
            }
        }
        return (int) (max % mod);
    }

    private ArrayList<Integer> leftSpecialValue(ArrayList<Integer> A){

        ArrayList<Integer> r = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<A.size();i++){
            while(!s.empty() && A.get(s.peek()) <= A.get(i)){
                s.pop();
            }

            if(s.empty()){
                r.add(0);
            }
            else{
                r.add(s.peek());
            }
            s.push(i);
        }

        return r;
    }

    private ArrayList<Integer> rightSpecialValue(ArrayList<Integer> A){

        ArrayList<Integer> r = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i=A.size()-1;i>=0;i--){
            while(!s.empty() && A.get(s.peek()) <= A.get(i)){
                s.pop();
            }

            if(s.empty()){
                r.add(0,0);
            }
            else{
                r.add(0,s.peek());
            }
            s.push(i);
        }

        return r;
    }

    public int maxSpecialProduct(ArrayList<Integer> A) {
        ArrayList<Integer> l = leftSpecialValue(A);
        ArrayList<Integer> r = rightSpecialValue(A);

        long product=0, res= 0;

        for(int i=0;i<A.size();i++){
            res= (long)l.get(i) * (long)r.get(i);
            if(product < res){
                product  = res;
            }
        }

        return (int)(product%1000000007);
    }

    public static void main(String... args) {
        MaxProduct mp = new MaxProduct();
        //int p = maxSpecialProduct(new ArrayList(Arrays.asList(5, 9, 6, 8, 6, 4, 6, 9, 5, 4, 9))); // 80
        int p = mp.maxSpecialProduct(new ArrayList(Arrays.asList(4, 6, 5, 5, 6, 6, 5, 6, 7, 5, 5, 7, 7))); // 88
        System.out.println("p="+p);
    }
}
