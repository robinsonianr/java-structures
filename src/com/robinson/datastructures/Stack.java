package com.robinson.datastructures;

public class Stack<E> {
    public int length;
    private SNode<E> head;


    public Stack() {
        this.head = null;
        this.length = 0;
    }


    public E pop() {
        this.length = Math.max(0, this.length - 1);
        if (this.length == 0) {
            SNode<E> head = this.head;
            this.head = null;
            return  head.value;
        }
        SNode<E> head = this.head;
        this.head = this.head.prev;

        return head.value;
    }


    public void push (E item) {
        this.length++;
        SNode<E> node = new SNode<>();
        node.value = item;
        if (this.head == null) {
            this.head = node;
            return;
        }
        node.prev = this.head;
        this.head = node;
    }

    public E peek() {
        return this.head.value;
    }


}
