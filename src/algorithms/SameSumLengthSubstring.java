package algorithms;

public class SameSumLengthSubstring {

    int getLongest(String digits) {
        int n = digits.length();
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            int l = i-1;
            int r = i;
            int lSum = 0;
            int rSum = 0;

            int len = 0;
            while (l >= 0 && r < n) {
                int lInt = (int) digits.charAt(l);
                int rInt = (int) digits.charAt(r);

                lSum += lInt;
                rSum += rInt;
                len += 2;
                if (lSum == rSum) {
                    System.out.println(digits.substring(l, r+1));
                    maxLen = Math.max(maxLen, len);
                }
                l--;
                r++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        SameSumLengthSubstring sls = new SameSumLengthSubstring();
        System.out.println(sls.getLongest("123123"));
        System.out.println(sls.getLongest("1538023"));
    }
}
