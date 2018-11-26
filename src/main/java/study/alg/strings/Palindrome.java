package study.alg.strings;

public class Palindrome {

    public static int isPalindrome(String A) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i< A.length(); i++) {
            char c = A.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(c);
            }
        }
        String s = sb.toString();
        //System.out.println(s);
        if (sb.reverse().toString().compareToIgnoreCase(s) == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int p = isPalindrome("A man, a plan, a canal: Panama");
        System.out.println("is palindrome " + p);
    }
}
