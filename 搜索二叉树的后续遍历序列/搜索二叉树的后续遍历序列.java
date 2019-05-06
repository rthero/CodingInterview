public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return isSequenceOfBST(sequence, 0, sequence.length -1);
    }
    private boolean isSequenceOfBST(int[] subSequence, int start, int end) {
        if (start >= end) {
            //要搞清楚这里返回true的判断条件为什么是大于等于
            //开始自己写的是判断二者是否相等作为条件，经过仔细分析后发现会出现start >= end的情况发生
            //当最后某节点只有右子树时出现这种情况
            return true;
        }
        
        int i = start;
        for ( ; i < end; i++) {
            //这里之所以要减一是因为，root本就是最后一个数无需比较
            if (subSequence[i] > subSequence[end]) {
                break;
            }
        }
        int j = i;
        for ( ; j < end; j++) {
            if (subSequence[j] < subSequence[end]) {
                return false;
            }
        }
        return isSequenceOfBST(subSequence, start , i - 1) && isSequenceOfBST(subSequence, i, end - 1);
    }
}