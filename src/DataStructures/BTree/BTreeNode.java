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
        this.elements = new Product[2];
        this.right_son = null;
        this.left_son = null;
        this.mid_son = null;
    }

    public BTreeNode(Product product){
        this.elements = new Product[2];
        this.elements[0] = product;
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


    public void insert(Product product){
        for (int i = 0; i < elements.length; i++) {
            if (product.getPrice() < elements[i].getPrice()){
                if (numElements < 3){
                    int index = i;
                    moveAndInsertElements(index, product);
                }else{
                    //rotate tree
                }
            }
        }
    }

    private void moveAndInsertElements(int index, Product product) {
        Product tmp;
        for (int i = numElements-1; i > index; i--) {
            elements[i+1] = elements[i];
        }
        elements[index] = product;
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
