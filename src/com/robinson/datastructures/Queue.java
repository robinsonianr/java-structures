package com.robinson.datastructures;


public class Queue<E> {
    public int length;
    private Node<E> head;
    private Node<E> tail;

    public Queue() {
        this.head = this.tail = null;
        this.length = 0;
    }

    public void enqueue(E item) {
        Node<E> node = new Node<>();
        node.value = item;
        this.length++;
        if (this.tail == null) {

            this.tail = this.head = node;
            return;
        }
        this.tail.next = node;
        this.tail = node;
    }

    public E deque(){
        if (this.head == null) {
            return null;
        }
        this.length--;
        Node<E> head = this.head;
        this.head = this.head.next;
        head.next = null;

        if (this.length == 0) {
            this.tail = null;
        }

        return head.value;
    }

    public E peek(){
        return this.head.value;
    }
}
