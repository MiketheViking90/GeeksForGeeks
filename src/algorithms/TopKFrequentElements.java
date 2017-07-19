package algorithms;

import lombok.Getter;

import java.util.*;

public class TopKFrequentElements {

    @Getter
    class WordCount implements Comparable<WordCount> {
        String word;
        int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordCount o) {
            return -Integer.compare(this.count, o.count);
        }
    }

    public String[] topElements(String[] words, int k) {
        Map<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            int cnt = wordToCount.getOrDefault(word, 0);
            wordToCount.put(word, cnt+1);
        }

        PriorityQueue<WordCount> topWords = new PriorityQueue<>(k);
        for (Map.Entry<String, Integer> entry : wordToCount.entrySet()) {
            WordCount wc = new WordCount(entry.getKey(), entry.getValue());
            topWords.add(wc);
        }

        String[] topWordsAry = new String[k];

        int i = 0;
        for (WordCount wc : topWords) {
            System.out.println(wc.getWord() + ": " + wc.getCount());
            topWordsAry[i++] = wc.getWord();
        }

        return topWordsAry;
    }

    public static void main(String[] args) {
        TopKFrequentElements top = new TopKFrequentElements();
        String[] words = new String[]{"a", "b", "a", "c", "a", "b", "d", "e", "z", "e", "z", "b", "c"};

        top.topElements(words, 2);
    }

}
