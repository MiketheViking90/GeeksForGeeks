package algorithms;

public class NextGreaterNumber {

    public int find(int n) {
        String nStr = String.valueOf(n);
        char[] nCharAry = nStr.toCharArray();
        int len = nStr.length();
        for (int i = len - 1; i > 0; i--) {
            int endVal = getIntAt(i, nStr);

            for (int j = i - 1; j >= 0; j--) {
                int begVal = getIntAt(j, nStr);

                if (endVal > begVal) {
                    System.out.println(endVal + ", " + begVal);
                    nCharAry[i] = (char) (begVal + '0');
                    nCharAry[j] = (char) (endVal + '0');

                    System.out.println(new String(nCharAry));
                    return -1;
                }
            }
        }

        return -1;
    }

    private int getIntAt(int i, String nStr) {
        return nStr.charAt(i) - '0';
    }

    public static void main(String[] args) {
        NextGreaterNumber n = new NextGreaterNumber();
        n.find(899999999);
    }
}
