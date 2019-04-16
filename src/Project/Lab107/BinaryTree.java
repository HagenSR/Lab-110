/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Lab107;

/**
 * 
 * Linked Positional List Class Code Fragment 8.6 from Data
 * Structures & Algorithms, 6th edition by Michael T. Goodrich, Roberto Tamassia
 * & Michael H. Goldwasser Wiley 2014 Transcribed by
 *
 * @author Sean Hagen
 *
 */
public interface BinaryTree<E> extends Tree<E> {
    
    /**
     * Returns the Position of p's left child (Or null if no child exists)
     * @param p the position to check
     * @return the position of p's left child (or null if no child exists)
     * @throws IllegalArgumentException if p is not a position
     */
    Position<E> left(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns the position of p's right child (or null if no child exists)
     * @param p the position to be checked
     * @return the position of p's right child
     * @throws IllegalArgumentException if p is not a position
     */
    Position<E> right(Position<E> p) throws IllegalArgumentException;
    
    
    /**
     * Returns the position of p's sibling (or null if no sibling exists)
     * @param p the position to be checked
     * @return the position of the sibling to p
     * @throws IllegalArgumentException if p is not a position
     */
    Position<E> sibling(Position <E> p) throws IllegalArgumentException;
    
}
