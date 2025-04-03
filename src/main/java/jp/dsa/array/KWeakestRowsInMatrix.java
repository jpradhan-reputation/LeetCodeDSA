package jp.dsa.array;

import java.util.*;

public class KWeakestRowsInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,0},{1,0},{1,0},{1,1}};
        System.out.println(Arrays.toString(kWeakestRows(matrix, 4)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[] weakestRows = new int[k];
        Map<Integer, Integer> rowSumMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0)
                    break;
                sum += 1;
            }
            rowSumMap.put(i, sum);
        }
        rowSumMap = sortRowSumMap(rowSumMap);
        int i = 0;
        for(Map.Entry<Integer, Integer> entry: rowSumMap.entrySet()) {
            if (i < k)
                weakestRows[i] = entry.getKey();
            else
                break;
            i++;
        }
        return weakestRows;
    }

    private static Map<Integer, Integer> sortRowSumMap(Map<Integer, Integer> rowSumMap) {
        HashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(rowSumMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue());

        for(Map.Entry<Integer, Integer> entry: entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
}
