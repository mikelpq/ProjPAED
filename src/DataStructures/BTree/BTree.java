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

    public BTree(){
        this.root = null;
    }

    /** INSERT FUNCTION **/
    public void insert(Product element, BTreeNode current){
        if (root == null) {
            root = new BTreeNode(element);
        }else{
            //move to next node
            if (current.getLeft_son() != null){
                current = current.getLeft_son();
            }

            if (current.getMid_son() != null){
                current = current.getMid_son();
            }

            if (current.getRight_son() != null){
                current = current.getRight_son();
            }

            if (current == null){
                System.out.println("[ERR] Arbre buit");
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
