package com.test.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNodeSolution {
    //判断二叉树是否相同
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null || q == null) return  false;
        return  isSameTree(p.left,q.left) && isSameTree(p.right,q.right) && p.val == q.val;
    }
    //判断二叉树是否对称 对称性：左子树。val = 右子树。val 左子树的左子树与右子树的右子树对称
    public boolean isSymmetric(TreeNode root) {

        return IsMorrir(root.right,root.left);
    }

    public  boolean IsMorrir(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return  false;
        return  IsMorrir(right.left,left.right)
                && IsMorrir(right.right,left.left) && right.val == left.val;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1+ Math.max(maxDepth(root.right),maxDepth(root.left));
    }
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }


}
