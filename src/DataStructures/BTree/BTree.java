package DataStructures.BTree;

import Model.Product;

public class BTree {
    private BTreeNode root;


    public BTree(){
        this.root = null;
    }

    /** INSERT FUNCTION **/
    public void insert(Product element){
        if (root == null){
            root = new BTreeNode();

        }
    }

    private void checkWhereToAdd(Product product, BTreeNode node){
        for (int i = 0; i < node.getElements().length; i++) {
            if (product.getPrice() < node.getElements()[i].getPrice()){
                if (node.getNumElements() < 3){
                    //move elements
                    //update num elements of node
                }else{
                    //rotate tree
                }
            }
        }
    }
    /** END OF INSERT FUNCTION **/


    /** REMOVE FUNCTION **/
    public void remove(Product product){

    }
    /** END OF REMOVE FUNCTION **/

    /** SEARCH FUNCTION **/
    public void search(){

    }
    /** END OF SEARCH FUNCTION **/
}
