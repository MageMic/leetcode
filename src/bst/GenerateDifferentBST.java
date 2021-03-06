package bst;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zjumic
 * @Date: created at 20:19 2020/4/9
 */
// 分治算法，不同的二叉搜索树
// 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
//
//示例:
//
//输入: 3
//输出:
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释:
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
public class GenerateDifferentBST {

    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return null;
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int s, int e) {
        ArrayList<TreeNode> res = new ArrayList<>();
        if (s > e) {
            // 这里需要加null表示空节点
            res.add(null);
            return res;
        }
        for (int i = s; i <= e; i++) {
            List<TreeNode> left = generateTrees(s, i - 1);
            List<TreeNode> right = generateTrees(i + 1, e);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
