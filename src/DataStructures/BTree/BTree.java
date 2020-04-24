package DataStructures.BTree;

import Model.Product;

import java.util.Scanner;

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

    public void BtreeMenu(int option, Product[] products){
        int index;
        //index -> element to remove or search
        switch (option){
            case 1:
                for (int i = 0; i < products.length; i++) {
                    insert(products[i]);
                }
                break;

            case 2:
                Product product = getData();
                break;

            case 3:
                index = getElement(products);

                if (index == -1){
                    System.out.println("[ERR] Objecte no trobat");
                }else{
                    remove(products[index]);
                }
                break;

            case 4:
                index = getElement(products);

                if (index == -1){
                    System.out.println("[ERR] Objecte no trobat");
                }else{
                    search(products[index]);
                }
                break;

            case 5:
                printStructure();
                break;

            default:
                if (option != 6){
                    System.out.println("[ERR] Opcio invalida");
                }
        }
    }


    //find product
    private int getElement(Product[] products) {
        Scanner sc = new Scanner(System.in);
        String option = "";
        int res = -1;

        System.out.println("[MENU] Quin element vols eliminar?");
        option = sc.nextLine();

        for (int i = 0; i < products.length; i++) {
            if (option.equals(products[i].getName())){
                res = i;
            }
        }
        return res;
    }

    //insert custom product, not from dataset
    private Product getData() {
        Scanner sc = new Scanner(System.in);
        Product product;

        System.out.println("[MENU] Nom del producte?");
        String name = sc.nextLine();
        System.out.println("[MENU] Preu del producte (enter)?");
        int price = sc.nextInt();

        product = new Product(name, price);


        return product;
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

        insertElementIntoNode(product, current);

        if (current.getMid_son() != null){
            insertNode(product, current.getMid_son());
        }

        insertElementIntoNode(product, current);

        if (current.getRight_son() != null){
            insertNode(product, current.getRight_son());
        }

        insertElementIntoNode(product, current);

    }

    private void insertElementIntoNode(Product product, BTreeNode node){
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

    /** PRINT STRUCTURE **/
    private void printStructure() {
        inOrderPrint(root);
    }

    private void inOrderPrint(BTreeNode current){
        if (current.getLeft_son() != null){
            inOrderPrint(current.getLeft_son());
        }

        System.out.println("[" + current.getElements()[0].getPrice() + "," + current.getElements()[1].getPrice() + "]");

        if (current.getMid_son() != null){
            inOrderPrint(current.getMid_son());
        }

        System.out.println("[" + current.getElements()[0].getPrice() + "," + current.getElements()[1].getPrice() + "]");

        if (current.getRight_son() != null){
            inOrderPrint(current.getRight_son());
        }

        System.out.println("[" + current.getElements()[0].getPrice() + "," + current.getElements()[1].getPrice() + "]");
    }
}
