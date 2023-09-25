package service;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            TreeNode t = q.poll();

            if (t.val == -1) {
                sb.append("-1,");
                continue;
            } else {
                sb.append(t.val);
                sb.append(",");
            }

            if (t.left == null && t.right == null) {
                continue;
            }
            if (t.left != null) {
                q.offer(t.left);
            } else {
                q.offer(new TreeNode(-1));
            }

            if (t.right != null) {
                q.offer(t.right);
            } else {
                q.offer(new TreeNode(-1));
            }
        }

        return sb.substring(0, sb.lastIndexOf(","));
    }





    static class RecodeNode{
        TreeNode node;
        int dep;

        public RecodeNode(){}
        public RecodeNode(TreeNode node, int dep){
            this.node = node;
            this.dep = dep;
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> n = new LinkedList<>();
        n.offer(root);

        int i = 0;
        while (!n.isEmpty()) {
            TreeNode r = n.poll();
            TreeNode left = 2 * i + 1 >= nodes.length ? null : new TreeNode(Integer.parseInt(nodes[2 * i + 1]));
            TreeNode right = 2 * i + 2 >= nodes.length ? null : new TreeNode(Integer.parseInt(nodes[2 * i + 2]));
            i++;

            if (r.val == -1 || (left == null && right == null)) {
                continue;
            }

            if (left == null || left.val == -1) {
                n.offer(new TreeNode(-1));
            } else {
                r.left = left;
                n.offer(left);
            }

            if (right == null || right.val == -1) {
                n.offer(new TreeNode(-1));
            } else {
                r.right = right;
                n.offer(right);
            }
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}


// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;
