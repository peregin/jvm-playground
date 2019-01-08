package study.alg.hashing;

import java.util.HashMap;

public class WindowString {

    public String minWindow(String A, String B) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> target = new HashMap<>();
        for (int i=0; i<B.length(); i++) {
            char c = B.charAt(i);
            freq.put(c, 0);
            Integer f = target.getOrDefault(c, 0);
            target.put(c, f+1);
        }

        int left = 0;
        int right = 0;
        int n = A.length();
        int m = B.length();
        int min = Integer.MAX_VALUE;
        int from = -1;
        while (right <= n && left < n) {
            boolean hasAll = true;
            for (Character c: freq.keySet()) {
                Integer curr = freq.get(c);
                Integer targ = target.get(c);
                if (curr.compareTo(targ) < 0) {
                    hasAll = false;
                    break;
                }
            }

            int diff = right - left;
            if (right < n && (!hasAll || diff < m)) {
                char c = A.charAt(right);
                Integer hits = freq.get(c);
                if (hits != null) {
                    freq.put(c, hits + 1);
                }
                right++;
            } else {
                if (hasAll && diff < min && diff >= m) {
                    min = diff;
                    from = left;
                }
                char c = A.charAt(left);
                Integer hits = freq.get(c);
                if (hits != null) {
                    freq.put(c, hits - 1);
                }
                left++;
            }
        }
        if (from == -1) {
            return "";
        }
        return A.substring(from, from + min);
    }

    public static void main(String[] args) {
        WindowString alg = new WindowString();
        String res = alg.minWindow("xiEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36vGC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh", "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h");
        //String res = alg.minWindow("ADOBECODEBANC", "ABC");
        //String res = alg.minWindow("AAAAAA", "AA");
        System.out.println("res = " + res);
    }
}
