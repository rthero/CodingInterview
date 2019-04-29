#-*- coding:utf-8 -*-

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def HasSubtree(self, pRoot1, pRoot2):
        if not pRoot1 or not pRoot2:
            return False
        return self.isSubtree(pRoot1, pRoot2) or self.HasSubtree(pRoot1.left, pRoot2) or self.HasSubtree(pRoot1.right, pRoot2)


#这里需要详细的说明一下这里为什么会使用三个 与 逻辑，这是为了减少代码的参数量，使用了短路法则 而且这样写实际上有一个好处也就是将
#确定两个二叉树的关系逻辑分离了，这样使用递归逻辑更加简洁明晰
#在这里实际上只是在递归遍历root1的二叉树而已

    def isSubtree(self, pRoot1, pRoot2):
        if not pRoot2:
            return True
        if not pRoot1:
            return False
        if pRoot1.val == pRoot2.val:
            return self.isSubtree(pRoot1.left, pRoot2.left) and self.isSubtree(pRoot1.right, pRoot2.right)
        else: return False