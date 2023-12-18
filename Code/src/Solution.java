import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int right = buildings[0][1];
        int index = 1;
        int preEdge = 0;
        while (index < buildings.length) {
            if (buildings[index][0] > right) {
                int[][] subBuildings = new int[index - preEdge][3];
                System.arraycopy(buildings, preEdge, subBuildings, 0, index - preEdge);
                right = buildings[index][1];
                preEdge = index;
                putSkyline(subBuildings);
            } else {
                right = Math.max(right, buildings[index][1]);
            }
            index++;
        }
        return result;
    }

    private List<List<Integer>> putSkyline(int[][] buildings) {
        List<List<Integer>> result = new ArrayList<>();
        putAnswer(result, buildings[0][0], buildings[0][2]);
        int[] next = getNext(buildings);
        int current = 0;
        while (next[current] != current) {
            int[] point = getPoint(buildings[current], buildings[next[current]]);
            putAnswer(result, point[0], point[1]);
        }
        putAnswer(result, buildings[current][1], 0);
        return result;
    }

    private void putAnswer(List<List<Integer>> result, int x, int y) {
        List<Integer> answer = new ArrayList<>();
        answer.add(x);
        answer.add(y);
    }

    private int[] getPoint(int[] current, int[] next) {

    }

    private int[] getNext(int[][] buildings) {
        int[] result = new int[buildings.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

    }

    private boolean isIntersect(int left1, int right1, int left2, int right2) {
        int left = Math.max(left1, left2);
        int right = Math.min(right1, right2);
        return left <= right;
    }
}