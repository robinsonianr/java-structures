package com.robinson.datastructures;

public class DoublyLinkedList<E> {
    public int length;
    private Node<E> head;
    private Node<E> tail;
    
    public DoublyLinkedList() {
        this.length = 0;
        this.head = this.tail = null;
    }
    
    public void preprend(E item) {
        Node<E> node = new Node<>();
        node.value = item;
       
        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }
        
        this.length++;
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    public void insertAt(E item, int index) {

        if (index > this.length) {
            throw new RuntimeException("Oh no");
        }
        this.length++;
        if (this.length == index) {
            this.append(item);
            return;
        } else if (this.length == 0) {
            this.preprend(item);
            return;
        }
        
        
        Node<E> node =  new Node<>();
        node.value = item;
        
        Node<E> curr = this.getAt(index);
        
        node.next = curr;
        node.prev = curr.prev;
        curr.prev.next = node;
        curr.prev = node;
        
    }
    
    public void append(E item) {
        this.length++;
        Node<E> node = new Node<>();
        node.value = item;

        if (this.head == null) {
            this.head = this.tail = node;
            return;
        }

        node.prev = this.tail;
        this.tail.next = node; 
        this.tail = node;
    }
    
    public E remove(E item) {
        Node<E> curr = this.head;
        for(int i = 0; curr != null && i < this.length; i++) {
            if (item == curr.value) {
               break;
            }
            curr = curr.next;
        }
        
        if (curr == null) {
            return null;
        }
        
        
        return this.removeNode(curr);
    }
    
    public E removeAt(int index) {
        Node<E> node = this.getAt(index);
        
        if (node == null) {
            return null;
        }
        return this.removeNode(node);
    }
    
    public E removeNode(Node<E> node) {
        this.length--;
        if (this.length == 0) {
            E out = this.head.value;
            this.head = this.tail = null;
            return out;
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;

        if (node == this.head) {
            this.head = node.next;
        }
        if (node == this.tail) {
            this.tail = node.prev;
        }
        node.next = node.prev = null;
        return node.value;
    }
    
    
    public E get(int index) {
        return this.getAt(index).value;
    }
    
    private Node<E> getAt(int index) {
        Node<E> curr = this.head;
        for(int i = 0; curr != null && i < index; i++) {
            curr = curr.next;
        }
        
        return curr;
    }

    public int getLength() {
        return this.length;
    }
}