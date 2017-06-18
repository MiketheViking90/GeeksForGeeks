package algorithms;

import com.google.common.collect.Sets;
import lombok.ToString;

import java.util.*;

public class WordLadder {

    @ToString
    class WordNode {
        String word;
        List<String> trail = new ArrayList<>();

        public WordNode(String word) {
            this.word = word;
        }
    }

    public List<String> getMinPath(String start, String end, Set<String> dict) {
        Queue<WordNode> q = new LinkedList<>();
        q.add(new WordNode(start));
        Set<String> visited = new HashSet<>();

        while (!q.isEmpty()) {
            WordNode curNode = q.poll();
            System.out.println(curNode + ", len: " + q.size());
            if (curNode.word.equals(end)) {
                return curNode.trail;
            }
            visited.add(curNode.word);

            for (int i = 0; i < start.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] wordAry = curNode.word.toCharArray();
                    if (wordAry[i] != c) {
                        wordAry[i] = c;
                        String nextString = String.valueOf(wordAry);
                        if (dict.contains(nextString) && !visited.contains(nextString)) {
                            System.out.println("\t" + nextString);
                            WordNode nextNode = new WordNode(nextString);
                            nextNode.trail.add(curNode.word);

                            if (!visited.contains(nextString)) {
                                q.add(nextNode);
                            }
                        }
                    }
                }
            }
        }
        System.err.println("err");
        return null;
    }

    public static void main(String[] args) {
        String start = "hot";
        String end = "dig";
        Set<String> dict = Sets.newHashSet("jay", "fro", "dot", "dog", "dig");

        WordLadder wl = new WordLadder();
        List<String> path = wl.getMinPath(start, end, dict);
        path.forEach(System.out::println);
    }

}
