package Project.Lab107;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Linked Positional List Class Code Fragment 8.7 from Data Structures &
 * Algorithms, 6th edition by Michael T. Goodrich, Roberto Tamassia & Michael H.
 * Goldwasser Wiley 2014 Transcribed by
 *
 * @author Sean Hagen
 *
 */
public abstract class AbstractBinaryTree<E> extends AbstractTree<E> implements BinaryTree<E> {
    
    @Override
    public Position<E> sibling(Position<E> p){
        Position<E> parent = parent(p);
        if(parent == null){
            return null; //p must be the root
        }
        if(p == left(parent)){
            return right(parent); //p must be left child, making sibling the right child
        }
        else{
            return left(parent); // p must be the right child, return the left sibling
        }
        
        
    }
    
    @Override
    public int numChildren(Position<E> p){
        int count = 0;
        if(left(p) != null){
            count++;
        }
        if(right(p) != null){
            count++;
        }
        return count;
    }
    
    @Override
    public Iterable<Position<E>> children(Position<E> p){
        ArrayList<Position<E>> snapshot = new ArrayList<>(2);
        if(left(p) != null){
            snapshot.add(left(p));
        }
        if(right(p) != null){
            snapshot.add(right(p));
        }
        return snapshot;
        
    }
    
    /**
     * adds the positions of the subtree rooted at position p to the given snapshot
     * @param p the root of the given subtree
     * @param snapshot an arraylist of positions inorder
     */
    private void inorderSubtree(Position<E> p, List<Position<E>> snapshot){
        if(left(p)  != null){
            inorderSubtree(left(p), snapshot);
        }
        snapshot.add(p);
        if(right(p) != null){
            inorderSubtree(right(p), snapshot);
        }
    }
    
    
    public Iterable<Position<E>> inorder(){
        List<Position<E>> snapshot = new ArrayList<>();
        if(!isEmpty()){
            inorderSubtree(root(), snapshot); //fills snapshot recursivly
        }
        return snapshot;
    }
    
    /**
     * Overrides positions to make inorder the default order for binary trees
     * @return 
     */
    @Override
    public Iterable<Position<E>> positions(){
        return inorder();
    }
    
    private void eulerTourBinary(Position<E> p, List<String> snapshot){
        snapshot.add("(");
         if(left(p)  != null){
            eulerTourBinary(left(p), snapshot);
        }
        snapshot.add(p.getElement().toString());
        if(right(p) != null){
            eulerTourBinary(right(p), snapshot);
        }
        snapshot.add(")");
    }
    
    public String callEulerTour(){
        List<String> snapshot = new ArrayList<>();
        if(!isEmpty()){
            eulerTourBinary(root(), snapshot); //fills snapshot recursivly
        }
        StringBuilder b = new StringBuilder(size()*2);
        for(String a : snapshot){
            b.append(a);  
        }
        return b.toString();
       
        
    }
    
    
    
    
}
