/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Lab107;

/**
 * /**
 * Queue interface
 * Code Fragment 6.9
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 * @author Sean Hagen
 * 
 */
public interface Queue<E> {
    /**
     * Returns the number of elements in the queue
     */
    int size();
    
    /**
     * Inserts an element at the rear of the queue
     * @return True if the array is empty
     */
    boolean isEmpty();
    
    /**
     * Inserts an element at the rear of the queue
     * @param e element to be added to the queue
     */
    void enqueue(E e) throws IndexOutOfBoundsException;
    
    /**
     * Removes and returns the first element of the queue(Null if empty)
     * @return first Element 
     */
    E first();
    
    /**
     * Removes and returns the first element of the queue(Null if empty)
     * @return the first Element
     */
    E dequeue();
    
    
}
