package EvaluateDivision;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-13 16:24
 **/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers. If the
 * answer does not exist, return -1.0.
 *
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?,x / x = ?
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 *
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string,
 * string>> queries , where equations.size() == values.size(), and the values are positive. This
 * represents the equations. Return vector<double>.
 *
 * According to the example above:
 *
 * equations = [ ["a", "b"], ["b", "c"] ], values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * The input is always valid. You may assume that evaluating the queries will result in no division
 * by zero and there is no contradiction.
 */

class Solution {
  public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

    // 准备数据
    List<StructData> relations = new LinkedList<>();
    HashMap<String ,Integer> existedCharacter = new HashMap<>();
    if (equations.length > 0){
      for (int i = 0; i < equations.length; i++) {
        String[] tempEqualtions = equations[i];
        StructData temp = new StructData();
        temp.setValue(values[i]);
        // 第一位是被除数
        temp.setLeft(tempEqualtions[0]);
        // 第二位是除数
        temp.setRight(tempEqualtions[1]);
        relations.add(temp);
        // 统计所有出现的字符
        existedCharacter.put(tempEqualtions[0],1);
        existedCharacter.put(tempEqualtions[1],1);
      }
    }
    double[] result = new double[queries.length];

    for (int i = 0; i < queries.length; i++) {
      String[] queryParameter = queries[i];
      String left = queryParameter[0];
      String right = queryParameter[1];
      // 查询的字符不存在
      if (existedCharacter.get(left) == null || existedCharacter.get(right) == null){
        result[i] = -1.0;
      }

      if (left.equals(right)){
        result[i] = 1.0;
      }
      // 查询的字符需要运算
      for (int j = 0; j < relations.size(); j++) {
        StructData temp = relations.get(j);
        if (temp.getLeft().equals(left) || temp.getRight().equals(left))
      }

    }
    
    return result;
  }
  class StructData{
    Double value;
    String left;
    String right;
    public void setValue(Double value){
      this.value = value;
    }
    public void setLeft(String left){
      this.left = left;
    }
    public void setRight(String right){
      this.right = right;
    }
    public Double getValue(){
      return this.value;
    }
    public String getLeft(){
      return this.left;
    }
    public String getRight(){
      return this.right;
    }
  }

}
