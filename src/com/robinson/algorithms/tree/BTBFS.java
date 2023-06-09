package com.robinson.algorithms.tree;

import com.robinson.datastructures.BinaryNode;

import java.util.ArrayList;


public class BTBFS {
    
    
    public static boolean bfs(BinaryNode<Integer> root, int needle) {
        ArrayList<BinaryNode<Integer>> queue = new ArrayList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            BinaryNode<Integer> curr = queue.get(0);
            if (curr == null) {
                continue;
            }       
            
            if (curr.value == needle){
                return true;
            }
            
            if (curr.left != null) {
                queue.add(curr.left);
            }
            
            if (curr.right != null) {
                queue.add(curr.right);
            }
           
                 
        }
        
        
        
        return false;
    }
    
}