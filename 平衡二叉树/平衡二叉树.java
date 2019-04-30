
// 一种简单的思路是：遍历每个节点，由该节点得到的左右子节点的深度判断该节点组成的二叉树是否是平衡二叉树，最后递归调用即可
// 但是这种思路有一个问题就是，需要每个节点都求一次深度，造成了额外的开销，导致时间复杂度为O(n*n)
// 为了更好的叙述，特地把这种方法放在下面供参考
//
/*
*class Solution {
*    public boolean isBalanced(TreeNode root) {
*        if (root == null) {
*            return true;
*        }
*        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(getDepth(root.right) - getDepth(root.left)) <= 1;
*    }
*
*    private int getDepth(TreeNode root) {
*        if (root == null) {
*            return 0;
*        }
*        return Math.max(getDepth(root.left), getDepth(root.right)) + 1;
*    }
*}
 */

// 下面主要说一下时间复杂度O(n)的方法，上一种方法的主要问题在于每一次的遍历都得求一下子树的深度，
// 新方法的主要改进在于是从下往上遍历的，如果子节点二叉树是平衡的那么就返回子节点的深度，如果不是平衡的话直接返回false并中断递归

class Solution {
    public boolean isBalanced(TreeNode root) {
        //这里使用了一个技巧也就getDepth函数无法返回两个类型的值，所以定义为int型
        //约定非为-1 做个比较就可以
        return (getDepth(root) != -1);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            //root为空，是平衡二叉树，且深度为0
            return 0;
        }
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        return Math.abs(right - left) > 1 ? -1 : Math.max(left, right) + 1;

    }
}
