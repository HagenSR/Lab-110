/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project.Lab107;


import Project.Lab107.Position;
import java.util.Iterator;
/**
 * 
 * Linked Positional List Class Code Fragment 8.6 from Data
 * Structures & Algorithms, 6th edition by Michael T. Goodrich, Roberto Tamassia
 * & Michael H. Goldwasser Wiley 2014 Transcribed by
 *
 * @author Sean Hagen
 *
 */
public interface Tree<E> extends Iterable<E>{
    /**
     * Gets the root of the tree
     * @return Returns the position of the root of the tree
     */
    Position<E> root();
    
    /**
     * Returns the position of the parent of position p
     * @param p the position to be checked
     * @return the parent of p or null if no parent
     * @throws IllegalArgumentException if p is not a valid position
     */
    Position<E> parent(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns an iterable collection containing the children of position p(if any)
     * @param p position that has children
     * @return an iterable collection of the positions children (or null if none)
     */
    Iterable<Position<E>> children(Position<E> p) throws IllegalArgumentException;
    
    /**
     * returns the number of children at Position p
     * @param p the position to be checked
     * @return the number of children the position has (or null if none)
     * @throws IllegalArgumentException if p is not a position
     */
    int numChildren(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns true if position p has at least one child
     * @param p the position to be checked
     * @return true if the position has one child
     * @throws IllegalArgumentException if p is not a position
     */
    boolean isInternal(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns true if position p does not have any children
     * @param p a position to be checked
     * @return true if p does not have any children
     * @throws IllegalArgumentException if p is not a position
     */
    boolean isExternal(Position<E> p) throws IllegalArgumentException;
    
    /**
     * Returns true if p is the root of the tree
     * @param p a position to be checked
     * @return true if p has no parents
     * @throws IllegalArgumentException if p is not a position 
     */
    boolean isRoot(Position<E> p) throws IllegalArgumentException;
    
    /**
     * returns the number of positions (and hence elements) that are in the tree
     * @return an int representing the count of positions
     */
    int size();
    
    /**
     * Returns true if the tree does not contain any positions (and thus no elements)
     * @return true if the amount of positions is equal to zero
     */
    boolean isEmpty();
    
    /**
     * Returns an Iterator for all elements in the tree(so the tree itself is iterable)
     * @return a tree iterator
     */
    @Override
    Iterator<E> iterator();
    
    /**
     * Returns an iterable collection of all positions of the tree
     * @return an interable collection of all positions of the tree
     */
    Iterable<Position<E>> positions();
    
    
    
}
