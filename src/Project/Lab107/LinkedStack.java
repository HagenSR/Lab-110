/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Lab107;

/**
 *
 * @author Sean
 */
/*ArrayQueue Class
 * Code Fragments 6.4, 
 * from
 * Data Structures & Algorithms, 6th edition
 * by Michael T. Goodrich, Roberto Tamassia & Michael H. Goldwasser
 * Wiley 2014
 * Transcribed by
 * @author Sean Hagen
 * 
 */
public class LinkedStack<E> implements Stack<E> {
    private final LinkedList<E> list = new LinkedList<>(); //creates an empty linked list
    
    /**
     * creates a new stack 
     */
    public LinkedStack(){
        
    }
    
    /**
     * returns the size of the the stack 
     * @return an int representing the amount of elements in the stack
     */
    public int size(){
        return list.getCurrentSize();
    }

    /**
     * checks to see if the stack is empty or not
     * @return true if the stack is empty
     */
    @Override
    public boolean isEmpty() {
     return list.isEmpty();
    }

    /**
     * Adds the given element to the stack
     * @param e the element to be removed 
     */
    @Override
    public void push(E e){
        list.addFirst(e);
    }

    /**
     * returns but does not remove the element at the top of the stack
     * @return the first element in the stack
     */
    @Override
    public E top() {
        return list.first();
    }

    /**
     * returns and removes the element in the first index of the stack
     * @return the element in the first index
     */
    @Override
    public E pop() {
      return list.removeFirst();
    }
    
    /**
     * Returns a string representing the stack in order
     * @return a string
     */
    public String toString(){
        return list.toString();
    }
    
}
