package com.robinson.datastructures;

import java.util.ArrayList;

public class MinHeap {
    public int length;
    public ArrayList<Integer> data;
    
    
    public MinHeap(){
        this.data = new ArrayList<>();
        this.length = 0;
    }

    void insert(int value) {
        this.data.set(this.data.size() - 1, value);
        heapifyUp(this.data.size());
        this.length++;
    }

    int delete() {
        if (this.data.isEmpty()) {
            return -1;
        }
        
        int out = this.data.get(0);
        this.length--;
        
        if (this.data.size() == 1) {
            this.data = new ArrayList<>();
            return out;
        }
        
        
        this.data.set(0, this.data.get(this.length));
        this.heapifyDown(0);
        
        
        return out;
    }


    private void heapifyDown(int idx) {
        if (idx >= data.size() || this.leftChild(idx) >= this.length) {
            return;
        }
        
        int leftChild = this.leftChild(idx);
        int rightChild = this.rightChild(idx);
        
        int leftVal = this.data.get(leftChild);
        int rightVal = this.data.get(rightChild);
        int value = this.data.get(idx);
        
        if (leftVal > rightVal && value > rightVal) {
               this.data.set(idx, rightVal);
               this.data.set(rightChild, value);
               heapifyDown(rightChild);
        } else if (leftVal < rightVal && value > leftVal) {
               this.data.set(idx, leftVal);
               this.data.set(leftChild, value);
               heapifyDown(leftChild);
        }
    }


    private void heapifyUp(int idx) {
        if (idx == 0) {
            return;
        }

        int p = this.parent(idx);
        int parentValue = this.data.get(p);
        int childValue = this.data.get(idx);

        if (childValue < parentValue) {
            data.set(idx, parentValue);
            data.set(p, childValue);
            heapifyUp(p);
        }
    }
    
    private int parent(int idx) {
        return Math.floorDiv(idx - 1, 2);
            
    }
    
    private int leftChild(int idx) {
        return (2 * idx) + 1;
    }
    
    private int rightChild(int idx) {
        return (2 * idx) + 2;
    }
    
    
}