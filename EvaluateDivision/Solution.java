package EvaluateDivision;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-13 16:24
 **/

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the
 * answer does not exist, return -1.0.
 *
 * Example: Given a / b = 2.0, b / c = 3.0. queries are: a / c = ?, b / a = ?, a / e = ?, a / a =
 * ?,x / x = ? return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string,
 * string>> queries , where equations.size() == values.size(), and the values are positive. This
 * represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ], values = [2.0, 3.0], queries = [ ["a", "c"], ["b", "a"],
 * ["a", "e"], ["a", "a"], ["x", "x"] ]. The input is always valid. You may assume that evaluating
 * the queries will result in no division by zero and there is no contradiction.
 */

/**
 * 参考： https://zxi.mytechroad.com/blog/graph/leetcode-399-evaluate-division/
 */
class Solution {

  Map<String, HashMap<String, Double>> g = new HashMap<>();

  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
    for (int i = 0; i < equations.length; ++i) {
      String x = equations[i][0];
      String y = equations[i][1];
      double k = values[i];
      g.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, k);
      g.computeIfAbsent(y, l -> new HashMap<String, Double>()).put(x, 1.0 / k);
    }

    double[] answer = new double[queries.length];

    for (int i = 0; i < queries.length; ++i) {
      String x = queries[i][0];
      String y = queries[i][1];

      if (!g.containsKey(x) || !g.containsKey(y)) {
        answer[i] = -1.0;
      } else {
        answer[i] = divide(x, y, new HashSet<String>());
      }
    }
    return answer;
  }

  private double divide(String x, String y, Set<String> visited) {
    if (x.equals(y)) {
      return 1.0;
    }
    visited.add(x);
    if (!g.containsKey(x)) {
      return -1.0;
    }
    for (String n : g.get(x).keySet()) {
      if (visited.contains(n)) {
        continue;
      }
      visited.add(n);
      double d = divide(n, y, visited);
      if (d > 0) {
        return d * g.get(x).get(n);
      }
    }
    return -1.0;
  }
}
