package algorithms;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PathExists {

    @EqualsAndHashCode
    @Getter
    @ToString
    static class Pair {
        int r;
        int c;

        public Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int minPath(int[][] graph, Pair source) {
        Queue<Pair> toVisit = new LinkedList<>();
        toVisit.add(source);
        Set<Pair> visited = new HashSet<>();

        int layer = 0;
        while (!toVisit.isEmpty()) {
            int curLayerSize = toVisit.size();
            layer++;
            System.out.println(curLayerSize);
            while (curLayerSize > 0) {
                Pair visiting = toVisit.poll();
                curLayerSize--;
                System.out.println(visiting);
                if (isSink(graph, visiting)) {
                    System.out.println("found! " + layer + " at : " + visiting);
                    return layer;
                }

                visited.add(visiting);
                addNeighboors(visiting, toVisit, visited, graph);
            }
        }

        return -1;
    }

    private void addNeighboors(Pair visiting, Queue<Pair> toVisit, Set<Pair> visited, int[][] graph) {
        int r = visiting.getR();
        int c = visiting.getC();

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (isValidCell(r+i, c+j, visited, graph)) {
                    toVisit.add(new Pair(r + i, j + c));
                }
            }
        }
    }

    private boolean isValidCell(int r, int c, Set<Pair> visited, int[][] graph) {
        int rows = graph.length;
        int cols = graph[0].length;

        return (r >= 0 && r < rows
                && c >= 0 && c < cols
                && !visited.contains(new Pair(r, c))
                && graph[r][c] != 0);
    }

    private boolean isSink(int[][] graph, Pair visiting) {
        int r = visiting.getR();
        int c = visiting.getC();

        return graph[r][c] == 2;
    }

    public static void main(String[] args) {
//        int[][] matrix = {
//                {3, 0, 0, 0 },
//                {0, 3, 3, 0},
//                {0, 1, 0, 3},
//                {0, 2, 3, 3}
//        };
        int[][] matrix =
            {{ 0 , 3 , 1 , 0 },
            { 3 , 0 , 3 , 3 },
            { 2 , 3 , 0 , 3 },
            { 0 , 3 , 3 , 3 }};

        PathExists pe = new PathExists();
        int len = pe.minPath(matrix, new Pair(0, 2));
        System.out.println(len);
    }
}
