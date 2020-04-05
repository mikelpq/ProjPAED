package DataStructures.BTree;

import Model.Product;

public class BTreeNode {
    private BTreeNode father;
    private BTreeNode right_son;
    private BTreeNode left_son;
    private BTreeNode mid_son;
    private Product[] elements;
    private int numElements;


    public BTreeNode(){
        this.elements = new Product[3];
        this.right_son = null;
        this.left_son = null;
        this.mid_son = null;
    }

    public BTreeNode(BTreeNode father){
        this.elements = new Product[3];
        this.father = father;
    }

    public BTreeNode getFather() {
        return father;
    }

    public BTreeNode getRight_son() {
        return right_son;
    }

    public BTreeNode getLeft_son() {
        return left_son;
    }

    public BTreeNode getMid_son() {
        return mid_son;
    }

    public Product[] getElements() {
        return elements;
    }

    public int getNumElements() {
        return numElements;
    }
}
