package DataStructures.BTree;

import Model.Product;

/** implementation a 2-3 Tree based on a B-Tree **/
/** OPERATIONS
 *
 * Cost
 *      - Insert = O (log n)
 *      - Search = O (log n)
 *      - Delete = O (log n)
 *
 * Tree Traversal method: Inorder -> Cost = O log(n)
 *    1. Traverse the left subtree
 *    2. Visit the root.
 *    3. Traverse the right subtree
 *
 *
 *
 * **/

public class BTree {
    private BTreeNode root;
    private int height;

    public BTree(){
        this.root = null;
    }

    public void BtreeMenu(String option, Product product){
        switch (option){
            case "insert":
                insert(product);
                break;
            case "remove":
                remove(product);
                break;
            case "search":
                search(product);
                break;
        }
    }

    /** INSERT FUNCTION **/
    public void insert(Product product){
        if (root == null) {
            root = new BTreeNode(product, null);
        }else{
            insertNode(product, root);
        }
    }

    private void insertNode(Product product, BTreeNode current) {
        if (current.getLeft_son() != null){
            insertNode(product, current.getLeft_son());
        }

        inOrderInsert(product, current);

        if (current.getMid_son() != null){
            insertNode(product, current.getMid_son());
        }

        inOrderInsert(product, current);

        if (current.getRight_son() != null){
            insertNode(product, current.getRight_son());
        }

        inOrderInsert(product, current);

    }

    private void inOrderInsert(Product product, BTreeNode node){
        if (product.getPrice() < node.getElements()[0].getPrice()) {
            if (node.getNumElements() == 1){
                node.insert(product);
            }else{
                splitNode(product, node);
            }
        }
    }

    private void splitNode(Product product, BTreeNode node) {
        if (product.getPrice() < node.getElements()[0].getPrice() && product.getPrice() < node.getElements()[1].getPrice()) {
            //split node -> element[0] is father
            BTreeNode leftNode = new BTreeNode(product, node);
            BTreeNode rightNode = new BTreeNode(node.getElements()[1], node);
            node.getElements()[1] = null;
        } else if (product.getPrice() < node.getElements()[0].getPrice() && product.getPrice() > node.getElements()[1].getPrice()) {
            //split node -> product is father
            BTreeNode leftNode = new BTreeNode(node.getElements()[0], node);
            BTreeNode rightNode = new BTreeNode(node.getElements()[1], node);
            node.getElements()[0] = product;
            node.getElements()[1] = null;
        } else {
            //split node -> element[1] is father
            BTreeNode leftNode = new BTreeNode(node.getElements()[0], node);
            BTreeNode rightNode = new BTreeNode(product, node);
            node.getElements()[0] = node.getElements()[1];
            node.getElements()[1] = null;
        }
    }

    /** END OF INSERT FUNCTION **/


    /** REMOVE FUNCTION **/
    public void remove(Product product){

    }
    /** END OF REMOVE FUNCTION **/

    /** SEARCH FUNCTION **/
    public void search(Product product){

    }
    /** END OF SEARCH FUNCTION **/
}
