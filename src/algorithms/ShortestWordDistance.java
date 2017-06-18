package algorithms;

public class ShortestWordDistance {

    int findDistance(String[] words, String word1, String word2) {
        int n = words.length;

        int i = 0;
        int j = n-1;

        int dist = n;

        while (i <= j) {
            String sWord = words[i];
            String eWord = words[j];

            if (sWord.equals(word1) && eWord.equals(word2)) {
                int diff = j - i;
                if (diff < dist) {
                    dist = diff;
                }

                i++;
                j--;
            } else if (sWord.equals(word1) && !eWord.equals(word2)) {
                j--;
            } else if (!sWord.equals(word1) && eWord.equals(word2)) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        ShortestWordDistance swd = new ShortestWordDistance();

        String[] words = {"practice", "makes", "makes", "perfect", "coding", "makes", "perfect"};
        int dist = swd.findDistance(words, "makes", "perfect");
        System.out.println(dist);
    }
}
