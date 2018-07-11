package test;

import java.util.*;

public class BinaryTreeTraversal {
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
 
        public TreeNode(int value){
            this.value=value;
        }
    }
 
    TreeNode root;
 
    public BinaryTreeTraversal(int[] array){
        root=makeBinaryTreeByArray(array,1);
    }
 
    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    public static TreeNode makeBinaryTreeByArray(int[] array,int index){
        if(index<array.length){
            int value=array[index];
            if(value!=0){
                TreeNode t=new TreeNode(value);
                array[index]=0;
                System.out.println(array[index]);
                t.left=makeBinaryTreeByArray(array,index*2);
                t.right=makeBinaryTreeByArray(array,index*2+1);
                return t;
            }
        }
        return null;
    }
 
    /**
     * 深度优先遍历，相当于先根遍历
     * 采用非递归实现
     * 需要辅助数据结构：栈
     */
    public void depthOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }       
        ArrayDeque<TreeNode> stack=new ArrayDeque<TreeNode>();
        stack.push(root);
        while(stack.isEmpty()==false){
            TreeNode node=stack.pop();
            System.out.print(node.value+"    ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }           
        }
        System.out.print("\n");
    }
 
    /**
     * 广度优先遍历
     * 采用非递归实现
     * 需要辅助数据结构：队列
     */
    public void levelOrderTraversal(){
        if(root==null){
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue=new ArrayDeque<TreeNode>();
        queue.add(root);
        while(queue.isEmpty()==false){
            TreeNode node=queue.remove();
            System.out.print(node.value+"    ");
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }
 
    /** 
     *                  13
     *                 /  \
     *               65    5
     *              /  \    \
     *             97  25   37
     *            /    /\   /
     *           22   4 28 32
     */


    /**
     * 比较靠谱的广度优先遍历
     * @param root
     * @return
     */
    public static ArrayList<Integer> printFromTopToBottom(TreeNode root) {
        ArrayList<Integer> lists=new ArrayList<Integer>();
        if(root==null)
            return lists;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode tree=queue.poll();
            if(tree.left!=null)
                queue.offer(tree.left);
            if(tree.right!=null)
                queue.offer(tree.right);
            lists.add(tree.value);
        }
        return lists;
    }

    /**
     * 深度优先遍历（非递归版本）
     * @param root
     * @return
     */
    public static ArrayList<Integer> depthPrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> lists=new ArrayList<Integer>();
        if(root==null)
            return lists;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode tree=stack.pop();
            /**先向栈找中压入右节点再压入左节点，这样出栈就是先左节点后右节点了*/

            if(tree.right!=null)
                stack.push(tree.right);
            if(tree.left!=null)
                stack.push(tree.left);
            lists.add(tree.value);
        }
        return lists;
    }

    /**
     * 递归深度遍历
     * @param tn
     */
    private void depthTraversal(TreeNode tn)
    {
        if (tn!=null)
        {
            System.out.print(tn.value+"  ");
            depthTraversal(tn.left);
            depthTraversal(tn.right);
        }
    }

    public static void main(String[] args) {
        int[] arr={0,13,65,5,97,25,0,37,22,0,4,28,0,0,32,0};
        BinaryTreeTraversal tree=new BinaryTreeTraversal(arr);
        tree.depthOrderTraversal();
        //tree.printFromTopToBottom(root);
        tree.levelOrderTraversal();
    }
}
