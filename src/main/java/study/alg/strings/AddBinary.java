package study.alg.strings;

public class AddBinary {

    public String addBinary(String A, String B) {
        boolean carry = false;
        int na = A.length();
        int nb = B.length();
        int ix = 0;
        StringBuffer res = new StringBuffer();
        while (ix < Math.max(na, nb)) {
            char ca = ix >= na ? '0' : A.charAt(na - ix -1);
            char cb = ix >= nb ? '0' : B.charAt(nb - ix -1);
            int counter = 0;
            if (ca == '1') counter++;
            if (cb == '1') counter++;
            if (carry) counter++;

            if (counter % 2 == 0) {
                res.append('0');
            } else {
                res.append('1');
            }
            carry = counter > 1;
            ix++;
            //System.out.println("ca="+ca+", cb="+cb+", counter="+counter+", res="+res.reverse().toString());
        }
        if (carry) {
            res.append('1');
        }
        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary alg = new AddBinary();
        //String res = alg.addBinary("101", "11");
        String res = alg.addBinary("100", "11");
        System.out.println("res = " + res);
    }
}
