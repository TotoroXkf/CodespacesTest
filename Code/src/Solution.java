public class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int width1 = ax2 - ax1;
        int height1 = ay2 - ay1;
        int area1 = width1 * height1;
        int width2 = bx2 - bx1;
        int height2 = by2 - by1;
        int area2 = width2 * height2;
        return area1 + area2 - getOverlapArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2);
    }

    private int getOverlapArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int overlapWidth = getOverlapNum(ax1, ax2, bx1, bx2);
        int overlapHeight = getOverlapNum(ay1, ay2, by1, by2);
        if (overlapWidth > 0 && overlapHeight > 0) {
            return overlapWidth * overlapHeight;
        } else {
            return 0;
        }
    }

    private int getOverlapNum(int a1, int a2, int b1, int b2) {
        return Math.min(a2, b2) - Math.max(a1, b1);
    }
}