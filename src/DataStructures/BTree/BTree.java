package DataStructures.BTree;

import Model.Product;


/** implementation a 2-3 Tree based on a B-Tree **/
public class BTree {
    private BTreeNode root;

    public BTree(){
        this.root = null;
    }

    /** INSERT FUNCTION **/
    public void insert(Product element){
        if (root == null){
            root = new BTreeNode();
            root.insert(element);
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
