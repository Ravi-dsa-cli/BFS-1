//Time Complexity: O(n)
//Space : O(n)
import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            List<Integer> curList = new ArrayList<>();
            int count = q.size();

            for (int i = 0; i < count; i++) {
                TreeNode node = q.poll();
                curList.add(node.val);

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
            }

            result.add(curList);
        }

        return result;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        LevelOrderTraversal sol = new LevelOrderTraversal();
        List<List<Integer>> result = sol.levelOrder(root);

        for (List<Integer> level : result) {
            System.out.println(level);
        }
    }
}
