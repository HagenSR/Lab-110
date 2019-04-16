/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Lab107;



/**
 * /**
 * SinglyLinkedList Class
 * Code Fragments 3.14, 3.15
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 *
 * @author Sean Hagen
 *
 */
public final class LinkedList<E> {

    /**
     * Nodes that the Linked list utilizes
     *
     * @param <E> The generic type to be used in the node
     */
    public static class Node<E> {

        private E element; //Refrence to the element stored at this node
        private Node<E> next; //Refrence to the subseuent node in the list

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }

    }//End of Nested Node Class

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public LinkedList() { //Constructs an initially Empty Linked bag object        
    }

    //access methods
    public boolean isEmpty() {
        return (size == 0);
    }

    public int getCurrentSize() {
        return size;
    }

    public E first() {
        return (isEmpty() ? null : head.getElement());
    }

    public E last() {
        return (isEmpty() ? null : tail.getElement());
    }

    //update methods
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) {
            tail = head;
        }
        size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement();
        head = head.getNext();
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return answer;

    }

    @Override
    public String toString() {
        Node<E> cursor = head;
        String outPut = "" + getClass().getName() + "\n";
        for (int x = 0; x < getCurrentSize(); x++) {
            outPut += cursor.getElement().toString() + "\n";
            cursor = cursor.getNext();
        }
        return outPut;
    }

    @Override
    public boolean equals(Object o) {
        boolean flag = true;
        if (!(o instanceof LinkedList)) {
            return false;
        }
        LinkedList<E> s = (LinkedList) o;
        if (s.getCurrentSize() != this.getCurrentSize()) {
            return false;
        }
        for (int x = 0; x < s.getCurrentSize(); x++) {
            E element = s.removeFirst();
            E element2 = this.removeFirst();
            if (!(element.equals(element2))) {
                flag = false;
            }
            s.addLast(element);
            this.addLast(element2);
        }
        return flag;
    }

}

