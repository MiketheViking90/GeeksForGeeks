package algorithms;

public class BitString {

    public void generate(int n) {
        generate(0, "", n);
    }

    private void generate(int i, String s, int n) {
        if (i == n) {
            System.out.println(s);
            return;
        }

        generate(i+1, s+"1", n);
        generate(i+1, s+"0", n);
    }

    public static void main(String[] args) {
        BitString bs = new BitString();
        bs.generate(4);
    }
}
