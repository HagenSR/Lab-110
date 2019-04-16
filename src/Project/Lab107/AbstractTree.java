package Project.Lab107;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Linked Positional List Class Code Fragment 8.2 from Data Structures &
 * Algorithms, 6th edition by Michael T. Goodrich, Roberto Tamassia & Michael H.
 * Goldwasser Wiley 2014 Transcribed by
 *
 * @author Sean Hagen
 *
 */
public abstract class AbstractTree<E> implements Tree<E> {

    @Override
    public boolean isInternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) > 0;
    }

    @Override
    public boolean isExternal(Position<E> p) throws IllegalArgumentException {
        return numChildren(p) == 0;
    }

    @Override
    public boolean isRoot(Position<E> p) throws IllegalArgumentException {
        return p == root();
    }

   
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }


    /**
     * Returns the number of levels separating position p from the root.
     * @param p the position to be checked
     * @return an int representing how many ancestors this node has
     */
    public int depth(Position<E> p) {
        if(isRoot(p)){
            return 0;
        }
        else{
            return 1 + depth(parent(p));
        }

    }
    
    /**
     * Returns the height of the subtree rooted at Position p
     * @param p the position to be checked
     * @return an int representing how many nodes are below this one
     */
    public int height(Position<E> p){
        int h = 0;
        for(Position<E> c : children(p)){
            h = Math.max(h, 1+ height(c));
        }
        return h;
    }
    
    /**
     * nested private Element Iteraotr class
     * Adapts the iteration of positions to return elements
     */
    private class ElementIterator implements Iterator<E>{
        Iterator<Position<E>> posIterator = positions().iterator();
        public boolean hasNext(){
            return posIterator.hasNext();
        }

        @Override
        public E next() {
            return posIterator.next().getElement();
        }
        
        public void remove(){
            posIterator.remove();
        }
                
    }
    
    /**
     * A Private subroutine that handles recursive calls to the traversal algorithm
     * @param p the position to be checked for children
     * @param snapshot an arraylist of all of the previous children in the traversal order
     */
    private void preorderSubtree(Position<E> p, List<Position<E>> snapshot){
        snapshot.add(p);
        for(Position<E> c: children(p)){
            preorderSubtree(c, snapshot);
        }
    }
    
    /**
     * Returns an iterable collection of positions of the tree, reported in preorder
     * @return an arraylist of positions in preorder position
     */
    public Iterable<Position<E>> preorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            preorderSubtree(root(), snapshot); //fills snapshot recursively
        }
        return snapshot;
    }
    
    /**
     * a private utility that recursively collects the positions of a tree in postorder
     * @param p the position currently being checked
     * @param snapshot a list of positions
     */
    private void postorderSubtree(Position<E> p, List<Position<E>> snapshot){
        for(Position<E> c : children(p)){
            postorderSubtree(c, snapshot);
        }
        snapshot.add(p);
    }
    
    /**
     * creates an iterable collection of positions in a tree in postorder
     * @return an arraylist of positions
     */
    public Iterable<Position<E>> postorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            postorderSubtree(root(), snapshot);
        }
        return snapshot;
    }
    
    /**
     * returns an iterable collection of positions of the tree in breadth first order
     * @return arraylist is breadth first order
     */
    public Iterable<Position<E>> breadthfirst(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            LinkedQueue<Position<E>> fringe = new LinkedQueue<>();
            fringe.enqueue(root()); //starts with the root
            while(!fringe.isEmpty()){
                Position<E> p = fringe.dequeue(); //remove from the front of the queue
                snapshot.add(p);
                for(Position<E> c : children(p)){
                    fringe.enqueue(c); //add children to back of queue
                }
            }
        }
        return snapshot;
    }
    
    
    @Override
    public Iterator<E> iterator(){
        return new ElementIterator();
    }
    
    @Override
    public Iterable<Position<E>> positions(){
        return preorder();
    }

}
