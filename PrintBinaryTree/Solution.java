package PrintBinaryTree;

/**
 * @program: leetcode
 * @description:
 * @author: chuangheng.yang
 * @create: 2018-09-17 14:41
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Print a binary tree in an m*n 2D string array following these rules:

 The row number m should be equal to the height of the given binary tree.
 The column number n should always be an odd number.
 The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 Each unused space should contain an empty string "".
 Print the subtrees following the same rules.
 Example 1:
 Input:
   1
  /
 2
 Output:
 [["", "1", ""],
 ["2", "", ""]]
 Example 2:
 Input:
         1
       /  \
      2   3
       \
        4
 Output:
 [["", "", "", "1", "", "", ""],
 ["", "2", "", "", "", "3", ""],
 ["", "", "4", "", "", "", ""]]
 Example 3:
 Input:
       1
      / \
     2   5
    /
   3
  /
 4
 Output:

 [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 Note: The height of binary tree is in the range of [1, 10].
 */
class Solution {
  public static List<List<String>> printTree(TreeNode root) {
    int depth = maxDepth(root);
    int length = (int) Math.pow(2, depth) - 1;
    List<List<String>> result = new LinkedList<>();
    if (root != null){
      for (int i = 1; i <= depth; i++) {
        String []leaves = new String[length];
        String[] floor = getFloorLeaves(root, i, leaves, 0, length / 2, length, depth);
        for (int j = 0; j < length; j++) {
          if (floor[j] == null){
            // test string
            floor[j] = "\"\"";
            // submit string
            floor[j] = "\"\"";
          }
        }
        List<String> convertedFloor = Arrays.asList(floor);
        result.add(convertedFloor);
      }
    }
    return result;
  }


  private static String[] getFloorLeaves(TreeNode root, Integer depth, String[] leaves, Integer currentDepth, Integer index, Integer length, int treeDepth){
    if (root != null){
      currentDepth++;
      TreeNode left = root.left;
      TreeNode right = root.right;
      if (currentDepth == depth){
          leaves[index] = String.valueOf(root.val);
      }
      leaves = getFloorLeaves(left, depth, leaves, currentDepth, (int) (index - Math.pow(2,(treeDepth - currentDepth - 1))), length, treeDepth);
      leaves = getFloorLeaves(right, depth, leaves, currentDepth, (int) (index + Math.pow(2,(treeDepth - currentDepth - 1))), length, treeDepth);
    }
    return leaves;
  }

  private static int maxDepth(TreeNode root){
    int depth = 0;
    if (root != null){
      depth ++;
      TreeNode left = root.left;
      TreeNode right = root.right;
      depth += Math.max(maxDepth(left), maxDepth(right));
    }
    return depth;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);

//    TreeNode root = new TreeNode(1);
//    root.left = new TreeNode(2);
//    root.left.right = new TreeNode(4);
//    root.right = new TreeNode(3);

    List<List<String>> result = printTree(root);
    for (int i = 0; i < result.size(); i++) {
      System.out.println(result.get(i));
    }
  }
}