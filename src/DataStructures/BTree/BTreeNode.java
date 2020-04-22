package DataStructures.BTree;

import Model.Product;

public class BTreeNode {
    private BTreeNode father;
    private BTreeNode right_son;
    private BTreeNode left_son;
    private BTreeNode mid_son;
    private Product[] elements;
    private int numElements;


    public BTreeNode(Product product, BTreeNode father){
        this.elements = new Product[2];
        this.elements[0] = product;
        this.father = father;
        this.right_son = null;
        this.left_son = null;
        this.mid_son = null;
        this.numElements = 1;
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


    public void insert( Product product) {
        Product tmp;
        if (product.getPrice() < elements[0].getPrice()){
            elements[1] = elements[0];
            elements[0] = product;
        }else{
            elements[1] = product;
        }
    }

    public static void main(String[] args) {

    }

    public void insertElementIntoNode(Product element) {
        //si node no esta buit
        if (elements[0] != null){
            elements[1] = elements[0];
        }
        elements[0] = element;
    }
}
