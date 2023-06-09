package com.robinson.algorithms.tree;

import com.robinson.datastructures.BinaryNode;

import java.util.ArrayList;

public class BTInOrder {
    
    public static ArrayList<Integer> InOrderSearch(BinaryNode<Integer> root) {
        ArrayList<Integer> path = new ArrayList<>();
        traverse(root, path);

        return path;
    }


    private static void traverse(BinaryNode<Integer> curr, ArrayList<Integer> path) {
        if (curr == null) {
            return;
        }

        traverse(curr.left, path);
        path.add(curr.value);
        traverse(curr.right, path);
    }
    
}