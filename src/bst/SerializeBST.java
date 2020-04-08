package bst;

/**
 * @Author: zjumic
 * @Date: created at 16:20 2020/3/6
 */
public class SerializeBST {
    StringBuffer sb = new StringBuffer();
    String Serialize(TreeNode root) {
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        } else {
            sb.append(root.val + ",");
        }
        Serialize(root.left);
        Serialize(root.right);
        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        String[] treeStr = str.split(",");
        return deserialize(treeStr);
    }

    private int index = -1;
    TreeNode deserialize(String[] str) {
        index++;
        if (!str[index].equals("#")) {
            TreeNode node = new TreeNode(Integer.parseInt(str[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        String str = "1,2,4,#,#,5,#,#,3,6,#,#,7,#,#";
        SerializeBST s = new SerializeBST();
        TreeNode node = s.Deserialize(str);
        System.out.println(TreeNode.treeNodeToString(node));
    }
}
