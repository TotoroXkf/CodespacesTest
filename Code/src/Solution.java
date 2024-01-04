import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int element1 = 0;
        int element2 = 0;
        int vote1 = 0;
        int vote2 = 0;
        for (int num : nums) {
            if (vote1 > 0 && num == element1) {
                vote1++;
            } else if (vote2 > 0 && num == element2) {
                vote2++;
            } else if (vote1 == 0) {
                vote1++;
                element1 = num;
            } else if (vote2 == 0) {
                vote2++;
                element2 = num;
            } else {
                vote1--;
                vote2--;
            }
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (int num : nums) {
            if (num == element1) {
                cnt1++;
            } else if (num == element2) {
                cnt2++;
            }
        }
        List<Integer> result = new ArrayList<>();
        if (cnt1 > nums.length / 3) {
            result.add(element1);
        }
        if (cnt2 > nums.length / 3) {
            result.add(element2);
        }
        return result;
    }
}