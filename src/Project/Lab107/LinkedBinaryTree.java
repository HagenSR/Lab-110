package Project.Lab107;

/**
 *
 * @author sean.r.hagen
 * Version Mar 22 2019
 */
public class LinkedBinaryTree<E> extends AbstractBinaryTree<E> {

    //Nested Node Class
    protected static class Node<E> implements Position<E> {

        private E element; //an element stored at this node
        private Node<E> parent; //a reference to the parent node (if any)
        private Node<E> left; //a refrenece to the left child(if any)
        private Node<E> right; //a refrence to the right child(if any)

        /**
         * constructs a node with the given element and neighbors
         *
         * @param e the element to be stored at this node
         * @param above the parent to this node
         * @param leftChild the left child to this node
         * @param rightChild the right child to this node
         */
        public Node(E e, Node<E> above, Node<E> leftChild, Node<E> rightChild) {
            element = e;
            parent = above;
            left = leftChild;
            right = rightChild;
        }

        //accessor methods 
        public E getElement() {
            return element;
        }

        public Node<E> getParent() {
            return parent;
        }

        public Node<E> getLeft() {
            return left;
        }

        public Node<E> getRight() {
            return right;
        }

        //update methods
        public void setElement(E e) {
            element = e;
        }

        public void setParent(Node<E> p) {
            parent = p;
        }

        public void setLeft(Node<E> l) {
            left = l;
        }

        public void setRight(Node<E> r) {
            right = r;
        }

       
    }
    //end of nested node class

    /**
     * Factory function to create a new node storing element e
     *
     * @param e element to be stored in the node
     * @param parent the parent of this node
     * @param l the left child of this node
     * @param r the right child of this node
     * @return a new Node object
     */
    protected Node<E> createNode(E e, Node<E> parent, Node<E> l, Node<E> r) {
        return new Node<E>(e, parent, l, r);
    }

    //LinkedBinaryTree instance variables
    protected Node<E> root = null; //root of the tree
    private int size = 0; //number of nodes in the tree

    //Constructor
    /**
     * creates an empty linked Binary tree
     */
    public LinkedBinaryTree() {

    }

    //nonpublic utility
    /**
     * checks to see if the position given is valid for a node object in this
     * tree
     *
     * @param p position to be checked
     * @return a valid node object
     * @throws IllegalArgumentException is p is not a node
     */
    protected Node<E> validate(Position<E> p) throws IllegalArgumentException {
        if (!(p instanceof Node)) {
            throw new IllegalArgumentException("Not a valid position type");
        }
        Node<E> node = (Node<E>) p; //safe cast
        if (node.getParent() == node) {
            throw new IllegalArgumentException("p is no longer in the tree");
        }
        return node;
    }

    //accessor methods not implemeneted in AbstractBinaryTree
    /**
     * returns how many nodes are in the tree
     *
     * @return an int representing the count of nodes
     */
    public int size() {
        return size;
    }

    /**
     * returns the root of the tree
     *
     * @return a position representing the root of the tree
     */
    public Position<E> root() {
        return root;
    }

    /**
     * Returns the position of the tree (or null if tree is empty)
     *
     * @param p position to be checked
     * @return the parent of p (or null if it doesn't exist
     * @throws IllegalArgumentException if p is not a valid position for this
     * tree
     */
    public Position<E> parent(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getParent();
    }

    public Position<E> left(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getLeft();
    }

    public Position<E> right(Position<E> p) throws IllegalArgumentException {
        Node<E> node = validate(p);
        return node.getRight();
    }

    //update methods supported by this class
    /**
     * places element e at the root of an empty tree and returns its new
     * position
     *
     * @param e the element to be stored at the root
     * @return the position this root is at
     * @throws IllegalStateException if the tree is not empty
     */
    public Position<E> addRoot(E e) throws IllegalStateException {
        if (!isEmpty()) {
            throw new IllegalStateException("Tree is not empty");
        }
        root = createNode(e, null, null, null);
        size = 1;
        return root;
    }
    
    /**
     * Adds a child to the left child position of p
     * @param p the parent object
     * @param e element to be stored at left child position
     * @return the position of the new child object;
     * @throws IllegalArgumentException if p already has a left child
     */
    public Position<E> addLeft(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getLeft() != null){
            throw new IllegalArgumentException("p already has a left child");
        }
        Node<E> child = createNode(e, parent, null,null);
        parent.setLeft(child);
        size++;
        return child;
    }
    
    /**
     * Adds a child to the right child position of p
     * @param p the parent position to be added to
     * @param e the element to be stored in the right position of p
     * @return the position of the new child object
     * @throws IllegalArgumentException if p already has a right child
     */
    public Position<E> addRight(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> parent = validate(p);
        if(parent.getLeft() != null){
            throw new IllegalArgumentException("p already has a right child");
        }
        Node<E> child = createNode(e, parent, null,null);
        parent.setRight(child);
        size++;
        return child;
    }
    
    /**
     * Replaces the element at Position p with e and returns the replaced element
     * @param p the position to have its element replaced
     * @param e the element you want to replace
     * @return the element that was replaced
     * @throws IllegalArgumentException 
     */
    public E set(Position<E> p, E e) throws IllegalArgumentException{
        Node<E> node = validate(p);
        E temp = node.getElement();
        node.setElement(e);
        return temp;
    }
    
    /**
     * attaches trees t1 and t2 as left and right subtrees of external p
     * @param p the position the trees will be attached to
     * @param t1 the left subtree to be added
     * @param t2 the right subtree to be added
     * @throws IllegalArgumentException if p is not a leaf
     */
    public void attach(Position<E> p, LinkedBinaryTree<E> t1, LinkedBinaryTree<E> t2) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if(isInternal(p)){
            throw new IllegalArgumentException("p must be a leaf");
        }
        size += t1.size() + t2.size();
        if(!t1.isEmpty()){
            t1.root.setParent(node);
            node.setLeft(t1.root);
            t1.root = null;
            t1.size = 0;
        }
        if(!t2.isEmpty()){
            t2.root.setParent(node);
            node.setRight(t2.root);
            t2.root = null;
            t2.size = 0;
        }
    }
    
    /**
     * Removes the node at Position p and replaces it with its child, if any
     * @param p the position of the node you want to remove
     * @return the element formerly stored at position p
     * @throws IllegalArgumentException if p has two children or is not a valid position
     */
    public E remove(Position<E> p) throws IllegalArgumentException{
        Node<E> node = validate(p);
        if(numChildren(p) == 2){
            throw new IllegalArgumentException("p has two children");
        }
        Node<E> child = (node.getLeft() != null ? node.getLeft() : node.getRight());
        if(child != null){
            child.setParent(node.getParent());
        }
        if(node == root){
            root = child;
        }
        else{
            Node<E> parent = node.getParent();
            if(node == parent.getLeft()){
                parent.setRight(child);
            }
            else{
                parent.setRight(child);
            }
        }
        size--;
        E temp = node.getElement();
        node.setElement(null);
        node.setLeft(null);
        node.setRight(null);
        node.setParent(node); //convention for defunct node
        return temp;
    }
    
    //Returns a string inorder
    @Override
    public String toString(){
        return callEulerTour();
    }
    
  

}

