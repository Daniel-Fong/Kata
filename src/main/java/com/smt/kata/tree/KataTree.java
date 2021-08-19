package com.smt.kata.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
// JDK 11.x
import java.util.List;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: KataTree.java
 * <b>Project</b>: Daily-Kata
 * <b>Description: </b> This kata helps us build a tree data structure from a collection
 *  of nodes that have ids and parent ids.  This is an important structure to understand as 
 *  we will need to convert a collection of elements form a database (ids and parent ids) 
 *  and convert the data into an actual linked data structure or tree.  
 *  
 *  In this Kata, you will be receiving a collection of node objects that have the 
 *  proper linkage, but are not linked as a tree.  You must fill out the tree properly 
 *  as well as link the children and parent nodes to each other
 *  
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jun 13, 2021
 * @updates:
 ****************************************************************************/
public class KataTree<T> {
    // Members
    private KataNode<T> root;
    private int depth = 0;
    private int size = 0;
    
    /**
     * Creates a Tree of nodes based upon a Collection of unlinked nodes.  
     * Uses the assigned Node as the root node.  The nodeId and the prentId is included
     * in each node in the list.  Builds the 
     * @param data Collection of unlinked Node objects
     * @param root Root Node object
     */
    public KataTree(List<KataNode<T>> data,  KataNode<T> root) {
        if (root != null) {
            /** Intentionally Blank.  Please build **/
            this.root = root;
            this.size = 1;
            this.depth = 1;
            recursivelyAddChildren(root, data, this.depth);
        }
    }

    public void recursivelyAddChildren(KataNode<T> node, List<KataNode<T>> list, int depth) {
        depth += 1;
        List<KataNode<T>> children = new ArrayList<>();
        for(KataNode<T> n : list) {
            if (n.getParentId().equals(node.getNodeId())) {
                size++;
                this.depth = Math.max(this.depth, depth);
                children.add(n);
                recursivelyAddChildren(n, list, depth);
            }
        }
        Collections.sort(children, new Comparator<KataNode<T>>() {

            @Override
            public int compare(KataNode<T> n1, KataNode<T> n2) {
                return n1.getNodeId().compareTo(n2.getNodeId());
            }
        });
        node.setChildren(children);
    }
    
    /**
     * Returns the total depth of the tree
     * @return
     */
    public int getDepth() {return depth;}

    /**
     * Retrieves the root node, which, if the tree is built properly, would contain 
     * the entire tree object
     * @return Root node for this tree
     */
    public KataNode<T> getRootNode() {
        return root;
    }
    
    /**
     * Calculates the total number of nodes
     * @return Total number of nodes calculated
     */
    public int getTotalNodeCount() {
        return size;
    }
    
    /**
     * Finds a node based upon its id
     * @return node corresponding to the ID.  Null if not found
     */
    public KataNode<T> find(String nodeId) {
        KataNode<T> n = find(nodeId, root);
        if(n != null) {
            return n;
        }
        return null;
    }

    public KataNode<T> find(String nodeId, KataNode<T> node) {
        if(node.getNodeId().equals(nodeId)) {
            return node;
        }

        for(KataNode<T> n : node.getChildren()) {
            KataNode<T> child = find(nodeId, n); 
            if(child != null) {
                return child.copy();
            }
        }
        return null;
    }
    
    /**
     * Gets a collection of nodes
     * Root Left Right
     * @return collection is provided in a preorder list formatting
     */
    public List<KataNode<T>> getPreOrderList() {
        return recursePreOrder2(root);
    }
    
    private List<KataNode<T>> recursePreOrder2(KataNode<T> node){
        List<KataNode<T>> nodeList = new ArrayList<>();
        nodeList.add(node.copy());
        for(KataNode<T> child : node.getChildren()) {
            nodeList.addAll(recursePreOrder2(child));
        }
        return nodeList;
    }
    
    /**
     * Gets a collection of nodes
     * Left Root Right
     * @return collection is provided in a inorder list formatting
     */
    public List<KataNode<T>> getInOrderList() {
        return recurseInOrderList(root);
    }

    
    private List<KataNode<T>> recurseInOrderList(KataNode<T> node){
        List<KataNode<T>> nodeList = new ArrayList<>();
        
        List<KataNode<T>> children = node.getChildren();
        if(children.size() > 0)
            nodeList.addAll(recurseInOrderList(children.get(0)));
        
        nodeList.add(node.copy());
        
        for(int x = 1; x < children.size(); x++)
            nodeList.addAll(recurseInOrderList(children.get(x)));
        
        return nodeList;
    }
    
    /**
     * Gets a collection of nodes
     * Left Right Root
     * @return collection is provided in a postorder list formatting
     */
    public List<KataNode<T>> getPostOrderList() {
        List<KataNode<T>> nodeList = new ArrayList<KataNode<T>>();
        recursePostOrder(root, nodeList);
        return nodeList;
    }

    private void recursePostOrder(KataNode<T> node, List<KataNode<T>> nodeList){
        for(int x = 0; x < node.getChildren().size(); x++){
            KataNode<T> child = (KataNode<T>) node.getChildren().get(x);
            recursePostOrder(child, nodeList);
        }
        nodeList.add(node.copy());
    }
    
    /**
     * Gets a collection of nodes
     * Left -> Right Top to Bottom
     * @return collection is provided in a level order list formatting
     */
    public List<KataNode<T>> getLevelOrderList() {
        List<KataNode<T>> retNodes = new ArrayList<>();
        Map<Integer, List<KataNode<T>>> nodes = new HashMap<>();
        getLevelNodes(0, root, nodes);
        for(int i = 0; i < depth; i++) {
            retNodes.addAll(nodes.get(i));
        }
        return retNodes;
    }
    public void getLevelNodes(int depth, KataNode<T> node, Map<Integer, List<KataNode<T>>> nodes) {
        List<KataNode<T>> l = nodes.get(depth);
        if(l == null) {
            l = new ArrayList<>();
        }
        l.add(node.copy());

        for(KataNode<T> n : node.getChildren()) {
            getLevelNodes(depth + 1, n, nodes);
        }
        nodes.put(depth, l);
    }
}