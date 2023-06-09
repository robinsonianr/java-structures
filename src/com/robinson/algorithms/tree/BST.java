package com.robinson.algorithms.tree;

public class BST {
    public int value;
    public BST left = null;
    public BST right = null;
    public BST parent = null;
    
    public BST(int value) {
        this.value = value;
    }
    
    
    private static BST search(BST root, int needle) {
        if (root == null) {
            return null;
        }

        if (root.value == needle) {
            return root;
        }
        if (needle < root.value) {
           return search(root.left, needle);
        }
        
        return search(root.right, needle);
    }
    
    
    public static BST dfs(BST root, int needle) {
        return search(root, needle);
    }
    
    private static BST insert(BST root, int value) {
        
        if (value < root.value ) {
            if (root.left != null) {
                insert(root.left, value);
            } else {
                root.left = new BST(value);
            }
            
        } else {
            if (root.right != null) {
                insert(root.right, value);
            }else {
                root.right = new BST(value);
            }
        }
        return root;
    }
    
    
    public static BST delete(BST root, int value) {
        
        BST node = search(root, value);
        
        if (node.left == null && node.right == null) {
            if (node.parent.value > node.value) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
            return root;
        }
        
        if (node.left == null || node.right == null) {
            if (node.left != null) {
                node.parent = node.left;
            } else {
                node.parent = node.right;
            }
             return root;
        }
        
        BST replace = traverse(node);
        if (replace.value < node.parent.value ) {
            node.parent.left = replace;
        } else {
            node.parent.right = replace;
        }
        
        return root;
    }
    
    
    private static BST traverse(BST curr) {
        curr = curr.left;
        
        while (curr.right != null) {
            curr = curr.right;
        }
        
        if (curr.left != null) {
            curr.left.parent = curr.parent;
            curr.parent.right = curr.left;
        }
        
        return curr;
    }
}