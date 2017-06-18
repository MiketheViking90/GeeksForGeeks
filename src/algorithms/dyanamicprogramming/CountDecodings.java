package algorithms.dyanamicprogramming;

public class CountDecodings {

    public int count(String msg) {
        char[] chars = msg.toCharArray();
        return countR(chars, msg.length()-1);
    }

    private int countR(char[] chars, int i) {
        if (i <= 0) {
            return 1;
        }
        System.out.println(i);
        int cnt = countR(chars, i-1);
        if (chars[i-1] == '1' ||
                chars[i-1] == '2' && chars[i] <= '6') {
            cnt += countR(chars, i-2);
        }
        return cnt;
    }

    public static void main(String[] args) {
        CountDecodings cd = new CountDecodings();
        int cnt = cd.count("121212312");
        System.out.println(cnt);
    }
}
