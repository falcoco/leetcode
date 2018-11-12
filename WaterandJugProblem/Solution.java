package WaterandJugProblem;

/**
 * You are given two jugs with capacities x and y litres. There is an infinite amount of water supply available. You need to determine whether it is possible to measure exactly z litres using these two jugs.
 *
 * If z liters of water is measurable, you must have z liters of water contained within one or both buckets by the end.
 *
 * Operations allowed:
 *
 * Fill any of the jugs completely with water.
 * Empty any of the jugs.
 * Pour water from one jug into another till the other jug is completely full or the first jug itself is empty.
 * Example 1: (From the famous "Die Hard" example)
 *
 * Input: x = 3, y = 5, z = 4
 * Output: True
 * Example 2:
 *
 * Input: x = 2, y = 6, z = 5
 * Output: False
 */
class Solution {
    public static boolean canMeasureWater(int x, int y, int z) {
        boolean isSucess = false;

        int difference = x - y > 0 ? x-y:y-x;
        int bigger = x - y > 0 ? x:y;
        int smaller = x - y > 0 ? x:y;
        return isSucess;
    }

    public static void main(String[] args) {
        // case 1
        int x = 3;
        int y = 5;
        int z = 4;
        // case 2
//        int x = 2;
//        int y = 6;
//        int z = 5;
        System.out.println(canMeasureWater(x, y, z));
    }
}