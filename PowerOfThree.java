public class Solution {
    public boolean isPowerOfThree(int n) {
        // return n > 0 && (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3.0))) % n == 0;
        // For signed number the max integer of power 3 is 1162261467
        // For unsigned number the max integer of power 3 is 3486784401
        return n > 0 && 1162261467 % n == 0;
    }
}