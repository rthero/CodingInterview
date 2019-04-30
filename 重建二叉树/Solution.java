
/*
* 本题依然是使用递归的思想来处理
* 简单分析一下本题：
* 在二叉树的前序遍历序列中，第一个数字总是树的根节点的值。
* 但在中序遍历中，根节点的值在序列的中间，左子树的结点的值位于根节点的值的左边，而右子树的结点的值位于根节点的右边。
* 因此我们根据前序遍历的第一个值扫描中序遍历序列，找到根节点的值。也就能确定原来二叉树左右子树值的分布
* 同样的接下来再根据递归算法可以重建原二叉树的左右子树
*
* */
public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null ){
            return null;
        }
        return reConstructBinaryTreeCore(pre, 0, pre.length - 1, in, 0, in.length -1);


    }

    private TreeNode reConstructBinaryTreeCore(int [] pre, int startPre, int endPre, int [] in, int startIn, int endIn ){
        if(startPre > endPre || startIn > endIn){
            return null;
        }

        //不好理清逻辑的时候可以画图辅助分析

        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = 0; i <= endIn; i++){
            if(in[i] == pre[startPre]){
                root.left = reConstructBinaryTreeCore(pre, startPre + 1, i - startIn + startPre, in, startIn, i-1 );
                root.right = reConstructBinaryTreeCore(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }
        return root;
    }
}