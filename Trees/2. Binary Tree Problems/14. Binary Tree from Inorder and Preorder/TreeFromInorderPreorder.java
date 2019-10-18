import java.util.*;
class TreeNode
{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val)
    {
        this.val = val;
        this.left = null;
        this.right = null;
    }
    public void print(TreeNode root)
    {
        // using level order traversal

        if (root == null)
            return;
     
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty())
        {
            int len = q.size();
            
            for (int i = 0; i < len; i++)
            {
                TreeNode current = q.poll();
                System.out.print(current.val + " ");
            
                if(current.left != null)
                    q.offer(current.left);
            
                if(current.right != null)
                    q.offer(current.right);
            }
            
        }
        System.out.println();
    }
}

public class TreeFromInorderPreorder
{
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        if (preorder.length == 0 || preorder.length != inorder.length)
            return null;
        
        Map<Integer, Integer> iMap = new HashMap<Integer, Integer>();
        
        // cache the inorder into the map
        for(int i = 0; i < inorder.length; i++)
            iMap.put(inorder[i], i);
        
        TreeNode root = buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, iMap);
        return root;
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> iMap)
    {
        if(preStart > preEnd || inStart > inEnd)
            return null;
        
        TreeNode root = new TreeNode(preorder[preStart]);
        
        int rootPos = iMap.get(root.val);
        
        int leftEndIndex = rootPos - inStart;
        
        root.left = buildTree(preorder, preStart + 1, preStart + leftEndIndex, inorder, inStart, rootPos -1, iMap);
        root.right = buildTree(preorder, preStart + leftEndIndex + 1, preEnd, inorder, rootPos + 1, inEnd, iMap);
        
        return root;
    }

    public static void main(String[] args) 
    {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeFromInorderPreorder obj = new TreeFromInorderPreorder();
        TreeNode root = obj.buildTree(preorder, inorder);

        root.print(root);       
    }
}