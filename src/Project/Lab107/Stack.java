/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Lab107;

/**
 * /**
 * Stack interface
 * Code Fragments 6.1
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 * @author Sean Hagen
 * 
 */
public interface Stack<E> {
    /**
     * Returns the number of elements in the stack
     * @return number of elements in the stack
     */
    int size();
    
    /**
     * Tests whether the stack is empty
     * @return true if the stack is empty
     */
    boolean isEmpty();
    
    /**
     * Inserts an element at the top of the stack
     * @param e the element to be inserted
     */
    void push(E e) throws IndexOutOfBoundsException;
    
    /**
     * Returns but does not remove the element at the top of the stack. 
     * @return element removed (or null if empty)
     */
    E top();
    
    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null if empty)
     */
    E pop();
    
}



