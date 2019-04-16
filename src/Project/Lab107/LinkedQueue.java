/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Lab107;

import java.util.LinkedList;

/**
 * 
 * LinkedQueue Class
 * Code Fragment 6.11
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 * @author Sean Hagen
 * @param <E>
 * 
 */
public class LinkedQueue<E> implements Queue<E>{
    private LinkedList<E> list = new LinkedList<>(); //creates the underlying linked list object
    
    /**
     * default constructor for linkedQueue
     */
    public LinkedQueue(){
        
    }
    
    /**
     * returns the amount of elements in the linked queue
     * @return an int representing the amount of elements in the queue
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * checks weather the queue is empty or not
     * @return true if the queue is empty
     */
    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adds the given element to the end of the list
     * @param e the element to be added
     * @throws QueueFullException if the array is full and cannot add another element
     */
    @Override
    public void enqueue(E e) throws IndexOutOfBoundsException {
        list.addLast(e);
    }

    /**
     * returns but does not remove the element in the first index
     * @return the element in the first index
     */
    @Override
    public E first() {
        return list.peek();
    }
    
    /**
     * returns and removes the first element in the index
     * @return the element in the first index
     */
    @Override
    public E dequeue() {
        return list.removeFirst();
    }
    
    /**
     * Returns a string representing the elements in the queue in order
     * @return a string 
     */
    @Override
    public String toString(){
        String out = "Contents : ";
        for(int k = 0; k < size(); k++){
            E e = this.dequeue();
            out += e + ":";
            this.enqueue(e);
        }
        return out;
    }
    
    
}
