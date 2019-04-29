
//使用递归的方法
public class Solution {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        } else {

            return isSubtree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
            /*
             * 这里需要详细的说明一下这里为什么会使用三个 与 逻辑，这是为了减少代码的参数量，使用了短路法则 而且这样写实际上有一个好处也就是将
             * 确定两个二叉树的关系逻辑分离了，这样使用递归逻辑更加简洁明晰 在这里实际上只是在递归遍历root1的二叉树而已
             */
        }
    }

    private boolean isSubtree(TreeNode r1, TreeNode r2) {
        if (r2 == null) {
            return true;
        }
        if (r1 == null) {
            return false;
        }
        if (r1.val == r2.val) {
            return isSubtree(r1.left, r2.left) && isSubtree(r1.right, r2.right);
        } else {
            return false;
        }

    }
}