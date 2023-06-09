package com.robinson.algorithms.tree;

import com.robinson.datastructures.BinaryNode;

import java.util.ArrayList;

public class BTPreOrder {
    
    
    public static ArrayList<Integer> preOrderSearch(BinaryNode<Integer> root) {
        
        ArrayList<Integer> path = new ArrayList<>();
        traverse(root, path);
        
        return path;
    }
    
    
    private static void traverse(BinaryNode<Integer> curr, ArrayList<Integer> path) {
        
        if (curr == null) {
            return;
        }
        
        path.add(curr.value);
        traverse(curr.left, path);
        traverse(curr.right, path);
    }
}