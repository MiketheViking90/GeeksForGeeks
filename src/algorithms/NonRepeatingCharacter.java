package algorithms;

public class NonRepeatingCharacter {

    public char first(String str) {
        char[] counts = new char[128];

        for (char c : str.toCharArray()) {
            counts[c]++;
        }
        for (char c : str.toCharArray()) {
            if (counts[c] == 1) {
                return c;
            }
        }
        return (char) (-1 + '0');
    }

    public static void main(String[] args) {
        NonRepeatingCharacter n = new NonRepeatingCharacter();
        char c = n.first("xxyyzz");
        System.out.println(c);
    }
}
